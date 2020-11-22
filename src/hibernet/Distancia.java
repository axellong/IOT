package hibernet;

import java.util.Date;

public class Distancia {

    private int id;
    private Date date;
    private int valor;

    public Distancia(int id, Date date, int valor) {
        this.id = id;
        this.date = date;
        this.valor = valor;
    }

    public Distancia() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
