package br.com.hash;

public class ListaEncadeada {
    private No inicio;
    private int tamanho;

    public ListaEncadeada() {
        inicio = null;
        tamanho = 0;
    }

    public void adicionar(String chave) {
        No novo = new No(chave);
        if (inicio == null) {
            inicio = novo;
        } else {
            No atual = inicio;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novo;
        }
        tamanho++;
    }

    public boolean contem(String chave) {
        No atual = inicio;
        while (atual != null) {
            if (atual.chave.equals(chave)) {
                return true;
            }
            atual = atual.proximo;
        }
        return false;
    }

    public int getTamanho() {
        return tamanho;
    }
}