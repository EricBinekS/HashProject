package br.com.hash;

public class Main {
    public static void main(String[] args) {
        int capacidade = 32;
        String[] nomes = LeitorArquivo.ler("nomes.txt", 5000);

        TabelaHashAbstrata hash1 = new TabelaHashDivisao(capacidade);
        long inicio1 = System.nanoTime();
        for (String nome : nomes) {
            if (nome != null) hash1.inserir(nome);
        }
        long tempo1 = System.nanoTime() - inicio1;

        TabelaHashAbstrata hash2 = new TabelaHashPolinomial(capacidade);
        long inicio2 = System.nanoTime();
        for (String nome : nomes) {
            if (nome != null) hash2.inserir(nome);
        }
        long tempo2 = System.nanoTime() - inicio2;

        System.out.println("Hash Divisao - Colisões: " + hash1.getColisoes() + ", Tempo: " + tempo1 / 1e6 + " ms");
        imprimirDistribuicao(hash1.getDistribuicao());

        System.out.println("Hash Polinomial - Colisões: " + hash2.getColisoes() + ", Tempo: " + tempo2 / 1e6 + " ms");
        imprimirDistribuicao(hash2.getDistribuicao());
    }

    public static void imprimirDistribuicao(int[] dist) {
        for (int i = 0; i < dist.length; i++) {
            System.out.println("Bucket " + i + ": " + dist[i] + " elementos");
        }
    }
}