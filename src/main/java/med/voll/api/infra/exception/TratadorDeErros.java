package med.voll.api.infra.exception;

import jakarta.persistence.EntityNotFoundException;
import med.voll.api.domain.ValidacaoException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
//Anotação utilizada para indicar que é uma classe java que trata erros na API
@RestControllerAdvice
public class TratadorDeErros {
    //Erro 404 - Não encontrado
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarErro404() {

        return ResponseEntity.notFound().build();
    }

    // Erro 400 - Campo invalido
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratarErro400(MethodArgumentNotValidException ex) {
        var erros = ex.getFieldErrors();

        return ResponseEntity.badRequest().body(erros.stream().map(DadosErroValidacao::new).toList());
    }

    // Erro 400 - Campo invalido
    @ExceptionHandler(ValidacaoException.class)
    public ResponseEntity tratarErroRegraDeNegocio(ValidacaoException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

}