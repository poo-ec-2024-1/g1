package Model.model;

import com.j256.ormlite.field.DatabaseField;
import java.time.LocalDate;

/**
 *  POJO para o banco de dados dos agendamentos
 */
public class Agendamento{
    
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField
    private int cliente;
    @DatabaseField
    private int servico;
    @DatabaseField
    private String data;
    @DatabaseField
    private String hora;
    @DatabaseField
    private String endereco;
    @DatabaseField
    private String modeloVeiculo;
    @DatabaseField
    private String placa;
    @DatabaseField
    private String formaPagamento;

    public Agendamento() {
    }

    public Agendamento(int id, int cliente, int servico, String data, String hora, String endereco, String modeloVeiculo, String placa, String formaPagamento) {
        this.id = id;
        this.cliente = cliente;
        this.servico = servico;
        this.data = data;
        this.hora = hora;
        this.endereco = endereco;
        this.modeloVeiculo = modeloVeiculo;
        this.placa = placa;
        this.formaPagamento = formaPagamento;
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

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getModeloVeiculo() {
        return modeloVeiculo;
    }

    public void setModeloVeiculo(String modeloVeiculo) {
        this.modeloVeiculo = modeloVeiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }


}