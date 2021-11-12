package exercicioum;

import java.util.*;

public class Main {
    private static Construtora CSR = new Construtora();

    public static void main(String[] args) {
        String cnpj;
        Scanner read = new Scanner(System.in);
        System.out.println("Bem vindo a construtora ConstroiSuperRapido");
        System.out.println("Primeiro digite o CNPJ");
        cnpj = read.next();
        while (!CSR.setCNPJ(cnpj)) {
            System.out.println("Coloque um CNPJ valido");
            cnpj = read.next();
            CSR.setCNPJ(cnpj);
        }
        System.out.println("O cnpj é " + cnpj);
        System.out.println("\n Agora iremos adicionar os corretores");
        CSR.adicionarCorretor();
        Construtora.menu();
    }

}