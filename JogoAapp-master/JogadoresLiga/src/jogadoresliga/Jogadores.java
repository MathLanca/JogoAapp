
package jogadoresliga;

import LigaJogadores.model.Confederacao;
import LigaJogadores.model.Jogador;
import LigaJogadores.model.Liga;
import LigaJogadores.model.Time;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Jogadores {

    public static void main(String[] args) {
        LeitorDadosJogadores leitor = new LeitorDadosJogadores();
        String[] dados = leitor.ler();
        List<Confederacao> confederacoes = new ArrayList();
        List<Liga> ligas = new ArrayList();
        List<Jogador> jogadores = new ArrayList();
        for (String dado : dados) {
            String[] registro = dado.split(";");

            Confederacao confederacao = new Confederacao(registro[0]);
            if (!confederacoes.contains(confederacao)) {
                confederacoes.add(confederacao);
            }

            Liga liga = new Liga(registro[1]);
            int indexConfederacao = confederacoes.indexOf(confederacao);;
            Confederacao confAux = confederacoes.get(indexConfederacao);
            
            
            if (!confAux.getLigas().contains(liga)) {
                confAux.getLigas().add(liga);
            }
            
            Time time = new Time(registro[2]);            
            if(!confAux.getLigas().get(indexConfederacao).getTimes().contains(time)){
                confAux.getLigas().get(indexConfederacao).getTimes().add(time);
            }
            
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
