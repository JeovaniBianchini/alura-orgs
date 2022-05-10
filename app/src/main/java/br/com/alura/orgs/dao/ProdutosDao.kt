package br.com.alura.orgs.dao

import br.com.alura.orgs.model.Produto
import java.math.BigDecimal

class ProdutosDao {

    fun add(produto: Produto){
        produtos.add(produto)
    }

    fun listarTodos() : List<Produto> {
        return produtos.toList()
    }

    companion object {
        private val produtos = mutableListOf<Produto>(
            Produto(
                nome = "Salada de frutas",
                descricao = "Uva, abacaxi, laranja, melancia, morango",
                valor = BigDecimal("30.55")
            )
        )
    }
}