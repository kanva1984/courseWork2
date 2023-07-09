package com.kanva1984.examinerthing.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class IfNotEnoughQuestionsInStorage extends RuntimeException{
}
