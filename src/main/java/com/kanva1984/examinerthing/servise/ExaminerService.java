package com.kanva1984.examinerthing.servise;

import com.kanva1984.examinerthing.model.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestion(int amount);
}
