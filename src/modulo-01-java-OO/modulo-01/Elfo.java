public class Elfo extends Personagem{

    public Elfo(String nome) {
        //Chama construtor debaixo
        this(nome, 42);
    }

    public Elfo(String nome, int quantidadeFlechas) {
        super(nome);
        super.vida = 100;
        inventario.adicionarItem(new Item("Arco", 1));
        inventario.adicionarItem(new Item("Flechas", quantidadeFlechas  >= 0 ? quantidadeFlechas : 42));     
    }

    public String toString(){
        boolean flechaNoSingular = this.getFlecha().getQuantidade() == 1;
        boolean experienciaNoSingular = this.experiencia == 1;
        return String.format("%s possui %d %s e %d %s de experiência.",this.nome, this.getFlecha().getQuantidade(),
            flechaNoSingular ? "flecha":"flechas", this.experiencia, experienciaNoSingular ? "nível":"níveis");

    }    

    public Item getArco(){
        return inventario.getItens().get(0);
    }

    public Item getFlecha(){
        return inventario.getItens().get(1);
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

