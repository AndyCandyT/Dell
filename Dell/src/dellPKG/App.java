package dellPKG;

import java.util.*;

public class App {
	
	//teclados
	public static Scanner tecladoNum = new Scanner(System.in);
	
	//variaveis globais
	public static int opcaoMenu=0;
	public static int opcaoSub=0;
	
	
	public static void main(String[] args) {
		 Assentos.criaSaidas();
		 Assentos.geraReservas();
		 System.out.println("Bem vindo ao sistema de reservas de passagem da Viação União Santa Cruz!");
		 menu();
		

	}//fim main
	
	public static void menu() {

        while (opcaoMenu != 6) {

            // menu principal
            System.out.println("\n Selecione a operação desejada:");
            System.out.println("(Digite o número correspondente a opção)");
            System.out.println("1- Visualizar os Acentos");
            System.out.println("2- Reservar uma Passagem");
            System.out.println("3- Liberar uma Reserva");
            System.out.println("4- Encontrar Acentos Livres");
            System.out.println("5- Gerar Relatorios");
            System.out.println("6- Sair do Programa");
            
       
            opcaoMenu=tecladoNum.nextInt();
            
            switch (opcaoMenu) {

                case 1:
                	
                    subMenuVisualizarAcentos();
                    break;
                    
                case 2:
                	
                	subMenuReservarPassagem();
                    break;
                    
                case 3:
                    
                	subMenuLiberarReserva();
                    break;
                    
                case 4:
                	
                	subMenuEncontrarAssentosLivres();
                    break;
                    
                case 5:
                	
                    subMenuRelatorios();
                    break;
                    
                
                case 6:
                	
                    System.out.println("Obrigado por usar nosso APP \n Até mais!");
                    break;
                    
                default:
                    
                    System.out.println("Opção inválida");

            }// fim switch
            
        } // fim while
        opcaoSub = 0;
        
    }// fim menu
	
	public static void subMenuVisualizarAcentos() {
		

		while (opcaoSub != 5) {
			
			
			System.out.println("\n Selecione o horario desejado para visualizar os acentos:");
			System.out.println("(Digite o número correspondente à opção)");
			System.out.println("1- Para o horário das 6h ");
			System.out.println("2- Para o horário das 10h ");
			System.out.println("3- Para o horário das 16h");
			System.out.println("4- Para o horário das 20h ");
			System.out.println("5- Voltar ao menu principal");


			opcaoSub = tecladoNum.nextInt();
			

			switch (opcaoSub) {
			case 1:

				Assentos.setHorario(0);
				Assentos.oni[0].setRotaAtual(1);
				Assentos.saida();
				break;

			case 2:
				
				Assentos.setHorario(0);
				Assentos.oni[0].setRotaAtual(2);
				Assentos.saida();
				break;

			case 3:
				
				Assentos.setHorario(1);
				Assentos.oni[1].setRotaAtual(1);
				Assentos.saida();
				break;
				
			case 4:
				
				Assentos.setHorario(1);
				Assentos.oni[1].setRotaAtual(2);
				Assentos.saida();
				break;

			case 5:

				System.out.println("Voltando ao menu principal...");
				break;

			default:

				System.out.println("Opção Inválida");

			}// fim switch

		} // fim while
		opcaoSub = 0;
		
	}// fim subMenuVisualizarAcentos()
	
	public static void subMenuReservarPassagem(){
		
		while (opcaoSub != 4) {
			
			System.out.println("\n Selecione a opção desejada:");
			System.out.println("(Digite a rota de passagem desejada:)");
			System.out.println("1- Uma passagem para a rota Porto Alegre -> Florianópolis ");
			System.out.println("2- Uma passagem para a rota Porto Alegre -> Criciúma ");
			System.out.println("3- Uma passagem para a rota Criciúma -> Florianópolis");
			System.out.println("4- Voltar ao menu principal");

			opcaoSub = tecladoNum.nextInt();
			

			switch (opcaoSub) {
				case 1:
	
					System.out.println("Qual horario desejas?");
					System.out.println("1 - 6h  2 - 16h");
					
					Assentos.setHorario(tecladoNum.nextInt()-1);
					while(Assentos.getHorario()<0 || Assentos.getHorario()>1) {
						System.out.println("Horario invalido - Qual horario desejas?");
						System.out.println("1 - 6h  2 - 16h");
						Assentos.setHorario(tecladoNum.nextInt()-1); //-1 pois os horarios são 0 e 1 não 1 e 2(melhor explicado na classe assentos)
					}
					Assentos.oni[Assentos.getHorario()].setRotaAtual(0);
					Assentos.saida();
					
					System.out.println("Qual desses assentos livres desejas?");
					Assentos.setVagaDesejada(tecladoNum.nextInt()-1);
					while(Assentos.getVagaDesejada()<0 ||Assentos.getVagaDesejada()>45) {
						System.out.println("Vaga invalida, digite uma vaga existente : 1-46");
						Assentos.setVagaDesejada(tecladoNum.nextInt()-1);
					}
					
					//saida
					if(Assentos.checaVaga()) {
						System.out.println("Vaga reservada!");
						
					}else {
						System.out.println("Erro: Esta vaga já esta ocupada");
						System.out.println("Tente de novo");
					}
					
					break;
	
				case 2:
	
					System.out.println("Qual horario desejas?");
					System.out.println("1 - 6h  2 - 16h");
					
					Assentos.setHorario(tecladoNum.nextInt()-1);
					while(Assentos.getHorario()<0 || Assentos.getHorario()>1) {
						System.out.println("Horario invalido - Qual horario desejas?");
						System.out.println("1 - 6h  2 - 16h");
						Assentos.setHorario(tecladoNum.nextInt()-1);
					}
					Assentos.oni[Assentos.getHorario()].setRotaAtual(1);
					Assentos.saida();
					
					System.out.println("Qual desses assentos livres desejas?");
					Assentos.setVagaDesejada(tecladoNum.nextInt()-1);
					
					while(Assentos.getVagaDesejada()<0 ||Assentos.getVagaDesejada()>45) {
						System.out.println("Vaga invalida, digite uma vaga existente : 1-46");
						Assentos.setVagaDesejada(tecladoNum.nextInt()-1);
					}
					
					
					//saida
					if(Assentos.checaVaga()) {
						System.out.println("Vaga reservada!");
						
					}else {
						System.out.println("Erro: Esta vaga já esta ocupada");
						System.out.println("Tente de novo");
					}
					
					break;
	
				case 3:
	
					System.out.println("Qual horario desejas?");
					System.out.println("1 - 10  2 - 20h");
					Assentos.setHorario(tecladoNum.nextInt()-1);
					
					while(Assentos.getHorario()<0 || Assentos.getHorario()>1) {
						System.out.println("Horario invalido - Qual horario desejas?");
						System.out.println("1 - 6h  2 - 16h");
						Assentos.setHorario(tecladoNum.nextInt()-1);
					}
					Assentos.oni[Assentos.getHorario()].setRotaAtual(2);
					Assentos.saida();
					
					
					System.out.println("Qual desses assentos livres desejas?");
					Assentos.setVagaDesejada(tecladoNum.nextInt()-1);
					while(Assentos.getVagaDesejada()<0 ||Assentos.getVagaDesejada()>45) {
						System.out.println("Vaga invalida, digite uma vaga existente : 1-46");
						Assentos.setVagaDesejada(tecladoNum.nextInt()-1);
					}
					
					//saida
					if(Assentos.checaVaga()) {
						System.out.println("Vaga reservada!");
						
					}else {
						System.out.println("Erro: Esta vaga já esta ocupada");
						System.out.println("Tente de novo");
					}
	
				case 4:
	
					System.out.println("Voltando ao menu principal...");
					break;
	
				default:
	
					System.out.println("Opção Inválida");

			}// fim switch

		} // fim while
		opcaoSub = 0;
		
		
	}// fim subMenuReservarPassagem
	
	public static void subMenuLiberarReserva(){
		
		while (opcaoSub != 4) {
			
			// menu principal
			System.out.println("\n Selecione a opção desejada:");
			System.out.println("(Digite o número correspondente à opção)");
			System.out.println("1- Liberar acento referente a rota Porto Alegre -> Florianópolis  ");
			System.out.println("2- Liberar acento referente a rota  Porto Alegre -> Criciúma  ");
			System.out.println("3- Liberar acento referente a rota Criciúma -> Florianópolis ");
			System.out.println("4- Voltar ao menu principal");

			opcaoSub = tecladoNum.nextInt();
			
			switch (opcaoSub) {
			case 1:

				System.out.println("Referente a qual horario?");
				System.out.println("1 - 6h  2 - 16h");
				Assentos.setHorario(tecladoNum.nextInt()-1);
				
				while(Assentos.getHorario()<0 || Assentos.getHorario()>1) {
					System.out.println("Horario invalido - Qual horario desejas?");
					System.out.println("1 - 6h  2 - 16h");
					Assentos.setHorario(tecladoNum.nextInt()-1);
				}
				Assentos.oni[Assentos.getHorario()].setRotaAtual(0);
				
				System.out.println("Qual assento desejas deseja liberar?");
				Assentos.setVagaDesejada(tecladoNum.nextInt()-1); //o -1 segue pois:  o array de assentos começa do 0, e achei melhor já passar com o numero correto que vou manipular
				
				while(Assentos.getVagaDesejada()<0 ||Assentos.getVagaDesejada()>45) {
					System.out.println("Vaga invalida, digite uma vaga existente : 1-46");
					Assentos.setVagaDesejada(tecladoNum.nextInt()-1);
				}
				
				//saida
				if(Assentos.liberaVaga()==1) {
					System.out.println("Esta vaga não esta ocupada nesse horario e percuso, logo não pode ser liberada");
				}else if (Assentos.liberaVaga()==2){
					System.out.println("Impossivel liberar essa vaga dado o percurso(vaga pertence a um percuso maior)");
				}else{
					System.out.println("Vaga liberada!");
				}
				break;
				
			case 2:
				
				System.out.println("Referente a qual horario?");
				System.out.println("1 - 6h  2 - 16h");
				Assentos.setHorario(tecladoNum.nextInt()-1);
				
				while(Assentos.getHorario()<0 || Assentos.getHorario()>1) {
					System.out.println("Horario invalido - Qual horario desejas?");
					System.out.println("1 - 6h  2 - 16h");
					Assentos.setHorario(tecladoNum.nextInt()-1);
				}
				Assentos.oni[Assentos.getHorario()].setRotaAtual(1);
				
				System.out.println("Qual assento desejas deseja liberar?");
				Assentos.setVagaDesejada(tecladoNum.nextInt()-1);
				
				while(Assentos.getVagaDesejada()<0 ||Assentos.getVagaDesejada()>45) {
					System.out.println("Vaga invalida, digite uma vaga existente : 1-46");
					Assentos.setVagaDesejada(tecladoNum.nextInt()-1);
				}
				
				//saida
				if(Assentos.liberaVaga()==1) {
					System.out.println("Esta vaga não esta ocupada nesse horario e percuso, logo não pode ser liberada");
				}else if (Assentos.liberaVaga()==2){
					System.out.println("Impossivel liberar essa vaga dado o percurso(vaga pertence a um percuso maior)");
				}else{
					System.out.println("Vaga liberada!");
				}
				break;

				
			case 3:
				
				System.out.println("Referente a qual horario?");
				System.out.println("1 - 10  2 - 20h");
				Assentos.setHorario(tecladoNum.nextInt()-1);
				
				while(Assentos.getHorario()<0 || Assentos.getHorario()>1) {
					System.out.println("Horario invalido - Qual horario desejas?");
					System.out.println("1 - 6h  2 - 16h");
					Assentos.setHorario(tecladoNum.nextInt()-1);
				}
				Assentos.oni[Assentos.getHorario()].setRotaAtual(2);
				
				System.out.println("Qual assento desejas deseja liberar?");
				Assentos.setVagaDesejada(tecladoNum.nextInt()-1);
				
				while(Assentos.getVagaDesejada()<0 ||Assentos.getVagaDesejada()>45) {
					System.out.println("Vaga invalida, digite uma vaga existente : 1-46");
					Assentos.setVagaDesejada(tecladoNum.nextInt()-1);
				}
				
				//saida
				if(Assentos.liberaVaga()==1) {
					System.out.println("Esta vaga não esta ocupada nesse horario e percuso, logo não pode ser liberada");
				}else if (Assentos.liberaVaga()==2){
					System.out.println("Impossivel liberar essa vaga dado o percurso o percurso e horario");
				}else if(Assentos.liberaVaga()==3) {
					System.out.println("Vaga liberada!");
				}
				break;

				
			case 4:

				System.out.println("Voltando ao menu principal...");
				break;

			default:

				System.out.println("Opção Inválida");

			}// fim switch

		} // fim while
		
		opcaoSub = 0;
	        
	}// fim subMenuLiberarReserva()	

	public static void subMenuEncontrarAssentosLivres(){
		

		while (opcaoSub != 4) {
			
			System.out.println("\n Selecione a opção desejada:");
			System.out.println("(Digite a rota de passagem desejada:)");
			System.out.println("1- Uma passagem para a rota Porto Alegre -> Florianópolis ");
			System.out.println("2- Uma passagem para a rota Porto Alegre -> Criciúma ");
			System.out.println("3- Uma passagem para a rota Criciúma -> Florianópolis");
			System.out.println("4- Voltar ao menu principal");

			opcaoSub = tecladoNum.nextInt();
		
			switch (opcaoSub) {
				case 1:
	
					System.out.println("Qual horario desejas?");
					System.out.println("1 - 6h  2 - 16h");
					Assentos.setHorario(tecladoNum.nextInt()-1);
					
					while(Assentos.getHorario()<0 || Assentos.getHorario()>1) {
						Assentos.setHorario(tecladoNum.nextInt()-1);
					}
					Assentos.oni[Assentos.getHorario()].setRotaAtual(0);
	
					
					System.out.println("Quantos assentos deseja?");
					Assentos.setQuantidade(tecladoNum.nextInt());
					while(Assentos.getQuantidade()<1 ||Assentos.getQuantidade()>45) {
						System.out.println("Quantidade invalida, digite uma quantidade existente : 1-46");
						Assentos.setQuantidade(tecladoNum.nextInt());
					}
					
					Assentos.verificaVagas();
					break;
	
				case 2:
	
					System.out.println("Qual horario desejas?");
					System.out.println("1 - 6h  2 - 16h");
					Assentos.setHorario(tecladoNum.nextInt()-1);
					
					while(Assentos.getHorario()<0 || Assentos.getHorario()>1) {
						Assentos.setHorario(tecladoNum.nextInt()-1);
					}
					Assentos.oni[Assentos.getHorario()].setRotaAtual(1);
					
					System.out.println("Quantos assentos deseja?");
					Assentos.setQuantidade(tecladoNum.nextInt());
					
					while(Assentos.getQuantidade()<1 ||Assentos.getQuantidade()>45) {
						System.out.println("Quantidade invalida, digite uma quantidade existente : 1-46");
						Assentos.setQuantidade(tecladoNum.nextInt());
					}
					
					Assentos.verificaVagas();
					break;
	
				case 3:
	
					System.out.println("Qual horario desejas?");
					System.out.println("1 - 10  2 - 20h");
					Assentos.setHorario(tecladoNum.nextInt()-1);
					
					while(Assentos.getHorario()<0 || Assentos.getHorario()>1) {
						Assentos.setHorario(tecladoNum.nextInt()-1);
					}
					Assentos.oni[Assentos.getHorario()].setRotaAtual(2);
	
					
					System.out.println("Quantos assentos deseja?");
					Assentos.setQuantidade(tecladoNum.nextInt());
					
					while(Assentos.getQuantidade()<1 ||Assentos.getQuantidade()>45) {
						System.out.println("Quantidade invalida, digite uma quantidade existente : 1-46");
						Assentos.setQuantidade(tecladoNum.nextInt());
					}
					
					Assentos.verificaVagas();
					break;
	
				case 4:
	
					System.out.println("Voltando ao menu principal...");
					break;
	
				default:
	
					System.out.println("Opção Inválida");

			}// fim switch
			
		} // fim while
		
		opcaoSub = 0;
        
	        
	}// fim subMenuEncontrarAssentosLivres()

	public static void  subMenuRelatorios(){

		while (opcaoSub != 4) {
			
		
			System.out.println("\n Selecione a opção desejada:");
			System.out.println("(Digite a rota desejada para obter os dados:)");
			System.out.println("1- rota Porto Alegre -> Florianópolis ");
			System.out.println("2- rota Porto Alegre -> Criciúma ");
			System.out.println("3- rota Criciúma -> Florianópolis");
			System.out.println("4- Voltar ao menu principal");

			opcaoSub = tecladoNum.nextInt();
			

			switch (opcaoSub) {
			case 1:

				
				
				Assentos.oni[0].setRotaAtual(0);
				Assentos.oni[1].setRotaAtual(0);
				Assentos.estatisticas();
				break;

			case 2:
				
				Assentos.oni[0].setRotaAtual(1);
				Assentos.oni[1].setRotaAtual(1);
				Assentos.estatisticas();
				break;
				
			case 3:

				Assentos.oni[0].setRotaAtual(2);
				Assentos.oni[1].setRotaAtual(2);
				Assentos.estatisticas();
				break;
				
			case 4:

				System.out.println("Voltando ao menu principal...");
				break;

			default:

				System.out.println("Opção Inválida");

			}// fim switch
		} // fim while
		opcaoSub = 0;
	        
	}// fim subMenuRelatorios

}//fim App
