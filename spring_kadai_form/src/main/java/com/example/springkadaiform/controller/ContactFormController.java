package com.example.springkadaiform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.springkadaiform.form.ContactForm;

@Controller
public class ContactFormController {

    // 入力画面表示
    @GetMapping("/form")
    public String contact(Model model) {
    if (!model.containsAttribute("contactForm")) {
        model.addAttribute("contactForm", new ContactForm());
    }   
        return "contactFormView";
    }

    // 確認画面へ
    @PostMapping("/confirm")
    public String confirm(@Validated ContactForm contactForm,
                          BindingResult result,
                          RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            // フォームとエラー情報をリダイレクト先へ渡す
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.contactForm", result);
            redirectAttributes.addFlashAttribute("contactForm", contactForm);
            return "redirect:/form";
        }

        // 正常なら確認画面へ
        return "confirmView";
    }
}