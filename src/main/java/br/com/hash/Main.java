package br.com.hash;

import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        final int CAPACIDADE = 32;
        List<String> nomes = Loader.carregarNomes("/female_names.txt");

        TabelaHash t1 = new TabelaHashFuncao1(CAPACIDADE);
        TabelaHash t2 = new TabelaHashFuncao2(CAPACIDADE);

        long inicioIns1 = System.nanoTime();
        for (String nome : nomes) t1.inserir(nome);
        long tempoIns1 = System.nanoTime() - inicioIns1;

        long inicioIns2 = System.nanoTime();
        for (String nome : nomes) t2.inserir(nome);
        long tempoIns2 = System.nanoTime() - inicioIns2;

        long inicioBus1 = System.nanoTime();
        for (String nome : nomes) t1.buscar(nome);
        long tempoBus1 = System.nanoTime() - inicioBus1;

        long inicioBus2 = System.nanoTime();
        for (String nome : nomes) t2.buscar(nome);
        long tempoBus2 = System.nanoTime() - inicioBus2;

        long col1 = t1.getColisoes(), col2 = t2.getColisoes();
        int[] dist1 = t1.getDistribuicao(), dist2 = t2.getDistribuicao();

        System.out.println("=== Tabela 1: Função (len-1) — Encadeamento Exterior ===");
        System.out.printf("Colisões: %d%nTempo inserção: %d ns%nTempo busca: %d ns%n",
                          col1, tempoIns1, tempoBus1);
        System.out.println("Distribuição por bucket: " + Arrays.toString(dist1));

        System.out.println("\n=== Tabela 2: Função (soma chars) — Encadeamento Exterior ===");
        System.out.printf("Colisões: %d%nTempo inserção: %d ns%nTempo busca: %d ns%n",
                          col2, tempoIns2, tempoBus2);
        System.out.println("Distribuição por bucket: " + Arrays.toString(dist2));
    }
}
