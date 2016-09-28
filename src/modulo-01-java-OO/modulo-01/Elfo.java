public class Elfo {
    private String nome;
    private Item arco;
    private Item flecha;
    private int experiencia;
    private int dwarf;

    public Elfo(String n) {
        nome = n;
        arco = new Item("Arco", 1);
        flecha = new Item("Flechas", 42);
        dwarf = 110;
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
    
    public int getDwarf() {
        return dwarf;
    }
    
    public void atirarFlecha() {
        if(flecha.getQuantidade() > 0){ //garante que o elfo não possua flechas negativas
            flecha.setQuantidade(flecha.getQuantidade() - 1);
            experiencia++;
        } 
    }

    public void atacarDwarf() {
        atirarFlecha();
        if(dwarf > 0 && flecha.getQuantidade() > 0){
            dwarf -= 10;
        }
    }
    /*public void atirarFlechaRefactory() {
    experiencia++;
    flecha.setQuantidade(flecha.getQuantidade()-1);
    }*/
}

