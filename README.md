Cenario 1

        public class Main {
            public static void main(String[] args) {
        
                HashTable table1 = new HashTableFunction1();
                HashTable table2 = new HashTableFunction2();
        
                //Arraylist para o cenario 1
                String[] chaves = {
                    "Eu","amo","programar","Java"
                };
                
                //insert adptado para o array
                for (String name : chaves) table1.insert(name);
                for (String name : chaves) table2.insert(name);
                
                // Chamando o indice
                int IndiceJavaT1 = table1.hash("Java");
                int IndiceJavaT2 = table2.hash("Java");
        
                //Prints solcitados
                System.out.println("===== Relatório Comparativo =====");
                System.out.println("Colisões (Função Hash 1): " + table1.getCollisions());
                System.out.println("Indice: " + IndiceJavaT1);
        
                System.out.println("\nColisões (Função Hash 2): " + table2.getCollisions());
                System.out.println("Indice: " + IndiceJavaT2);
            }
        }

Cenario 2

     String[] chavesEspecificas = {
            "Ana", "Pedro", "Maria", "João"
        };

        // --- 4) Para cada chave:
        for (String chave : chavesEspecificas) {
            // 4a) Insere a chave:
            table1.insert(chave);

            // 4b) Em seguida, chama buscar(chave) para confirmar que foi inserida:
            boolean achou = table1.search(chave);


