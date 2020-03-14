package loja.DAO;

import java.util.List;

import loja.Cliente;

public class ClienteDAO extends BaseDAO {

    String path = "/clientes.txt";

    @Override
    public void txtToObjectArray(String rootpath) {
        super.txtToObjectArray(rootpath + this.path);
    }

    @Override
    protected void criaObjeto(String[] objectArray) {

        Cliente c = new Cliente(objectArray[0]);
        c.incluiCliente();
    }
    
    public void writeFile(List<String>dados){
        super.writeFile(this.path,dados);
    }
    @Override
    public void writeFile(String path, List<String>dados){
        super.writeFile(path,dados);
    }

}