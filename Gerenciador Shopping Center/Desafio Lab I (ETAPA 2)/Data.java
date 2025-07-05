public class Data {
    private int dia;
    private int mes;
    private int ano;

    // Construtor
    public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    // Getters e Setters
    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    // Método toString
    public String toString() {
        return String.format("%02d/%02d/%04d", dia, mes, ano);
    }

    // Verifica se o ano é bissexto
    public boolean verificaAnoBissexto() {
        return (ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0);
    }

    // Método de comparação de datas
    // Retorna:
    // -1 se this < outra
    //  0 se this == outra
    //  1 se this > outra
    public int compararCom(Data outra) {
        if (this.ano != outra.ano) {
            return this.ano < outra.ano ? -1 : 1;
        }
        if (this.mes != outra.mes) {
            return this.mes < outra.mes ? -1 : 1;
        }
        if (this.dia != outra.dia) {
            return this.dia < outra.dia ? -1 : 1;
        }
        return 0;
    }
}
