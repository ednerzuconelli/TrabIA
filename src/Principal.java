import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Principal {
	public static void main(String[] args){
		int estA=0,estB=0;
		int y = 0;
		System.out.println("Jogar contra Máquina? 1=sim ou 0=não");
		Scanner joga = new Scanner(System.in);
		y = joga.nextInt();
		Empresa empresaA = null;
		if (y==1) {
			System.out.println("Qual o valor de capital inicial?");
			Scanner valor = new Scanner(System.in);
			empresaA = new Empresa(valor.nextFloat());
		} else	empresaA = new Empresa((float) 25000.00);
		Empresa empresaB = new Empresa((float) 25000.00);
		
		
		
		int x = 0;
		while(x!=1 && x!=2 && x!=3){
			if (y==1) 
				System.out.println("Escolha sua Estratégia:");
			else System.out.println("Escolha a Estratégia da empresa A:");
			System.out.println("1: Olho Por Olho.");
			System.out.println("2: Retaliador Permanente.");
			System.out.println("3: Cooperador Incondicional.");
			
			
			Scanner scan = new Scanner(System.in);
			x = scan.nextInt();
			
			switch (x) {
			case 1:
				empresaA.setEstrategia(0);
				break;
			case 2:
				empresaA.setEstrategia(1);
				break;
			case 3:
				empresaA.setEstrategia(2);
				break;
			}
			
		}
		if (y==1){
		  Random ran = new Random(System.currentTimeMillis()%1000);
		  empresaB.setEstrategia(ran.nextInt(3));
		}  
		 else { 
			x = 0;
		
			while(x!=1 && x!=2 && x!=3){
				
				System.out.println("Escolha a Estratégia da empresa B:");
				System.out.println("1: Olho Por Olho.");
				System.out.println("2: Retaliador Permanente.");
				System.out.println("3: Cooperador Incondicional.");
				
				Scanner scan = new Scanner(System.in);
				x = scan.nextInt();
				
				switch (x) {
				case 1:
					empresaB.setEstrategia(0);
					break;
				case 2:
					empresaB.setEstrategia(1);
					break;
				case 3:
					empresaB.setEstrategia(2);
					break;	
				}
				
			}
		}
		Genetico genetico =  new Genetico();
		genetico.inicializarRandom(empresaA);
		genetico.inicializarRandom(empresaB);
		
		
		genetico.escolheEstrategiaAleatoria(empresaA);
		
		genetico.escolheEstrategiaAleatoria(empresaB);
		
		System.out.println("Rodada 1:");
		System.out.println("\nEmpresa A");
		empresaA.mostraEstrategia();
		empresaA.atualiza();
		System.out.println("\nEmpresa B");
		empresaB.mostraEstrategia();
		empresaB.atualiza();
		
		System.out.println("\nResultado:");
		defineDistribuicao(empresaA,empresaB);
		System.out.println("\nEmpresa A Vendeu: "+ empresaA.getQuantidadeVendida());
		empresaA.atualizaCapital();
		empresaA.mostrarResultado();
		
		System.out.println("\nEmpresa B Vendeu: "+ empresaB.getQuantidadeVendida());
		empresaB.atualizaCapital();
		empresaB.mostrarResultado();
		
		
		
		empresaA.setPrecoConcorrente(empresaB.getPreco());
		empresaB.setPrecoConcorrente(empresaA.getPreco());
	
		
		empresaA.setRodada(empresaA.getRodada()+1);
		empresaB.setRodada(empresaB.getRodada()+1);
		
		for(int i=2;i<101;i++){
			
			System.out.println("\n\nRodada "+i);
			System.out.println("\nEmpresa A");
			genetico.inicializarRandom(empresaA);
			if(genetico.geraFilhos(empresaA)){
				estA++;	
			}
			
			genetico.escolheEstrategiaMelhor(empresaA);
			empresaA.mostraEstrategia();
			empresaA.atualiza();
			
			
			
			
			System.out.println("\nEmpresa B");
			genetico.inicializarRandom(empresaB);
			
			if(genetico.geraFilhos(empresaB)){
				estB++;
			}
			genetico.escolheEstrategiaMelhor(empresaB);
			empresaB.mostraEstrategia();
			empresaB.atualiza();
			
			System.out.println("\nResultado:");
			defineDistribuicao(empresaA,empresaB);
			System.out.println("\nEmpresa A Vendeu: "+ empresaA.getQuantidadeVendida());
			empresaA.atualizaCapital();
			empresaA.mostrarResultado();
			System.out.println("\nEmpresa B Vendeu: "+ empresaB.getQuantidadeVendida());
			empresaB.atualizaCapital();
			empresaB.mostrarResultado();

			empresaA.setPrecoConcorrente(empresaB.getPreco());
			empresaB.setPrecoConcorrente(empresaA.getPreco());
			empresaA.setRodada(empresaA.getRodada()+1);
			empresaB.setRodada(empresaB.getRodada()+1);
			
		}
		
			estA = 99-estA; 
			System.out.println("\n\nEmpresa A seguiu a estratégia:"+estA+"%");
			
			estB = 99-estB; 
			System.out.println("\n\nEmpresa B seguiu a estratégia:"+estB+"%");
		
		
	}
	

	private static void defineDistribuicao(Empresa empresaA, Empresa empresaB){
		float fatorPrecoA = 0,fatorPrecoB = 0,fatorMarketingA = 0,fatorMarketingB = 0;
		float aceitacaoMarketing;
		float aceitacaoA,aceitacaoB;
		int mercado;
		
		if(empresaA.getPreco()>empresaB.getPreco()){
			fatorPrecoB=(float) 0.6;
			fatorPrecoA=(float) 0.4;
		}
		
		if(empresaA.getPreco()<empresaB.getPreco()){
			fatorPrecoB=(float) 0.4;
			fatorPrecoA=(float) 0.6;
		}
		
		if(empresaA.getPreco()==empresaB.getPreco()){
			fatorPrecoB=(float) 0.5;
			fatorPrecoA=(float) 0.5;
		}
		
		Random rand = new Random();
		aceitacaoMarketing = rand.nextFloat();
		
		aceitacaoA = aceitacaoMarketing * empresaA.getCustoMarketing();
		aceitacaoB = aceitacaoMarketing * empresaB.getCustoMarketing();
		
		if(aceitacaoA>aceitacaoB){
			fatorMarketingA=(float) 0.6;
			fatorMarketingB=(float) 0.4;
		}
		
		if(aceitacaoA<aceitacaoB){
			fatorMarketingA=(float) 0.4;
			fatorMarketingB=(float) 0.6;
		}
		
		if(aceitacaoA==aceitacaoB){
			fatorMarketingA=(float) 0.5;
			fatorMarketingB=(float) 0.5;
		}
		
		mercado = geraMercado();
		
		empresaA.setQuantidadeVendida((int) (mercado*((fatorPrecoA+fatorMarketingA)/2)));
		empresaB.setQuantidadeVendida((int) (mercado*((fatorPrecoB+fatorMarketingB)/2)));
		
	}
	
	private static int geraMercado(){
		Random rand = new Random(System.currentTimeMillis()%1000);
		return rand.nextInt(150);
		
	}
}
