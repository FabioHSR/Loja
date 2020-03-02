/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author 082170007
 */
public class Produto {
    private String descricao;
    private double preço;
    public static int tamanho = 0;

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preço;
    }

    private static List<Produto> produtos = new ArrayList<Produto>();

    public Produto(String descricao, double preço) {
        this.descricao = descricao;
        this.preço = preço;
    }

    public static Produto produtoFromLista(int index) {
        return produtos.get(index);
    }

    public void incluiProduto() {
        produtos.add(this);
        tamanho = produtos.size();
    }

    public static void alteraProduto() {
        if (produtos.size() != 0) {
            System.out.println("Selecoine o produto que deseja atualizar.");
            listaProdutos();
            Scanner s = new Scanner(System.in);
            String escolha = s.nextLine();
            String max = Integer.toString(produtos.size());
            while (!escolha.matches("[1-" + max + "]")) {
                System.out.println("Por favor, escolha um opção válida do menu.");
                escolha = s.nextLine();
            }
            Produto p = inputProduto();
            if (p != null) {
                produtos.set(Integer.parseInt(escolha) - 1, p);
                System.out.println("Produto alterado com sucesso.");
            }
        } else {
            System.out.println("Sem produtos para cadastrados.");
        }
    }

    public static void listaProdutos() {
        System.out.println(produtosToString());
    }

    public static String produtosToString() {
        String produtosStr = "";
        int qtd = produtos.size();
        if (qtd > 0) {
            for (int n = 0; n < produtos.size(); n++) {
                produtosStr += String.format("\n%d) %s - Preço: %.2f", n + 1, produtos.get(n).descricao,
                        produtos.get(n).preço);
            }
        } else
            produtosStr = "Sem produtos cadastrados";
        return produtosStr;
    }

    public static void cadastraProduto() {
        Produto p = inputProduto();
        if (p != null) {
            p.incluiProduto();
            System.out.println("Cadastro realizado.");
        }
    }

    public static Produto inputProduto() {
        System.out.println("Digite a descrição ou 0 para cancelar.");
        Scanner s = new Scanner(System.in);
        String descrição = s.nextLine();
        if (descrição.equals("0")) {
            System.out.println("Operação cancelada pelo operador.");
            return null;
        }
        System.out.println("Digite o preço ou 0 para cancelar.");
        String preço = s.nextLine();
        while (!Biblioteca.isParsableDouble(preço) && preço != "0") {
            System.out.println("Por favor, digite um valor válido ou 0 para cancelar.");
            preço = s.nextLine();
        }
        if (!preço.equals("0")) {
            Produto p = new Produto(descrição, Double.parseDouble(preço));
            return p;
        } else {
            System.out.println("Operação cancelada pelo operador.");
            Biblioteca.exibeMenu();
            return null;
        }
    }
}
