package org.example.demo;
import org.example.myLib;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SpBootController {

    @RequestMapping("/nameToChar")
    public String ntcPage(Model model){
        model.addAttribute("chars", "");
        return "nameToChars";
    }
    @RequestMapping(value="/nameToChar", method= RequestMethod.POST)
    public String charResp(Model model, @RequestParam("name") String name){
        String charString="";

        Character[] charapters = myLib.GetChars(new String[]{name});


        for(int i=0 ; i< charapters.length; i++) {
            charString+=charapters[i] + " ";
        }

        model.addAttribute("chars", charString);
        return "nameToChars";

    }

    @RequestMapping("/")
    public String rootPage(){

        return "root";
    }
/*
    @RequestMapping(value="/save", method= RequestMethod.POST)
    public ModelAndView save(@ModelAttribute User user)
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user-data");
        modelAndView.addObject("user", user);
        return modelAndView;
    }
*/
}
