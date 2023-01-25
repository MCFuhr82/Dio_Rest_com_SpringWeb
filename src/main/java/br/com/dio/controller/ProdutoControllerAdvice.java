package br.com.dio.controller;

import br.com.dio.exceptions.ProductNullException;
import br.com.dio.exceptions.ProductPriceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

// Classe criada para tratar exceções

@ControllerAdvice //serva para lidar com exceções. Serve como se fosse um try-catch
public class ProdutoControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ProductNullException.class) //serve para tratar exceções específicas e enviar respostas personalizadas
    public ResponseEntity<Object> capturaErroNull() {

        Map<String, Object> body = new HashMap<String, Object>();
        body.put("message", "Verifique os campos do produto");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    @ExceptionHandler(ProductPriceException.class)
    public ResponseEntity<Object> capturaErroPrice() {

        Map<String, Object> body = new HashMap<String, Object>();
        body.put("message", "O valor do produto não pode ser menor que zero");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }
}
