public class Elfo {
    private String nome;
    private Item arco;
    private Item flecha;
    private int experiencia;

    public Elfo(String n) {
        nome = n;
        arco = new Item("Arco", 1);
        flecha = new Item("Flechas", 42);
    }
    
    public Elfo(String n, int quantidadeFlechas) {
        nome = n;
        arco = new Item("Arco", 1);
        flecha = new Item("Flechas", quantidadeFlechas);
    }

    public String toString(){
        return getNome() + " possui " + flecha.getQuantidade() + " flechas e " + getExperiencia() + " níveis de experiência";
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
    
    public Item getFlecha() {
        return flecha;
    }

    public void atirarFlecha(Dwarf dwarf) {
        if(flecha.getQuantidade() > 0){ //garante que o elfo não possua flechas negativas
            flecha.setQuantidade(flecha.getQuantidade() - 1);
            experiencia++;
            dwarf.perderVida();
        } 
    }

    /*public void atirarFlechaRefactory() {
    experiencia++;
    flecha.setQuantidade(flecha.getQuantidade()-1);
    }*/
}

