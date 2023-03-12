package org.example.demo;

import jakarta.validation.ConstraintViolationException;
import org.example.demo.controller.SpBootController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



@ControllerAdvice
class NameFormatAdvice {
    @ExceptionHandler(ConstraintViolationException.class )
    public String handleException(ConstraintViolationException ex) {
        //model.addAttribute("errorMessage", ex.getMessage());
        Logger logger = LoggerFactory.getLogger(SpBootController.class);
        //logger.warn("!!!!!!!!!!!!!!!!!!!!!!!Q@@SDRGDFGGDG");
        return "redirect:/custom_error";
    }


}
