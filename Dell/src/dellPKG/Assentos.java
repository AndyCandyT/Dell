package dellPKG;


public class Assentos {
	
	public static Onibus[] oni = new Onibus[2];
	
	protected static int saida0[] = new int[46];
	protected static int saida1[] = new int[46];
	
	private static int horario;
	private static int vagaDesejada;
	private static int quantidade;
	
	
	public static int getHorario() {
		return horario;
	}
	public static void setHorario(int horario) {
		Assentos.horario = horario;
	}
	public static int getVagaDesejada() {
		return vagaDesejada;
	}
	public static void setVagaDesejada(int vagaDesejada) {
		Assentos.vagaDesejada = vagaDesejada;
	}
	public static int getQuantidade() {
		return quantidade;
	}
	public static void setQuantidade(int quantidade) {
		Assentos.quantidade = quantidade;
	}
	

	
	//essa classe cria as 2 saidas de onibus, o saida[0] para o primeiro horario e a saida[1] para o segundo
	public static void criaSaidas(){
	
		for(int i = 0;i<46; i++  ) {
			
				saida0[i]=0;
				saida1[i]=0;
		}
		
		oni[0] = new Onibus(0,saida0,-1);
		oni[1] = new Onibus(1,saida1,-1);
		
		
	}
	
	public static void saida(){
		
		System.out.println(oni[horario]);
	
		
		
	}//fim saida
	
	//essa clase reserva 30% dos assentos
	public static void geraReservas(){
		
		for(int i = 0; i<46; i++  ) {
			if(i<7) {
				saida0[i]=3;
				saida1[i]=3;
			}else if(i<14){
				saida0[i]=1;
				saida1[i]=1;
			}else {
				saida0[i]=0;
				saida1[i]=0;
			}
			
		}
		
	}//fim atualizadas
	
	
	public static boolean checaVaga(){
		//retorna um boolean para ver se a vaga esta livre, já deixando-a reservada
		
		boolean livre = false;


		//se for a primeira saida do onibus 
		if(horario==0) {
			
			//o switch checa a rota que sera verificada
			switch(oni[0].getRotaAtual()) {
			case 0:
				
				if(saida0[vagaDesejada]==0) {
					livre=true;
					saida0[vagaDesejada]=3;
				}
				break;
				
			case 1:
				
				if(saida0[vagaDesejada]==0 ) {
					livre=true;
					saida0[vagaDesejada]=1;
				}else if(saida0[vagaDesejada]==2) {
					livre=true;
					saida0[vagaDesejada]=4;
				}
				break;
				
			case 2:
				
				if(saida0[vagaDesejada]==0) {
					livre=true;
					saida0[vagaDesejada]=2;
				}else if(saida0[vagaDesejada]==1) {
					livre=true;
					saida0[vagaDesejada]=4;
				}
				break;
				
			default:
				System.out.println("Erro");
			}	
			
		}else {//para a segunda saida do onibus
			
			//o switch checa a rota que sera verificada
			switch(oni[1].getRotaAtual()) {
			case 0:
				
				if(saida1[vagaDesejada]==0) {
					livre=true;
					saida1[vagaDesejada]=3;
				}
				break;
				
			case 1:
				
				if(saida1[vagaDesejada]==0 ) {
					livre=true;
					saida1[vagaDesejada]=1;
				}else if(saida1[vagaDesejada]==2 ) {
					livre=true;
					saida1[vagaDesejada]=4;
				}

				break;
				
			case 2:
				
				if(saida1[vagaDesejada]==0 ) {
					livre=true;
					saida1[vagaDesejada]=2;
				}else if(saida1[vagaDesejada]==1 ) {
					livre=true;
					saida1[vagaDesejada]=4;
				}
				break;
				
			default:
				System.out.println("Erro");
			}	

		}
		return livre;
	}//fim classe checa vaga
	
	public static int liberaVaga(){
		//retorna um int para ver se a vaga esta de fato liberada, e se pode ser liberada;
		
		int liberada = 0; //1 - vaga já esta liberada | 2-vaga não pode ser liberada pois faz parte de um trajeto maior | 3-vaga liberada!


		//se for a primeira saida do onibus 
		if(horario==0) {
			
			//o switch checa a rota que sera verificada
			switch(oni[0].getRotaAtual()) {
			case 0:
				
				if(saida0[vagaDesejada]==0) {
					
					liberada=1;
					
				}else if(saida0[vagaDesejada]==3 ) {
					
					liberada=3;
					saida0[vagaDesejada]=0;
					
				}
				else {
					
					liberada=2;
					
				}
				break;
				
			case 1:
				
				if(saida0[vagaDesejada]==1) {
					
					liberada=3;
					saida0[vagaDesejada]=0;
					
				}else if(saida0[vagaDesejada]==3) {
					
					liberada=2;
					
				}else if(saida0[vagaDesejada]==4 ) {
					
					liberada=3;
					saida0[vagaDesejada]=2;
					
				}else {
					
					liberada=1;
				}
				break;
				
			case 2:
				
				if(saida0[vagaDesejada]==2) {
					
					liberada=3;
					saida0[vagaDesejada]=0;
					
				}else if(saida0[vagaDesejada]==3) {
					
					liberada=2;
					
				}else if(saida0[vagaDesejada]==4) {
					
					liberada=3;
					saida0[vagaDesejada]=1;
					
				}else {
					
					liberada=1;
				}
				break;
				
			default:
				System.out.println("Erro");
			}	
			
		}else {//para a segunda saida do onibus
			
			//o switch checa a rota que sera verificada
			switch(oni[1].getRotaAtual()) {
			case 0:
				
				if(saida1[vagaDesejada]==0) {
					
					liberada=1;
					
				}else if(saida1[vagaDesejada]==3 ) {
					
					liberada=3;
					saida1[vagaDesejada]=0;
					
				}else {
					
					liberada=2;
					
				}
				break;
				
			case 1:
				
				if(saida1[vagaDesejada]==1) {
					
					liberada=3;
					saida0[vagaDesejada]=0;
					
				}else if(saida1[vagaDesejada]==3) {
					
					liberada=2;
					
				}else if(saida1[vagaDesejada]==4) {
					
					liberada=3;
					saida1[vagaDesejada]=2;
					
				}else {
					
					liberada=1;
				}
				break;
				
			case 2:
				
				if(saida1[vagaDesejada]==2) {
					
					liberada=3;
					saida1[vagaDesejada]=0;
					
				}else if(saida1[vagaDesejada]==3) {
					
					liberada=2;
				}else if(saida1[vagaDesejada]==4) {
					
					liberada=3;
					saida1[vagaDesejada]=1;
					
				}else {
					liberada=1;
				}
				break;
				
			default:
				System.out.println("Erro");
			}	

		}
		return liberada;
	}//fim classe libera
	
	public static void  verificaVagas() {
		
		int cont0=0;
		int cont1=0;
		
		int ini0=0;
		int ini1=0;
		
		int fim0=0;
		int fim1=0;
		
		int i=0;
		
		int resultado = 0;
		String vagas="";
		String aux="";
		
		int rota = oni[horario].getRotaAtual();
		
		switch(rota) {
		
			//verifica se possui, e quais são as vagas livres nessa quantidade
			case 0:
				while(i<46) {
					if(saida0[i]==0) {
						
						cont0++;
						
						if(cont0==1) {
							
							ini0=i;
							
						}else if(cont0==quantidade) {
							
							fim0=i;
							if((fim0-ini0)==(quantidade-1)) {
								break;
							}else {
								i=ini0;
								
								ini0=0;
								fim0=0;
								cont0=0;
							}
							
						}	
					}
					i++;
				}
				i=0;
				
				while(i<46) {
					if(saida1[i]==0) {
						
						cont1++;
						
						if(cont1==1) {
							ini1=i;
						}else if(cont1==quantidade) {
							fim1=i;
							if((fim1-ini1)==(quantidade-1)) {
								break;
							}else {
								
								i=ini1;
								ini1=0;
								fim1=0;
								cont1=0;
							}
						}
					}
					i++;
				}//fim while
				i=0;
				
				//preenche as vagas
				if(horario==0) {
					if(cont0==quantidade) {
						for(int j= ini0; j<=fim0;j++) {
							saida0[i]=3;
							aux=(i+1)+", ";
							vagas+=aux;
						}
						resultado=1;
					}else if(cont1==quantidade) {
						resultado=2;
					}
					
				}else {
					if(cont1==quantidade) {
						
						for(int j= ini1; j<=fim1;j++) {
							saida1[j]=3;
							aux=(j+1)+", ";
							vagas+=aux;
						}
						
					}else if(cont0==quantidade) {
						
						resultado=2;
						
					}
				}
				
				
				break;
				
			case 1:
				//verifica se possui, e quais são as vagas livres nessa quantidade
				
				while(i<46) {
					if(saida0[i]==0 || saida0[i]==2) {
						
						cont0++;
						
						if(cont0==1) {
							
							ini0=i;
							
						}else if(cont0==quantidade) {
							
							fim0=i;
							if((fim0-ini0)==(quantidade-1)) {
								break;
							}else {
								i=ini0;
								
								ini0=0;
								fim0=0;
								cont0=0;
							}
							
						}	
					}
					i++;
				}
				i=0;
				
				while(i<46) {
					if(saida1[i]==0 || saida1[i]==2) {
						
						cont1++;
						
						if(cont1==1) {
							ini1=i;
						}else if(cont1==quantidade) {
							fim1=i;
							if((fim1-ini1)==(quantidade-1)) {
								break;
							}else {
								
								i=ini1;
								ini1=0;
								fim1=0;
								cont1=0;
							}
						}
					}
					i++;
				}//fim while
				i=0;
				
				//preenche as vagas
				if(horario==0) {
					if(cont0==quantidade) {
						for(int j= ini0; j<=fim0;j++) {
							
							if(saida0[j]==0) {
								saida0[j]=1;
							}else {
								saida0[j]=4;
							}
							
							aux=(j+1)+", ";
							vagas+=aux;
						}
						resultado=1;
					}else if(cont1==quantidade) {
						resultado=2;
					}
					
				}else {
					if(cont1==quantidade) {
						for(int j= ini1; j<=fim1;j++) {
							
							if(saida1[j]==0) {
								saida1[j]=1;
							}else {
								saida1[j]=4;
							}
							
							aux=(j+1)+", ";
							vagas+=aux;
						}
						resultado=1;
					}else if(cont0==quantidade) {
						resultado=2;
					}
				}
				
				break;
				
			case 2:
				//verifica se possui, e quais são as vagas livres nessa quantidade
				
				while(i<46) {
					if(saida0[i]==0 || saida0[i]==1) {
						
						cont0++;
						
						if(cont0==1) {
							
							ini0=i;
							
						}else if(cont0==quantidade) {
							
							fim0=i;
							if((fim0-ini0)==(quantidade-1)) {
								break;
							}else {
								i=ini0;
								
								ini0=0;
								fim0=0;
								cont0=0;
							}
							
						}	
					}
					i++;
				}
				i=0;
				
				while(i<46) {
					if(saida1[i]==0 || saida1[i]==1) {
						
						cont1++;
						
						if(cont1==1) {
							ini1=i;
						}else if(cont1==quantidade) {
							fim1=i;
							if((fim1-ini1)==(quantidade-1)) {
								break;
							}else {
								
								i=ini1;
								ini1=0;
								fim1=0;
								cont1=0;
							}
						}
					}
					i++;
				}//fim while
				i=0;
				
				
				//preenche as vagas
				if(horario==0) {
					if(cont0==quantidade) {
						for(int j= ini0; j<=fim0;j++) {
							
							if(saida0[j]==0) {
								saida0[j]=2;
							}else {
								saida0[j]=4;
							}
							
							aux=(j+1)+", ";
							vagas+=aux;
						}
						resultado=1;
					}else if(cont1==quantidade) {
						resultado=2;
					}
					
				}else {
					if(cont1==quantidade) {
						for(int j= ini1; j<=fim1;j++) {
							
							if(saida1[j]==0) {
								saida1[j]=2;
							}else {
								saida1[j]=4;
							}
							
							aux=(j+1)+", ";
							vagas+=aux;
						}
						resultado=1;
					}else if(cont0==quantidade) {
						resultado=2;
					}
				}
				
			default:
		}//fim switch
		
		//saida
		if(resultado==1) {
			System.out.println("Existem vagas disponiveis!");
			System.out.println("Seus assentos são: "+vagas);
			
			
		}else if(resultado==2) {
			
			System.out.println("Não existem vagas livres nesse horario");
			System.out.println("Porem no outro horario deste onibus tem essa quantidade de vagas!");
			System.out.println("Se quiseres podes rodar outra vez o programa mudando o horario selecionado que dai poderemos reservar suas vagas!");
			
		}else {
			
			System.out.println("Não existem vagas livres nesse horario -  e infelizmente no outro horario tambem não");
		}
		
	}//fim metodo
	
	public static void  estatisticas() {
		
		int vagas=46;
		
		int contVagas=0;
		int contAcumulo=0;
		String numeros="";
		String dupla="";
		String aux="";
		
		int disponiveis=0;
		int acumulado=0;
		int dobradinha=0;
		
		int contVagasR=0;
		int acumuladoR=0;
		int disponiveisR=0;
		int dobradinhaR=0;
		
		
		//R equivale a reservas
		
		for(int i = 0; i<46; i++  ) {
			
			int tipo;
			
			if(oni[0].getRotaAtual()==0) {
				tipo=3;
			}else{
				tipo=oni[0].getRotaAtual();
			}
			
			
			
			if(saida0[i]==tipo) {
				
				contVagas++;
				aux=(i+1)+", ";
				numeros+=aux;
				
			}else if(saida0[i]==1) {
				
				if(tipo==3) {
					contAcumulo++;
				}
		
			}else if(saida0[i]==2) {
				
				if(tipo==3) {
					contAcumulo++;
				}
				
			}else if(saida0[i]==3) {
				
				contAcumulo++;
		
			}else if(saida0[i]==4){
				
				if(tipo==3) {
					
					contAcumulo+=2;

					aux=i+"";
					dupla+=aux;
					
					dobradinha++;
					
				}else{
					
					contVagas++;
					contAcumulo++;
					
					aux=(i+1)+", ";
					numeros+=aux;
					
					aux=i+"";
					dupla+=aux;
					
					dobradinha++;
					
				}
				
			}
			
		}//fim for
		
		acumulado=contAcumulo+contVagas;
		disponiveis=(vagas-acumulado)+dobradinha;
		
		System.out.println(oni[0]);
		System.out.println("");
		System.out.println("	*Numero de assentos totais: "+vagas);
		System.out.println("	*Numero de assentos disponiveis: "+disponiveis);
		System.out.println("	*Numero de assentos reservados especificamente para essa rota: "+contVagas);
		System.out.println("	*Numero dos assentos reservados especificamente para essa rota: "+numeros);
		System.out.println("	*Numero de assentos com 2 reservas (sendo uma de poa=>criciuma e outra de criciuma=>floripa): "+dobradinha+", Sendo estes os assentos de numero: "+dupla);
		System.out.println("	*Total acumulados em reserva: "+acumulado);
		
		
		//atribui em variaveis aux para exibir como dados acumulados no final
		acumuladoR=acumulado;
		disponiveisR=disponiveis;
		contVagasR=contVagas;
		dobradinhaR=dobradinha;
		
		
		//reseta variaveis
		acumulado=0;
		disponiveis=0;
		contVagas=0;
		contAcumulo=0;
		dobradinha=0;
		numeros="";
		dupla="";
		
		for(int i = 0; i<46; i++  ) {
			
			int tipo;
			
			if(oni[1].getRotaAtual()==0) {
				tipo=3;
			}else{
				tipo=oni[1].getRotaAtual();
			}
			
			
			
			if(saida1[i]==tipo) {
				
				contVagas++;
				aux=(i+1)+", ";
				numeros+=aux;
				
			}else if(saida1[i]==1) {
				
				if(tipo==3) {
					contAcumulo++;
				}
		
			}else if(saida1[i]==2) {
				
				if(tipo==3) {
					contAcumulo++;
				}
				
			}else if(saida1[i]==3) {
				
				contAcumulo++;
		
			}else if(saida1[i]==4){
				
				if(tipo==3) {
					
					contAcumulo+=2;

					aux=(i+1)+"";
					dupla+=aux;
					
					dobradinha++;
					
				}else{
					
					contVagas++;
					contAcumulo++;
					
					aux=(i+1)+", ";
					numeros+=aux;
					
					aux=(i+1)+"";
					dupla+=aux;
					
					dobradinha++;
					
				}
				
			}
			
		}//fim for
		
		acumulado=contAcumulo+contVagas;
		disponiveis=(vagas-acumulado)+dobradinha;
		
		
		System.out.println(oni[1]);
		System.out.println("");
		System.out.println("	*Numero de assentos totais: "+vagas);
		System.out.println("	*Numero de assentos disponiveis: "+disponiveis);
		System.out.println("	*Numero de assentos reservados especificamente para essa rota: "+contVagas);
		System.out.println("	*Numero dos assentos reservados especificamente para essa rota: "+numeros);
		System.out.println("	*Numero de assentos com 2 reservas (sendo uma de poa=>criciuma e outra de criciuma=>floripa): "+dobradinha+", Sendo estes os assentos de numero: "+dupla);
		System.out.println("	*Total acumulados em reserva: "+acumulado);
		
		
		acumuladoR+=acumulado;
		disponiveisR+=disponiveis;
		contVagasR+=contVagas;
		dobradinhaR+=dobradinha;
		
		System.out.println("\n Logo nas 2 rotas teremos: " );
		System.out.println("	*Numero de assentos totais: "+2*vagas);
		System.out.println("	*Numero de assentos disponiveis: "+disponiveisR);
		System.out.println("	*Numero de assentos reservados especificamente para essa rota: "+contVagasR);
		System.out.println("	*Numero de assentos com 2 reservas (sendo uma de poa=>criciuma e outra de criciuma=>floripa): "+dobradinhaR);
		System.out.println("	*Total acumulados em reserva: "+acumuladoR);
		
	}//fim metodo estatisticas
		
}//fim assentos
