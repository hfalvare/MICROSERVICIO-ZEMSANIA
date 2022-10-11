package com.co.zemsania.cliente.domain.model.gateways;

import com.co.zemsania.cliente.domain.model.entities.Clientes;
import org.springframework.http.ResponseEntity;

public interface GetClientesGateway {
    ResponseEntity<Clientes> getClientes(String tipoDocumento, String numeroCedula);
}
