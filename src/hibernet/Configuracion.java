package hibernet;

public class Configuracion {
    private String param;
    private int valor;

    public Configuracion(String param, int valor) {
        this.param = param;
        this.valor = valor;
    }

    public Configuracion() {
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
