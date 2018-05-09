package jogadoresliga;

import LigaJogadores.model.Confederacao;
import LigaJogadores.model.Liga;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jogadoresliga.LeitorDadosJogadores;

public class Jogadores {

    public static void main(String[] args) {
        LeitorDadosJogadores leitor = new LeitorDadosJogadores();
        String[] dados = leitor.ler();
        List<Confederacao>confederacoes = new ArrayList();
        
        for (String dado : dados) {
            String [] registro = dado.split(";");
            
            Confederacao confederacao = new Confederacao(registro[0]);
            if(!confederacoes.contains(confederacao)){
                confederacoes.add(confederacao);
                    }
            
            Liga liga = new Liga(registro[1]);
            int indexOfConfedaracao = confederacoes.indexOf(confederacao);
            if(!confederacoes.get(indexOfConfedaracao).getLigas().contains(liga)){
                confederacoes.get(indexOfConfedaracao).addLiga(liga);
            }
    }
        System.out.println(confederacoes.size());  
        Collections.sort(confederacoes);
        for (Confederacao conf: confederacoes){
            System.out.println(conf.getNome());
            Collections.sort(conf.getLigas());
            for(Liga liga: conf.getLigas()){
                System.out.println("\t"+liga.getNome());

            }
    }
}
}
