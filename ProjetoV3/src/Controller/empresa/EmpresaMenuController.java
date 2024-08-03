
package Controller.empresa;

import Model.repository.Database;
import Model.repository.EmpresaRepository;
import Util.Util;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
import javafx.scene.control.TableView;
import javafx.stage.Stage;


public class EmpresaMenuController implements Initializable{

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button BotaoSair;
    @FXML
    private Label titleNome;
    @FXML
    private Label titleDate;
    @FXML
    private Label titleCnpj;
    @FXML
    private Label titleSaldo;
    @FXML
    private BarChart<?, ?> graficoVendas;
    @FXML
    private TableView<?> tabelaServicos;
    @FXML
    private Button BotaoEditarPedido;
    
    public static int idSelecionado = 0;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        idSelecionado = TelaLoginEmpresaController.idSelecionado;
        Database database = Util.openDatabase("empresasDatabase");
        EmpresaRepository empresaRP = new EmpresaRepository(database);
        titleNome.setText(empresaRP.loadFromId(idSelecionado).getNome());
        titleCnpj.setText(empresaRP.loadFromId(idSelecionado).getCnpj());
        database.close();
    }
    
    @FXML
    public void onClickVoltar(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/View/Empresa/TelaLoginEmpresa.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public Label getTitleNome() {
        return titleNome;
    }

    public void setTitleNome(Label titleNome) {
        this.titleNome = titleNome;
    }

    public Label getTitleDate() {
        return titleDate;
    }

    public void setTitleDate(Label titleDate) {
        this.titleDate = titleDate;
    }

    public Label getTitleCnpj() {
        return titleCnpj;
    }

    public void setTitleCnpj(Label titleCnpj) {
        this.titleCnpj = titleCnpj;
    }

    public Label getTitleSaldo() {
        return titleSaldo;
    }

    public void setTitleSaldo(Label titleSaldo) {
        this.titleSaldo = titleSaldo;
    }
}
