public class Elfo {
    private String nome;
    private int experiencia;
    private Status status;
    private Inventario inventario;

    public Elfo(String n) {
        //Chama construtor debaixo
        this(n, 42);
    }

    public Elfo(String n, int quantidadeFlechas) {
        nome = n;
        inventario = new Inventario(); 
        inventario.adicionarItem(new Item("Arco", 1));
        inventario.adicionarItem(new Item("Flechas", quantidadeFlechas  >= 0 ? quantidadeFlechas : 42));
        status = Status.VIVO;
    }

    public String toString(){
        boolean flechaNoSingular = this.getFlecha().getQuantidade() == 1;
        boolean experienciaNoSingular = this.experiencia == 1;
        return String.format("%s possui %d %s e %d %s de experiência.",this.nome, this.getFlecha().getQuantidade(),
            flechaNoSingular ? "flecha":"flechas", this.experiencia, experienciaNoSingular ? "nível":"níveis");

    }    

    public void setNome(String n) {
        nome = n;
    }

    public String getNome() {
        return nome;
    }

    public Item getArco(){
        return inventario.getItens().get(0);
    }

    public Item getFlecha(){
        return inventario.getItens().get(1);
    }

    public int getExperiencia() {
        return experiencia;
    }

    public Status getStatus() {
        return status;
    }

    public void atirarFlecha(Dwarf dwarf) {
        int quantidadeFlechas = getFlecha().getQuantidade();
        if(quantidadeFlechas > 0){ //garante que o elfo não possua flechas negativas
            getFlecha().setQuantidade(quantidadeFlechas - 1);   
            dwarf.perderVida(); 
            experiencia++;
        }
    }
}  

