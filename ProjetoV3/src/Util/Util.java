package Util;

import Model.model.Cliente;
import Model.model.Empresa;
import Model.repository.ClienteRepository;
import Model.repository.Database;
import Model.repository.EmpresaRepository;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

/**
 * Conjunto de vários métodos úteis para o projeto
 */
public class Util {
    /**
     * Verifica se ass duas Strings são iguais
     * @param a primeira String
     * @param b segunda String
     * @return retorna true se as Strings forem iguais. Caso contrário, retorna false
     */
    public static boolean verificarIgualdade(String a, String b){
        boolean validador = false;
        if(a.equals(b)){
            validador = true;
        }
        return validador;
    }
    /**
     * Verifica se a String está em branco
     * @param s String a ser verificada
     * @return retorna true se a String estiver em branco. Do contrário, retorna false
     */
    public static boolean stringVazia(String s){
        boolean validador = false;
        if(s.trim().isEmpty()){
            validador = true;
        }
        return validador;
    }
    /**
     * Verifica se algum item da lista está vazio
     * @param list lista a ser verificada
     * @return retorna true se existir elemento em branco. Do contrário, retorna false
     */
    public static boolean existeVazio(List<String> list){
        boolean validador = false;
        for(String x : list){
            if(stringVazia(x)){
                validador = true;
                break;
            }
        }
        return validador;
    }
    /**
     * Cria uma lista com os atributos do cliente do parâmetro
     * @param cliente cliente a ser listado
     * @return lista dos atributos do cliente do parâmetro
     */
    public static List<String> listCliente(Cliente cliente){
        List<String> list = new ArrayList<>();
        list.add(cliente.getNome());
        list.add(cliente.getCpf());
        list.add(cliente.getDataNascimento());
        list.add(cliente.getEmail());
        list.add(cliente.getCep());
        list.add(cliente.getCidade());
        list.add(cliente.getTelefone());
        list.add(cliente.getSenha());
        list.add(cliente.getEstado());
        return list;
    }
    /**
     * Cria um banco de dados e inicia sua conexão
     * @param nome nome do bando de dados a ser criado/aberto
     * @return retorna o banco de dados que foi criado
     */
    public static Database openDatabase(String nome){
        Database database = new Database(nome);
        database.getConnection();
        return database;
    }
    /**
     * Verifica se a String passada no parâmetro é um número, e se ela possui o mesmo tamanho que o passado no parâmetro
     * @param num String a ser verificada
     * @param tamanho tamanho que o número deve ter
     * @return true se passar pela verificação, false do contrário
     */
    public static boolean verificarNumero(String num, int tamanho){
        if(Util.stringVazia(num)){
           return false;
        }
        else{
            char[] list = num.toCharArray();
            if(list.length == tamanho){
                for(char x : list){
                    if(!Character.isDigit(x)){
                        return false;
                    }
                }
            }
            else{
                return false;
            }
        }
        return true;
    }
    /**
     * Formata uma data do pattern "yyyy-MM-dd" para o pattern "dd/MM/yyyy"
     * @param data pattern a ser convertido
     * @return pattern convertido
     */
    public static String formatData(String data){
        DateTimeFormatter inDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter outDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(data, inDate);
        String newData = date.format(outDate);
        return newData;
    }
    /**
     * Transforma uma String em um LocalDate
     * @param data String a ser transformada
     * @param pattern pattern em que a String está formatada
     * @return novo LocalDate
     */
    public static LocalDate stringToDate(String data, String pattern){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return LocalDate.parse(data, formatter);
    }
    /**
     * Verifica se um número é de telefone
     * @param telefone número a ser verificado
     * @return true se passar pela verificação, false do contrário
     */
    public static boolean verificarTelefone(String telefone){
        if(Util.verificarNumero(telefone, 11) || Util.verificarNumero(telefone, 10)){
            return true;
        }
        return false;
    }
    /**
     * Verifica se um CEP é válido
     * @param cep CEP a ser verificado
     * @return true se passar pela verificação, false do contrário
     */
    public static boolean verificarCep(String cep){
        return Util.verificarNumero(cep, 8);
    }
    /**
     * Verifica se uma senha possui 8 ou mais caracteres
     * @param senha senha a ser verificada
     * @return true se passar pela verificação, false do contrário
     */
    public static boolean verificarSenha(String senha){
        char[] list = senha.toCharArray();
        if(list.length < 8){
            return false;
        }
        return true;
    }
    /**
     * Verifica se o email dado já existe em um cliente ou empresa do banco de dados
     * @param email email a ser verificado
     * @return true se passar pela verificação, false do contrário
     */
    public static boolean verificarEmail(String email){
        Database database1 = Util.openDatabase("clientesDatabase");
        Database database2 = Util.openDatabase("empresasDatabase");
        ClienteRepository clienteRP = new ClienteRepository(database1);
        EmpresaRepository empresaRP = new EmpresaRepository(database2);
        List<Cliente> clientes = clienteRP.loadAll();
        List<Empresa> empresas = empresaRP.loadAll();
        for(Cliente x : clientes){
            if(email.equals(x.getEmail())){
                return false;
            }
        }
        for(Empresa x : empresas){
            if(email.equals(x.getEmail())){
                return false;
            }
        }
        return true;
    }
    /**
     * Verifica se um CNPJ é válido
     * @param cnpj CNPJ a ser verificad
     * @return true se passar pela verificação, false do contrário
     */
    public static boolean verificarCnpj(String cnpj){
        return Util.verificarNumero(cnpj, 14);
    }
    /**
     * Verifica se um CNPJ já existe no banco de dados
     * @param cnpj CNPJ a ser verificado
     * @return true se já existir, false do contrário
     */
    public static boolean existeCnpj(String cnpj){
        Database database = Util.openDatabase("empresasDatabase");
        EmpresaRepository empresaRP = new EmpresaRepository(database);
        List<Empresa> empresas = empresaRP.loadAll();
        for(Empresa x : empresas){
            if(x.getCnpj() == cnpj){
                return true;
            }
        }
        return false;
    }
    /**
     * Verifica se um CPF é válido
     * @param cpf CPF a ser verificado
     * @return true se passar pela verificação, false do contrário
     */
    public static boolean verificarCpf(String cpf){
        Database database = Util.openDatabase("clientesDatabase");
        ClienteRepository clienteRP = new ClienteRepository(database);
        List<Cliente> clientes = clienteRP.loadAll();
        if(Util.verificarNumero(cpf, 11)){
            for(Cliente x : clientes){
                if(cpf.equals(x.getCpf())){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
