package com.springboot.lanceapp.controllers;

import com.springboot.lanceapp.domain.Knight;
import com.springboot.lanceapp.domain.PlayerInformation;
import com.springboot.lanceapp.domain.Quest;
import com.springboot.lanceapp.domain.repository.PlayerInformationRepository;
import com.springboot.lanceapp.services.KnightService;
import com.springboot.lanceapp.services.QuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class QuestController {

    @Autowired
    KnightService knightService;

    @Autowired
    QuestService questService;

    @RequestMapping("/assignQuest")
    public String assignQuest(@RequestParam("knightId") Integer id, Model model){
        Knight knight = knightService.getKnight(id);
        List<Quest> notStartedQuests =  questService.getAllNotStartedQuests();
        model.addAttribute("knight",knight);
        model.addAttribute("notStartedQuests", notStartedQuests);
        return "assignQuest";
    }

    @RequestMapping(value = "/assignQuest", method = RequestMethod.POST)
    public String assignQuest123(Knight knight){
        knightService.updateKnight(knight);
        Quest quest = knight.getQuest();
        questService.update(quest);
        return "redirect:/knights";
    }

    @RequestMapping(value = "/checkQuests")
    public String checkQuests(){
        knightService.getMyGold();
        return "redirect:/knights";
    }

}
