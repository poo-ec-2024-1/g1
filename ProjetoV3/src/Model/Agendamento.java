package Model;

import com.j256.ormlite.field.DatabaseField;

/**
 *  POJO para o banco de dados dos agendamentos
 * @author Matheus TP
 */
public class Agendamento{
    
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField
    private int cliente;
    @DatabaseField
    private int empresa;
    @DatabaseField
    private int servico;
    @DatabaseField
    private String data;
    @DatabaseField
    private String horário;
    @DatabaseField
    private String endereco;

    public Agendamento() {
    }

    public Agendamento(int id, int cliente, int empresa, int servico, String data, String horário, String endereco) {
        this.id = id;
        this.cliente = cliente;
        this.empresa = empresa;
        this.servico = servico;
        this.data = data;
        this.horário = horário;
        this.endereco = endereco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public int getEmpresa() {
        return empresa;
    }

    public void setEmpresa(int empresa) {
        this.empresa = empresa;
    }

    public int getServico() {
        return servico;
    }

    public void setServico(int servico) {
        this.servico = servico;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHorário() {
        return horário;
    }

    public void setHorário(String horário) {
        this.horário = horário;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
}