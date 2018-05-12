package pacote.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.ArrayList;
import java.util.List;

public class Time implements Serializable, Comparable<Time>{
    private String nome;
    private List<Jogador> jogadores = new ArrayList();
    public Time(){
        
    }
    
    public Time(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public List<Jogador> getJogadores() {
        return jogadores;
    }

    public void setJogadores(List<Jogador> jogadores) {
        this.jogadores = jogadores;
    }
    
    public void addJogador(Jogador jogador){
        this.jogadores.add(jogador);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.nome);
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
        final Time other = (Time) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Time time) {
        return this.nome.compareTo(time.getNome());
    }
    
    

    
    
    
}
