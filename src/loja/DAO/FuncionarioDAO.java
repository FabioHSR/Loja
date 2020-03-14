package loja.DAO;

import java.util.List;

import loja.Funcionario;
import loja.Gerente;
import loja.Vendedor;

public class FuncionarioDAO extends BaseDAO{

    String path = "/funcionarios.txt";
    @Override
    public void txtToObjectArray(String rootpath) {
        super.txtToObjectArray(rootpath+this.path);        
    }

    //generalizar método
    @Override
    protected void criaObjeto(String[] objectArray) {
        Funcionario f;
        if(objectArray[3].equals("VENDEDOR"))
        {
            f = new Vendedor(objectArray[0], objectArray[1], objectArray[2]);
            f.addFuncListaSemAtualizarTXT();
        }
        else{
            f = new Gerente(objectArray[0], objectArray[1], objectArray[2]);
            f.addFuncListaSemAtualizarTXT();
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