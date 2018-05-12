
package pacote.model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
public class Confederacao implements Serializable,Comparable<Confederacao>{
    private String nome;
    List<Liga> ligas = new ArrayList();

    public Confederacao(String nome) {
        this.nome = nome;
    }
    
    public Confederacao(){
    }
    
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void addLiga(Liga liga){
        this.ligas.add(liga);
    }
    public List<Liga> getLigas(){
        return ligas;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.nome);
        hash = 29 * hash + Objects.hashCode(this.ligas);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Confederacao other = (Confederacao) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Confederacao confederacao) {
        return this.nome.compareTo(confederacao.getNome());
        }
}
