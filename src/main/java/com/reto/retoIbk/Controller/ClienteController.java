package com.reto.retoIbk.Controller;

import com.reto.retoIbk.Entity.Cliente;
import com.reto.retoIbk.Service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
@AllArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;


    @PostMapping("/guardarCliente")
    public ResponseEntity guardarCliente (@RequestBody  Cliente cliente){
        return new ResponseEntity(clienteService.guardarCliente(cliente), HttpStatus.CREATED);
    }

    @GetMapping("/obtenerCliente/{codigoUnico}")
    public ResponseEntity obtenerCliente (@PathVariable("codigoUnico") Long codigoUnico ){
        return new ResponseEntity(clienteService.obtenerCliente(codigoUnico), HttpStatus.OK);
    }

    @PutMapping("/modificarCliente/{codigoUnico}")
    public ResponseEntity modificarCliente (@PathVariable("codigoUnico") Long codigoUnico,  @RequestBody  Cliente cliente){
        return new ResponseEntity(clienteService.modificarCliente(codigoUnico, cliente), HttpStatus.OK);
    }

    @DeleteMapping("/eliminarCliente/{codigoUnico}")
    public ResponseEntity eliminarCliente (@PathVariable("codigoUnico") Long codigoUnico){
        boolean response = clienteService.eliminarCliente(codigoUnico);
        HttpStatus status = response ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity(status);
    }
}
