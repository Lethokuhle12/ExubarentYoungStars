package com.letho.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.letho.model.Document;
import com.letho.model.UserApplication;
import com.letho.service.ApplicationService;

@Controller
@RequestMapping("/api/application")
public class ApplicationController {

    @Autowired
    private ApplicationService appService;

@GetMapping({"","/"})
public String loadSummaryPageDirectly(Model model) {
    // Optionally add dummy data if needed
    return "application_summary";
}


   //  View application details
    @GetMapping("/{userId}")
    public String viewApplication(@PathVariable Long userId, Model model) {
        if (!appService.isPaymentConfirmed(userId)) {
            model.addAttribute("error", "Please complete your payment before continuing.");
            return "payment_pending";
        }

        model.addAttribute("application", appService.getUserApplication(userId));
        model.addAttribute("documents", appService.getUserDocuments(userId));
        model.addAttribute("residence", appService.getUserResidence(userId));
        return "application_summary";
    }


     // 2. Update personal details
    @PostMapping("/update-details/{userId}")
    public String updatePersonalDetails(@PathVariable Long userId,
                                        @ModelAttribute UserApplication updatedApp,
                                        Model model) {
        appService.updateUserApplication(userId, updatedApp);
        return "redirect:/application/" + userId;
    }


    // 3. Re-upload document
    @PostMapping("/reupload-document/{userId}")
    public String reUploadDoc(@PathVariable Long userId,
                              @RequestParam String documentType,
                              @ModelAttribute Document document,
                              Model model) {
        appService.reUploadDocument(userId, documentType, document);
        return "redirect:/application/" + userId;
    }


    // 4. Change residence
    @PostMapping("/change-residence/{userId}")
    public String changeResidence(@PathVariable Long userId,
                                  @RequestParam String newResidenceName,
                                  Model model) {
        appService.changeResidence(userId, newResidenceName);
        return "redirect:/application/" + userId;
    }

}
