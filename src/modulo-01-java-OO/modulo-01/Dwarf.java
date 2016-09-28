public class Dwarf {

    private int vida;
    private String nome;
    private DataTerceiraEra dataNascimento;
    
    public Dwarf(String nome, DataTerceiraEra dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.vida = 110;
    }

    public void perderVida(){
        vida-=10;
    }

    public int getVida(){
        return vida;
    }
}

    