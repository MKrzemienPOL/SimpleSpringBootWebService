package com.springboot.lanceapp.controllers;

import com.springboot.lanceapp.components.TimeComponent;
import com.springboot.lanceapp.domain.Knight;
import com.springboot.lanceapp.domain.PlayerInformation;
import com.springboot.lanceapp.domain.repository.PlayerInformationRepository;
import com.springboot.lanceapp.services.KnightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
public class KnightController {

    @Autowired
    PlayerInformationRepository playerInformationRepository;

    @Autowired
    TimeComponent timeComponent;

    @Autowired
    KnightService service;

    @RequestMapping("/knights")
    public String getKnights(Model model){
        PlayerInformation playerInformation = playerInformationRepository.getFirst();
        List<Knight> allKnights = service.getAllKnights();
        model.addAttribute("knights", allKnights);
        model.addAttribute("timeComponent",timeComponent);
        model.addAttribute("playerInformation", playerInformation);
        return "knights";
    }

    @RequestMapping(value = "/knights", method = RequestMethod.POST)
    public String saveKnight(@Valid Knight knight, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            bindingResult.getAllErrors().forEach(objectError -> {
                System.out.println(objectError.getObjectName() + " " + objectError.getDefaultMessage());
            });
            System.out.println("There were errors");
            return "knightform";
        }else{
            service.saveKnight(knight);
            return "redirect:/knights";
        }
    }

    @RequestMapping("/knight")
    public String getKnight(@RequestParam("id") Integer id, Model model){
        PlayerInformation playerInformation = playerInformationRepository.getFirst();
        Knight knight = service.getKnight(id);
        model.addAttribute("knight",knight);
        model.addAttribute("timeComponent",timeComponent);
        model.addAttribute("playerInformation", playerInformation);

        return "knight";
    }

    @RequestMapping("/newknight")
    public String createKnight(Model model){
        model.addAttribute("knight",new Knight());
        return "knightform";
    }

    @RequestMapping(value = "/knight/delete/{id}")
    public String deleteKnight(@PathVariable ("id") Integer id){
        service.deleteKnight(id);
        return "redirect:/knights";
    }
}
