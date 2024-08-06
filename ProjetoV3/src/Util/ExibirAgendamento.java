package Util;

import Model.model.Agendamento;
import Model.model.Cliente;
import Model.model.Empresa;
import Model.model.Servico;
import Model.repository.ClienteRepository;
import Model.repository.Database;
import Model.repository.EmpresaRepository;
import Model.repository.ServicoRepository;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
/**
 * Define o método responsável transformar o agendamento em um agendamento exibível
 */
public class ExibirAgendamento {
    
    /**
     * Transforma um agendamento de serviço em um agendamento exibível, para que o mesmo possa ser exibido em uma table view.
     * 
     * @param agend É o agendamendo que será convertido em um agendamento exibível
     * @param entidade Descreve a entidade que que será exibida. Se for "cliente", a entidade será o cliente que fez o agendamento.
     * Se for "empresa", a entidade será a empresa que prestará o serviço.
     * @return Agendamento exibível para ser usado na table view.
     */
    public static AgendamentoExibivel getAgendamentoExibivel(Agendamento agend, String entidade){
        
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
        
        Database database2 = Util.openDatabase("clientesDatabase");
        ClienteRepository clienteRP = new ClienteRepository(database2);
        Cliente cliente = clienteRP.loadFromId(agend.getCliente());
        
        AgendamentoExibivel agendamento = new AgendamentoExibivel();
        
        agendamento.setId(agend.getId());
        agendamento.setServico(servico.getNome());
        agendamento.setPreco(String.valueOf(servico.getPreco()));
        agendamento.setVeiculo(agend.getModeloVeiculo());
        agendamento.setData(Util.formatData(agend.getData()));
        agendamento.setHora(agend.getHora());
        agendamento.setEndereco(agend.getEndereco());
        
        if(entidade.equals("empresa")){
            agendamento.setEntidade(empresa.getNome());
        }
        else{
            agendamento.setEntidade(cliente.getNome());
        }
        
        return agendamento;
    }
}
