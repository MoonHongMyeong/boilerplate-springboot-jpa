package me.moon.boilerplate.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//@RestControllerAdvice
//@Slf4j
//public class ExceptionController {
//    @ExceptionHandler({RuntimeException.class})
//    public ResponseEntity exceptionHandler(final Exception e){
//        log.info(e.getMessage());
//        log.error("error", e);
//        return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//}
