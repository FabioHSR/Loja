package loja.DAO;

import java.util.List;

import loja.Biblioteca.Menus;
import loja.Biblioteca.Metodos;
import loja.Models.Produto;

public class ProdutoDAO extends BaseDAO {

    String path = "/produtos.txt";

    @Override
    public void txtToObjectArray(String rootpath) {
        super.txtToObjectArray(rootpath + this.path);
    }

    @Override
    protected void criaObjeto(String[] objectArray) {
        if (Metodos.isParsableDouble(objectArray[1].replace(",", "."))) {
            Produto p = new Produto(objectArray[0], Double.parseDouble(objectArray[1].replace(",", ".")));
            p.incluiProdutoSemAtualizarTXT();
        }
    }
    public void writeFile(List<String>dados){
        super.writeFile(this.path,dados);
    }
    @Override
    public void writeFile(String path, List<String>dados){
        super.writeFile(path,dados);
    }

}