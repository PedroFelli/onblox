package com.br.onblox.Controllers;

import com.br.onblox.Service.ClienteService;
import com.br.onblox.entity.Cliente;
import com.br.onblox.entity.Contato;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;


@RestController
@RequestMapping("/api")
public class ClienteController {
   
	@Autowired
    ClienteService clienteService;

   @RequestMapping(value = "/cliente/", method = RequestMethod.GET)
    public ResponseEntity<List<Cliente>> listAllCliente(){
       List<Cliente> clientes = clienteService.findAllClientes();
       if(clientes.isEmpty()){

           return new ResponseEntity(HttpStatus.NO_CONTENT);
       }
       return new ResponseEntity<List<Cliente>>(clientes, HttpStatus.OK);
   }

   @RequestMapping(value = "/cliente/{id}", method = RequestMethod.GET)
    public ResponseEntity<Cliente> getCliente(@PathVariable Long id){
        Cliente cliente = clienteService.findById(id);
        if (cliente == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
   }

   @RequestMapping(value = "/cliente/", method = RequestMethod.POST)
    public ResponseEntity<String> createCliente(@RequestBody Cliente cliente){
        clienteService.saveCliente(cliente);
        return new ResponseEntity( HttpStatus.CREATED);

   }

   @RequestMapping(value ="/cliente/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateCliente(@PathVariable long id, @RequestBody Cliente cliente){
        Cliente currentCliente = clienteService.findById(id);


       currentCliente.setId(cliente.getId());
       currentCliente.setNome(cliente.getNome());
       currentCliente.setTipo(cliente.getTipo());
       currentCliente.setStatus(cliente.getStatus());
       currentCliente.setCpf(cliente.getCpf());
       currentCliente.setContato(cliente.getContato());

       clienteService.updateCliente(currentCliente);
       return new ResponseEntity<Cliente>(currentCliente, HttpStatus.OK);
    }

    @RequestMapping(value = "/cliente/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Cliente> deleteCliente(@PathVariable("id") long id){
        Cliente cliente = clienteService.findById(id);
        if(cliente == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        clienteService.deleteClienteById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/cliente/", method = RequestMethod.DELETE)
    public ResponseEntity<Cliente> deleteAllClientes(){
        clienteService.deleteAllClientes();
        return new ResponseEntity<Cliente>(HttpStatus.NO_CONTENT);
    }

}
