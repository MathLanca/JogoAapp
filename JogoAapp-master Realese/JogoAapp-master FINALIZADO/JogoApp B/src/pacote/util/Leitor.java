/*Projeto desenvolvido por:
Guilherme Giazzi - TIA 31722792
Matheus Lança - TIA 31700004
Gabriel Dias - TIA 31756573*/

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

		// carregadar os dados
		for (String dado : dados) {
			String[] registro = dado.split(";");

			// adicionando a confederação
			Confederacao confederacao = new Confederacao(registro[0]);
			if (!confederacoes.contains(confederacao)) {
				confederacoes.add(confederacao);
			}

			// adicionando ligas na confederação
			Liga liga = new Liga(registro[1]);
			int indexOfConfederacao = confederacoes.indexOf(confederacao);
			if (!confederacoes.get(indexOfConfederacao).getLigas().contains(liga)) {
				confederacoes.get(indexOfConfederacao).addLiga(liga);
			}

			// adicionando times nas ligas
			Time time = new Time(registro[2]);
			int indexOfLiga = confederacoes.get(indexOfConfederacao).ligas.indexOf(liga);
			if (!confederacoes.get(indexOfConfederacao).ligas.get(indexOfLiga).getTimes().contains(time)) {
				confederacoes.get(indexOfConfederacao).ligas.get(indexOfLiga).addTime(time);
			}

			// adicionando jogadores nos times
			Jogador jogador = new Jogador(registro[3], registro[4], registro[5]);
			int indexOfTimes = confederacoes.get(indexOfConfederacao).ligas.get(indexOfLiga).times.indexOf(time);
			if (!confederacoes.get(indexOfConfederacao).ligas.get(indexOfLiga).times.get(indexOfTimes).getJogadores()
					.contains(jogador)) {
				confederacoes.get(indexOfConfederacao).ligas.get(indexOfLiga).times.get(indexOfTimes)
						.addJogador(jogador);
			}
		}

		Scanner sc = new Scanner(System.in);
		boolean sair = false;
		while (!sair) {
			System.out.println("\nMENU PRINCIPAL: " + "\n(1) Listar Confederações" + "\n(0) Sair");

			System.out.print("\nEscolha uma opção: ");
			int opPrincipal = sc.nextInt();

			while (opPrincipal < 0 || opPrincipal > 1) {
				System.out.print("\nDigite uma opção valida: ");
				opPrincipal = sc.nextInt();
			}

			if (opPrincipal == 1) {
				// apresentando as Confederacoes no menu
				boolean sairConf = false;
				while (!sairConf) {
					System.out.println("\nLista de Confederações");
					int cont = 1;
					for (Confederacao conf : confederacoes) {
						System.out.println(" (" + cont + ") " + conf.getNome());
						cont++;
					}
					System.out.println(" (0) Voltar");
					System.out.print("\nEscolha uma opção: ");
					int opConf = sc.nextInt();
					while (opConf < 0 || opConf > cont - 1) {
						System.out.print("\nDigite uma opção valida: ");
						opConf = sc.nextInt();
					}

					if (opConf == 0) {
						sairConf = true;
					} else {
						// apresentando as ligas da confederacao
						boolean sairLig = false;
						while (!sairLig) {
							cont = 1;
							Confederacao essaConf = confederacoes.get(opConf - 1);
							System.out.println("\nLista de Ligas da Confederação " + essaConf.getNome());
							for (Liga liga : essaConf.getLigas()) {
								System.out.println(" (" + cont + ") " + liga.getNome());
								cont++;
							}
							System.out.println(" (0) Voltar");
							System.out.print("\nEscolha uma opção: ");
							int opLiga = sc.nextInt();
							while (opLiga < 0 || opLiga > cont - 1) {
								System.out.print("\nDigite uma opção valida: ");
								opLiga = sc.nextInt();
							}

							if (opLiga == 0) {
								sairLig = true;
							} else {
								// apresentando as opcoes de escolha da liga
								Liga essaLiga = essaConf.getLigas().get(opLiga - 1);
								boolean sairOpLig = false;
								while (!sairOpLig) {
									System.out.println("\nLiga " + essaLiga.getNome() + " (Confederação "
											+ essaConf.getNome() + "): " + "\n (1) Listar times" + "\n (2) Listar jogos"
											+ "\n (0) Voltar");
									System.out.print("\nEscolha uma opção: ");
									int opLig = sc.nextInt();
									while (opLig < 0 || opLig > 2) {
										System.out.print("\nDigite uma opção valida: ");
										opLig = sc.nextInt();
									}

									// apresentando as opcoes de listar times e listar jogos
									if (opLig == 1) {
										boolean sairTime = false;
										while (!sairTime) {
											cont = 1;
											System.out.println("\nTimes da Liga " + essaLiga.getNome()
													+ " (Confederação " + essaConf.getNome() + "): ");
											for (Time time : essaLiga.getTimes()) {
												System.out.println(" (" + cont + ") " + time.getNome());
												cont++;
											}
											System.out.println(" (0) Voltar");
											System.out.print("\nEscolha uma opção: ");
											int opTime = sc.nextInt();
											while (opTime < 0 || opTime > cont - 1) {
												System.out.print("\nDigite uma opção valida: ");
												opTime = sc.nextInt();
											}

											if (opTime == 0) {
												sairTime = true;
											} else {
												// apresentando os jogadores do time
												Time esseTime = essaLiga.getTimes().get(opTime - 1);
												boolean sairJog = false;
												while (!sairJog) {
													cont = 1;
													System.out.println("\nJogadores do time " + esseTime.getNome()
															+ " (Liga " + essaLiga.getNome() + " da Confederação "
															+ essaConf.getNome() + "): ");
													for (Jogador jogador : esseTime.getJogadores()) {
														System.out.println(" (" + cont + ") " + jogador.getNome());
														cont++;
													}
													System.out.println(" (0) Voltar");
													System.out.print("\nEscolha uma opção: ");
													int opJogador1 = sc.nextInt();
													while (opJogador1 < 0 || opJogador1 > cont - 1) {
														System.out.print("\nDigite uma opção valida: ");
														opJogador1 = sc.nextInt();
													}

													if (opJogador1 == 0) {
														sairJog = true;
													} else {
														// apresentando os dados do jogador escolhido
														Jogador esseJogador = esseTime.getJogadores()
																.get(opJogador1 - 1);
														System.out.println("\n" + esseJogador.getNome() + " (do time "
																+ esseTime.getNome() + ", Liga " + essaLiga.getNome()
																+ ", Confederação " + essaConf.getNome() + "): ");
														System.out.println(
																" - Data de nascimento: " + esseJogador.getDataNasc()
																		+ "\n - Local de nascimento: "
																		+ esseJogador.getLocalNasc());
														System.out.print("\n Pressione 0 para voltar: ");
														int opJogador = sc.nextInt();
														while (opJogador < 0 || opJogador > 1) {
															System.out.print("\nDigite uma opção valida: ");
															opJogador = sc.nextInt();
														}

														if (opJogador == 0) {
															sairJog = true;
														}
													}
												}
											}
										}

									} else if (opLig == 2) {
										System.out.println("\nJogos da Liga " + essaLiga.getNome() + " (Confederação "
												+ essaConf.getNome() + "): ");
										System.out.print(essaLiga.organizarJogos());

										System.out.print("\nPressione 0 para voltar: ");
										int opJogador2 = sc.nextInt();
										while (opJogador2 != 0) {
											System.out.print("\nDigite uma opção valida: ");
											opJogador2 = sc.nextInt();
										}

										sairOpLig = true;
									} else {
										sairOpLig = true;
									}

								}
							}
						}
					}

				}
			} else {
				System.out.println("\nSaiu!");
				sair = true;
			}
		}

	}

}
