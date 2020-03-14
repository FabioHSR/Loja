package loja.DAO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import loja.Loja;
import loja.Biblioteca.Menus;
import loja.Biblioteca.Metodos;
import loja.Models.Pedido;

public class PedidoDAO {

    String path = "/Pedidos/" + Pedido.getnPedido() + ".txt";

    public static void getnPedidoFromTXT(){
        try {
            try(FileReader fr = new FileReader(Loja.rootpath+"/Pedidos/nPedido.txt")){
                try(BufferedReader br = new BufferedReader(fr)){
                  String linha;
        
                  while((linha = br.readLine()) != null) {     
                      if(Metodos.isParsableInt(linha))           
                    Pedido.setnPedido(Integer.parseInt(linha));
                  }                  
                }
              }
        } catch (Exception e) {
            System.out.println("Problemas ao ler ou encontrar o arquivo.");
            System.out.println("Caminho do arquivo: "+Loja.rootpath+"/Pedidos/nPedido.txt");
            System.out.println(e.getMessage());
        }
    }


    public void writeFile(String dados) {
        writeFile(this.path,dados);
    }
    public static void writeFile(String path, String dados) {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(Loja.rootpath + path));
            pw.print(dados);
            pw.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}