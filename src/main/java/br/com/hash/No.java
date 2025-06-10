package br.com.hash;

public class No {
    public String chave;
    public No proximo;

    public No(String chave) {
        this.chave = chave;
        this.proximo = null;
    }
}