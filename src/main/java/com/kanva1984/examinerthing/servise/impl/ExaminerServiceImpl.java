package com.kanva1984.examinerthing.servise.impl;

import com.kanva1984.examinerthing.exceptions.IfNotEnoughQuestionsInStorage;
import com.kanva1984.examinerthing.model.Question;
import com.kanva1984.examinerthing.servise.ExaminerService;
import com.kanva1984.examinerthing.servise.QuestionService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestion(int amount) {
        if (amount > questionService.getAll().size()) {
            throw new IfNotEnoughQuestionsInStorage();

        }

            Set<Question> randomQuestions = new HashSet<>();

        while (randomQuestions.size() < amount) {
            randomQuestions.add(questionService.getRandomQuestion());
        }
        return randomQuestions;
    }
}
