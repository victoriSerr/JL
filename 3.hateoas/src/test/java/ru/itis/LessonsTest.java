package ru.itis;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import ru.itis.models.Course;
import ru.itis.models.Lesson;
import ru.itis.services.LessonService;

import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
@AutoConfigureRestDocs(outputDir = "target/snippets")
public class LessonsTest {

    @Autowired
    private MockMvc mockMvc;


    @MockBean
    private LessonService lessonService;

    @BeforeEach
    public void setUp() {
        when(lessonService.finish(1L)).thenReturn(finishedLesson());
    }

    @Test
    public void lessonFinishTest() throws Exception {
        mockMvc.perform(put("/lessons/1/finish")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(finishedLesson().getName()))
                .andExpect(jsonPath("$.description").value(finishedLesson().getDescription()))
                .andExpect(jsonPath("$.finished").value(finishedLesson().isFinished()))
                .andDo(document("finish_lesson", responseFields(
                        fieldWithPath("name").description("Название урока"),
                        fieldWithPath("description").description("Описание урока"),
                        fieldWithPath("finished").description("Состояние урока")
                        )));
    }


    private Lesson finishedLesson() {
        return Lesson.builder()
                .name("less")
                .isFinished(false)
                .description("asd")
                .build();
    }
}
