package com.michelle.taskmanager;
import com.michelle.taskmanager.exception.EntityNotFoundException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    protected ResponseEntity<Object> handleEntityNotFound(EntityNotFoundException ex, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage());
        return handleExceptionInternal(ex, errorResponse, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        BindingResult bindingResult = ex.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();

        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST, "Validation error");
        for (FieldError fieldError : fieldErrors) {
            errorResponse.addValidationError(fieldError.getField(), fieldError.getDefaultMessage());
        }

        return handleExceptionInternal(ex, errorResponse, headers, HttpStatus.BAD_REQUEST, request);
    }

    // Add more exception handlers as needed

    @Data
    @AllArgsConstructor
    static class ErrorResponse {
        private HttpStatus status;
        private String message;
        private List<ValidationError> validationErrors = new ArrayList<>();

        public void addValidationError(String field, String message) {
            validationErrors.add(new ValidationError(field, message));
        }
    }

    @Data
    @AllArgsConstructor
    static class ValidationError {
        private String field;
        private String message;
    }

}
