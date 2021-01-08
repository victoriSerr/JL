package ru.itis.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.support.RepositoryEntityLinks;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import ru.itis.controllers.LessonController;
import ru.itis.models.Lesson;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class LessonRepresentationProcessor implements RepresentationModelProcessor<EntityModel<Lesson>> {

    @Autowired
    private RepositoryEntityLinks links;

    @Override
    public EntityModel<Lesson> process(EntityModel<Lesson> model) {
        Lesson lesson = model.getContent();
        if (lesson != null && !lesson.isFinished()) {
            model.add(linkTo(methodOn(LessonController.class)
                    .finish(lesson.getId())).withRel("finish"));
        }

        if (lesson!= null && lesson.isFinished()) {
            model.add(links.linkToItemResource(Lesson.class, lesson.getId()).
                    withRel("delete"));
        }
        return model;
    }
}
