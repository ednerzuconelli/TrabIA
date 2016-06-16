import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Timer;

public class Genetico {

	
	private List<Individuo> populacao;
	
	public Genetico(){
		populacao = new ArrayList<Individuo>();
	}
	
	public void inicializarRandom(Empresa empresa){
		
		
		for(int i=0;i<25;i++){
			
		  List<String> cromossomo = new ArrayList<String>();
		  Individuo individuo = new Individuo();
		  
		  for(int j=0;j<=4;j++){
			  Random rn = new Random();
			  switch(rn.nextInt(3)){
			  	case 0:
			  		cromossomo.add("A");
			  		break;
			  	case 1:	
			  		cromossomo.add("B");
			  		break;
			  	case 2:	
			  		cromossomo.add("C");
			  		break;	
			  	case 3:
			  		cromossomo.add("D");
			  		break;
			  }
		  }
		  
		  individuo.setCromossomo(cromossomo);
		  
		  if (atendeRestricao(individuo, empresa)&&!populacao.contains(individuo)){
			  populacao.add(individuo);
			  empresa.addHistorico(individuo);
		    //System.out.println(individuo.getCromossomo());
		  }  
		}
		
		
			
	
		
		
	}
	
	
	public void inicializar(Empresa empresa){
		
		List<String> cromossomo = Arrays.asList("A","B","C","D","A") ;
		for(int i=0;i<100;i++){
		  Collections.shuffle(cromossomo);
		  Individuo individuo = new Individuo();
		  individuo.setCromossomo(cromossomo);
		  Random rn = new Random();
		  int range = 300 - 10 + 1;
		  int randomNum =  rn.nextInt(range) + 10;
		  individuo.setValor(randomNum);
		  if (atendeRestricao(individuo, empresa)){
		    populacao.add(individuo);
		    //System.out.println(individuo.getCromossomo());
		  }  
		}
		
		
		
		
	}
	
	private Individuo verificaMelhor(List<Individuo> populacao, Empresa empresa){
		return empresa.selecionaMelhor(populacao);
	}
	
	

	private boolean atendeRestricao(Individuo individuo, Empresa empresa){
		boolean valido = false;
		Converter converter = new Converter();
		if (empresa.atendeRestricao(converter.Converter(individuo.getCromossomo().get(0), 0), 
				converter.Converter(individuo.getCromossomo().get(1), 1),
				converter.Converter(individuo.getCromossomo().get(2), 2), 
				converter.Converter(individuo.getCromossomo().get(3), 3), 
				converter.Converter(individuo.getCromossomo().get(4), 4))){	
		  valido = true;
		
		individuo.setValor(empresa.simulaReceita(converter.Converter(individuo.getCromossomo().get(0), 0), 
				converter.Converter(individuo.getCromossomo().get(1), 1),
				converter.Converter(individuo.getCromossomo().get(2), 2), 
				converter.Converter(individuo.getCromossomo().get(3), 3), 
				converter.Converter(individuo.getCromossomo().get(4), 4)));
		}
		return valido;
	}

	public void escolheEstrategiaAleatoria(Empresa empresa) {
		
		Random rand = new Random(System.currentTimeMillis()%1000);
		Converter converter = new Converter();
		Individuo individuo = new Individuo();
		individuo = empresa.getHistoricoEstrategia().get(rand.nextInt(empresa.getHistoricoEstrategia().size()-1));
		
		empresa.setQuantidadeProduzir(converter.Converter(individuo.getCromossomo().get(0),0));
		empresa.setFuncionario(converter.Converter(individuo.getCromossomo().get(1),1));
		empresa.setCustoMarketing(converter.Converter(individuo.getCromossomo().get(2),2));
		empresa.setCompraInsumo(converter.Converter(individuo.getCromossomo().get(3),3));
		empresa.setPercentuallucro(converter.Converter(individuo.getCromossomo().get(4),4));
		
		
		
	}
	
public void escolheEstrategiaMelhor(Empresa empresa) {
		
		
		Converter converter = new Converter();
		Individuo individuo = empresa.selecionaMelhor(empresa.getHistoricoEstrategia());
		
		
		empresa.setQuantidadeProduzir(converter.Converter(individuo.getCromossomo().get(0),0));
		empresa.setFuncionario(converter.Converter(individuo.getCromossomo().get(1),1));
		empresa.setCustoMarketing(converter.Converter(individuo.getCromossomo().get(2),2));
		empresa.setCompraInsumo(converter.Converter(individuo.getCromossomo().get(3),3));
		empresa.setPercentuallucro(converter.Converter(individuo.getCromossomo().get(4),4));
		
		
		
	}
}
