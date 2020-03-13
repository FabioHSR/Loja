/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 082170007
 */
public abstract class Funcionario {

    static void listaFuncionarios() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    private static List<Funcionario> funcionarios = new ArrayList<Funcionario>();

    public Funcionario(String nome, String usuario, String senha) {
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
    }

    public void addFuncLista() {
        getFuncionarios().add(this);
    }

    public static void cadastraFuncionario(Funcionario usuarioLogado) {
        if (usuarioLogado instanceof ICadastraFuncionario) {
            System.out.println("Sucesso");
        } else {
            System.out.println("Usuario não autorizado");
        }
    }

    /**
     * @return the funcionarios
     */
    public static List<Funcionario> getFuncionarios() {
        return funcionarios;
    }
    


}
