package com.springboot.lanceapp.services;

import com.springboot.lanceapp.domain.Quest;
import com.springboot.lanceapp.domain.repository.QuestRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class QuestServiceTests {

    @Mock
    QuestRepository repositoryMock;

    @Test
    public void returnsNotStartedQuests(){
        List<Quest> quests = new ArrayList<>();
        Quest q1 = new Quest(1,"Test quest 1");
        Quest q2 = new Quest(2,"Test quest 2");
        Quest q3 = new Quest(3,"Test quest 3");

        q2.setStarted(true);

        quests.add(q1);
        quests.add(q2);
        quests.add(q3);

        when(repositoryMock.getAll()).thenReturn(quests);

        QuestService questService = new QuestService();

        questService.setQuestRepository(repositoryMock);

        List<Quest> allNotStartedQuests = questService.getAllNotStartedQuests();

        Assert.assertEquals("Size of returned quest" , 2 , allNotStartedQuests.size());
        Assert.assertThat(allNotStartedQuests,containsInAnyOrder(q1,q3));
    }
}
