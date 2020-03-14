package loja.DAO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jdk.nashorn.internal.ir.CatchNode;
import loja.Loja;

public abstract class BaseDAO{


    protected void txtToObjectArray(String path){
        try {
            try(FileReader fr = new FileReader(path)){
                try(BufferedReader br = new BufferedReader(fr)){
                  String linha;
        
                  while((linha = br.readLine()) != null) {                
                    String[] objeto = linha.split(";");
                    criaObjeto(objeto);
                  }                  
                }
              }
        } catch (Exception e) {
            System.out.println("Problemas ao ler ou encontrar o arquivo.");
            System.out.println("Caminho do arquivo: "+path);
            System.out.println(e.getMessage());
        }
    }

    protected abstract void criaObjeto(String[] objectArray);

    public void writeFile(String path, List<String>dados) {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(Loja.rootpath+path));  
            for(String line : dados){
                pw.println(line);
            }
            pw.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}