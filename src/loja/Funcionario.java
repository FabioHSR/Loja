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

public abstract class Funcionario {

    enum Cargo {
        GERENTE, VENDEDOR
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    protected String nome;
    protected String usuario;
    protected String senha;
    protected Cargo cargo;

    private static List<Funcionario> funcionarios = new ArrayList<Funcionario>();

    public Funcionario(String nome, String usuario, String senha, Cargo cargo) {
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
        this.cargo = cargo;
    }

    public void addFuncLista() {
        getFuncionarios().add(this);
    }

    public static void cadastraFuncionario(Funcionario usuarioLogado) {
        if (usuarioLogado instanceof ICadastraFuncionario) {
            Scanner s = new Scanner(System.in);
            System.out.println("Selecione o cargo do novo funcionario ou 0 para cancelar");
            int index = 1;
            for (Cargo myVar : Cargo.values()) {
                System.out.println(String.format("%d) Novo %s", index, myVar.toString()));
                index++;
            }
            String cargo = s.nextLine();
            String max = Integer.toString(Cargo.values().length);
            while (!cargo.matches("[0-" + max + "]")) {
                System.out.println("Por favor, digite um valor válido ou 0 para cancelar.");
                cargo = s.nextLine();
            }
            if (cargo.equals("0")) {
                System.out.println("Operação cancelada.");
                return;
            } else {
                System.out.println("Digite o nome do novo funcionario ou 0 para cancelar");
                String nome = s.nextLine();
                if (nome.equals("0")) {
                    System.out.println("Operação cancelada.");
                    return;
                }
                System.out.println("Digite o usuario do novo funcionario ou 0 para cancelar");
                String usuario = s.nextLine();
                while (!Funcionario.validaNovoUsuario(usuario) && !usuario.equals("0")) {
                    System.out.println("Usuario já em uso, tente novamente ou 0 para cancelar");
                    usuario = s.nextLine();
                }
                if (usuario.equals("0")) {
                    System.out.println("Operação cancelada.");
                    return;
                }
                System.out.println("Digite a senha do novo funcionario ou 0 para cancelar");
                String senha = s.nextLine();
                while (!senha.matches("^[^ ;]{4,8}$") && !senha.equals("0")) {
                    System.out.println(
                            "Por favor, digite uma senha de 4 a 8 caracteres que não contenha espaços ou ;, ou digite 0 para cancelar");
                    senha = s.nextLine();
                }
                if (senha.equals("0")) {
                    System.out.println("Operação cancelada.");
                    return;
                }
                int cargoIndex = Integer.parseInt(cargo);
                Funcionario f;
                if (Cargo.values()[cargoIndex] == Cargo.GERENTE) //generalizar se der tempo
                    f = new Gerente(nome, usuario, senha);
                else
                    f = new Vendedor(nome, usuario, senha);
                f.addFuncLista();
                System.out.println("Operação realizada com sucesso.");
            }
        } else {
            System.out.println("Usuário não autorizado a realizar cadastro de funcionarios");
        }
    }

    private static boolean validaNovoUsuario(String novoUsuario) {
        for (Funcionario f : Funcionario.getFuncionarios()) {
            if (f.getUsuario().equals(novoUsuario)) {
                return false;
            }
        }
        return true;
    }

    /**
     * @return the funcionarios
     */
    public static List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    static void listaFuncionarios() {
        String funcionariosStr = "";
        int qtd = funcionarios.size();
        if (qtd > 0) {
            for (int n = 0; n < funcionarios.size(); n++) {
                funcionariosStr += String.format("\n%d) %s", n + 1, funcionarios.get(n).nome);
            }
        } else
            funcionariosStr = "Sem funcionarios cadastrados";
        System.out.println(funcionariosStr);
    }

    public static void funcionariosToCSV() {
        String funcionariosCSV = "";
        int qtd = funcionarios.size();
        if (qtd > 0) {
            for (int n = 0; n < funcionarios.size(); n++) {
                funcionariosCSV += String.format("%s;%s;%s;%s", funcionarios.get(n).nome, funcionarios.get(n).usuario,
                        funcionarios.get(n).senha, funcionarios.get(n).cargo);
            }
        } else
            funcionariosCSV = "Sem funcionarios cadastrados";
    }

}
