package alfa.argilyazov.workers.web.advice;


import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RepositoryAdvice {

    @ExceptionHandler(EntityNotFoundException.class)
    public ErrorResponse handleNotFoundException(EntityNotFoundException e) {
        return ErrorResponse.create(e, HttpStatus.NOT_FOUND, "Ресурс не найден");
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ErrorResponse handleDataIntegrityViolationException(DataIntegrityViolationException e) {
        return ErrorResponse.create(e, HttpStatus.CONFLICT, "Сотрудник с такими email и phone существует");
    }
}
