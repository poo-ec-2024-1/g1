package Util;

import Model.model.Agendamento;
import java.time.LocalDate;


public class VerificarAgendamento {
    
    public static boolean isEmpty(String s){
        boolean validator = true;
        if(s.trim().isEmpty()){
            validator = false;
        }
        return validator;
    }
    
    public static boolean verificarHora(String hora){
        return isEmpty(hora);
    }
    
    public static boolean verificarModeloVeiculo(String modeloVeiculo){
        return isEmpty(modeloVeiculo);
    }
    
    public static boolean verificarPlaca(String placa){
        return isEmpty(placa);
    }
    
    public static boolean verificarEndereco(String endereco){
        return isEmpty(endereco);
    }
    
    public static boolean verificarData(String data){
        return isEmpty(data);
    }
    
    public static boolean verificarFormaPagamento(String formaPagamento){
        return isEmpty(formaPagamento);
    }
    
    public static boolean verificarAgendamento(Agendamento agendamento){
        boolean a = verificarHora(agendamento.getHora());
        boolean b = verificarModeloVeiculo(agendamento.getModeloVeiculo());
        boolean c = verificarPlaca(agendamento.getPlaca());
        boolean d = verificarEndereco(agendamento.getEndereco());
        boolean e = verificarData(agendamento.getData());
        boolean f = verificarFormaPagamento(agendamento.getFormaPagamento());
        boolean validator = false;
        if((a && b && c && d && e && f)){
            validator = true;
        }
        return validator;
    }
}
