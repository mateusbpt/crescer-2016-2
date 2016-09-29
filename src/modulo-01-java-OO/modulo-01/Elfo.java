public class Elfo {
    private String nome;
    private Item arco;
    private Item flecha;
    private int experiencia;
    private Status status;

    public Elfo(String n) {
        //Chama construtor debaixo
        this(n, 42);
    }

    public Elfo(String n, int quantidadeFlechas) {
        nome = n;
        arco = new Item("Arco", 1);
        flecha = new Item("Flechas", quantidadeFlechas  >= 0 ? quantidadeFlechas : 42);
        status = Status.VIVO;
    }

    public String toString(){
        boolean flechaNoSingular = this.flecha.getQuantidade() == 1;
        boolean experienciaNoSingular = this.experiencia == 1;
        return String.format("%s possui %d %s e %d %s de experiência.",this.nome, this.flecha.getQuantidade(),
            flechaNoSingular ? "flecha":"flechas", this.experiencia, experienciaNoSingular ? "nível":"níveis");

    }    

    public void setNome(String n) {
        nome = n;
    }

    public String getNome() {
        return nome;
    }

    public Item getArco() {
        return arco;
    }

    public int getExperiencia() {
        return experiencia;
    }
    
    public Status getStatus() {
        return status;
    }
    
    public Item getFlecha() {
        return flecha;
    }

    public void atirarFlecha(Dwarf dwarf) {
        if(flecha.getQuantidade() > 0){ //garante que o elfo não possua flechas negativas
            flecha.setQuantidade(flecha.getQuantidade() - 1);   
            dwarf.perderVida(); 
            experiencia++;
        }
    }
}  


