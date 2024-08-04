package Util;

import Model.model.Agendamento;
import Model.model.Empresa;
import Model.model.Servico;
import Model.repository.Database;
import Model.repository.EmpresaRepository;
import Model.repository.ServicoRepository;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ExibirAgendamento {
    
    public static AgendamentoExibivel getAgendamentoExibivel(Agendamento agend){
        
        Database database = Util.openDatabase("servicosDatabase");
        ServicoRepository servicoRP = new ServicoRepository(database);
        List<Servico> servicos = servicoRP.loadAll();
        Servico servico = new Servico();
        for(Servico x : servicos){
            if(x.getId() == agend.getServico()){
                servico = x;
                break;
            }
        }
        Database database1 = Util.openDatabase("empresasDatabase");
        EmpresaRepository empresaRP = new EmpresaRepository(database1);
        Empresa empresa = empresaRP.loadFromId(servico.getEmpResponsavel());
        
        AgendamentoExibivel agendamento = new AgendamentoExibivel();
        
        agendamento.setId(agend.getId());
        agendamento.setEmpresa(empresa.getNome());
        agendamento.setServico(servico.getNome());
        agendamento.setPreco(String.valueOf(servico.getPreco()));
        agendamento.setVeiculo(agend.getModeloVeiculo());
        agendamento.setData(formatData(agend.getData()));
        agendamento.setHora(agend.getHora());
        agendamento.setEndereco(agend.getEndereco());
        
        return agendamento;
    }
    
    public static String formatData(String data){
        DateTimeFormatter inDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter outDate = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = LocalDate.parse(data, inDate);
        String newData = date.format(outDate);
        return newData;
    }
}
