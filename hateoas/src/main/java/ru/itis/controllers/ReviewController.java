package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.itis.services.ReviewService;

@RepositoryRestController
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PutMapping("/reviews/{review-id}/finish")
    public @ResponseBody
    ResponseEntity<?> reply(@PathVariable("review-id") Long reviewId) {
        return ResponseEntity.ok(
                EntityModel.of(reviewService.reply(reviewId)));
    }
}
