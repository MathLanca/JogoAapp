package pacote.model;

import java.io.Serializable;
import java.util.Objects;

public class Jogador implements Serializable, Comparable<Jogador> {
    private String nome;
    private String dataNasc;
    private String localNasc;
        
    public Jogador(){
        
    }
    
    public Jogador(String nome, String dataNasc, String localNasc){
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.localNasc = localNasc;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getLocalNasc() {
        return localNasc;
    }

    public void setLocalNasc(String localNasc) {
        this.localNasc = localNasc;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.nome);
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
        final Jogador other = (Jogador) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Jogador jogador) {
      return this.nome.compareTo(jogador.getNome());
    } 
    
}