/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja.Models;

/**
 *
 * @author 082170007
 */
public class Gerente extends Funcionario implements ICadastraFuncionario {
    
    public Gerente(String nome, String usuario, String senha) {
        super(nome, usuario, senha,Cargo.GERENTE);
    }        
}
