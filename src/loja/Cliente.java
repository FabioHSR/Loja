package loja;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import loja.DAO.ClienteDAO;

public class Cliente {

    protected String nome;

    private static List<Cliente> clientes = new ArrayList<Cliente>();

    public Cliente(String nome) {
        this.nome = nome;
    }

    public void incluiCliente() {
        clientes.add(this);
        atualizaTXT();
    }

    private static void atualizaTXT() {
        ClienteDAO DAO = new ClienteDAO();
        DAO.writeFile(clientesToCSV());
    }
    
    public static List<String> clientesToCSV() {
        List<String> clientesCSV = new ArrayList<String>();
        int qtd = clientes.size();
        if (qtd > 0) {
            for (int n = 0; n < clientes.size(); n++) {
                String linha = String.format("%s", clientes.get(n).nome);
                clientesCSV.add(linha);
            }
        }
        return clientesCSV;
    }
    public static void alteraCliente() {
        if(clientes.size()!=0)
        {
            System.out.println("Selecoine o cliente que deseja atualizar.");
            listaClientes();
            Scanner s = new Scanner(System.in);
            String escolha = s.nextLine();
            String max = Integer.toString(clientes.size());
            while (!escolha.matches("[1-" + max + "]")) {
                System.out.println("Por favor, escolha um opção válida do menu.");
                escolha = s.nextLine();
            }
            Cliente p = inputCliente();
            if (p != null) {
                clientes.set(Integer.parseInt(escolha)-1, p);
                System.out.println("Cliente alterado com sucesso.");
                atualizaTXT();
            }
        }
        else{
            System.out.println("Sem clientes para cadastrados.");
        }
    }

    public static void listaClientes(){
        System.out.println(clientesToString());
    }

    public static String clientesToString() {
        String clientesStr = "";
        int qtd = clientes.size();
        if (qtd > 0) {
            for (int n = 0; n < clientes.size(); n++) {
                clientesStr += String.format("\n%d) %s", n + 1, clientes.get(n).nome);
            }
        } else
            clientesStr = "Sem clientes cadastrados";
        return clientesStr;
    }

    public static void cadastraCliente() {
        Cliente c = inputCliente();
        if (c != null) {
            c.incluiCliente();
            System.out.println("Cadastro realizado.");
        }
    }

    public static Cliente inputCliente() {
        System.out.println("Digite o nome ou 0 para cancelar.");
        Scanner s = new Scanner(System.in);
        String nome = s.nextLine();
        if (nome.equals("0")) {
            System.out.println("Operação cancelada pelo operador.");
            return null;
        }
            Cliente c = new Cliente(nome);
            return c;        
    }

	public void incluiClienteSemAtualizarTXT() {
        clientes.add(this);
	}
}