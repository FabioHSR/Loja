package loja;

import java.text.ParseException;
import java.util.Scanner;

public class Menus {

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

    public static void loginMenu() {
        Scanner s = new Scanner(System.in);
        String usuario;
        String senha;
        System.out.println("Login\nDigite seu usuário:");
        usuario = s.nextLine();
        System.out.println("Digite a senha:");
        senha = s.nextLine();
        while (!Login.autenticaUsuario(usuario, senha)) {
            System.out.println("\nUsuario ou senha invalidos, por favor tente novamente.");
            System.out.println("\nDigite o usuario:");
            usuario = s.nextLine();
            System.out.println("Digite a senha:");
            senha = s.nextLine();
        }
        System.out.println("\nBem vindo!\n");
        exibeMenu();
    }

    public static void exibeMenu() {
        Scanner s = new Scanner(System.in);
        String escolha;
        System.out.println("Menu Geral:" + "\n1) Produtos" + "\n2) Clientes" + "\n3) Pedido" + "\n4) Funcionarios");
        escolha = s.nextLine();
        while (!escolha.matches("[1-4]")) {
            System.out.println("Por favor, escolha um opção válida do menu.");
            escolha = s.nextLine().toString();
        }
        int opcao = Integer.parseInt(escolha);
        switch (opcao) {
            case 1:
                menuProdutos();
                break;
            case 2:
                menuClientes();
                break;
            case 3:
                menuPedido();
                break;
            case 4:
                menuFuncionarios();
                break;
        }
        exibeMenu();
    }

    public static void menuProdutos() {
        Scanner s = new Scanner(System.in);
        System.out.println("Menu Produtos:\n1) Cadastro de Produto\n2) Listar produtos\n3) Atualizar produto\n4) Sair");
        String escolha = s.nextLine();
        while (!escolha.matches("[1234]")) {
            System.out.println("Por favor, escolha um opção válida do menu.");
            escolha = s.nextLine();
        }
        int opcao = Integer.parseInt(escolha);
        switch (opcao) {
            case 1:
                Produto.cadastraProduto();
                break;
            case 2:
                Produto.listaProdutos();
                break;
            case 3:
                Produto.alteraProduto();
                break;
            case 4:
                return;
        }
        menuProdutos();
    }

    private static void menuClientes() {
        Scanner s = new Scanner(System.in);
        System.out.println("Menu Clientes:\n1) Cadastro de clientes\n2) Listar clientes\n3) Atualizar cliente\n4) Sair");
        String escolha = s.nextLine();
        while (!escolha.matches("[1234]")) {
            System.out.println("Por favor, escolha um opção válida do menu.");
            escolha = s.nextLine();
        }
        int opcao = Integer.parseInt(escolha);
        switch (opcao) {
            case 1:
                Cliente.cadastraCliente();
                break;
            case 2:
                Cliente.listaClientes();
                break;
            case 3:
                Cliente.alteraCliente();
                break;
            case 4:
                return;
        }
        menuClientes();
    }

    private static void menuPedido() {
        Scanner s = new Scanner(System.in);
        String escolha;
        System.out.println("Menu Pedidos:\n1) Novo pedido\n2) Sair");
        escolha = s.nextLine();
        while (!escolha.matches("[12]")) {
            System.out.println("Por favor, escolha um opção válida do menu.");
            escolha = s.nextLine();
        }
        int opcao = Integer.parseInt(escolha);
        switch (opcao) {
            case 1:
                Pedido.novoPedido();
                break;
            case 2:
                return;
        }
        menuPedido();
    }
    
        private static void menuFuncionarios() {
        Scanner s = new Scanner(System.in);
        System.out.println("Menu Funcionarios:\n1) Cadastro de funcionarios\n2) Listar funcionarios\n3) Sair");
        String escolha = s.nextLine();
        while (!escolha.matches("[1-3]")) {
            System.out.println("Por favor, escolha um opção válida do menu.");
            escolha = s.nextLine();
        }
        int opcao = Integer.parseInt(escolha);
        switch (opcao) {
            case 1:
                Funcionario.cadastraFuncionario(Login.usuarioLogado);
                break;
            case 2:
                Funcionario.listaFuncionarios();
                break;
            case 3:
                return;
        }
        menuFuncionarios();
    }

}
