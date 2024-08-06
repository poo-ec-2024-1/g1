package Util;

import Model.model.Agendamento;
import java.time.LocalDate;

/**
 * Classe que verifica se um agendamento é válido
 */
public class VerificarAgendamento {
    /**
     * Verifica se a String está vazia
     * @param s String a ser verificada
     * @return true se passar pela verificação, false do contrário
     */
    public static boolean isEmpty(String s){
        boolean validator = true;
        if(s.trim().isEmpty()){
            validator = false;
        }
        return validator;
    }
    /**
     * Verifica se uma String hora está vazia
     * @param hora hora a ser verificada
     * @return true se passar pela verificação, false do contrário
     */
    public static boolean verificarHora(String hora){
        return isEmpty(hora);
    }
    /**
     * Verifica se uma String modeloVeiculo está vazia
     * @param modeloVeiculo modeloVeiculo a ser verificada
     * @return true se passar pela verificação, false do contrário
     */
    public static boolean verificarModeloVeiculo(String modeloVeiculo){
        return isEmpty(modeloVeiculo);
    }
    /**
     * Verifica se uma String placa está vazia
     * @param placa placa a ser verificada
     * @return true se passar pela verificação, false do contrário
     */
    public static boolean verificarPlaca(String placa){
        return isEmpty(placa);
    }
    /**
     * Verifica se uma String endereco está vazia
     * @param endereco endereco a ser verificado
     * @return true se passar pela verificação, false do contrário
     */
    public static boolean verificarEndereco(String endereco){
        return isEmpty(endereco);
    }
    /**
     * Verifica se uma String data está vazia
     * @param data data a ser verificada
     * @return true se passar pela verificação, false do contrário
     */
    public static boolean verificarData(String data){
        return isEmpty(data);
    }
    /**
     * Verifica se uma String formaPagamento está vazia
     * @param formaPagamento formaPagamento a ser verificada
     * @return true se passar pela verificação, false do contrário
     */
    public static boolean verificarFormaPagamento(String formaPagamento){
        return isEmpty(formaPagamento);
    }
    /**
     * Verifica um agendamento
     * @param agendamento a ser verificado
     * @return true se passar pela verificação, false do contrário
     */
    public static boolean verificarAgendamento(Agendamento agendamento){
        boolean a = verificarHora(agendamento.getHora());
        boolean b = verificarModeloVeiculo(agendamento.getModeloVeiculo());
        boolean c = verificarPlaca(agendamento.getPlaca());
        boolean d = verificarEndereco(agendamento.getEndereco());
        boolean e = verificarData(agendamento.getData());
        boolean f = verificarFormaPagamento(agendamento.getFormaPagamento());
        if((a && b && c && d && e && f)){
            return true;
        }
        return false;
    }
}
