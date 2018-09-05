package com.springboot.lanceapp.domain.repository;

import com.springboot.lanceapp.domain.Knight;
import org.springframework.stereotype.Repository;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;

public class DBKnightRepository implements KnightRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void createKnight(String name, int age) {
        Knight knight = new Knight(name,age);
        entityManager.persist(knight);
//        throw new NotImplementedException();
    }

    @Override
    @Transactional
    public Collection<Knight> getAllKnights() {
        return entityManager.createQuery("from Knight",Knight.class).getResultList();
    }

    @Override
    @Transactional
    public Optional<Knight> getKnight(String name) {
        Knight knightByName = entityManager.createQuery("from  Knight k where k.name=:name", Knight.class)
                .setParameter("name",name).getSingleResult();

        return Optional.ofNullable(knightByName);
    }

    @Override
    @Transactional
    public void deleteKnight(Integer id) {
        entityManager.remove(id);
    }

    @Override
    public void build() {
        throw new NotImplementedException();
    }

    @Override
    @Transactional
    public void createKnight(Knight knight) {
        entityManager.persist(knight);
    }

    @Override
    @Transactional
    public Knight getKnightById(Integer id) {
        return entityManager.find(Knight.class,id);
    }

    @Override
    @Transactional
    public void updateKnight(int id, Knight knight){
        entityManager.merge(knight);
    }
}
