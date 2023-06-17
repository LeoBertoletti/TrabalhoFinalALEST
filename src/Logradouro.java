public class Logradouro {
    private String tipo;
    private String nome;
    private Logradouro anterior;
    private Logradouro proximo;
    private ListaSinalizacao listaSinalizacao;

    public Logradouro(String tipo, String nome) {
        this.tipo = tipo;
        this.nome = nome;
        this.listaSinalizacao = new ListaSinalizacao();
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

    public void inserirSinalizacao(Sinalizacao sinalizacao) {
        this.listaSinalizacao.inserir(sinalizacao);
    }

    public ListaSinalizacao getListaSinalizacao() {
        return listaSinalizacao;
    }

    @Override
    public String toString() {
        return tipo + " " + nome;
    }

}