public class Dwarf {

    private int vida;

    public Dwarf() {
        this.vida = 110;
    }

    public void perderVida(){
        vida-=10;
    }

    public int getVida(){
        return vida;
    }
}

    