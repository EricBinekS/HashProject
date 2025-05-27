package br.com.hash;

import java.io.*;
import java.util.*;

public class Loader {
    public static List<String> carregarNomes(String resourcePath) throws IOException {
        List<String> nomes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(Loader.class.getResourceAsStream(resourcePath)))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                nomes.add(linha.trim());
            }
        }
        return nomes;
    }
}
