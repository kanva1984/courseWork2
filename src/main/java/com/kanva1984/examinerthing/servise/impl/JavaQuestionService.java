package com.kanva1984.examinerthing.servise.impl;

import com.kanva1984.examinerthing.model.Question;
import com.kanva1984.examinerthing.servise.QuestionService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

@Service

public class JavaQuestionService implements QuestionService {
    private final Random random = new Random();
    private final List<Question> questions = new ArrayList<>() {{
        add(new Question("question1", "answer1"));
        add(new Question("question2", "answer2"));
        add(new Question("question3", "answer3"));
        add(new Question("question4", "answer4"));
    }};
    @Override
    public Question add(String question, String answer) {
        Question questionText = new Question(question, answer);
        questions.add(questionText);
        return questionText;
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(String question, String answer) {
        return remove(new Question(question, answer));
    }

    @Override
    public Question remove(Question question) {
        boolean iaRemoved = questions.remove(question);
        return iaRemoved ? question : null;
    }

    @Override
    public  Collection<Question> getAll() {

        return new ArrayList<>(questions);
    }

    @Override
    public Question getRandomQuestion() {
        int randomIndex = random.nextInt(questions.size());
        return questions.get(randomIndex);
    }
}
