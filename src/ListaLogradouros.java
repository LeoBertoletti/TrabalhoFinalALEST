public class ListaLogradouros {
    public Logradouro inicio;
    private Logradouro fim;
    private int quantidade;

    public ListaLogradouros() {
        inicio = new Logradouro("", "");
        fim = new Logradouro("", "");
        quantidade = 0;

        inicio.setProximo(fim);
        fim.setAnterior(inicio);
    }

    public void inserir(Logradouro novoLogradouro) {
        // if (quantidade == 0) {
        // this.inicio = novoLogradouro;
        // inicio.setProximo(fim);
        // quantidade++;
        // }
        Logradouro atual = inicio.getProximo();

        while (atual != fim && novoLogradouro.getNome().compareTo(atual.getNome()) > 0) {
            atual = atual.getProximo();
        }

        if (atual == fim || !atual.getNome().equals(novoLogradouro.getNome())) {
            novoLogradouro.setAnterior(atual.getAnterior());
            novoLogradouro.setProximo(atual);

            atual.getAnterior().setProximo(novoLogradouro);
            atual.setAnterior(novoLogradouro);

            quantidade++;
        }
    }

    public void remover(Logradouro logradouro) {
        Logradouro anterior = logradouro.getAnterior();
        Logradouro proximo = logradouro.getProximo();

        anterior.setProximo(proximo);
        proximo.setAnterior(anterior);

        logradouro.setAnterior(null);
        logradouro.setProximo(null);

        quantidade--;
    }

    public Logradouro buscar(String nome) {
        nome = nome.toUpperCase();
        Logradouro atual = this.inicio;

        while (atual != fim) {
            if (atual.getNome().equals(nome)) {
                return atual;
            }

            atual = atual.getProximo();
        }

        return null;
    }

    public boolean existe(String nome) {
        nome = nome.toUpperCase();
        Logradouro atual = inicio.getProximo();

        while (atual != fim) {
            if (atual.getNome().equals(nome)) {
                return true;
            }

            atual = atual.getProximo();
        }
        return false;
    }

    @Override
    public String toString() {
        String ret = "{";
        Logradouro aux = null;
        if (quantidade > 0)
            aux = inicio.getProximo();
        for (int i = 0; i < quantidade; i++) {
            ret = ret + aux.getTipo() + " " + aux.getNome() + System.lineSeparator();
            aux = aux.getProximo();
        }
        ret = ret + "}";
        return ret;
    }

    public int getQuantidade() {
        return quantidade;
    }
}
