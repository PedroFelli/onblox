package com.br.onblox.Service;


import com.br.onblox.entity.Produto;
import com.br.onblox.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("produtoService")
@Transactional
public class ProdutoServiceImp  implements ProdutoService{

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto findById(Long id) {
        return produtoRepository.findById(id).get();
    }

    @Override
    public Produto findByName(String name) {
        return null;
    }

    public void saveProduto(Produto produto){
        produtoRepository.save(produto);
    }

    public void updateProduto(Produto produto){
        saveProduto(produto);
    }

    public void deleteProdutoById(Long id){
        produtoRepository.deleteById(id);
    }

    @Override
    public void deleteAllProdutos() {

    }

    @Override
    public List<Produto> findAllProdutos() {
        return   produtoRepository.findAll();
    }


    public void deleteAllProduto(){
        produtoRepository.deleteAll();
    }

    public List<Produto> findAllProduto(){
        return produtoRepository.findAll();
    }

    public boolean isProdutoExist(Produto produto){
        return findById((long) produto.getId()) != null;
    }

}
