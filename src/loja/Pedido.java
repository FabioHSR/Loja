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

import loja.DAO.PedidoDAO;

/**
 *
 * @author 082170007
 */
public class Pedido {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    private static List<Pedido> pedidos = new ArrayList<Pedido>();

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
            sPedido += "\n" + p.getDescricao() + " - " + item.getQuantidade() + " x " + preco + " = "
                    + item.getQuantidade() * preco;
            total += preco * item.getQuantidade();
        }
        sPedido += "\n----------------";
        sPedido += "\nTotal: " + total;

        PedidoDAO.writeFile("/Pedidos/nPedido.txt", Integer.toString(nPedido));
        PedidoDAO DAO = new PedidoDAO();
        DAO.writeFile(sPedido);

        return sPedido;
    }

    /**
     * @param itensPedido the itensPedido to set
     */
    public void setItensPedido(ItemPedido itemPedido) {
        this.itensPedido.add(itemPedido);
    }

    public void contaPedido() {
        nPedido++;
    }

    public static int getnPedido(){
        return nPedido;
    }
    public static void setnPedido(int parseInt) {
        nPedido = parseInt;
	}
    public static void novoPedido() {
        if (Produto.tamanho == 0) {
            System.out.println("Sem produtos cadastrados.");
            return;
        }
        String escolha = "";
        Pedido pedido = new Pedido();
        Scanner s = new Scanner(System.in);
        do {
            System.out.println("Adicione um produto para o pedido, ou digite 0 para cancelar a adição deste item.");
            Produto.listaProdutos();
            escolha = s.nextLine();
            String max = Integer.toString(Produto.tamanho);
            while (!escolha.matches("[0-" + max + "]")) {
                System.out.println(
                        "\nPor favor, escolha um opção válida do menu, ou digite 0 para cancelar a adição deste item.");
                escolha = s.nextLine();
            }
            if (!escolha.equals("0")) {
                int indexProduto = Integer.parseInt(escolha);
                Produto produtoPedido = Produto.produtoFromLista(indexProduto - 1);
                boolean jaExsite = pedido.verificaItemPedidoExiste(produtoPedido);
                if (jaExsite)
                    System.out.println(
                            "Produto já existente no pedido, digite a nova quantidade total desejada ou 0 para cancelar a adição deste item.");
                else
                    System.out.println("Adicione a quantidade, ou digite 0 para cancelar a adição deste item.");
                escolha = s.nextLine();
                while (!escolha.matches("[\\d]+")) {
                    System.out.println(
                            "\nPor favor, digite uma quantidade valida, ou digite 0 para cancelar a adição deste item.");
                    escolha = s.nextLine();
                }
                if (!escolha.equals("0")) {
                    int quantidade = Integer.parseInt(escolha);
                    if (jaExsite) {
                        pedido.atualizaPedido(produtoPedido, quantidade);
                        System.out.println("\nItem de pedido atualizado.");
                    } else {
                        ItemPedido ip = new ItemPedido(produtoPedido, quantidade);
                        pedido.itensPedido.add(ip);
                        System.out.println("\nItem de pedido cadastrado.");
                    }
                }
            }
            String menu;
            String regex;
            String saida;
            if(pedido.itensPedido.size()>0)
            {
                menu = "\n1)Novo item\n2)Finalizar Pedido\n3)Cancelar Pedido";
                regex = "[123]";
                saida= "3";
            }
            else
            {
                menu = "\n1)Novo item\n2)Cancelar Pedido";
                regex = "[12]";
                saida= "2";
            }

            System.out.println(menu);
            escolha = s.nextLine();
            while (!escolha.matches(regex)) {
                System.out.println("\nPor favor, digite uma opção válida.");
                System.out.println(menu);
                escolha = s.nextLine();
            }
            if (escolha.equals(saida))
                return;
        } while (escolha.equals("1"));
        pedidos.add(pedido);
        nPedido++;
        System.out.println("Deseja imprimir o pedido?\n1)Sim\n2)Não");
        escolha = s.nextLine();
        while (!escolha.matches("[1-2]")) {
            System.out.println("Por favor, digite uma opção válida.");
            System.out.println("Deseja imprimir o pedido?\n1)Sim\n2)Não");
            escolha = s.nextLine();
        }
        if (escolha.equals("1"))
        {
            System.out.println(pedido.imprimePedido());
        }
    }

    private void atualizaPedido(Produto produtoPedido, int quantidade) {
        for (int n = 0; n < this.itensPedido.size(); n++) {
            if (this.itensPedido.get(n).getProduto().getDescricao() == produtoPedido.getDescricao())
                this.itensPedido.get(n).setQuantidade(quantidade);
        }
    }

    private boolean verificaItemPedidoExiste(Produto prod) {
        for (int n = 0; n < this.itensPedido.size(); n++) {
            if (this.itensPedido.get(n).getProduto().getDescricao() == prod.getDescricao())
                return true;
        }
        return false;
    }



}
