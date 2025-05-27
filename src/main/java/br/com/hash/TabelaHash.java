package br.com.hash;

import java.util.*;

public abstract class TabelaHash {
    protected List<LinkedList<String>> buckets;
    protected int capacidade;
    protected long colisoes;

    public TabelaHash(int capacidade) {
        this.capacidade = capacidade;
        this.buckets = new ArrayList<>(capacidade);
        for (int i = 0; i < capacidade; i++) {
            buckets.add(new LinkedList<>());
        }
        this.colisoes = 0;
    }

    protected abstract int hash(String chave);

    public void inserir(String chave) {
        int idx = hash(chave);
        LinkedList<String> lista = buckets.get(idx);
        if (!lista.isEmpty()) colisoes++;
        lista.add(chave);
    }

    public boolean buscar(String chave) {
        int idx = hash(chave);
        return buckets.get(idx).contains(chave);
    }

    public long getColisoes() {
        return colisoes;
    }

    public int[] getDistribuicao() {
        int[] dist = new int[capacidade];
        for (int i = 0; i < capacidade; i++) {
            dist[i] = buckets.get(i).size();
        }
        return dist;
    }
}
