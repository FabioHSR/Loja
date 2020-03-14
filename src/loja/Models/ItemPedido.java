/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja.Models;

import loja.Models.Produto;

/**
 *
 * @author 082170007
 */
public class ItemPedido {
    private Produto produto;
    private int quantidade;

    public Produto getProduto(){
        return produto;
    }

    public int getQuantidade(){
        return quantidade;
    }

    public ItemPedido (Produto produto, int quantidade)
    {
        this.produto = produto;
        this.quantidade = quantidade;
    }

	public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
	}
}
