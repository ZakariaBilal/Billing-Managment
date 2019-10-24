package com.anp.gestion_facturation.controllers.bulletins;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.anp.gestion_facturation.model.dao.PortRepo;
import com.anp.gestion_facturation.model.entity.Bulletin;
import com.anp.gestion_facturation.model.entity.LigneBulletin;

import com.anp.gestion_facturation.model.entity.Prestation;
import com.anp.gestion_facturation.service.BulletinService;
import com.anp.gestion_facturation.service.ClientService;
import com.anp.gestion_facturation.service.NavireService;
import com.anp.gestion_facturation.service.PrestationService;
import com.anp.gestion_facturation.service.TypeBulletinService;
import com.anp.gestion_facturation.service.UserPrincipal;
import com.anp.gestion_facturation.utils.Calculateur;
import com.anp.gestion_facturation.utils.PdfGeneratorUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * BulletinTableController
 */
@Controller
public class BulletinTableController {

    private BulletinService bulletinService;
    private TypeBulletinService typeBulletinService;
    private ClientService clientService;
    private NavireService navireService;
    private PrestationService prestationService;
    private PdfGeneratorUtil pdfGeneratorUtil;
    private PortRepo portRepo;

    @Autowired
    public BulletinTableController(BulletinService bulletinService, TypeBulletinService typeBulletinService,
            ClientService clientService, NavireService navireService, PrestationService prestationService,
            PortRepo portRepo, PdfGeneratorUtil pdfGeneratorUtil) {
        this.bulletinService = bulletinService;
        this.typeBulletinService = typeBulletinService;
        this.clientService = clientService;
        this.navireService = navireService;
        this.prestationService = prestationService;
        this.pdfGeneratorUtil = pdfGeneratorUtil;
        this.portRepo = portRepo;

    }

    @GetMapping(value = "/bulletins")
    public String displayBulletinTable(Model model, @RequestParam(required = false) String factured) {
        model.addAttribute("bulletins", bulletinService.findAll());
        if (factured != null) {
            model.addAttribute("factured", factured);
        }

        return "bulletins/bulletins";
    }

    @GetMapping(value = "/bulletins/add")
    public String displayBulletinAddForm(Model model) {
        UserPrincipal user = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Bulletin bulletin = new Bulletin();

        model.addAttribute("typesBulletin", typeBulletinService.findAll());
        model.addAttribute("clients", clientService.findAll());
        model.addAttribute("navires", navireService.findAll());

        model.addAttribute("ports", portRepo.findAll());

        if (user.getPort().getLocation() == "global") {
            model.addAttribute("prestations", prestationService.findAll());
            model.addAttribute("global", true);
        } else {
            ArrayList<Prestation> prestations = new ArrayList<>();
            prestations.addAll(prestationService.findByPortId(user.getPort().getId()));
            prestations.addAll(prestationService.findByPortId(1));
            model.addAttribute("prestations", prestations);
            bulletin.setPort(user.getPort());
            model.addAttribute("global", false);
        }
        model.addAttribute("bulletin", bulletin);
        return "bulletins/ajouterBulletin";
    }

    @PostMapping(value = "/bulletins")
    public String addBulletin(@ModelAttribute("bulletin") Bulletin bulletin) {
        List<LigneBulletin> removable = new ArrayList<>();
        for (LigneBulletin ligneBulletin : bulletin.getLigneBulletins()) {
            ligneBulletin.setBulletin(bulletin);
            if (ligneBulletin.getPrestation() == null) {
                removable.add(ligneBulletin);
            }
        }
        System.out.println(bulletin);

        bulletin.getLigneBulletins().removeAll(removable);

        bulletinService.save(bulletin);
        return "redirect:/bulletins";
    }

    @GetMapping(value = "/bulletins/delete/{bulletinId}")
    public String deleteBulletin(@PathVariable int bulletinId) {
        Bulletin bulletin = bulletinService.findById(bulletinId);
        if (bulletin.getFactured()) {
            return "redirect:/bulletins?factured=" + bulletinId;
        } else {
            bulletinService.deleteById(bulletinId);
            return "redirect:/bulletins";
        }

    }

    @GetMapping(value = "/bulletins/edit/{bulletinId}")
    public String editBulletin(Model model, @PathVariable int bulletinId) {
        Bulletin bulletin = bulletinService.findById(bulletinId);
        if (bulletin.getFactured()) {
            return "redirect:/bulletins?factured=" + bulletinId;
        } else {
            model.addAttribute("bulletin", bulletin);
            model.addAttribute("typesBulletin", typeBulletinService.findAll());
            model.addAttribute("clients", clientService.findAll());
            model.addAttribute("navires", navireService.findAll());
            model.addAttribute("prestations", prestationService.findAll());

            return "bulletins/editBulletin";
        }

    }

    @GetMapping(value = "/bulletins/view/{bulletinId}")
    public String viewBulletin(Model model, @PathVariable int bulletinId) {
        Bulletin bulletin = bulletinService.findById(bulletinId);
        model.addAttribute("bulletin", bulletin);

        for (LigneBulletin ligne : bulletin.getLigneBulletins()) {
            System.out.println(Calculateur.calculerLigneBulletin(ligne));
            System.out.println(Calculateur.calculerLigneFacture(ligne));
        }

        return "bulletins/viewBulletin";
    }

    @GetMapping(value = "/bulletins/pdf/{idBulletin}", produces = "application/pdf")
    public ResponseEntity<byte[]> getBulletinPdf(@PathVariable int idBulletin) throws Exception {
        Map<String, Object> data = new HashMap<String, Object>();

        data.put("bulletin", bulletinService.findById(idBulletin));

        String filePath = pdfGeneratorUtil.createPdf("/bulletins/bulletinPdfTemplate", data);

        Path path = Paths.get(filePath);
        byte[] pdfContents = null;
        try {
            pdfContents = Files.readAllBytes(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/pdf"));
        String filename = "bulletin.pdf";
        headers.setContentDispositionFormData(filename, filename);
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        // headers.add("content-disposition", "attachement;filename=\"" + filename +
        // "\"");
        ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(pdfContents, headers, HttpStatus.OK);
        return response;
    }

}