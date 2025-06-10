package br.com.hash;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeitorArquivo {
    public static String[] ler(String caminho, int max) {
        String[] nomes = new String[max];
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha;
            while ((linha = br.readLine()) != null && count < max) {
                nomes[count++] = linha.trim();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return nomes;
    }
}