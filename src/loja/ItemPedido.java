/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja;

/**
 *
 * @author 082170007
 */
public class ItemPedido {
    public Produto produto;
    public int quantidade;

    public ItemPedido (Produto produto, int quantidade)
    {
        this.produto = produto;
        this.quantidade = quantidade;
    }
}
