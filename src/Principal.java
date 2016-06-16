import java.util.List;
import java.util.Random;

public class Principal {
	public static void main(String[] args){
		Empresa empresaA = new Empresa((float) 100000.00);
		Empresa empresaB = new Empresa((float) 100000.00);
		
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
		
		System.out.println("Resultado:");
		defineDistribuicao(empresaA,empresaB);
		System.out.println("Empresa A Vendeu: "+ empresaA.getQuantidadeVendida());
		System.out.println("Empresa B Vendeu: "+ empresaB.getQuantidadeVendida());
		
		
		
		
		
		
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
		Random rand = new Random(1000);
		return rand.nextInt(90000);
		
	}
}
