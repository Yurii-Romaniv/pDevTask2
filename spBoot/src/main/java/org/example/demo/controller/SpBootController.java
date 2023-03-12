package org.example.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.constraints.Pattern;
import org.example.myLib;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Controller
@Validated
@Api
public class SpBootController {


    @GetMapping(value="/nameToChar")
    @Operation(summary = "get name input page")
    public String ntcPage(Model model){
        model.addAttribute("chars", "");
        return "nameToChars";
    }


    @PostMapping (value="/nameToChar")
    @Operation(summary = "separate name into symbols",description = "...")
    public String charResp(Model model, @RequestParam("name") @Pattern(regexp = "^[A-Z][a-z]*(?: [A-Z][a-z]*)*$", message = "must be  ^[A-Z][a-z]*(?: [A-Z][a-z]*)*$ ")  String name){
        StringBuilder charString= new StringBuilder();



        Character[] characters = myLib.GetChars(new String[]{name});


        for (Character character : characters) {
            charString.append(character).append(" ");
        }

        model.addAttribute("chars", charString.toString());
        return "nameToChars";

    }



    @RequestMapping("/custom_error")
    @Operation(summary = "get root page")
    public String customError(){
        return "custom_error";
    }



    @RequestMapping("/")
    @Operation(summary = "get root page")
    public String rootPage(){
        return "root";
    }

}


