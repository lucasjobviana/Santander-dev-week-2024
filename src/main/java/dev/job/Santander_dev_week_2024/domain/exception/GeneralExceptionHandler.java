package dev.job.Santander_dev_week_2024.domain.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GeneralExceptionHandler{
    private final Logger logger = LoggerFactory.getLogger(GeneralExceptionHandler.class);

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handle(IllegalArgumentException ex) {
        String msg = "IllegalArgumentException, see the logs.";
        this.logger.error(msg, ex);
        return new ResponseEntity<>(msg, HttpStatus.UNPROCESSABLE_ENTITY);
    }
    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> handle(Throwable unexpectedException){
        String msg = "Unexpected server error, see the logs.";
        this.logger.error(msg,unexpectedException);
        return new ResponseEntity<>(msg, HttpStatus.INTERNAL_SERVER_ERROR );
    }
}
