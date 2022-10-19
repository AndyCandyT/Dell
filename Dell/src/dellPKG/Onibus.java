package dellPKG;


public class Onibus {
	
	//variaveis
	private int idSaida; //saida0 e saida1 
	private int[] assento = new int[46];// 0 - livre toda a rota | 1 - Ocupado rota 1 | 2- Ocupado rota 2 | 3-Oupado todas as rotas | 4 - ocupado rota 1 + rota 2 separadamente
	private int rotaAtual; // 0 - rota total  | 1 - rota 1 | 2 - rota 
	
   
	
	public int getRotaAtual() {
		return rotaAtual;
	}

	public void setRotaAtual(int rotaAtual) {
		this.rotaAtual = rotaAtual;
	}	
	
	
	public Onibus(int idSaida, int[] assento, int rotaAtual) {
		super();
		this.idSaida = idSaida;
		this.assento = assento;
		this.rotaAtual = rotaAtual;
	}

	public String editaSaida() {
		String status="";
		int num =0;
		String frase="";
		String fraseAtual="";

		switch (rotaAtual) {

			case 0:
	
				for(int i=0;i<46;i++){
					num=i+1;
	
					if(assento[i]==0) {
						status= "Livre  ";
					}else {
						status= "Ocupado";
					}
	
	
					if((i+1)%4==0) {
						if(i>8) {
							fraseAtual="Assento "+num +": "+status+" | \n";
						}else {
							fraseAtual="Assento "+num +": "+status+"  | \n";
						}
	
					}else if((i+1)%2==0) {
	
						if(i>8) {
							fraseAtual="Assento "+num +": "+status+" || ";
						}else {
							fraseAtual="Assento "+num +": "+status+"  || ";
						}
	
					}else {
						if(i>8) {
							fraseAtual="Assento "+num +": "+status+" | ";
						}else {
							fraseAtual="Assento "+num +": "+status+"  | ";
						}
	
					}
					//atualiza variaveis
					num++;
					frase+=fraseAtual;
				}
	
				break;
	
			case 1:
	
				for(int i=0;i<46;i++){
	
					num=i+1;
	
					if(assento[i]==0 || assento[i]==2) {
						status= "Livre  ";
					}else {
						status= "Ocupado";
					}
	
	
					if((i+1)%4==0) {
						if(i>8) {
							fraseAtual="Assento "+num +": "+status+" | \n";
						}else {
							fraseAtual="Assento "+num +": "+status+"  | \n";
						}
	
					}else if((i+1)%2==0) {
	
						if(i>8) {
							fraseAtual="Assento "+num +": "+status+" || ";
						}else {
							fraseAtual="Assento "+num +": "+status+"  || ";
						}
	
					}else {
						if(i>8) {
							fraseAtual="Assento "+num +": "+status+" | ";
						}else {
							fraseAtual="Assento "+num +": "+status+"  | ";
						}
	
					}
					//atualiza variaveis
					num++;
					frase+=fraseAtual;
				}//fim for
				break;
	
			case 2:
	
				for(int i=0;i<46;i++){
	
					num=i+1;
	
					if(assento[i]==0 || assento[i]==1) {
						status= "Livre  ";
					}else {
						status= "Ocupado";
					}
	
					if((i+1)%4==0) {
						if(i>8) {
							fraseAtual="Assento "+num +": "+status+" | \n";
						}else {
							fraseAtual="Assento "+num +": "+status+"  | \n";
						}
	
					}else if((i+1)%2==0) {
	
						if(i>8) {
							fraseAtual="Assento "+num +": "+status+" || ";
						}else {
							fraseAtual="Assento "+num +": "+status+"  || ";
						}
	
					}else {
						if(i>8) {
							fraseAtual="Assento "+num +": "+status+" | ";
						}else {
							fraseAtual="Assento "+num +": "+status+"  | ";
						}
	
					}
					//atualiza variaveis
					num++;
					frase+=fraseAtual;
				}//fim for	
				break;
			
			default:
	
				System.out.println("Opção inválida");
	
		}// fim switcH

		return frase;
		
	}//fim classe

	@Override
	public String toString() {
	
		String id="";
		
		if(idSaida==0) {
			id="Primeiro";
		}else {
			id="Segundo";
		}
		
		
		return "\n Onibus do "+ id +" Horario" +"\n"+editaSaida();
	}//fim return
	
	
}
	