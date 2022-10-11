package com.co.zemsania.cliente.infraestructure;

import com.co.zemsania.cliente.domain.model.entities.Clientes;
import com.co.zemsania.cliente.domain.model.gateways.GetClientesGateway;
import com.co.zemsania.cliente.infraestructure.utils.modelo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class ClientesRepositoryAdapter implements GetClientesGateway {


    @Override
    public ResponseEntity<Clientes> getClientes(String tipoDocumento, String numeroCedula) {

        if (!validarValorPresente(numeroCedula, tipoDocumento)) {
            log.info("Sin resultados=",Clientes.builder().build());
            return new ResponseEntity<>(Clientes.builder().build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        Clientes clientes = modelo.clientes()
                .stream()
                .filter(t -> t.getNumeroDocumento().equals(numeroCedula))
                .filter(t -> t.getTipoDocumento().equals(tipoDocumento))
                .findFirst()
                .get();

        log.info("Salida exitosa=",Clientes.builder().build());

        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    public boolean validarValorPresente(String numeroCedula, String tipoDocumento) {
        return modelo.clientes()
                .stream()
                .filter(t -> t.getNumeroDocumento().equals(numeroCedula))
                .filter(t -> t.getTipoDocumento().equals(tipoDocumento))
                .findAny()
                .isPresent();
    }


}
