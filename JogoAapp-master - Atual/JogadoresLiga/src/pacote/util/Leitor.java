
package pacote.util;

import pacote.model.Confederacao;
import pacote.model.Jogador;
import pacote.model.Liga;
import pacote.model.Time;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jogadoresliga.LeitorDadosJogadores;

public class Leitor {

    public static void main(String[] args) {
        LeitorDadosJogadores leitor = new LeitorDadosJogadores();
        String[] dados = leitor.ler();
        List<Confederacao> confederacoes = new ArrayList();
        List<Liga> ligas = new ArrayList();
        List<Jogador> jogadores = new ArrayList();
        for (String dado : dados) {
            String[] registro = dado.split(";");
            
            // Adcionando confederações
            Confederacao confederacao = new Confederacao(registro[0]);
            if (!confederacoes.contains(confederacao)) {
                confederacoes.add(confederacao);
            }
            
            // Adicionando ligas na confederação
            Liga liga = new Liga(registro[1]);
            int indexOfConfederacao = confederacoes.indexOf(confederacao);
            if(!confederacoes.get(indexOfConfederacao).getLigas().contains(liga)){
                confederacoes.get(indexOfConfederacao).addLiga(liga);
            }
            
            // Adicionando times nas ligas
            Time time = new Time(registro[2]);
            int indexOfLiga = confederacoes.get(indexOfConfederacao).ligas.indexOf(liga);
            
            
            
        }
        System.out.println(confederacoes.size());
        Collections.sort(confederacoes);
        for (Confederacao conf : confederacoes) {
            System.out.println(conf.getNome());
            Collections.sort(conf.getLigas());
            for (Liga liga : conf.getLigas()) {
                System.out.println("\t" + liga.getNome());
                Collections.sort(liga.getTimes());
                for(Time time : liga.getTimes()){
                    System.out.println("\t"+time.getNome());
                    
                    
                }
            }
        }
    }
}
