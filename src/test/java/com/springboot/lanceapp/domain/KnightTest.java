package com.springboot.lanceapp.domain;

import com.springboot.lanceapp.domain.Knight;
import com.springboot.lanceapp.domain.Quest;
import org.junit.Assert;
import org.junit.Test;

public class KnightTest {

    @Test
    public void testIfQuestMarkedAsStarted(){
        Knight knight = new Knight("Percival" , 25);
        Quest quest = new Quest(1,"Testowe zadanie");

        knight.setQuest(quest);

        Assert.assertTrue(knight.getQuest().isStarted());
    }
}
