package com.example.senai.View;


import com.senai.crudSemBanco.controller.ProdutoController;
import com.senai.crudSemBanco.model.Produto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProdutoView {

    ProdutoController pc = new ProdutoController();

    @GetMapping("/produto")
    public List<Produto> getAllProdutos(){
        return pc.pegarTodosOsProdutos();
    }

    @PostMapping("/produto")
    public String postNovoProduto(@RequestBody Produto p){
        pc.inserirNoBanco(p);
        return "Sucesso";
    }
    @DeleteMapping("/produto")
    public String deletarProduto(@RequestBody Integer idProduto) {
        if(pc.excluirProduto(idProduto)) {
            return "Sucesso!";
        }else {
            return "Falha...";
        }
    }
}
