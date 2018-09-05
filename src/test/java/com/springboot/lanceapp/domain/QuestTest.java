package com.springboot.lanceapp.domain;

import org.junit.Assert;
import org.junit.Test;

public class QuestTest {

    @Test
    public void settingStartedFlagToFalseShouldSetStartDate(){
        Quest quest = new Quest(1,"Testowe zadanie");
        quest.setStarted(true);
        Assert.assertNotNull(quest.startDate);
    }

    @Test
    public void questShouldBeCompleted(){
        Quest quest = new Quest(1,"Testowe zadanie");
        quest.setStarted(true);
        quest.lenghtInSeconds = -60;
        Assert.assertTrue(quest.isCompleted());
        Assert.assertTrue(quest.isCompleted());
    }

    @Test
    public void questShouldBeNotCompleted(){
        Quest quest = new Quest(1,"Testowe zadanie");
        quest.setStarted(true);
        quest.lenghtInSeconds = 20000;
        Assert.assertFalse(quest.isCompleted());
        Assert.assertFalse(quest.isCompleted());
    }
}
