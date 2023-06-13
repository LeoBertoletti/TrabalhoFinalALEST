public class Logradouro {
    private String tipo;
    private String nome;
    private Logradouro anterior;
    private Logradouro proximo;
    private ListaSinalizacao listaSinalizacao;

    public Logradouro(String tipo, String nome) {
        this.tipo = tipo;
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public String getNome() {
        return nome;
    }

    public Logradouro getAnterior() {
        return anterior;
    }

    public void setAnterior(Logradouro anterior) {
        this.anterior = anterior;
    }

    public Logradouro getProximo() {
        return proximo;
    }

    public void setProximo(Logradouro proximo) {
        this.proximo = proximo;
    }

}