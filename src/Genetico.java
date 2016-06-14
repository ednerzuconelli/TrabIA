import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Genetico {

	
	private List<Individuo> populacao;
	
	public Genetico(){
		populacao = new ArrayList<Individuo>();
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
		if (populacao.size()>0 ){
			System.out.println(verificaMelhor(populacao, empresa).getValor());
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
				converter.Converter(individuo.getCromossomo().get(4), 4)))	
		  valido = true;
		
		return valido;
	}
}
