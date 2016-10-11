import java.util.*;

public interface Exercito {

    public Elfo[] getExercitoDeElfos();

    public void alistarElfo(Elfo soldado);

    public Elfo buscarPeloNome(String nome);

    public ArrayList<Elfo> buscarPeloStatus (Status status);

}
