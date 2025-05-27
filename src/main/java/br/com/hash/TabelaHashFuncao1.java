package br.com.hash;

public class TabelaHashFuncao1 extends TabelaHash {
    public TabelaHashFuncao1(int capacidade) {
        super(capacidade);
    }

    @Override
    protected int hash(String chave) {
        return (chave.length() - 1) % capacidade;
    }
}
