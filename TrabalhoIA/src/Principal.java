
public class Principal {



	private static int GASTOS = 6;
    private static int NUMERO_POPULACAO = 15;
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		boolean mostrarEvolucao = true; //usado para imprimir a evoluçao, caso false lista apenas o melhor caminho.
		float taxaSobrevivencia = (float) 0.5;
		int numeroEvolucoes = 60;
		
		// matriz de adjacencia
		int[][] mapa = { { 0, 20, 25, 30, 13, 12 },
						 { 20, 0, 16, 37, 18,  9 },
						 { 25, 16, 0, 29, 14, 16 },
						 { 30, 37, 29, 0,  3,  1 },
						 { 13, 18, 14,  3, 0, 62 },
						 { 12,  9, 16,  1, 62, 0 } };
                //lista de GASTOS a serem percorridas, ordenada, mutada
		String[] NOME_GASTOS = { "Marketing   ", "Funcionário ", "Localização ", "MateriaPrima", "GastosFixos ", "OutrosGastos" };
                
		int[][] cromossomos = new int[NUMERO_POPULACAO][GASTOS];
		int[] resultados = new int[NUMERO_POPULACAO];
                //metodos de manipulacao dos cromossomos
		
		Genetico.gerarCromossomosAleatoriamente(cromossomos);
		Genetico.calcularResultado(cromossomos, resultados, mapa);
		Genetico.ordenar(cromossomos, resultados);
		if (mostrarEvolucao)
			Genetico.imprimir(cromossomos, resultados, NOME_GASTOS);

		int i;
		for (i = 0; i < numeroEvolucoes; i++) {
			Genetico.renovarCromossomos(cromossomos, resultados, taxaSobrevivencia);
			Genetico.calcularResultado(cromossomos, resultados, mapa);
			Genetico.ordenar(cromossomos, resultados);
			if (mostrarEvolucao) {
				System.out.println("Geracao: " + (i + 1));
				Genetico.imprimir(cromossomos, resultados, NOME_GASTOS);
			}
		}
		// mostrando resultado encontrado
		Genetico.resultado(cromossomos, resultados, NOME_GASTOS);

		
	}

	public static int getGASTOS() {
		return GASTOS;
	}

	public static int getNUMERO_POPULACAO() {
		return NUMERO_POPULACAO;
	}

	
	
}
