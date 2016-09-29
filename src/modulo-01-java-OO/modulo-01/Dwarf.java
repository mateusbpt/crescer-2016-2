public class Dwarf {

    private int vida;
    private String nome;
    private DataTerceiraEra dataNascimento;
    private int experiencia;

    public Dwarf(){ //para compilar a ElfoTest
        this.nome = null;
        this.dataNascimento = new DataTerceiraEra(1,1,1);
        this.vida = 110;
    }

    public Dwarf(String nome, DataTerceiraEra dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.vida = 110;
    }

    public void perderVida(){
        boolean menorQueZero = getNumeroSorte() < 0;
        boolean maiorQue100 = getNumeroSorte() > 100;
        if(menorQueZero){
            experiencia+=2;
        }
        if(maiorQue100){
            vida-=10;
        }
    }

    public int getVida(){
        return vida;
    }

    public int getExperiencia(){
        return experiencia;
    }

    public void ganharExperiencia(int xp){
        experiencia+=xp;
    }

    public double getNumeroSorte(){
        boolean vida = this.vida >= 80 && this.vida <= 90;
        boolean nome = "Seixas".equals(this.nome) || "Meireles".equals(this.nome);
        double numero = 101.0; 
        if(dataNascimento.ehBissexto() && vida){
            return numero*= -33.0;    
        }
        if(!dataNascimento.ehBissexto() && nome){
            return (numero*33.0)%100;    
        }
        return numero;
    }
}
