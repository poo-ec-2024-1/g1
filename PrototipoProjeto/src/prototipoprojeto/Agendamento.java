public class Agendamento {
    private String data;
    private String hora;
    private String cliente;

    public Agendamento(String data, String hora, String cliente) {
        this.data = data;
        this.hora = hora;
        this.cliente = cliente;
    }

    // Getters e setters
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

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
}
