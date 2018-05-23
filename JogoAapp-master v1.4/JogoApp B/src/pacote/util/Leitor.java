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
        
        ////TESTE
        
        ////

        Scanner sc = new Scanner(System.in);
        System.out.println("\nMENU PRINCIPAL: "
                + "\n(1) Listar confederações"
                + "\n(0) SAIR");
        
        System.out.print("\nEscolha uma opção: ");
        int opPrincipal = sc.nextInt();
        
        while (opPrincipal < 0 || opPrincipal > 1) {
            System.out.print("\nDigite uma opção valida: ");
            opPrincipal = sc.nextInt();
        }
        
        if (opPrincipal == 1) {
            //apresentando as Confederacoes no menu
            System.out.println("\nLista de Confederações");
            int cont = 1;
                    for(Confederacao conf : confederacoes){
                        System.out.println(" (" + cont + ") " + conf.getNome());
                        cont ++;
                    }
                    System.out.println(" (0) Voltar");
            System.out.print("\nEscolha uma opção: ");
            int opConf = sc.nextInt();
            while(opConf < 0 || opConf > cont-1){
                System.out.print("\nDigite uma opção valida: ");
                opConf = sc.nextInt();
            }
            
            //apresentando as ligas da confederacao
            cont = 1;
            Confederacao essaConf = confederacoes.get(opConf-1);
            System.out.println("\nLista de Ligas da Confederação " + essaConf.getNome());
            for(Liga liga : essaConf.getLigas()){
                System.out.println(" (" + cont + ") " + liga.getNome());
                cont ++;
            }
            System.out.println(" (0) Voltar");
            System.out.print("\nEscolha uma opção: ");
            int opLiga = sc.nextInt();
            while(opLiga < 0 || opLiga > cont-1){
                System.out.print("\nDigite uma opção valida: ");
                opLiga = sc.nextInt();
            }
            Liga essaLiga = essaConf.getLigas().get(opLiga-1);
            
            //apresentando as opcoes de escolha da liga
            System.out.println("\nLiga " + essaLiga.getNome() + " (Confederação " + essaConf.getNome() + "): "
                                + "\n (1) Listar times"
                                + "\n (2) Listar jogos"
                                + "\n (0) Voltar");
            System.out.print("\nEscolha uma opção: ");
            int opLiga2 = sc.nextInt();
            while(opLiga2 < 0 || opLiga2 > 2){
                System.out.print("\nDigite uma opção valida: ");
                opLiga2 = sc.nextInt();
            }
            
            //apresentando as opcoes de listar times e listar jogos
            cont = 1;
            if(opLiga2 == 1){
                System.out.println("\nTimes da Liga " + essaLiga.getNome() + " (Confederação " + essaConf.getNome() + "): ");
                        for(Time time : essaLiga.getTimes()){
                            System.out.println(" (" + cont + ") " + time.getNome());
                            cont ++;
                        }
                        System.out.println(" (0) Voltar");
                        System.out.print("\nEscolha uma opção: ");
                        int opTime = sc.nextInt();
                        while(opTime < 0 || opTime > cont-1){
                            System.out.print("\nDigite uma opção valida: ");
                            opTime = sc.nextInt();
                        }
                        Time esseTime = essaLiga.getTimes().get(opTime-1);
                        
                        //apresentando os jogadores do time
                        cont = 1;
                        System.out.println("\nJogadores do time " + esseTime.getNome() + " (Liga " + essaLiga.getNome() + " da Confederação " + essaConf.getNome() + "): ");
                        for(Jogador jogador : esseTime.getJogadores()){
                            System.out.println(" (" + cont + ") " + jogador.getNome());
                            cont ++;
                        }
                        System.out.println(" (0) Voltar");
                        System.out.print("\nEscolha uma opção: ");
                        int opJogador = sc.nextInt();
                        while(opJogador < 0 || opJogador > cont-1){
                            System.out.print("\nDigite uma opção valida: ");
                            opJogador = sc.nextInt();
                        }
                        
                        //apresentando os dados do jogador escolhido
                        Jogador esseJogador = esseTime.getJogadores().get(opJogador-1);
                        System.out.println("\n" + esseJogador.getNome() + " (do time " + esseTime.getNome() + ", Liga " + essaLiga.getNome() + ", Confederação " + essaConf.getNome() + "): ");
                        System.out.println(" - Data de nascimento: " + esseJogador.getDataNasc() 
                                         + "\n - Local de nascimento: " + esseJogador.getLocalNasc());
                        
                        System.out.println("\nPressione 0 para voltar: ");
            } else{
                System.out.println("\nJogos da Liga " + essaLiga.getNome() + " (Confederação " + essaConf.getNome() + "): ");
                System.out.println(essaLiga.organizarJogos());
                System.out.println("Pressione 0 para voltar: ");
            }
            
        } else{
            System.out.println("\nSaiu!");

        }

        //op = 0;

            

                /*op = sc.nextInt();
                while (op < 0 || op > 3) {
                    System.out.println("Digite uma opção valida!");
                    System.out.println(menu);
                    op = sc.nextInt();
                }
                if (op == 1) {
                    Collections.sort(confederacoes);
                    for (Confederacao conf : confederacoes) {
                        //if () {
                            for (Liga l : conf.getLigas()) {
                                System.out.println("\t" + l.getNome());
                            }
                        //}
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
        

        for (Confederacao conf1:confederacoes){
            for(Liga l1 : conf1.getLigas()){
                l1.organizarJogos();
            }
        }*/
        //ler os dados 
    }

}
