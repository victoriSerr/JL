package ru.itis.config;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import ru.itis.controllers.LessonController;
import ru.itis.controllers.ReviewController;
import ru.itis.models.Review;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ReviewRepresentationProcessor implements RepresentationModelProcessor<EntityModel<Review>> {
    @Override
    public EntityModel<Review> process(EntityModel<Review> model) {
        Review review = model.getContent();
        if (review != null && !review.getStatus().equals(Review.Status.REQUESTED)) {
            model.add(linkTo(methodOn(ReviewController.class)
                    .reply(review.getId())).withRel("reply"));
        }
        return model;
    }
}
