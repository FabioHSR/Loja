/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja;

import java.nio.file.FileAlreadyExistsException;


import jdk.nashorn.internal.runtime.regexp.joni.Regex;

/**
 *
 * @author 082170007
 */
public class Loja {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Produto p1 = new Produto("Produto1", 11.3);
        p1.incluiProduto();
        Produto p2 = new Produto("Produto2", 21.2);
        p2.incluiProduto();
        Produto p3 = new Produto("Produto3", 31.4);
        p3.incluiProduto();
        Produto p4= new Produto("Produto4", 41.1);
        p4.incluiProduto();

        Biblioteca.exibeMenu();
        

    }

}
