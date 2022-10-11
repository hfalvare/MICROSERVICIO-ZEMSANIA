package com.co.zemsania.cliente.domain.usecase;

import com.co.zemsania.cliente.domain.model.entities.Clientes;
import com.co.zemsania.cliente.domain.model.gateways.GetClientesGateway;
import com.co.zemsania.cliente.domain.model.utils.ObjectUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class GetClienteUseCase {

    @Autowired
    private GetClientesGateway getClientesGateway;

    public ResponseEntity<Clientes> getClientes(String tipoDocumento, String numeroDocumento) {

        log.info("Entrada datos peticion=",tipoDocumento,numeroDocumento);

        if (validarCamposVacios(tipoDocumento, numeroDocumento)) {
            return new ResponseEntity<>(Clientes
                    .builder()
                    .build(), HttpStatus.BAD_REQUEST);
        }

        if (!validarTipoDocumento(tipoDocumento)) {
            return new ResponseEntity<>(Clientes
                    .builder()
                    .build(), HttpStatus.UNAUTHORIZED);
        }

        ResponseEntity<Clientes> clientesResponseEntity = getClientesGateway.getClientes(tipoDocumento, numeroDocumento);

        if (ObjectUtils.isNullOrEmpty(clientesResponseEntity)) {
            return new ResponseEntity<>(clientesResponseEntity.getBody(), HttpStatus.NOT_FOUND);
        }
        log.info("Respuesta peticion=",clientesResponseEntity.getStatusCode());
        return clientesResponseEntity;
    }

    public boolean validarTipoDocumento(String tipoDocumento) {
        return (tipoDocumento.equals("C") || tipoDocumento.equals("P"));
    }

    public boolean validarCamposVacios(String tipoDocumento, String numeroDocumento) {
        return (ObjectUtils.isNullOrEmpty(tipoDocumento) || ObjectUtils.isNullOrEmpty(numeroDocumento));
    }
}
