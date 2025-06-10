package br.com.hash;

public abstract class TabelaHashAbstrata {
    protected ListaEncadeada[] tabela;
    protected int capacidade;
    protected int colisoes;

    @SuppressWarnings("unchecked")
    public TabelaHashAbstrata(int capacidade) {
        this.capacidade = capacidade;
        this.tabela = new ListaEncadeada[capacidade];
        for (int i = 0; i < capacidade; i++) {
            tabela[i] = new ListaEncadeada();
        }
        this.colisoes = 0;
    }

    protected abstract int funcaoHash(String chave);

    public void inserir(String chave) {
        int indice = funcaoHash(chave);
        if (tabela[indice].getTamanho() > 0) {
            colisoes++;
        }
        tabela[indice].adicionar(chave);
    }

    public boolean buscar(String chave) {
        int indice = funcaoHash(chave);
        return tabela[indice].contem(chave);
    }

    public int getColisoes() {
        return colisoes;
    }

    public int[] getDistribuicao() {
        int[] dist = new int[capacidade];
        for (int i = 0; i < capacidade; i++) {
            dist[i] = tabela[i].getTamanho();
        }
        return dist;
    }
}