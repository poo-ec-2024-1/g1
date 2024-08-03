
package Controller.cliente;

import Model.model.Agendamento;
import Model.model.Empresa;
import Model.model.Servico;
import Model.repository.AgendamentoRepository;
import Model.repository.Database;
import Model.repository.EmpresaRepository;
import Model.repository.ServicoRepository;
import Util.Util;
import Util.VerificarAgendamento;
import java.io.IOException;
import java.net.URL;
import java.time.chrono.Chronology;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Callback;

public class TelaAgendamentoClienteController implements Initializable{
    @FXML
    private Button botaoAgendar;
    @FXML
    private Button botaoVoltar;
    @FXML
    private ComboBox<Empresa> boxEmpresa;
    @FXML
    private ComboBox<String> boxFormaPagamento;
    @FXML
    private ComboBox<Servico> boxServico;
    @FXML
    private DatePicker dateData;
    @FXML
    private TextField tfEndereco;
    @FXML
    private TextField tfModeloVeiculo;
    @FXML
    private TextField tfPlaca;
    @FXML
    private TextArea tfDescricao;
    @FXML
    private Label labelPreco;
    @FXML
    private TextField tfHora;
    @FXML
    private Label labelMensagem;
    
    private Scene scene;
    private Parent root;
    private Stage stage;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Database database = Util.openDatabase("empresasDatabase");
        EmpresaRepository empresaRP = new EmpresaRepository(database);
        ObservableList<Empresa> empresas = FXCollections.observableArrayList(empresaRP.loadAll());
        boxEmpresa.setItems(empresas);
        database.close();
        ObservableList<String> formasPagamento = FXCollections.observableArrayList(formasPagamento());
        boxFormaPagamento.setItems(formasPagamento);
    }
    
    public List<String> formasPagamento(){
        List<String> formasPagamento = new ArrayList<>();
        formasPagamento.add("Dinheiro");
        formasPagamento.add("Cartão de Crédito");
        formasPagamento.add("Cartão de Débito");
        formasPagamento.add("Pix");
        formasPagamento.add("Cheque");
        return formasPagamento;
    }
    
    public void onClickVoltar(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/View/TelaMenuPrinc.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    public void hideFields(boolean x){
        dateData.setDisable(x);
        tfHora.setDisable(x);
        tfModeloVeiculo.setDisable(x);
        tfPlaca.setDisable(x);
        tfEndereco.setDisable(x);
        boxFormaPagamento.setDisable(x);
        tfDescricao.setDisable(x);
        botaoAgendar.setDisable(x);
    }
    
    public void hideServicos(boolean x){
        boxServico.setDisable(x);
    }
    
    public void clearFields(){
        tfModeloVeiculo.setText("");
        tfPlaca.setText("");
        tfEndereco.setText("");
        tfDescricao.setText("");
        labelPreco.setText("");
        tfHora.setText("");
        boxFormaPagamento.setValue("");
        dateData.setValue(null);
        
    }
    
    ObservableList<Servico> empresaServicos = FXCollections.observableArrayList();
    
    public void selectEmpresa(){
        try{
            Empresa empresaSelecionada = boxEmpresa.getSelectionModel().getSelectedItem();
            Database database = new Database("servicosDatabase");
            ServicoRepository servicoRP = new ServicoRepository(database);
            List<Servico> servicos = servicoRP.loadAll();
            empresaServicos = FXCollections.observableArrayList();
            for(Servico x : servicos){
                if(empresaSelecionada.getId() == x.getEmpResponsavel()){
                    empresaServicos.add(x);
                }
            }
            boxServico.setItems(empresaServicos);
            hideServicos(false);
            hideFields(true);
            clearFields();
            database.close();
        } catch(Exception e){
            
        }
    }
    
    public void selectServico(){
        try{
            Servico servicoSelecionado = boxServico.getSelectionModel().getSelectedItem();
            tfDescricao.setText(servicoSelecionado.getDescricao());
            String preco = (servicoSelecionado.getPreco() + " R$");
            labelPreco.setText(preco);
            hideFields(false);
        } catch(Exception e){
            
        }
    }
    
    public void onClickedAgendar(){
        try{
            Agendamento agenda = new Agendamento();
            agenda.setServico(boxServico.getSelectionModel().getSelectedItem().getId());
            agenda.setCliente(TelaLoginClienteController.idSelecionado);
            agenda.setData(String.valueOf(dateData.getValue()));
            agenda.setHora(tfHora.getText());
            agenda.setModeloVeiculo(tfModeloVeiculo.getText());
            agenda.setPlaca(tfPlaca.getText());
            agenda.setEndereco(tfEndereco.getText());
            agenda.setFormaPagamento(boxFormaPagamento.getSelectionModel().getSelectedItem());
            
            if(!VerificarAgendamento.verificarAgendamento(agenda)){
                labelMensagem.setText("Dados inválidos! Tente novamente.");
            }
            else{
                Database database = Util.openDatabase("agendamentosDatabase");
                AgendamentoRepository agendamentoRP = new AgendamentoRepository(database);
                agendamentoRP.create(agenda);
                labelMensagem.setText("Agendamento realizado com sucesso!");
            }
            
        } catch (Exception e){
            labelMensagem.setText("Deu erro");
        }
    }
}