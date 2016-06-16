import java.util.List;

public class Principal {
	public static void main(String[] args){
		systemm.
	}
	private Individuo geraGanhador(Individuo primeiro, Individuo segundo){
		Individuo individuoGanhador = geraMercado();
		if (individuoGanhador.equals(primeiro))
			System.out.println("Individuo primeiro ganhador");
		if (individuoGanhador.equals(segundo))
			System.out.println("Individuo segundo ganhador");
		return individuoGanhador;
		
	}
	private Individuo geraMercado(){
		Individuo individuo = null;
		individuo.addCromossomo("ABCDC");
		List<String> cromossomo=null;
		cromossomo.add("E");
		individuo.setCromossomo(cromossomo);
		individuo.setValor(15);
		return individuo;
		
	}
}
