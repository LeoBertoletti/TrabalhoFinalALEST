public class Sinalizacao {
    public String descricao;
    public String estado;
    public String complemento;
    public String dataImplantacao;
    public String numeroInicial;
    public String numeroFinal;
    public String defronte;
    public String cruzamentoNome;
    public String lado;
    public String fluxo;
    public String localDeInstalacao;
    private Sinalizacao proximo;

    public Sinalizacao getProximo() {
        return proximo;
    }

    public void setProximo(Sinalizacao proximo) {
        this.proximo = proximo;
    }
}