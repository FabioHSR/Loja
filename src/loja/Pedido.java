/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author 082170007
 */
public class Pedido {
    SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
    
    
    private String dataPedido = (sdf.format(new Date()));
    private List<ItemPedido> itensPedido = new ArrayList<ItemPedido>();

    /**
     * @return the itensPedido
     */
    public String getItensPedido() {
        String sItensPedido = dataPedido;
        for(ItemPedido item : itensPedido){
            sItensPedido+= "\n"+item.produto.descricao+" x "+item.produto.preço+
                    " = "+item.quantidade*item.produto.preço;
        }
        return sItensPedido;
    }

    /**
     * @param itensPedido the itensPedido to set
     */
    public void setItensPedido(ItemPedido itemPedido) {
        this.itensPedido.add(itemPedido);
    }
}
