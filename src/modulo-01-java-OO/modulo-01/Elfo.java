public class Elfo {
    private String nome;
    private Item arco;
    private Item flecha;
    private int experiencia;
    private int dwarves;

    public Elfo(String n) {
        nome = n;
        arco = new Item("Arco", 1);
        flecha = new Item("Flechas", 2);
        dwarves = 110;
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

    public Item getFlecha() {
        return flecha;
    }

    public void atirarFlecha() {
        if(flecha.getQuantidade() > 0){ //garante que o elfo não possua flechas negativas
            flecha.setQuantidade(flecha.getQuantidade() - 1);
            experiencia++;
        } 
    }

    public void atacarDwarves() {
        atirarFlecha();
        if(dwarves > 0 && flecha.getQuantidade() > 0){
            dwarves -= 10;
        }
    }
    /*public void atirarFlechaRefactory() {
    experiencia++;
    flecha.setQuantidade(flecha.getQuantidade()-1);
    }*/
}

