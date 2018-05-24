package com.br.onblox.Service;

import com.br.onblox.entity.Cliente;
import com.br.onblox.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("clienteService")
@Transactional
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente findById(String cpf){
        return clienteRepository.findByCpf(cpf);
    }

    @Override
    public Cliente findById(Long id) {
        return null;
    }

    @Override
    public Cliente findByName(String name) {
        return null;
    }

    public void saveCliente(Cliente cliente){
        clienteRepository.save(cliente);
    }

    public void updateCliente(Cliente cliente){
        saveCliente(cliente);
    }

    public void deleteClienteById(Long id){
        clienteRepository.deleteById(id);
    }

    @Override
    public void deleteAllClientes() {

    }

    @Override
    public List<Cliente> findAllClientes() {
        return clienteRepository.findAll();
    }


    public void deleteAllCliente(){
        clienteRepository.deleteAll();
    }

    public List<Cliente> findAllCliente(){
        return clienteRepository.findAll();
    }

    public boolean isClienteExist(Cliente cliente){
        return findById(String.valueOf(cliente.getId())) != null;
    }
}
