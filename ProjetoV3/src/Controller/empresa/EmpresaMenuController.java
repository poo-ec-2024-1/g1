
package Controller.empresa;

import Model.model.Agendamento;
import Model.model.Servico;
import Model.repository.AgendamentoRepository;
import Model.repository.Database;
import Model.repository.EmpresaRepository;
import Model.repository.ServicoRepository;
import Util.AgendamentoExibivel;
import static Util.ExibirAgendamento.getAgendamentoExibivel;
import Util.Util;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.chart.BarChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * EmpresaMenu Controller Class
 */
public class EmpresaMenuController implements Initializable{

    private Stage stage;
    private Scene scene;
    private Parent root;
    
    @FXML
    private Button BotaoEditarPedido;
    @FXML
    private Button BotaoSair;
    @FXML
    private TableColumn<AgendamentoExibivel, String> colCliente;
    @FXML
    private TableColumn<AgendamentoExibivel, String> colData;
    @FXML
    private TableColumn<AgendamentoExibivel, String> colEndereco;
    @FXML
    private TableColumn<AgendamentoExibivel, String> colHora;
    @FXML
    private TableColumn<AgendamentoExibivel, Integer> colId;
    @FXML
    private TableColumn<AgendamentoExibivel, Double> colPreco;
    @FXML
    private TableColumn<AgendamentoExibivel, String> colServico;
    @FXML
    private TableColumn<AgendamentoExibivel, String> colVeiculo;
    @FXML
    private BarChart<AgendamentoExibivel, String> graficoVendas;
    @FXML
    private TableView<AgendamentoExibivel> tabelaServicos;
    @FXML
    private Label titleCnpj;
    @FXML
    private Label titleDate;
    @FXML
    private Label titleNome;
    @FXML
    private Label titleSaldo;
    
    public static int idSelecionado;
    public static double saldo;
    
    ObservableList<AgendamentoExibivel> agends;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        saldo = 0;
        idSelecionado = TelaLoginEmpresaController.idSelecionado;
        Database database = Util.openDatabase("empresasDatabase");
        EmpresaRepository empresaRP = new EmpresaRepository(database);
        titleNome.setText(empresaRP.loadFromId(idSelecionado).getNome());
        titleCnpj.setText(empresaRP.loadFromId(idSelecionado).getCnpj());
        database.close();
        
        Database database0 = Util.openDatabase("servicosDatabase");
        ServicoRepository servicoRP = new ServicoRepository(database0);
        
        Database database1 = Util.openDatabase("agendamentosDatabase");
        AgendamentoRepository agendamentoRP = new AgendamentoRepository(database1);
        
        List<Agendamento> agendamentos = agendamentoRP.loadAll();
        agends = FXCollections.observableArrayList();
        Servico servico = new Servico();
        for(Agendamento x : agendamentos){
            servico = servicoRP.loadFromId(x.getServico());
            if(servico.getEmpResponsavel() == idSelecionado){
                agends.add(getAgendamentoExibivel(x, "cliente"));
                saldo += servico.getPreco();
            }
        }
        titleSaldo.setText(String.valueOf(saldo));
        carregarDados();
    }
    /**
     * Sai da tela de menu da empresa para a tela de login da empresa
     * @param event e
     * @throws IOException  e
     */
    @FXML
    public void onClickVoltar(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/View/Empresa/TelaLoginEmpresa.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    /**
     * Carrega os agendamentos feitas para a empresa na tabela
     */
    public void carregarDados(){
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colServico.setCellValueFactory(new PropertyValueFactory<>("servico"));
        colCliente.setCellValueFactory(new PropertyValueFactory<>("entidade"));
        colPreco.setCellValueFactory(new PropertyValueFactory<>("preco"));
        colVeiculo.setCellValueFactory(new PropertyValueFactory<>("veiculo"));
        colData.setCellValueFactory(new PropertyValueFactory<>("data"));
        colHora.setCellValueFactory(new PropertyValueFactory<>("hora"));
        colEndereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
        tabelaServicos.setItems(agends);
    }
    /**
     * Sai da tela de menu da empresa para a tela de editar perfil da empresa
     * @param event e
     * @throws IOException  e
     */
    public void onClickPerfil(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/View/Empresa/PerfilEmpresa.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    /**
     * Sai da tela de menu da empresa para a tela de registar serviços da empresa
     * @param event e
     * @throws IOException e
     */
    public void onClickServicos(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/View/Empresa/RegistrarServico.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    /**
     * Sai da tela de menu da empresa para a tela de editar serviço
     * @param event e
     * @throws IOException e
     */
    @FXML
    public void onClickedEditar(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/Empresa/EditarServico.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
