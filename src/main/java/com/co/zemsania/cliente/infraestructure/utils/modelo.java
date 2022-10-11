package com.co.zemsania.cliente.infraestructure.utils;

import com.co.zemsania.cliente.domain.model.entities.Clientes;

import java.util.ArrayList;
import java.util.List;

public class modelo {

    public static List<Clientes> clientes() {

        Clientes clienteLocal = Clientes.builder()
                .primerNombre("A")
                .segundoNombre("B")
                .primerApellido("C")
                .segundoApellido("D")
                .numeroDocumento("23445322")
                .direccion("F")
                .telefono("G")
                .tipoDocumento("C")
                .ciudadResidencia("H")
                .build();

        Clientes clienteExtranjero = Clientes.builder()
                .primerNombre("A")
                .segundoNombre("B")
                .primerApellido("C")
                .segundoApellido("D")
                .numeroDocumento("23445322")
                .direccion("F")
                .telefono("G")
                .tipoDocumento("P")
                .ciudadResidencia("H")
                .build();

        List<Clientes> clientesList = new ArrayList<>();

        clientesList.add(clienteExtranjero);

        clientesList.add(clienteLocal);

        return clientesList;
    }
}
