import java.time.LocalDate;

public class Sinalizacao {
    private String descricao;
    private String estado;
    private String complemento;
    private LocalDate dataImplantacao;
    private double numeroInicial;
    private double numeroFinal;
    private String defronte;
    private String cruzamentoNome;
    private String lado;
    private String fluxo;
    private String localDeInstalacao;
    private Sinalizacao proximo;

    public Sinalizacao(String descricao, String estado, String complmento, LocalDate dataImplantacao,
            double numeroInicial,
            double numeroFinal, String defronte, String cruzamentoNome, String lado, String fluxo,
            String localDeInstacao) {
        this.descricao = descricao;
        this.estado = estado;
        this.complemento = complmento;
        this.dataImplantacao = dataImplantacao;
        this.numeroInicial = numeroInicial;
        this.defronte = defronte;
        this.cruzamentoNome = cruzamentoNome;
        this.lado = lado;
        this.fluxo = fluxo;
        this.localDeInstalacao = localDeInstacao;
        this.proximo = null;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getEstado() {
        return estado;
    }

    public String getComplemento() {
        return complemento;
    }

    public LocalDate getDataImplantacao() {
        return dataImplantacao;
    }

    public double getNumeroInicial() {
        return numeroInicial;
    }

    public double getNumeroFinal() {
        return numeroFinal;
    }

    public String getDefronte() {
        return defronte;
    }

    public String getCruzamentoNome() {
        return cruzamentoNome;
    }

    public String getLado() {
        return lado;
    }

    public String getFluxo() {
        return fluxo;
    }

    public String getLocalDeInstalacao() {
        return localDeInstalacao;
    }

    public Sinalizacao getProximo() {
        return proximo;
    }

    public void setProximo(Sinalizacao proximo) {
        this.proximo = proximo;
    }

    public String toString() {
        return descricao + " " + estado + " " + complemento + " " + dataImplantacao + " " + numeroInicial + " "
                + numeroFinal + " " + defronte + " " + cruzamentoNome + " " + lado + " " + fluxo + " "
                + localDeInstalacao;
    }
}