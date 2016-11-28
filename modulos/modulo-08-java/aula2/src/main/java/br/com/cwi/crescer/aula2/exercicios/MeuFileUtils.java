package br.com.cwi.crescer.aula2.exercicios;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MeuFileUtils {

    public static void main(String[] args) throws IOException {
        boolean sair = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha sua opção: "
                + "\n 1 - Criar Arquivo ou diretório "
                + "\n 2 - Excluir arquivo "
                + "\n 3 - Mostrar arquivos do diretório "
                + "\n 4 - Mover arquivo "
                + "\n 5 - Sair");

        while (sair != true) {
            System.out.println("\nDigite sua opção: ");
            int opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("\nDigite o diretório ou o arquivo a ser criado: ");
                    String arquivo = scanner.next();
                    mk(arquivo);
                    break;
                case 2:
                    System.out.println("\nDigite o arquivo a ser excluido: ");
                    String excluido = scanner.next();
                    rm(excluido);
                    break;
                case 3:
                    System.out.println("\nDigite o caminho do arquivo a ser listado: ");
                    String listado = scanner.next();
                    ls(listado);
                    break;

                case 4:

                    break;

                case 5:
                    sair = true;
                    break;

                default:
                    System.out.println("Você digitou uma opção inválida");
            }

        }
    }

    public static void mk(final String nome) {
        File arquivo = new File(nome);

        if (ehArquivo(nome)) {
            try {
                arquivo.createNewFile();
                System.out.println("Arquivo criado com sucesso");
            } catch (IOException e) {
                System.out.println("Ocorreu um erro ao criar o arquivo");
            }
        } else {
            try {
                arquivo.mkdirs();
                System.out.println("Diretório criado com sucesso");
            } catch (Exception e) {
                 System.out.println("Ocorreu um erro, verifique o caminho informado");
            }
        }

    }

    public static void rm(final String nome) {
        File arquivo = new File(nome);

        if (arquivo.exists() && ehArquivo(nome)) {
            arquivo.delete();
            System.out.println("Arquivo removido com sucesso");
        } else {
            System.out.println("Arquivo não encontrado, não pôde ser removido");
        }
    }

    public static void ls(final String nome) {
        File arquivo = new File(nome);

        if (arquivo.exists() && ehArquivo(nome)) {
            System.out.println(arquivo.getAbsolutePath());
        } else {
            File[] arquivos = arquivo.listFiles();

            for (File arq : arquivos) {
                System.out.println(arq.getName());
            }
        }
    }

    private static boolean ehArquivo(String frase) {

        if (frase.length() < 4) {
            return false;
        }

        String auxiliar = frase.substring(frase.length() - 4);

        return auxiliar.contains(".");
    }
}
