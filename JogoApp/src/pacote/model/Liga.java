package pacote.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Liga implements Serializable, Comparable<Liga> {
    private String nome;
    public List<Time> times = new ArrayList();
    public int numTimes;
    public Jogo[] jogos;
    
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
    
    /*public int getNumTimes(){
        this.numTimes = times.size();
        return this.numTimes;
    }*/
    
    public void organizarJogos(){
        
        this.numTimes = times.size();
        //System.out.println(numTimes);
        if (numTimes <= 10){
            /*try{
                for (int a = 0; a < numTimes; a++){
                    System.out.println(times.get(a).getNome() + " X " + times.get(a+1).getNome());
                    //System.out.println(times.get(a+1).getNome() + " X " + times.get(a).getNome());
                }
            } catch(IndexOutOfBoundsException ex){
                System.out.println("");
            }*/
            
            // Vamos ver essa parte do Jogo
            for(int t1 = 0; t1 < numTimes - 1; t1++){
                for(int t2 = t1; t2 < numTimes; t2++){
                    this.jogos[numJogo] = new Jogo(times[t1],times[t2]);
                }
            }
        } else{
            for(Time t1 : times){
                for(Time t2 : times){
                    System.out.println(t1.getNome() + " X " + t2.getNome());
                }
            }
          }
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
