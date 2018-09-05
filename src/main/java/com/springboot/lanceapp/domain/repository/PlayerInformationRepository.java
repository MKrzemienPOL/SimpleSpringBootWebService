package com.springboot.lanceapp.domain.repository;

import com.springboot.lanceapp.domain.PlayerInformation;
import com.springboot.lanceapp.domain.Quest;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class PlayerInformationRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public void createPlayerInformation(PlayerInformation playerInformation){
        entityManager.persist(playerInformation);
    }

    public PlayerInformation getFirst(){
        return entityManager.createQuery("from PlayerInformation",PlayerInformation.class).getResultList().get(0);
    }
}
