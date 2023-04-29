package com.example.mobilite_internationale.controllers;

import com.example.mobilite_internationale.entities.FAQ;
import com.example.mobilite_internationale.repositories.HelpCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/helpcenter")
public class HelpCenterController {

    @Autowired
    private HelpCenterRepository helpCenterRepository;



    @GetMapping("/faqs")
    public List<FAQ> getFAQs() {
        return helpCenterRepository.findAll();
    }


    @PostMapping("/addfaq")
    public FAQ addFAQ(@RequestBody FAQ faq) {
        return helpCenterRepository.save(faq);
    }

    @GetMapping("/top-clicked")
    public List<FAQ> getTopClickedFAQs() {
        return helpCenterRepository.findAll(Sort.by(Sort.Direction.DESC, "clicks"));

    }
    @PutMapping("/faq/{id}/clicks")
    public ResponseEntity<Void> incrementClicks(@PathVariable("id") Long id) {
        // retrie
        // ve the FAQ item from the database
        FAQ faq = helpCenterRepository.findById(id).orElseThrow();

        // increment the clicks count for the FAQ item
        faq.setClicks(faq.getClicks() + 1);
        helpCenterRepository.save(faq);

        // return a success response
        return ResponseEntity.ok().build();
    }
    @PostMapping("/{id}/rate")
    public ResponseEntity<FAQ> rateFaq(@PathVariable Long id, @RequestParam("rating") double rating) {
        Optional<FAQ> faqOptional = helpCenterRepository.findById(id);
        if (faqOptional.isPresent()) {
            FAQ faq = faqOptional.get();
            double currentRating = faq.getRating();
            int numRatings = faq.getNumRatings();

            // Calculate new rating and number of ratings
            double newRating = (currentRating * numRatings + rating) / (numRatings + 1);
            int newNumRatings = numRatings + 1;

            // Update faq object with new rating and number of ratings
            faq.setRating(newRating);
            faq.setNumRatings(newNumRatings);

            // Save updated faq object to the database
            FAQ updatedFaq = helpCenterRepository.save(faq);

            return ResponseEntity.ok(updatedFaq);
        } else {
            return ResponseEntity.notFound().build();
        }
    }



}
