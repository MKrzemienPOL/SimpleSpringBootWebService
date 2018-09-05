package com.springboot.lanceapp;

import com.springboot.lanceapp.domain.PlayerInformation;
import com.springboot.lanceapp.domain.repository.KnightRepository;
import com.springboot.lanceapp.domain.repository.PlayerInformationRepository;
import com.springboot.lanceapp.domain.repository.QuestRepository;
import com.springboot.lanceapp.services.QuestService;
import com.springboot.lanceapp.utils.Role;
import com.springboot.lanceapp.utils.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Scope("singleton")
public class Starter implements CommandLineRunner {

    @Autowired
    KnightRepository knightRepository;

    @Autowired
    QuestRepository questRepository;

    @Autowired
    QuestService questService;

    @Autowired
    PlayerInformationRepository playerInformationRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        questRepository.createRandomQuest();
        questRepository.createRandomQuest();
        questRepository.createRandomQuest();

        knightRepository.createKnight("Percival",30);
        playerInformationRepository.createPlayerInformation(new PlayerInformation("user1","{noop}user1"));
        playerInformationRepository.createPlayerInformation(new PlayerInformation("user2","{noop}user2"));
        System.out.println(knightRepository);

        Role user1RoleUSER = new Role("user1","USER");
        Role user2RoleUSER = new Role("user2","USER");
        Role user2RoleADMIN = new Role("user2","ADMIN");

        roleRepository.persistRole(user1RoleUSER);
        roleRepository.persistRole(user2RoleUSER);
        roleRepository.persistRole(user2RoleADMIN);

        questService.assignRandomQuest("Percival");

    }
}
