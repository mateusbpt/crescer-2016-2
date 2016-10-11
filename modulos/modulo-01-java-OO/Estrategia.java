import java.util.*;

public interface Estrategia {
    public List<Elfo> getOrdemDeAtaque(List<Elfo> atacantes)throws ElfosDesproporcionalException;
}
