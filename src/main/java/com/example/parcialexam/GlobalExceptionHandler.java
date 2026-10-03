package com.example.parcialexam;

import com.example.parcialexam.exceptions.*;
import com.example.parcialexam.model.Status;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(AlreadyRequestedException.class)
    public ProblemDetail handlerAlreadyRequestedException(AlreadyRequestedException e){
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.CONFLICT);
        problemDetail.setTitle("");
        problemDetail.setDetail(e.getMessage());
        return problemDetail;
    }
    @ExceptionHandler(ForbiddenTripActionException.class)
    public ProblemDetail handlerForbiddenTripActionException(ForbiddenTripActionException e){
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.CONFLICT);
        problemDetail.setTitle("");
        problemDetail.setDetail(e.getMessage());
        return problemDetail;
    }
    @ExceptionHandler(InvalidCredentialsException.class)
    public ProblemDetail handlerInvalidCredentialsException(InvalidCredentialsException e){
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.UNAUTHORIZED);
        problemDetail.setTitle("Unauthorized");
        problemDetail.setDetail(e.getMessage());
        return problemDetail;
    }
    @ExceptionHandler(TripNotFoundException.class)
    public ProblemDetail handlerTripNotFoundException(TripNotFoundException e){
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
        problemDetail.setTitle("Not found");
        problemDetail.setDetail(e.getMessage());
        return problemDetail;
    }
    @ExceptionHandler(TripFullException.class)
    public ProblemDetail handlerTripFullException(TripFullException e){
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.CONFLICT);
        problemDetail.setTitle("Trip full");
        problemDetail.setDetail(e.getMessage());
        return problemDetail;
    }
    @ExceptionHandler(TripOverlapException.class)
    public ProblemDetail handlerTripOverlapException(TripOverlapException e){
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.CONFLICT);
        problemDetail.setTitle("");
        problemDetail.setDetail(e.getMessage());
        return problemDetail;
    }
    @ExceptionHandler(UserAlreadyExistsException.class)
    public ProblemDetail handlerUserAlreadyExistsException(UserAlreadyExistsException e){
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.CONFLICT);
        problemDetail.setTitle("Conflict user");
        problemDetail.setDetail(e.getMessage());
        return problemDetail;
    }


}
