package org.example.demo;

import jakarta.validation.ConstraintViolationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;


@ControllerAdvice
class NameFormatAdvice {
    @ExceptionHandler(ConstraintViolationException.class )
    public RedirectView handleException(RedirectAttributes redirectAttributes, ConstraintViolationException ex) {
        redirectAttributes.addAttribute("errMess", ex.getMessage());
        return new RedirectView("custom_error");
    }


}
