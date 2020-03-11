package loja;

import java.text.ParseException;
import java.util.Scanner;


public class Biblioteca {

    public static boolean isParsableDouble(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isParsableInt(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void exibeMenu(){
        Scanner s = new Scanner(System.in);
        String escolha;
        System.out.println("Menu Geral:\n" + "1) Produtos\n" + "2) Clientes\n" + "3) Cadastra pedido");
        escolha =s.nextLine();
        while (!escolha.matches("[123]")) {
            System.out.println("Por favor, escolha um opção válida do menu.");            
            escolha = s.nextLine().toString();
        }
        int opcao = Integer.parseInt(escolha);
        switch(opcao)
        {
            case 1: menuProdutos(); break;
            case 2: menuClientes(); break;
            case 3: menuPedido(); break;
        }
        exibeMenu();
    }

    public static void menuProdutos() {
        Scanner s = new Scanner(System.in);
        System.out.println("Menu Produtos:\n1) Cadastro de Produto\n2) Listar produtos\n3) Atualizar produto\n4) Sair");
        String escolha =s.nextLine();
        while (!escolha.matches("[1234]")) {
            System.out.println("Por favor, escolha um opção válida do menu.");            
            escolha = s.nextLine();
        }
        int opcao = Integer.parseInt(escolha);
        switch(opcao)
        {
            case 1: Produto.cadastraProduto(); break;
            case 2: Produto.listaProdutos(); break;
            case 3: Produto.alteraProduto(); break;
            case 4: return;
        }
        menuProdutos();
    }
    
    private static void menuClientes() {
        Scanner s = new Scanner(System.in);
        System.out.println("Menu Clientes:\n1) Cadastro de clientes\n2) Listar clientes\n3) Atualizar cliente\n4) Sair" );
        String escolha =s.nextLine();
        while (!escolha.matches("[1234]")) {
            System.out.println("Por favor, escolha um opção válida do menu.");            
            escolha = s.nextLine();
        }
        int opcao = Integer.parseInt(escolha);
        switch(opcao)
        {
            case 1: Cliente.cadastraCliente(); break;
            case 2: Cliente.listaClientes(); break;
            case 3: Cliente.alteraCliente(); break;
            case 4: return;
        }        
        menuClientes();
    }

    private static void menuPedido() {
        Scanner s = new Scanner(System.in);
        String escolha;
        System.out.println("Menu Pedidos:\n1) Novo pedido\n2) Sair" );
        escolha =s.nextLine();
        while (!escolha.matches("[12]")) {
            System.out.println("Por favor, escolha um opção válida do menu.");            
            escolha = s.nextLine();
        }
        int opcao = Integer.parseInt(escolha);
        switch(opcao)
        {
            case 1: Pedido.novoPedido(); break;
            case 2: return;
        }        
        menuPedido();
    }

}