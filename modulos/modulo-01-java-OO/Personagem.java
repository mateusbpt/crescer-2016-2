public abstract class Personagem {
    protected String nome;
    protected Inventario inventario;
    protected Status status;
    protected int experiencia;
    protected double vida;

    public Personagem(String nome){
        this.nome = nome;
        this.status = Status.VIVO;
        this.inventario = new Inventario();
    }

    public void setNome(String n) {
        nome = n;
    }

    public String getNome() {
        return nome;
    }

    public Inventario getInventario(){
        return inventario;
    }

    public Status getStatus() {
        return status;
    }

    public int getExperiencia() {
        return experiencia;
    }
    
    public void ganharItem(Item item) {
        inventario.adicionarItem(item);
    }

    public void perderItem(Item item) {
        inventario.removerItem(item);
    }

     public double getVida(){
        return vida;
    }
}
