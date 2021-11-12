
package exercicioum;

public class Corretor {
    private String nome;
    private int matricula, metaMensal, totalDeVendas = 0;

    public String getNome() {
        return nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public int getMetaMensal() {
        return metaMensal;
    }

    public int getTotalDeVendas() {
        return totalDeVendas;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public void setMetaMensal(int metaMensal) {
        this.metaMensal = metaMensal;
    }

    public void setTotalDeVendas(int vendaMensal) {
        this.totalDeVendas = totalDeVendas + vendaMensal;
    }


}