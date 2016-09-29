public class Dwarf {

    private int vida;
    private String nome;
    private DataTerceiraEra dataNascimento;

    public Dwarf(){ //para compilar a ElfoTest
        this.vida = 110;
    }

    public Dwarf(String nome, DataTerceiraEra dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.vida = 110;
    }

    public void perderVida(){
        vida-=10;
    }

    public int getVida(){
        return vida;
    }

    public double getNumeroSorte(){
        boolean vidaDwarf = this.vida >= 80 && this.vida <= 90;
        boolean nomeDwarf = this.nome.equals("Seixas") || this.nome.equals("Meireles");
        double numero = 101.0; 
        if(dataNascimento.ehBissexto() == true && vidaDwarf == true){
            return numero*(-33.0);    
        }
        if(dataNascimento.ehBissexto() == false && nomeDwarf == true){
            return (numero*(33.0))%100;    
        }
        return numero;
    }
}
