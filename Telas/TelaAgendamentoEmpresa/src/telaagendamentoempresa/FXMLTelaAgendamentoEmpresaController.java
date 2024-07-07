/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package telaagendamentoempresa;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author mathe
 */
public class FXMLTelaAgendamentoEmpresaController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private TextField textCEP;
    @FXML
    private TextField textCPF;
    @FXML
    private TextField textData;
    @FXML
    private TextField textDataNascimento;
    @FXML
    private TextArea textDescricao;
    @FXML
    private TextField textEmail;
    @FXML
    private TextField textEndereco;
    @FXML
    private TextField textHorario;
    @FXML
    private TextField textLocalizacao;
    @FXML
    private TextField textNomeCliente;
    @FXML
    private TextField textNomeServico;
    @FXML
    private TextField textPreco;
    @FXML
    private TextField textTelefone;
    @FXML
    private TextField textTempo;

    @FXML
    private ComboBox<AgendamentoEmpresa> cbAgendamentos;
    private List<AgendamentoEmpresa> agendamentos = new ArrayList<>();
    private ObservableList<AgendamentoEmpresa> obsAgendamentos;
    
    private AgendamentoEmpresa agendamento = new AgendamentoEmpresa();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        carregarDados();
    }    
    
    public void carregarDados(){
        AgendamentoEmpresa agendamento1 = new AgendamentoEmpresa("Lavagem Interior", "10/07/2023", "00:00", "30 min", "R$ 50,00",
                "Rua 5 Quadra 34 Lote 12 Jardim Vaca Nervosa", "Uma lavagem completa na parte interna do seu carro."
                        + " Ele vai ficar limpo e agradável!", "Jacinto Ferreira", "12345678901", "12/03/1998","(62) 966666666666", 
        "jacintoferreira@gmail.com", "7000097", "Rua 5 Quadra 34 Lote 12 Jardim Vaca Nervosa");
        AgendamentoEmpresa agendamento2 = new AgendamentoEmpresa("Troca de Óleo", "30/07/2023", "22:00", "30 min", "R$ 100,00",
                "Rua 5 Quadra 33 Lote 2 Parque das Capivaras", "Troca de óleo rápida e barata para o seu veículo."
                        + " Você não precisa sair de casa, e nem se sujar!", "Isadora da Silva", "21313123534", "30/01/2001", "(62) 96121221221", 
        "isasilva@hotmail.com", "773443", "Rua 2 Quadra 90 Lote 1 Bairro da Madeira");
        
        agendamentos.add(agendamento1);
        agendamentos.add(agendamento2);
        
        obsAgendamentos = FXCollections.observableArrayList(agendamentos);
        cbAgendamentos.setItems(obsAgendamentos);
    }
    
    public void exibirDados(){
        agendamento = cbAgendamentos.getSelectionModel().getSelectedItem();
        
        textCEP.setText(String.valueOf(agendamento.getCep()));
        textCPF.setText(String.valueOf(agendamento.getCpf()));
        textDataNascimento.setText(String.valueOf(agendamento.getDataNascimento()));
        textData.setText(String.valueOf(agendamento.getData()));
        textEmail.setText(String.valueOf(agendamento.getEmail()));
        textEndereco.setText(String.valueOf(agendamento.getEndereco()));
        textHorario.setText(String.valueOf(agendamento.getHorario()));
        textLocalizacao.setText(String.valueOf(agendamento.getLocalizacao()));
        textNomeCliente.setText(String.valueOf(agendamento.getNomeCliente()));
        textNomeServico.setText(String.valueOf(agendamento.getNomeServico()));
        textPreco.setText(String.valueOf(agendamento.getPreco()));
        textTelefone.setText(String.valueOf(agendamento.getTelefone()));
        textTempo.setText(String.valueOf(agendamento.getTempo()));
        textDescricao.setText(String.valueOf(agendamento.getDescricao()));
    }
}