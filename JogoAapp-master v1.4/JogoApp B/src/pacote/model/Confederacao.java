package pacote.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Confederacao implements Serializable, Comparable<Confederacao> {
    private String nome;
    public List<Liga> ligas = new ArrayList();
        
    public Confederacao(){
    
    }
  
    public Confederacao(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Liga> getLigas() {
        return ligas;
    }

    public Liga getLiga(Liga liga){
        int indexLiga = ligas.indexOf(liga);
        Liga essaLiga = ligas.get(indexLiga);
        return essaLiga;
    }            
            
    public void setLigas(List<Liga> ligas) {
        this.ligas = ligas;
    }
    
    public void addLiga(Liga liga){
        this.ligas.add(liga);
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.nome);
        hash = 67 * hash + Objects.hashCode(this.ligas);
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
