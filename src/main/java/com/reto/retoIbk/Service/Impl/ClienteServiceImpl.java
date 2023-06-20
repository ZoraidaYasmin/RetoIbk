package com.reto.retoIbk.Service.Impl;

import com.reto.retoIbk.Entity.Cliente;
import com.reto.retoIbk.Repository.ClienteRepository;
import com.reto.retoIbk.Service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Override
    public Cliente guardarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente obtenerCliente(Long codigoUnico) {
        return clienteRepository.findById(codigoUnico)
                .orElseThrow(() -> new NoSuchElementException("No se encontró el cliente con el código único: " + codigoUnico));
    }

    @Override
    public Cliente modificarCliente(Long codigoUnico, Cliente clienteModi) {
        return clienteRepository.findById(codigoUnico)
                .map(cliExistente -> {
                    cliExistente.setNombres(clienteModi.getNombres());
                    cliExistente.setApellidos(clienteModi.getApellidos());
                    cliExistente.setNumeroDocumento(clienteModi.getNumeroDocumento());
                    cliExistente.setTipoDocumento(clienteModi.getTipoDocumento());
                    return clienteRepository.save(cliExistente);
                })
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
    }

    @Override
    public boolean eliminarCliente(Long codigoUnico) {
        try {
            clienteRepository.findById(codigoUnico).ifPresent(clienteRepository::delete);
            return true;
        }catch (Exception e){
            return false;
        }

    }
}
