import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Timer;

public class Genetico {

	
	private List<Individuo> populacao;
	private float taxaCrossover = (float) 0.6;
	private float taxaMutacao = (float) 0.03;
	
	public Genetico(){
		populacao = new ArrayList<Individuo>();
	}
	
	public void inicializarRandom(Empresa empresa){
		int i = 0;
		populacao.clear();
		
		while(i<=50){
			
		  List<String> cromossomo = new ArrayList<String>();
		  Individuo individuo = new Individuo();
		  
		  for(int j=0;j<=4;j++){
			  cromossomo.add(geneAleatorio());
		  }
		  
		  individuo.setCromossomo(cromossomo);
		  
		  if (atendeRestricao(individuo, empresa)&&!populacao.contains(individuo)){
			  populacao.add(individuo);
			  empresa.addHistorico(individuo);
			  i++;
		    //System.out.println(individuo.getCromossomo());
		  }  
		}
		
		
			
		
		
		
	}
	
	
	
	
	private List<Individuo> verificaMelhor(List<Individuo> populacao, Empresa empresa){
		Individuo ind1 = new Individuo();
		Individuo ind2 = new Individuo();
		
		ind1 = empresa.selecionaMelhor(populacao);
		populacao.remove(ind1);
		ind2 = empresa.selecionaMelhor(populacao);
		
		List<Individuo> list = new ArrayList<>();
		list.add(ind1);
		list.add(ind2);
		
		return list;
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

public void geraFilhos(Empresa empresa) {
	List<Individuo> novaPopulacao = new ArrayList<Individuo>();
	
	List<Individuo> pais = verificaMelhor(populacao, empresa);
	Random random = new Random();
	
	while(novaPopulacao.size()<20){
		List<Individuo> filhos = new ArrayList<Individuo>();
		
		if(random.nextFloat()<taxaCrossover){
			filhos = crossover(pais);
		}else{
			Individuo filho1 = pais.get(0);
			Individuo filho2 = pais.get(1);
			filhos.add(filho1);
			filhos.add(filho2);
		}
		
		
		
		for(Individuo f:filhos){
			if(atendeRestricao(f, empresa)){
				novaPopulacao.add(f);
			}
			
		}
		
	}
	
}

private List<Individuo> crossover(List<Individuo> pais) {
	
	
	
	List<Individuo> filhos = new ArrayList<Individuo>();
	
	List<String> cromossomo1 = new ArrayList<String>();
	List<String> cromossomo2 = new ArrayList<String>();
	
	for(int i=0;i<=pais.get(0).getCromossomo().size()/2;i++){
		cromossomo1.add(pais.get(1).getCromossomo().get(i));
		cromossomo2.add(pais.get(0).getCromossomo().get(i));
	}
	
	
	
	for(int i=pais.get(0).getCromossomo().size()/2;i<pais.get(0).getCromossomo().size()-1;i++){
		cromossomo1.add(pais.get(1).getCromossomo().get(i));
		cromossomo2.add(pais.get(0).getCromossomo().get(i));
	}
	
	
	Random rand = new Random();
	int gene=0;
	if(rand.nextFloat()<taxaMutacao){
		gene = rand.nextInt(cromossomo1.size()-1);
		cromossomo1.add(gene, geneAleatorio());
	}
	
	gene=0;
	if(rand.nextFloat()<taxaMutacao){
		gene = rand.nextInt(cromossomo2.size()-1);
		cromossomo2.add(gene, geneAleatorio());
	}
	
	Individuo ind1 = new Individuo();
	Individuo ind2 = new Individuo();
	ind1.setCromossomo(cromossomo1);
	ind2.setCromossomo(cromossomo2);
	filhos.add(ind1);
	filhos.add(ind2);
	
	return filhos;
}

	public String geneAleatorio(){
		Random rn = new Random();
		  switch(rn.nextInt(3)){
		  	case 0:
		  		return "A" ;
		  		
		  	case 1:	
		  		return "B";
		  		
		  	case 2:	
		  		return "C";
		  			
		  	case 3:
		  		return "D";
		  		
		  }
		return "A";
	}


}
