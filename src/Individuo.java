import java.util.ArrayList;
import java.util.List;

public class Individuo implements Cloneable {
	private float valor;
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

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}
	
	public Object clone() {
        try {
            // call clone in Object.
            return super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("Cloning not allowed.");
            return this;
        }
    }
	
	
}
