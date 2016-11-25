package br.com.cwi.crescer.exercicios1;

/**
 *
 * @author mateus.teixeira
 */
public class MeuStringUtil {

    public boolean stringVazia(String frase) {
        return frase.isEmpty();
    }

    public int contaVogais(String frase) {
        int contador = 0;
        String vogais = "aeiou";
        char[] auxiliar = frase.toCharArray();
        for (int i = 0; i < auxiliar.length; i++) {
            if (vogais.contains(String.valueOf(auxiliar[i]))) {
                contador++;
            }
        }
        return contador;
    }

    public String fraseInvertida(String frase) {
        StringBuilder auxiliar = new StringBuilder(frase);

        auxiliar.reverse();

        return auxiliar.toString();
    }

    public String palindromo(String frase) {
        if (stringVazia(frase)) {
            return "Não é Palindromo";
        }

        String auxiliar = fraseInvertida(frase);
        return frase.toUpperCase().equals(auxiliar.toUpperCase()) ? "É Palindromo" : "Não é Palindromo";
    }

}
