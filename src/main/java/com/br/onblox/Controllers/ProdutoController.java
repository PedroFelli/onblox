package com.br.onblox.Controllers;

import com.br.onblox.Service.ProdutoService;
import com.br.onblox.entity.Produto;

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
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @RequestMapping(value = "/produto/", method = RequestMethod.GET)
    public ResponseEntity<List<Produto>> listAllProduto(){

        List<Produto> produtos = produtoService.findAllProdutos();
        System.out.println(produtos);
        return new ResponseEntity<List<Produto>>(produtos, HttpStatus.OK);

    }

    @RequestMapping(value = "/produto/{id}", method = RequestMethod.GET)
    public ResponseEntity<Produto> getProduto(@PathVariable Long id){
        Produto produto = produtoService.findById(id);
        if (produto == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Produto>(produto, HttpStatus.OK);
    }

    @RequestMapping(value = "/produto", method = RequestMethod.POST)
    public ResponseEntity<String> createProduto(@RequestBody Produto produto){
        produtoService.saveProduto(produto);


        return new ResponseEntity(HttpStatus.CREATED);

    }

    @RequestMapping(value ="/produto/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateProduto(@PathVariable long id, @RequestBody Produto produto){
        Produto currentProduto = produtoService.findById(id);

        currentProduto.setId(produto.getId());
        currentProduto.setName(produto.getName());
        currentProduto.setPreco(produto.getPreco());
        currentProduto.setQuantidade(produto.getQuantidade());

        produtoService.updateProduto(currentProduto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/produto/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Produto> deleteProduto(@PathVariable long id){
        Produto produto = produtoService.findById(id);
        if(produto == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        produtoService.deleteProdutoById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/produto/", method = RequestMethod.DELETE)
    public ResponseEntity<Produto> deleteAllProdutos(){
        produtoService.deleteAllProdutos();
        return new ResponseEntity<Produto>(HttpStatus.NO_CONTENT);
    }
}
