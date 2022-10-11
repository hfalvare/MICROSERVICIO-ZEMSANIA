package com.co.zemsania.cliente;

import com.co.zemsania.cliente.domain.usecase.GetClienteUseCase;
import com.co.zemsania.cliente.domain.model.entities.Clientes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController

@Slf4j
@CrossOrigin("*")
public class ApiClientes {

    @Autowired
    private GetClienteUseCase getClienteUseCase;

    @GetMapping("api/get/{tipoDocumento}/{numeroDocumento}")
    public ResponseEntity<Clientes> getClientes(@PathVariable("tipoDocumento") String tipoDocumento, @PathVariable("numeroDocumento") String numeroDocumento) {
        log.info("Comenzo la peticion=", tipoDocumento, numeroDocumento);
        return getClienteUseCase.getClientes(tipoDocumento, numeroDocumento);
    }
}
