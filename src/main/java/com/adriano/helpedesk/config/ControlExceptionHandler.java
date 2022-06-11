package com.adriano.helpedesk.config;

import com.adriano.helpedesk.exception.BusinessException;
import com.adriano.helpedesk.exception.ExceptionResolver;
import javassist.NotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ControllerAdvice
public class ControlExceptionHandler {

    public static final String CONSTRAINT_VALIDATION_FAILED = "Constraint validation failed";

    @ExceptionHandler(value = { BusinessException.class })
    protected ResponseEntity<Object> handleConflict(BusinessException ex, WebRequest request) {
        HttpHeaders responseHeaders = new HttpHeaders();
        return ResponseEntity.status(ex.getHttpStatusCode()).headers(responseHeaders).body(ex.getOnlyBody());

    }

    @ExceptionHandler({ Throwable.class })
    public ResponseEntity<Object> handleException(Throwable eThrowable) {

        BusinessException ex = BusinessException.builder().httpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR)
                .message(Optional.ofNullable(eThrowable.getMessage()).orElse(eThrowable.toString()))
                .description(ExceptionResolver.getRootException(eThrowable)).build();
        HttpHeaders responseHeaders = new HttpHeaders();

        return ResponseEntity.status(ex.getHttpStatusCode()).headers(responseHeaders).body(ex.getOnlyBody());

    }

    /**
     *
     * @param request
     * @return
     */
    @ExceptionHandler({ MethodArgumentTypeMismatchException.class })
    public ResponseEntity<Object> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException exMethod,
                                                                   WebRequest request) {

        String error = exMethod.getName() + " should be " + exMethod.getRequiredType().getName();

        BusinessException ex = BusinessException.builder().httpStatusCode(HttpStatus.BAD_REQUEST)
                .message(CONSTRAINT_VALIDATION_FAILED).description(error).build();
        HttpHeaders responseHeaders = new HttpHeaders();

        return ResponseEntity.status(ex.getHttpStatusCode()).headers(responseHeaders).body(ex.getOnlyBody());
    }

    @ExceptionHandler({ ConstraintViolationException.class })
    public ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException exMethod, WebRequest request) {
        List<String> errors = new ArrayList<String>();
        for (ConstraintViolation<?> violation : exMethod.getConstraintViolations()) {
            errors.add(violation.getMessage());
        }

        BusinessException ex = BusinessException.builder().httpStatusCode(HttpStatus.BAD_REQUEST)
                .message(CONSTRAINT_VALIDATION_FAILED).description(errors.toString()).build();
        HttpHeaders responseHeaders = new HttpHeaders();

        return ResponseEntity.status(ex.getHttpStatusCode()).headers(responseHeaders).body(ex.getOnlyBody());
    }

    @ExceptionHandler({ NotFoundException.class })
    public ResponseEntity<Object> handleNotFound(NotFoundException e) {

        BusinessException ex = BusinessException.builder().httpStatusCode(HttpStatus.NOT_FOUND)
                .message(Optional.ofNullable(e.getMessage()).orElse(e.toString()))
                .description(ExceptionResolver.getRootException(e)).build();
        HttpHeaders responseHeaders = new HttpHeaders();

        return ResponseEntity.status(ex.getHttpStatusCode()).headers(responseHeaders).body(ex.getOnlyBody());
    }

}
