package com.springboot.lanceapp.domain.repository;

import com.springboot.lanceapp.domain.Quest;
import com.springboot.lanceapp.utils.Ids;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.*;

@Repository
public class QuestRepository {

    @PersistenceContext
    private EntityManager entityManager;

    Random rand = new Random();

//    Map<Integer,Quest> quests = new HashMap<>();


    List<Quest> questList = new ArrayList<Quest>();

    @Transactional
    public void createQuest (String description){
        Quest newQuest = new Quest(description);
        entityManager.persist(newQuest);
    }

    @Transactional
    public void deleteQuest (Quest quest){
        entityManager.remove(quest);
//        quests.remove(quest.getId());
    }

    @Transactional
    public List<Quest> getAll(){
        return entityManager.createQuery("from Quest",Quest.class).getResultList();
//        return (List<Quest>) new ArrayList<>(quests.values());
    }

    @Override
    public String toString() {
        return "QuestRepository{" +
                "quests=" + questList +
                '}';
    }

    @Scheduled(fixedDelayString = "${questCreationDelay}" )
    @Transactional
    public void createRandomQuest(){
        List<String> descriptions = new ArrayList<>();

        descriptions.add("Save the princess");
        descriptions.add("Join to the tournament");
        descriptions.add("Kill goblins");
        descriptions.add("Kill dragon");

        String description = descriptions.get(rand.nextInt(descriptions.size()));
        createQuest(description);
    }

    @Transactional
    public void update(Quest quest) {
        entityManager.merge(quest);
//        quests.put(quest.getId(),quest);
    }

    @Transactional
    public Quest getQuest(Integer id) {
        return entityManager.find(Quest.class,id);
//        return quests.get(id);
    }
}
