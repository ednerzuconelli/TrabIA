import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Principal {

	private static int NUMERO_CIDADES = 9;
    private static int NUMERO_POPULACAO = 1000;
	
    
	public static void main(String[] args) {
		String[] cidades = null;
		try {
			   FileReader arq = new FileReader("D:/git/trabalhoIA/att48.txt");
		       BufferedReader lerArq = new BufferedReader(arq);
		       NUMERO_POPULACAO = Integer.parseInt(lerArq.readLine()); // lê a primeira linha;
		       NUMERO_CIDADES = NUMERO_POPULACAO; 
		       String linha = lerArq.readLine();
		       cidades = new String[NUMERO_CIDADES];
		       int cont = 0;
		       while (linha != null) {
		    	   cidades[cont] = linha.substring(0, 2).trim();
		           
		    	   System.out.printf("%s\n", cidades[cont]);
		           cont++;
		           linha = lerArq.readLine(); // lê da segunda até a última linha
		         }
		       
		       arq.close();
			} catch (IOException e) {
		        System.err.printf("Erro na abertura do arquivo.\n",
		        e.getMessage());
		    } 
		
		boolean mostrarEvolucao = false; //usado para imprimir a evoluçao, caso false lista apenas o melhor caminho.
		float taxaSobrevivencia = (float) 0.5;
		int numeroEvolucoes = 60;
		
		// matriz de adjacencia
		int[][] mapa = { { 0, 42, 61, 30, 17, 82, 31, 11, 27 },
				{ 42, 0, 14, 87, 28, 70, 19, 33, 13 },
				{ 61, 14, 0, 20, 81, 21, 8, 29, 15 },
				{ 30, 87, 20, 0, 34, 33, 91, 10, 20 },
				{ 17, 28, 81, 34, 0, 41, 34, 82, 22 },
				{ 82, 70, 21, 33, 41, 0, 19, 32, 27 },
				{ 31, 19, 8, 91, 34, 19, 0, 59, 30 },
				{ 11, 33, 29, 10, 82, 32, 59, 0, 32 }, 
                                { 27, 13, 15, 20, 22, 27, 30, 32, 0} };
                //lista de cidades a serem percorridas, ordenada, mutada
		//String[] cidades = { "A", "B", "C", "D", "E", "F", "G", "H", "I" };
                
		int[][] cromossomos = new int[NUMERO_POPULACAO][NUMERO_CIDADES];
		int[] resultados = new int[NUMERO_POPULACAO];
                //metodos de manipulacao dos cromossomos
		
		Genetico.gerarCromossomosAleatoriamente(cromossomos);
		Genetico.calcularResultado(cromossomos, resultados, mapa);
		Genetico.ordenar(cromossomos, resultados);
		if (mostrarEvolucao)
			Genetico.imprimir(cromossomos, resultados, cidades);

		int i;
		for (i = 0; i < numeroEvolucoes; i++) {
			Genetico.renovarCromossomos(cromossomos, resultados, taxaSobrevivencia);
			Genetico.calcularResultado(cromossomos, resultados, mapa);
			Genetico.ordenar(cromossomos, resultados);
			if (mostrarEvolucao) {
				System.out.println("Geracao: " + (i + 1));
				Genetico.imprimir(cromossomos, resultados, cidades);
			}
		}
		// mostrando resultado encontrado
		Genetico.resultado(cromossomos, resultados, cidades);

		
	}

	public static int getNUMERO_CIDADES() {
		return NUMERO_CIDADES;
	}

	public static int getNUMERO_POPULACAO() {
		return NUMERO_POPULACAO;
	}

	
}
