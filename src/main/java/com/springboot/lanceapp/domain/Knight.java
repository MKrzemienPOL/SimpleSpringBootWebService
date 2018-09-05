package com.springboot.lanceapp.domain;

import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Knight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @Size(min=2, max=40, message = "The name of the knight must be between 2 and 40 characters")
    private String name;

    @NotNull
    @Range(min=18,max = 60, message = "The knight must be at least 18 years old and no more than 60 years old")
    private int age;


    private int level;

    @OneToOne(cascade = CascadeType.ALL)
    private Quest quest;

    public Knight(){
    }

    public Knight(String name, int age){
        this.name = name;
        this.age = age;
        this.level = 0;
    }

    public Quest getQuest() {
        return quest;
    }

    public void setQuest(Quest quest){
        if (quest != null) {
            quest.setStarted(true);
        }
        this.quest = quest;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Rycerz o imieniu " + this.name + "(" + this.age + ")" + ", zadanie jego to: " + this.quest;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
