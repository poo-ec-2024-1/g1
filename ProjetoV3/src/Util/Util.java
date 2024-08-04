package Util;

import Model.model.Cliente;
import Model.repository.Database;
import java.lang.reflect.Field;
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
    
    public static Database openDatabase(String nome){
        Database database = new Database(nome);
        database.getConnection();
        return database;
    }
    
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
}
