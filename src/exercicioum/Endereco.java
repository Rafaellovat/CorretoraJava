
package exercicioum;

public class Endereco {
    private String Rua, cidade, bairro, UF;
    private int cep, numero;

    public void setUF(String UF) {
        this.UF = UF;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setRua(String rua) {
        this.Rua = rua;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public int getCep() {
        return cep;
    }

    public String getRua() {
        return Rua;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getUF() {
        return UF;
    }

}