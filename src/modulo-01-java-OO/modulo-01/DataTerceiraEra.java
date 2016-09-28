public class DataTerceiraEra {

    private int dia;
    private int mes;
    private int ano;

    public DataTerceiraEra (int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public int getDia() {
        return dia;
    }    

    public int getMes() {
        return mes;
    }    

    public int getAno() {
        return ano;
    }    

    public boolean ehBissexto(){

        if(ano%400 == 0 || (ano%100 != 0 && ano%4 == 0)){ //Condições para ocorrer ano Bissexto
            return true;   
        }
        return false;
    }
}