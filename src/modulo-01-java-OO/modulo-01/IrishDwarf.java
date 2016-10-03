public class IrishDwarf {

    private int vida;
    private String nome;
    private DataTerceiraEra dataNascimento;
    private int experiencia;
    private Status status;
    private Inventario inventario;

    public IrishDwarf(){ //para compilar a ElfoTest
        this(null, new DataTerceiraEra(1,1,1));        
    }

    public IrishDwarf(String nome, DataTerceiraEra dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.vida = 110;
        this.status = Status.VIVO;
        this.inventario = new Inventario();
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

    public int getVida(){
        return vida;
    }

    public Status getStatus(){
        return status;
    }

    public int getExperiencia(){
        return experiencia;
    }    

    public Inventario getInventario(){
        return inventario;
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

    public void ganharItem(Item item) {
        inventario.adicionarItem(item);
    }

    public void perderItem(Item item) {
        inventario.removerItem(item);
    }

    public void tentarSorte(){
        boolean temSorte = getNumeroSorte() == -3333.0;
        if(temSorte){
            inventario.aumentarUnidadesDosItensVezes1000();   
        }
    } 
}