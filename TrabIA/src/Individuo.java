import java.util.ArrayList;
import java.util.List;

public class Individuo {
	private int valor;
	private List<String> cromossomo;
	
	public Individuo(){
		cromossomo = new ArrayList<String>();
	}
	
	public int getValor(){
		return valor;
	}
	
	public List<String> getCromossomo(){
		return cromossomo;
	}
	
	public void setValor(int valor){
		this.valor = valor;
	}
	
	public void setCromossomo(List<String> cromossomo){
		this.cromossomo = cromossomo;
	}
	
	public void addCromossomo(String c){
		cromossomo.add(c);
	}
	
}
