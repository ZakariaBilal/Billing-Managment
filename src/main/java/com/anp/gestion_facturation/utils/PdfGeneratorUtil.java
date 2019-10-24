package com.anp.gestion_facturation.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.xhtmlrenderer.pdf.ITextRenderer;

/**
 * PdfGeneratorUtil
 */
@Component
public class PdfGeneratorUtil {

    @Autowired
    private TemplateEngine templateEngine;

    public String createPdf(String templateName, Map<String, Object> map) throws Exception {
        Context context = new Context();

        String path = "";

        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry pair = (Map.Entry) iterator.next();
            context.setVariable(pair.getKey().toString(), pair.getValue());
        }

        String processedHtml = templateEngine.process(templateName, context);

        FileOutputStream os = null;

        String fileName = UUID.randomUUID().toString();

        File dir = new File("./src/main/resources/static/pdf");

        try {
            final File outputFile = File.createTempFile(fileName, ".pdf", dir);
            os = new FileOutputStream(outputFile);

            ITextRenderer renderer = new ITextRenderer();

            renderer.setDocumentFromString(processedHtml);
            renderer.layout();
            renderer.createPDF(os, false);
            renderer.finishPDF();
            path = outputFile.getAbsolutePath();
            System.out.println("path of the file is " + outputFile.getAbsolutePath());
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {

                }
            }
        }
        return path;
    }

}