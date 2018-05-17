package pacote.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import jogadoresliga.LeitorDadosJogadores;
import pacote.model.Confederacao;
import pacote.model.Jogador;
import pacote.model.Liga;
import pacote.model.Time;
import pacote.model.Jogo;

public class Leitor {

    public static void main(String[] args) {

        LeitorDadosJogadores leitor = new LeitorDadosJogadores();
        String[] dados = leitor.ler();
        List<Confederacao> confederacoes = new ArrayList();

        //carregadar os dados
        for (String dado : dados) {
            String[] registro = dado.split(";");

            //adicionando a confederação
            Confederacao confederacao = new Confederacao(registro[0]);
            if (!confederacoes.contains(confederacao)) {
                confederacoes.add(confederacao);
            }

            //adicionando ligas na confederação
            Liga liga = new Liga(registro[1]);
            int indexOfConfederacao = confederacoes.indexOf(confederacao);
            if (!confederacoes.get(indexOfConfederacao).getLigas().contains(liga)) {
                confederacoes.get(indexOfConfederacao).addLiga(liga);
            }

            //adicionando times nas ligas
            Time time = new Time(registro[2]);
            int indexOfLiga = confederacoes.get(indexOfConfederacao).ligas.indexOf(liga);
            if (!confederacoes.get(indexOfConfederacao).ligas.get(indexOfLiga).getTimes().contains(time)) {
                confederacoes.get(indexOfConfederacao).ligas.get(indexOfLiga).addTime(time);
            }

            //adicionando jogadores nos times
            Jogador jogador = new Jogador(registro[3], registro[4], registro[5]);
            int indexOfTimes = confederacoes.get(indexOfConfederacao).ligas.get(indexOfLiga).times.indexOf(time);
            if (!confederacoes.get(indexOfConfederacao).ligas.get(indexOfLiga).times.get(indexOfTimes).getJogadores().contains(jogador)) {
                confederacoes.get(indexOfConfederacao).ligas.get(indexOfLiga).times.get(indexOfTimes).addJogador(jogador);

            }

        }

        Scanner sc = new Scanner(System.in);
        String menu;
        menu = "\nMENU PRINCIPAL: "
                + "\n(1) Listar confederações"
                + "\n(0) SAIR"
                + "\n\nEscolha uma opção: ";

        //
        System.out.println(menu);
        int op = sc.nextInt();
        while (op != 0) {
            while (op < 0 || op > 1) {
                System.out.println("Digite uma opção valida!");
                System.out.println(menu);
                op = sc.nextInt();
            }
            if (op == 1) {
                menu = "\nLista de Confederações"
                        + "\n(1) Africa"
                        + "\n(2) Ásia"
                        + "\n(3) America do Sul"
                        + "\n"
                        + "\n(0) Voltar"
                        + "\n"
                        + "\nEscolha uma confederação (ou Voltar)";

                System.out.println(menu);
                op = sc.nextInt();
                while (op < 0 || op > 3) {
                    System.out.println("Digite uma opção valida!");
                    System.out.println(menu);
                    op = sc.nextInt();
                }
                if (op == 1) {
                    Collections.sort(confederacoes);
                    for (Confederacao conf : confederacoes) {
                        if () {
                            for (Liga l : conf.getLigas()) {
                                System.out.println("\t" + l.getNome());
                            }
                        }
                        System.out.println(conf.getNome());
                        Collections.sort(conf.getLigas());
                        for (Liga l : conf.getLigas()) {
                            System.out.println("\t" + l.getNome());
                            for (Time t : l.getTimes()) {
                                System.out.println("\t\t" + t.getNome());
                                for (Jogador jogador : t.getJogadores()) {
                                    System.out.println("\t\t\t" + jogador.getNome() + ", " + jogador.getDataNasc() + ", " + jogador.getLocalNasc());
                                }
                            }
                        }
                    }
                }
            }
        }

        /*for (Confederacao conf1:confederacoes){
            for(Liga l1 : conf1.getLigas()){
                l1.organizarJogos();
            }
        }*/
        //ler os dados 
    }

}
