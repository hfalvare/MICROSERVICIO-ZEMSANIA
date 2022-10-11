package com.co.zemsania.cliente.domain.model.entities;


import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Clientes {

    private final String tipoDocumento;
    private final String numeroDocumento;
    private final String primerNombre;
    private final String segundoNombre;
    private final String primerApellido;
    private final String segundoApellido;
    private final String telefono;
    private final String direccion;
    private final String ciudadResidencia;


}
