package com.br.onblox.Service;

import com.br.onblox.entity.Cliente;

import java.util.List;

public interface ClienteService {

    Cliente findById(Long id);

    Cliente findByName(String name);

    void saveCliente(Cliente cliente);

    void updateCliente(Cliente cliente);

    void deleteClienteById(Long id);

    void deleteAllClientes();

    List<Cliente> findAllClientes();

    boolean isClienteExist(Cliente cliente);

}
