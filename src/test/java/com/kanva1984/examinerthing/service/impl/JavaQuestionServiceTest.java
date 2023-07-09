package com.kanva1984.examinerthing.service.impl;

import com.kanva1984.examinerthing.model.Question;
import com.kanva1984.examinerthing.servise.impl.JavaQuestionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class JavaQuestionServiceTest {
    private final JavaQuestionService javaQuestionService = new JavaQuestionService();

    @Test
    public void shouldRemoveExistedQuestion() {
        //given
        Question question = new Question("question", "answer");
        javaQuestionService.add(question);

        //when
        Question removedQuestion = javaQuestionService.remove(question);

        //then
        Assertions.assertEquals(question, removedQuestion);

    }
    @Test
    public void shouldRemoveNotExistedQuestionAndReturnNull() {
        //given
        Question question = new Question("question", "answer");


        //when
        Question removedQuestion = javaQuestionService.remove(question);

        //then
        Assertions.assertNull(removedQuestion);

    }
    @Test
    public void shouldAddNewQuestion() {
        //given
        Question question = new Question("question", "answer");


        //when
        Question addQuestion = javaQuestionService.add(question);

        //then
        Assertions.assertEquals(question, addQuestion);

    }
    @Test
    public void shouldReturnAllList() {
        //given

        List<Question> questions;
        questions = new ArrayList<>() {{
            add(new Question("question1", "answer1"));
            add(new Question("question2", "answer2"));
            add(new Question("question3", "answer3"));
            add(new Question("question4", "answer4"));
        }};

        //when
        Collection<Question> getAllQuestion =  javaQuestionService.getAll();

        //then
        Assertions.assertEquals(questions, getAllQuestion);

    }
    @Test
    public void shouldFindRandomQuestion() {
        Random random = new Random();
        //given
//        Question question = new Question("question", "answer");
//        javaQuestionService.add(question);
        List<Question> questions;
        questions = new ArrayList<>() {{
            add(new Question("question1", "answer1"));
            add(new Question("question2", "answer2"));
            add(new Question("question3", "answer3"));
            add(new Question("question4", "answer4"));
        }};
        Question expected = questions.get(random.nextInt(questions.size()));

        //when
        Question getRandomQuestion = javaQuestionService.getRandomQuestion();

        //then
        Assertions.assertEquals(expected, getRandomQuestion);

    }

}
