package com.reto.retoIbk.Service;

import com.reto.retoIbk.Entity.Cliente;

public interface ClienteService {

    Cliente guardarCliente (Cliente cliente);
    Cliente obtenerCliente (Long codigoUnico);
    Cliente modificarCliente (Long codigoUnico, Cliente clienteModi);
    boolean eliminarCliente (Long codigoUnico);
}
