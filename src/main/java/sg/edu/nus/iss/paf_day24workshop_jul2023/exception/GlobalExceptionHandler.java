package sg.edu.nus.iss.paf_day24workshop_jul2023.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHanlder(IllegalArgumentExeption.class)


    //what is servletrequest what is servletresponse
    
}
