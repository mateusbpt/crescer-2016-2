package br.com.cwi.crescer.aula1;

import java.util.Scanner;

/**
 *
 * @author mateus.teixeira
 */
public class StringRun {
    public static void main(String[] args) {
      final Scanner scanner = new Scanner(System.in);
        //System.out.println("Digite uma Frase: ");
        //String aux = scanner.nextLine();
        
        //System.out.println("Quantidade de vogais: ");
        //System.out.println(quantidadeDeVogais(aux));
        
       // System.out.println("String Inversa: ");
        //System.out.println(fraseInvertida(aux));
        
       // System.out.println(Estados.concatenar());
      Data data = new Data();
       
      System.out.format("Data Atual: %s \n", data.exibeDataAtual());
      System.out.format("Data Atual Formatada: %s \n", data.exibeDataFormatada());
      
      System.out.println("Insira sua data de nascimento: ");
       String aux = scanner.nextLine();
      System.out.format("Dia que você nasceu: %s", data.exibeDiaDaSemanaDoNascimento(aux));
    }
    
    public static int quantidadeDeVogais(String frase){
        int contador = 0;
        String vogais = "aeiou";
        char[] auxiliar = frase.toCharArray();
        for(int i = 0; i < auxiliar.length; i++){
            if(vogais.contains(String.valueOf(auxiliar[i]))){
                contador++;
            }
        }
           return contador;   
    }
 
    public static String fraseInvertida(String frase){
        StringBuilder auxiliar = new StringBuilder(frase);
        
        auxiliar.reverse();
        
        return auxiliar.toString();                 
    }
}

