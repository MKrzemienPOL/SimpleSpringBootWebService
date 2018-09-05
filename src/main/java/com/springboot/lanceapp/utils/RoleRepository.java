package com.springboot.lanceapp.utils;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class RoleRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public void persistRole(Role role){
        entityManager.persist(role);
    }
}
