package LigaJogadores.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Liga implements Serializable,Comparable<Liga>{
    private String nome;
    private List<Time> times = new ArrayList();
    public Liga() {
    }
    
    public Liga(String nome) {
        this.nome = nome;
    }
    
   public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void addTime(Time time){
        this.times.add(time);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.nome);
        hash = 29 * hash + Objects.hashCode(this.times);
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
        final Liga other = (Liga) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }
    public int compareTo(Liga liga) {
        return this.nome.compareTo(liga.getNome());
        }
}
