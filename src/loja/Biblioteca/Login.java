/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja.Biblioteca;

import loja.Models.Funcionario;

/**
 *
 * @author 082170007
 */
public class Login {

    public static Funcionario usuarioLogado;

    public static boolean autenticaUsuario(String userDigitado, String senhaDigitada) {
        for (Funcionario f : Funcionario.getFuncionarios()) {
            if (f.getUsuario().equals(userDigitado) && f.getSenha().equals(senhaDigitada)) {
                usuarioLogado = f;
                return true;
            }
        }
        return false;
    }
}
