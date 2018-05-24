package com.br.onblox.Service;

import com.br.onblox.entity.Produto;

import java.util.List;


public interface ProdutoService {

    Produto findById(Long id);

    Produto findByName(String name);

    void saveProduto(Produto produto);

    void updateProduto(Produto produto);

    void deleteProdutoById(Long id);

    void deleteAllProdutos();

    List<Produto> findAllProdutos();

    boolean isProdutoExist(Produto produto);

}
