import java.util.ArrayList;
import java.util.List;

public class Individuo {
	private Integer valor;
	private List<String> cromossomo;
	
	public Individuo(){
		cromossomo = new ArrayList<String>();
	}
	
	public List<String> getCromossomo(){
		return cromossomo;
	}
	
	public void setCromossomo(List<String> cromossomo){
		this.cromossomo = cromossomo;
	}
	
	public void addCromossomo(String c){
		cromossomo.add(c);
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}
	
	
	
}
