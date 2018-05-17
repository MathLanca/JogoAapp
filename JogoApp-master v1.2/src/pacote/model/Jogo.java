package pacote.model;

import java.io.Serializable;
import java.util.Objects;

public class Jogo implements Serializable{
    private Time t1;
    private Time t2;
    
    public Jogo(){
    
    }
    
    public Jogo(Time t1, Time t2){
        this.t1 = t1;
        this.t2 = t2;
    }

    public String getJogo() {
        return t1.getNome() + " X " + t2.getNome();
    }

    public void setJogo(Time t1, Time t2) {
        this.t1 = t1;
        this.t2 = t2;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.t1);
        hash = 53 * hash + Objects.hashCode(this.t2);
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
        final Jogo other = (Jogo) obj;
        if (!Objects.equals(this.t1, other.t1)) {
            return false;
        }
        return true;
    }

    
    
}
