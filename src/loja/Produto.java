/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja;

/**
 *
 * @author 082170007
 */
public class Produto {
    public String descricao;
    public double preço;

    private List<Produto> produtos =  new ArrayList<Produto>();

    public Produto(String descricao, double preço){
        this.descricao = descricao;
        this.preço = preço;
    }


    
    public void CadastraProduto(ICadastraFuncionario func){
        
    }
}
