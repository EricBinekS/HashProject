package br.com.hash;

public class TabelaHashPolinomial extends TabelaHashAbstrata {
    public TabelaHashPolinomial(int capacidade) {
        super(capacidade);
    }

    @Override
    protected int funcaoHash(String chave) {
        long hash = 0;
        long a = 31;
        for (int i = 0; i < chave.length(); i++) {
            hash = (hash * a + chave.charAt(i)) % capacidade;
        }
        return (int) hash;
    }
}