package br.com.Forum_challenge2.infra.exeption;


import br.com.Forum_challenge2.domain.ValidacaoException;
import jakarta.persistence.EntityNotFoundException;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratamentodeErros {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratamento404(){

        return  ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public  ResponseEntity tratamento400(MethodArgumentNotValidException ex){
        var erros = ex.getFieldErrors();


        return ResponseEntity.badRequest().body(erros.stream().
                map(DadosTratamentoErros :: new));
    }

    @ExceptionHandler(ValidacaoException.class)
    public  ResponseEntity tratamento400(ValidacaoException ex){

        return ResponseEntity.badRequest().body(ex.getMessage());
    }


    private record  DadosTratamentoErros(String nome,String mensagem){
        public DadosTratamentoErros(FieldError error){
            this(error.getField(), error.getDefaultMessage());
        }
    }

}