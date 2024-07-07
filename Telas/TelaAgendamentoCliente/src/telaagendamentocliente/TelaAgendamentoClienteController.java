package telaagendamentocliente;

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
 * FXMLTelaAgendamentoCliente Controller class
 *
 * @author matheus teixeira pires
 */
public class TelaAgendamentoClienteController implements Initializable {

    @FXML
    private TextField textCEP;
    @FXML
    private TextField textCNPJ;
    @FXML
    private TextField textData;
    @FXML
    private TextField textEmail;
    @FXML
    private TextField textEndereco;
    @FXML
    private TextField textHorario;
    @FXML
    private TextField textLocalizacao;
    @FXML
    private TextField textNomeEmpresa;
    @FXML
    private TextField textNomeServico;
    @FXML
    private TextField textPreco;
    @FXML
    private TextField textTelefone;
    @FXML
    private TextField textTempo;
    @FXML
    private TextArea textDescricao;
    @FXML
    private ComboBox<AgendamentoCliente> cbAgendamentos;
    
    private List<AgendamentoCliente> agendamentos = new ArrayList<>();
    private ObservableList<AgendamentoCliente> obsAgendamentos;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        carregarAgendamentos();
    }    
    /**
     *  Classe responsável por inicializar e atribuir instâncias à ComboBox
     */
    public void carregarAgendamentos(){
        
        AgendamentoCliente agendamento1 = new AgendamentoCliente("Lavagem Completa", "08/07/2023", "15:00", "60 min", "R$ 100,00",
                "Rua 02 Quadra 34 Lote 12 Jardim São Francisco", "Uma lavagem completa no seu carro, interna e externamente."
                        + " Ele vai ficar limpo como nunca!", "Super Lava Tudo", "12345678910121", "(62) 990431223", 
        "superlavatudo@gmail.com", "78950345", "Rua T9 Quadra 7 Lote 1 Jardim das Cachorras");
        AgendamentoCliente agendamento2 = new AgendamentoCliente("Lavagem Externa", "10/07/2023", "16:00", "30 min", "R$ 60,00",
                "Rua 54 Quadra 31 Lote 22 Jardim das Palmeiras", "Uma lavagem completa na parte externa do seu carro. "
                        + "Ele ficará brilhando!", "Mega Lava Jato", "11111111111111", "(90) 96663629", 
        "megalavajato@gmail.com", "70707070", "Rua 29 Quadra 1 Lote 2 Parque do Peixe");
        
        agendamentos.add(agendamento1);
        agendamentos.add(agendamento2);
        
        obsAgendamentos = FXCollections.observableArrayList(agendamentos);
        cbAgendamentos.setItems(obsAgendamentos);
    }
    /**
     * Seleciona e exibe os dados do objeto atual da ComboBox
     */
    public void selecionarDados(){
        
        AgendamentoCliente agendamento = cbAgendamentos.getSelectionModel().getSelectedItem();
        
        textCEP.setText(String.valueOf(agendamento.getCep()));
        textCNPJ.setText(String.valueOf(agendamento.getCnpj()));
        textData.setText(String.valueOf(agendamento.getData()));
        textEmail.setText(String.valueOf(agendamento.getEmail()));
        textEndereco.setText(String.valueOf(agendamento.getEndereco()));
        textHorario.setText(String.valueOf(agendamento.getHorario()));
        textLocalizacao.setText(String.valueOf(agendamento.getLocalizacao()));
        textNomeEmpresa.setText(String.valueOf(agendamento.getNomeEmpresa()));
        textNomeServico.setText(String.valueOf(agendamento.getNomeServico()));
        textPreco.setText(String.valueOf(agendamento.getPreco()));
        textTelefone.setText(String.valueOf(agendamento.getTelefone()));
        textTempo.setText(String.valueOf(agendamento.getTempo()));
        textDescricao.setText(String.valueOf(agendamento.getDescricao()));
    }
}
