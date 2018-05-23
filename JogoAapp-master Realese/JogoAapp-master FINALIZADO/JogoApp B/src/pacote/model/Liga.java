package pacote.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Liga implements Serializable, Comparable<Liga> {
    private String nome;
    public List<Time> times = new ArrayList();
    //public Time[] times2;
    public int numTimes;
    //public Jogo[] jogos;
    
    public Liga(){
        
    }
    
    public Liga(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public List<Time> getTimes() {
        return times;
    }

    public void setTimes(List<Time> times) {
        this.times = times;
    }
    
    public void addTime(Time time){
        this.times.add(time);
    }
    
    public String organizarJogos(){
        this.numTimes = this.times.size();
        //System.out.println("Num times: " + numTimes);
        if (numTimes <= 10){
            //Jogos turno e returno
            for(int t1 = 0; t1 < numTimes - 1; t1++){
                for(int t2 = t1 + 1; t2 < numTimes; t2++){
                    Jogo jogo1 = new Jogo(times.get(t1), times.get(t2));
                    Jogo jogo2 = new Jogo(times.get(t2), times.get(t1));
                    System.out.println(jogo1.getJogo());
                    System.out.println(jogo2.getJogo());
                }
            }
        } else{
            //Jogos returno
            for(int t1 = 0; t1 < numTimes - 1; t1++){
                for(int t2 = t1 + 1; t2 < numTimes; t2++){
                    Jogo jogo = new Jogo(times.get(t1), times.get(t2));
                    System.out.println(jogo.getJogo());
                }
            }
            //System.out.println("\n");
          }
       return ""; 
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.nome);
        hash = 79 * hash + Objects.hashCode(this.times);
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
    
    

    @Override
    public int compareTo(Liga liga) {
      return this.nome.compareTo(liga.getNome());
    }
    
    
}
