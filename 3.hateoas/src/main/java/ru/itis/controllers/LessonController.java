package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.itis.services.LessonService;

@RepositoryRestController
public class LessonController {

    @Autowired
    private LessonService lessonService;

    @PutMapping(value = "/lessons/{lesson-id}/finish")
    public @ResponseBody
    ResponseEntity<?> finish(@PathVariable("lesson-id") Long lessonId) {
        return ResponseEntity.ok(
                EntityModel.of(lessonService.finish(lessonId)));
    }
}
