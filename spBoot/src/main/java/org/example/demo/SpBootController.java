package org.example.demo;


import org.example.myLib;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import javax.validation.constraints.Size;


@Controller
@Validated
@EnableWebMvc
public class SpBootController {



    @GetMapping(value="/nameToChar/{name}")
    public String charResp(Model model, @Valid @PathVariable("name") @NotBlank @Size(max = 10) String name){
        StringBuilder charString= new StringBuilder();

        Character[] characters = myLib.GetChars(new String[]{name});


        for (Character character : characters) {
            charString.append(character).append(" ");
        }

        model.addAttribute("chars", charString.toString());
        return "nameToChars";

    }

    @GetMapping("/nameToChar")
    public String ntcPage(Model model){
        model.addAttribute("chars", "");
        return "nameToChars";
    }

    @RequestMapping("/")
    public String rootPage(){
        return "root";
    }

}
