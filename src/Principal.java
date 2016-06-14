import java.util.List;

public class Principal {
	public static void main(String[] args){
		Empresa empresaA = new Empresa();
		Empresa empresaB = new Empresa();
		empresaA.setCapital(10000);
		empresaA.setEstMateriaPrima(10000);
		empresaA.setPercentuallucro(80);
		empresaA.setEstProduto(0);
		empresaA.setPreco(10);
		empresaB.setCapital(10000);
		empresaB.setEstMateriaPrima(10000);
		empresaB.setPercentuallucro(80);
		empresaB.setEstProduto(0);
		empresaB.setPreco(10);
		Genetico geneticoA =  new Genetico();
		geneticoA.inicializar(empresaA);
		Genetico geneticoB =  new Genetico();
		geneticoB.inicializar(empresaB);
		
		
	}
	private void verificaGanhador(Individuo primeiro, Individuo segundo){
		if (primeiro.getValor()> segundo.getValor())
			System.out.println("Individuo primeiro ganhadorcom R$ "+primeiro.getValor());
		if (segundo.getValor()> primeiro.getValor())
			System.out.println("Individuo segundo ganhador com R$ "+segundo.getValor());
		if (segundo.getValor() == primeiro.getValor())
			System.out.println("empate técnico com R$ "+segundo.getValor());
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
