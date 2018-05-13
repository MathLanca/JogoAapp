package pacote.model;

import java.util.Objects;

public class Jogo {
    private Time t1;
    private Time t2;
    
    public Jogo(){
    
    }
    
    public Jogo(Time t1, Time t2){
        this.t1 = t1;
        this.t2 = t2;
    }

    public String getJogo() {
        String time1 = t1.toString();
        String time2 = t2.toString();
        return time1 + " X " + time2;
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
        return Objects.equals(this.t1, other.t1);
    }
    
    
}
