package com.kanva1984.examinerthing.service.impl;

import com.kanva1984.examinerthing.exceptions.IfNotEnoughQuestionsInStorage;
import com.kanva1984.examinerthing.model.Question;
import com.kanva1984.examinerthing.servise.ExaminerService;
import com.kanva1984.examinerthing.servise.QuestionService;
import com.kanva1984.examinerthing.servise.impl.ExaminerServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    @Mock
    QuestionService questionService;
    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @Test
    public void shouldThrowExceptionWhenAmountMoreThenQuestions() {
        //given
        int amount = 5;
        when(questionService.getAll()).thenReturn(Collections.emptyList());
        //when
        //then
        Assertions.assertThrows(
                IfNotEnoughQuestionsInStorage.class,
                () -> examinerService.getQuestion(amount)
        );
    }

    @Test
    public void shouldGetAmountRandomQuestions() {
        //given
        List<Question> questions = new ArrayList<>();

            questions.add(new Question("question1", "answer1"));
            questions.add(new Question("question2", "answer2"));
            questions.add(new Question("question3", "answer3"));
            questions.add(new Question("question4", "answer4"));

        when(questionService.getAll()).thenReturn(questions);
        int amount = 3;
        when(questionService.getRandomQuestion()).thenReturn(
                questions.get(0),
                questions.get(1),
                questions.get(1),
                questions.get(2)
                );
        //when
        Collection<Question> questions1 = examinerService.getQuestion(amount);
        //then
        Assertions.assertEquals(amount, questions1.size());
        Assertions.assertTrue(questions1.contains(questions.get(0)));
        Assertions.assertTrue(questions1.contains(questions.get(1)));
        Assertions.assertTrue(questions1.contains(questions.get(2)));
        verify(questionService, times(4)).getRandomQuestion();

    }
}
