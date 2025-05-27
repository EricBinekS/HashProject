package br.com.hash;

public class TabelaHashFuncao2 extends TabelaHash {
    public TabelaHashFuncao2(int capacidade) {
        super(capacidade);
    }

    @Override
    protected int hash(String chave) {
        int soma = 0;
        for (char c : chave.toCharArray()) {
            soma += c;
        }
        return soma % capacidade;
    }
}
