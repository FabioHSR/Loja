/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author 082170007
 */
public class Pedido {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    private String dataPedido = (sdf.format(new Date()));
    private List<ItemPedido> itensPedido = new ArrayList<ItemPedido>();
    private double total = 0;
    private static int nPedido = 1;

    /**
     * @return the itensPedido
     */
    public String imprimePedido() {
        String sPedido = "";
        sPedido += "----------------";
        sPedido += "\nPedido Nº: " + nPedido + " - Data do pedido: " + dataPedido;
        sPedido += "\n----------------";
        for (ItemPedido item : itensPedido) {
            Produto p = item.getProduto();
            double preco = p.getPreco();
            sPedido += "\n" + p.getDescricao() +" - "+ item.getQuantidade() + " x " + preco + " = " + item.getQuantidade() * preco;
            total += preco*item.getQuantidade();
        }
        sPedido += "\n----------------";
        sPedido += "\nTotal: " + total;
        return sPedido;
    }

    /**
     * @param itensPedido the itensPedido to set
     */
    public void setItensPedido(ItemPedido itemPedido) {
        this.itensPedido.add(itemPedido);
    }
    public Pedido(){
        nPedido++;
    }

    public static void novoPedido() {
        if (Produto.tamanho == 0) {
            System.out.println("Sem produtos cadastrados.");
            return;
        }
        System.out.println("Adicione um produto para o pedido, ou digite 0 para cancelar.");
        Produto.listaProdutos();
        Scanner s = new Scanner(System.in);
        String escolha = s.nextLine();
        String max = Integer.toString(Produto.tamanho);
        while (!escolha.matches("[1-" + max + "]")) {
            System.out.println("Por favor, escolha um opção válida do menu, ou digite 0 para cancelar.");
            escolha = s.nextLine();
        }
        if (escolha.equals("0"))
            return;
        int indexProduto = Integer.parseInt(escolha);
        System.out.println("Adicione a quantidade:");
        escolha = s.nextLine();
        while (!escolha.matches("[\\d]+")) {
            System.out.println("Por favor, digite uma quantidade valida, ou digite 0 para cancelar.");
            escolha = s.nextLine();
        }
        if (escolha.equals("0"))
            return;
        int quantidade = Integer.parseInt(escolha);
        ItemPedido ip = new ItemPedido(Produto.produtoFromLista(indexProduto-1), quantidade);
        Pedido pedido = new Pedido();
        pedido.itensPedido.add(ip);
        System.out.println("Item de pedido cadastrado.");
        System.out.println(pedido.imprimePedido());
    }

}
