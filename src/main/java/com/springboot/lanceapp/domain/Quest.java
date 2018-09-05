package com.springboot.lanceapp.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Quest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String description;
    private int reward = 100;
    protected int lenghtInSeconds = 10;
    private boolean started = false;
    private boolean completed = false;
    protected LocalDateTime startDate;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public int getLenghtInSeconds() {
        return lenghtInSeconds;
    }

    public void setLenghtInSeconds(int lenghtInSeconds) {
        this.lenghtInSeconds = lenghtInSeconds;
    }

    public boolean isStarted() {
        return started;
    }

    public void setStarted(boolean started) {

        this.started = started;

        if (started){
            this.startDate = LocalDateTime.now();
        }
    }

    public boolean isCompleted() {

        if (this.completed){
            return this.completed;
        } else {

            LocalDateTime now = LocalDateTime.now();
            LocalDateTime localDateTime = this.startDate.plusSeconds(this.lenghtInSeconds);

            boolean isAfter = now.isAfter(localDateTime);

            if (isAfter) {
                this.completed = true;
            }

            return isAfter;
        }
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Quest(int id,String description) {
        this.id = id;
        this.description = description;
    }

    public Quest(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() { return description; }

    public Quest() {
    }
}
