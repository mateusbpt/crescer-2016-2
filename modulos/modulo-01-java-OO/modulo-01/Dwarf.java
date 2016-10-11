public class Dwarf extends Personagem{

    protected DataTerceiraEra dataNascimento;

    public Dwarf(){ //para compilar a ElfoTest
        this(null, new DataTerceiraEra(1,1,1));        
    }

    public Dwarf(String nome, DataTerceiraEra dataNascimento) {
        super(nome);
        this.dataNascimento = dataNascimento;
        super.vida = 110;
    }    

    public void perderVida(){
        if(status == Status.MORTO){
            return;    
        }
        boolean menorQueZero = getNumeroSorte() < 0;
        boolean maiorQue100 = getNumeroSorte() > 100;
        boolean statusVida = vida > 0;
        if(menorQueZero){
            experiencia+=2;
        }

        if(maiorQue100 && statusVida){
            vida-=10;
        }

        if(vida == 0){
            status = Status.MORTO; 
        }
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

    public void tentarSorte(){
        boolean temSorte = getNumeroSorte() == -3333.0;
        if(temSorte){
            inventario.aumentarUnidadesDosItens(1000);    
        }
    } 
}
