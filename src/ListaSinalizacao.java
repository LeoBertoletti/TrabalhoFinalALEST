public class ListaSinalizacao {
    public Sinalizacao inicio;
    private Sinalizacao fim;
    private int quantidade;

    public ListaSinalizacao() {
        inicio = null;
        fim = null;
        quantidade = 0;
    }

    public void inserir(Sinalizacao novaSinalizacao) {
        if (inicio == null) {
            inicio = novaSinalizacao;
            fim = novaSinalizacao;
        } else {
            fim.setProximo(novaSinalizacao);
            fim = novaSinalizacao;
        }

        novaSinalizacao.setProximo(null);
        quantidade++;
    }

    public void remover(Sinalizacao sinalizacao) {
        Sinalizacao atual = inicio;

        while (atual.getProximo() != null && atual.getProximo() != sinalizacao) {
            atual = atual.getProximo();
        }

        if (atual.getProximo() == null) {
            return; // Sinalizacao não encontrada na lista
        }

        atual.setProximo(atual.getProximo().getProximo());
        sinalizacao.setProximo(null);

        quantidade--;
    }

    public Sinalizacao buscar(String descricao) {
        Sinalizacao atual = inicio.getProximo();

        while (atual != null) {
            if (atual.getDescricao().equals(descricao)) {
                return atual;
            }

            atual = atual.getProximo();
        }

        return null;
    }

    public Sinalizacao proximo(Sinalizacao sinalizacao) {
        return sinalizacao.getProximo();
    }

    public String toString() {
        String retorno = "";

        Sinalizacao atual = inicio.getProximo();

        while (atual != null) {
            retorno += atual.getDescricao() + " " + atual.getEstado() + " " + atual.getComplemento() + " "
                    + atual.getDataImplantacao() + " " + atual.getNumeroInicial() + " " + atual.getNumeroFinal() + " "
                    + atual.getDefronte() + " " + atual.getCruzamentoNome() + " " + atual.getLado() + " "
                    + atual.getFluxo() + " " + atual.getLocalDeInstalacao() + "\n";

            atual = atual.getProximo();
        }

        return retorno;
    }

    public int getQuantidade() {
        return quantidade;
    }
}
