package Util;

import Model.model.Cliente;
import Model.model.Empresa;
import Model.repository.ClienteRepository;
import Model.repository.Database;
import Model.repository.EmpresaRepository;
import java.util.List;

public class VerificarRegEmpresa{
    
    public static boolean verificarCep(String cep){
        return Util.verificarNumero(cep, 8);
    }
    
    public static boolean verificarCnpj(String cnpj){
        return Util.verificarNumero(cnpj, 14);
    }
    
    public static boolean verificarTelefone(String telefone){
        if(Util.verificarNumero(telefone, 11) || Util.verificarNumero(telefone, 10)){
            return true;
        }
        return false;
    }
    
    public static boolean existeEmail(String email){
        Database database = Util.openDatabase("empresasDatabase");
        EmpresaRepository empresaRP = new EmpresaRepository(database);
        Database database0 = Util.openDatabase("clientesDatabase");
        ClienteRepository clienteRP = new ClienteRepository(database0);

        for(Empresa x : empresaRP.loadAll()){
            if(x.getEmail() == email){
                return true;
            }
        }
        for(Cliente x : clienteRP.loadAll()){
            if(x.getEmail() == email){
                return true;
            }
        }
        return false;
    }
    
    public static boolean existeCnpj(String cnpj){
        Database database = Util.openDatabase("empresasDatabase");
        EmpresaRepository empresaRP = new EmpresaRepository(database);
        
        for(Empresa x : empresaRP.loadAll()){
            if(x.getCnpj() == cnpj){
                return true;
            }
        }
        return false;
    }
    
    public static boolean verificarSenha(String senha){
        char[] list = senha.toCharArray();
        if(list.length < 8){
            return false;
        }
        return true;
    }
    
}
