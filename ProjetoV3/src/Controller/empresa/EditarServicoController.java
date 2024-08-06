
package Controller.empresa;

import Model.model.Agendamento;
import Model.model.Servico;
import Model.repository.AgendamentoRepository;
import Model.repository.Database;
import Model.repository.ServicoRepository;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * EditarServico Controller Class
 */
public class EditarServicoController implements Initializable {

    @FXML
    private Button buttonDeletar;
    @FXML
    private Button buttonEditar;
    @FXML
    private Button buttonLimpar;
    @FXML
    private Button buttonSalvar;
    @FXML
    private Button buttonVoltar;
    @FXML
    private TableColumn<Servico, String> colDescricao;
    @FXML
    private TableColumn<Servico, Integer> colId;
    @FXML
    private TableColumn<Servico, Float> colPreco;
    @FXML
    private TableColumn<Servico, String> colServico;
    @FXML
    private TableView<Servico> tabel;
    @FXML
    private TextArea tfDescricao;
    @FXML
    private TextField tfNome;
    @FXML
    private TextField tfPreco;
    @FXML
    private Label labelMensagem;
    
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    ObservableList<Servico> servicosEmpresa;
    Database database;
    ServicoRepository servicoRP;
    Servico servicoAtual;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        servicosEmpresa = FXCollections.observableArrayList();
        database = Util.openDatabase("servicosDatabase");
        servicoRP = new ServicoRepository(database);
        atualizarTabel();
    }
    /**
     * Atualiza os servios na tabela de serviços da empresa
     */
    public void atualizarTabel(){
        List<Servico> servicos = servicoRP.loadAll();
        for(Servico x : servicos){
            if(x.getEmpResponsavel() == TelaLoginEmpresaController.idSelecionado){
                servicosEmpresa.add(x);
            }
        }
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colServico.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        colPreco.setCellValueFactory(new PropertyValueFactory<>("preco"));
        tabel.setItems(servicosEmpresa);
    }
    /**
     * Habilita alguns botões na tela de editar serviço, escaneia o serviço selecionado na tabela e o exibe nos campos de texto
     * @param event e
     */
    @FXML
    public void onClickTabel(MouseEvent event) {
        try{
            int id = tabel.getSelectionModel().getSelectedItem().getId();
            servicoAtual = servicoRP.loadFromId(id);
            tfNome.setText(servicoAtual.getNome());
            tfPreco.setText(String.valueOf(servicoAtual.getPreco()));
            tfDescricao.setText(servicoAtual.getDescricao());
            buttonEditar.setDisable(false);
            buttonDeletar.setDisable(false);
        } catch (Exception e){
            
        }
    }
    /**
     * Deleta o serviço selecionado
     * @param event e
     */
    @FXML
    public void onClickedDeletar(ActionEvent event) {
        try{
            Database database1 = Util.openDatabase("agendamentosDatabase");
            AgendamentoRepository agendamentoRP = new AgendamentoRepository(database1);
            List<Agendamento> agendamentos = agendamentoRP.loadAll();
            for(Agendamento x : agendamentos){
                if(servicoAtual.getId() == x.getServico()){
                    agendamentoRP.deleteById(x.getId());
                }
            }
            servicoRP.deleteById(servicoAtual.getId());
            clear();
            atualizarTabel();
            servicoAtual = null;
            labelMensagem.setText("O serviço e os seus agendamentos foram deletados!");
            buttonEditar.setDisable(true);
            buttonSalvar.setDisable(true);
            buttonDeletar.setDisable(true);
        } catch (Exception e){
            
        }
    }
    /**
     * Habilita a edição do serviço selecionado
     * @param event e
     */
    @FXML
    public void onClickedEditar(ActionEvent event) {
        buttonEditar.setDisable(true);
        buttonSalvar.setDisable(false);
        isEditable(true);
    }
    /**
     * Limpa os campos de texto do serviço selecionado
     * @param event e
     */
    @FXML
    public void onClickedLimpar(ActionEvent event) {
        try{  
            clear();
            labelMensagem.setText("");
            if(!tfNome.isEditable()){
                buttonSalvar.setDisable(true);
                buttonEditar.setDisable(true);
                buttonDeletar.setDisable(true);
            }
        } catch(Exception e){
            
        }
    }
    /**
     * Após uma verificação, salva os dados do serviço editado
     * @param event e
     */
    @FXML
    public void onClickedSalvar(ActionEvent event) {
        try{
            String nome = tfNome.getText();
            String preco = tfPreco.getText();
            String descricao = tfDescricao.getText();
            servicoAtual.setPreco(Float.valueOf(preco));
            servicoAtual.setNome(nome);
            servicoAtual.setDescricao(descricao);
            
            if(Util.stringVazia(nome) || Util.stringVazia(preco) || Util.stringVazia(descricao) || servicoAtual.getPreco() <=0){
                labelMensagem.setText("Dados inválidos! Tente novamente.");
            }
            else{
                servicoRP.update(servicoAtual);
                labelMensagem.setText("Serviço Salvo com Sucesso!");
                buttonSalvar.setDisable(true);
                isEditable(false);
                atualizarTabel();
                buttonEditar.setDisable(false);
            }
        } catch(Exception e){
            labelMensagem.setText("Dados inválidos! Tente novamente.");
        }
    }
    /**
     * Sai da tela de editar serviço da empresa para o menu da empresa
     * @param event e
     * @throws IOException e
     */
    @FXML
    public void onClickedVoltar(ActionEvent event) throws IOException {
        try{
            Parent root = FXMLLoader.load(getClass().getResource("/View/Empresa/EmpresaMenu.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch(Exception e){
            
        }
    }
    /**
     * Limpa as caixas de texto
     */
    public void clear(){
        tfNome.setText("");
        tfPreco.setText("");
        tfDescricao.setText("");
    }
    /**
     * Define se as caixas de texto são editáveis ou não
     * @param x true para serem editáveis, false para o contrário
     */
    public void isEditable(boolean x){
       tfNome.setEditable(x);
       tfPreco.setEditable(x);
       tfDescricao.setEditable(x);
    }
}
