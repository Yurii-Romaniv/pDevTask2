package org.example.demo;
import org.example.myLib;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SpBootController {

    @RequestMapping(value="/nameToChar", method= RequestMethod.GET)
    public String ntcPage(Model model){
        model.addAttribute("chars", "");
        return "nameToChars";
    }
    @RequestMapping(value="/nameToChar", method= RequestMethod.POST)
    public String charResp(Model model, @RequestParam("name") String name){
        StringBuilder charString= new StringBuilder();

        Character[] characters = myLib.GetChars(new String[]{name});


        for (Character character : characters) {
            charString.append(character).append(" ");
        }

        model.addAttribute("chars", charString.toString());
        return "nameToChars";

    }

    @RequestMapping("/")
    public String rootPage(){
        return "root";
    }

}
