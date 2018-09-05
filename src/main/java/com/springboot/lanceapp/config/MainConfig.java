package com.springboot.lanceapp.config;

import com.springboot.lanceapp.domain.Knight;
import com.springboot.lanceapp.domain.Quest;
import com.springboot.lanceapp.domain.repository.DBKnightRepository;
import com.springboot.lanceapp.domain.repository.InMemoryRepository;
import com.springboot.lanceapp.domain.repository.KnightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

@Configuration
public class MainConfig {

//    Quest quest;

//    @Bean
//    @Primary
//    public Knight lancelot(){
//        Knight lancelot = new Knight("Lancelot",21);
//        lancelot.setQuest(quest);
//        return lancelot;
//    }

//    @Bean
//    public Knight createKnightPerc(){
//        Knight percival = new Knight("Percival", 22);
//        percival.setQuest(quest);
//        return percival;
//    }

    @Bean(name="inMemoryRepository")
    @Profile("dev")
    public KnightRepository createInMemoryRepo(){
        KnightRepository repo = new InMemoryRepository();
        return repo;
    }

    @Bean(name="DBKnightRepository")
    @Profile("prod")
    public KnightRepository createDBRepo(){
        KnightRepository repo = new DBKnightRepository();
        return repo;
    }


}
