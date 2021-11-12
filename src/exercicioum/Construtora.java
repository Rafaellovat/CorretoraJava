package exercicioum;

import java.util.*;

public class Construtora {
    static Corretor[] corretor = new Corretor[]{new Corretor(), new Corretor(), new Corretor()};
    static Endereco[] endereco = new Endereco[]{new Endereco(), new Endereco(), new Endereco()};
    String CNPJ;
    static int totalVendido = 0;

    static void menu() {
        Scanner read = new Scanner(System.in);
        String opcao;
        int posicao;
        System.out.println("Oque deseja fazer ?");
        System.out.println("Adicionar vendas a um corretor: 1");
        System.out.println("Ver a venda total de um corretor: 2");
        System.out.println("Total de vendas da construtora: 3");
        opcao = read.next();
        switch (opcao) {
            case "1":
                System.out.println("Qual Corretor. 1, 2 ou 3 ?");
                posicao = read.nextInt();
                switch (posicao){
                    case 1,2,3:
                        System.out.println("Qual o valor ?");
                        corretor[(posicao - 1)].setTotalDeVendas(read.nextInt());
                        break;
                    default:
                        System.out.println("Não existe este corretor. Digite 1, 2 ou 3");
                }
                break;

            case "2":
                System.out.println("Qual Corretor. 1, 2 ou 3 ?");
                posicao = read.nextInt();
                switch (posicao){
                    case 1,2,3:
                        System.out.println("o total de vendas do corretor " + corretor[posicao - 1].getNome() + " é: " + corretor[(posicao - 1)].getTotalDeVendas());
                        break;
                    default:
                        System.out.println("Não existe este corretor. Digite 1, 2 ou 3");
                }
                break;
                
            case "3":
                totalVendido = corretor[0].getTotalDeVendas() + corretor[1].getTotalDeVendas() + corretor[2].getTotalDeVendas();
                System.out.println("O total de vendas da Construtora é: " + totalVendido);
                break;

            default:
                System.out.println("Digite 1, 2 ou 3");
        }
        menu();

    }

    public boolean setCNPJ(String cnpj) {
        if (validarCNPJ(cnpj)) {
            this.CNPJ = cnpj;
            return true;
        }
        return false;
    }

    public boolean validarCNPJ(String cnpj){
        if (!cnpj.substring(0, 1).equals("")) {
            try {
                cnpj = cnpj.replace('.', ' ');//onde há ponto coloca espaço
                cnpj = cnpj.replace('/', ' ');//onde há barra coloca espaço
                cnpj = cnpj.replace('-', ' ');//onde há traço coloca espaço
                cnpj = cnpj.replaceAll(" ", "");//retira espaço
                int soma = 0, dig;
                String cnpj_calc = cnpj.substring(0, 12);

                if (cnpj.length() != 14) {
                    return false;
                }
                char[] chr_cnpj = cnpj.toCharArray();
                /* Primeira parte */
                for (int i = 0; i < 4; i++) {
                    if (chr_cnpj[i] - 48 >= 0 && chr_cnpj[i] - 48 <= 9) {
                        soma += (chr_cnpj[i] - 48) * (6 - (i + 1));
                    }
                }
                for (int i = 0; i < 8; i++) {
                    if (chr_cnpj[i + 4] - 48 >= 0 && chr_cnpj[i + 4] - 48 <= 9) {
                        soma += (chr_cnpj[i + 4] - 48) * (10 - (i + 1));
                    }
                }
                dig = 11 - (soma % 11);
                cnpj_calc += (dig == 10 || dig == 11) ? "0" : Integer.toString(dig);
                /* Segunda parte */
                soma = 0;
                for (int i = 0; i < 5; i++) {
                    if (chr_cnpj[i] - 48 >= 0 && chr_cnpj[i] - 48 <= 9) {
                        soma += (chr_cnpj[i] - 48) * (7 - (i + 1));
                    }
                }
                for (int i = 0; i < 8; i++) {
                    if (chr_cnpj[i + 5] - 48 >= 0 && chr_cnpj[i + 5] - 48 <= 9) {
                        soma += (chr_cnpj[i + 5] - 48) * (10 - (i + 1));
                    }
                }
                dig = 11 - (soma % 11);
                cnpj_calc += (dig == 10 || dig == 11) ? "0" : Integer.toString(dig);
                return cnpj.equals(cnpj_calc);
            }
            catch (Exception e) {
                return false;
            }
        }else {
            return false;
        }
    }

    static void adicionarCorretor() {
        for (int x = 0; x < 3; x++)//preenche os 3 corretores
        {
            Scanner read = new Scanner(System.in);
            System.out.println("Qual o nome do " + (x + 1) + "º corretor");
            corretor[x].setNome(read.next());
            System.out.println("Qual a matricula do " + corretor[x].getNome());
            corretor[x].setMatricula(read.nextInt());
            System.out.println("Qual a meta mensal de vendas do " + corretor[x].getNome());
            corretor[x].setMetaMensal(read.nextInt());
            System.out.println("\n Endereço:");
            System.out.println("CEP");
            endereco[x].setCep(read.nextInt());
            System.out.println("Rua");
            endereco[x].setRua(read.next());
            System.out.println(("número"));
            endereco[x].setNumero(read.nextInt());
            System.out.println("Bairro");
            endereco[x].setBairro(read.next());
            System.out.println("Cidade");
            endereco[x].setCidade(read.next());
            System.out.println("Estado");
            endereco[x].setUF(read.next());
            System.out.println("\n");
        }
    }
}