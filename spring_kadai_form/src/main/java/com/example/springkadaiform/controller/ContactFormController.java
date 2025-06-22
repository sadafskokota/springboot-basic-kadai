package com.example.springkadaiform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.springkadaiform.form.ContactForm;

@Controller
public class ContactFormController {

    // 入力画面表示
    @GetMapping("/contact")
    public String contact(Model model) {
        model.addAttribute("contactForm", new ContactForm());
        return "contactFormView";
    }

    // 確認画面へ
    @PostMapping("/contact/confirm")
    public String confirm(Model model, @Validated ContactForm form, BindingResult result) {
        if (result.hasErrors()) {
            return "contactFormView";
        }
        model.addAttribute("contactForm", form);
        return "confirmView";
    }
}
