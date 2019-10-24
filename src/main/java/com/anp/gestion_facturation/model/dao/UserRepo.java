package com.anp.gestion_facturation.model.dao;

import com.anp.gestion_facturation.model.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * UserRepo
 */
@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    User findByUsername(String username);
}