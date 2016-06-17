import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Empresa {
	private float capital;
	private int homemhora;
	private int estMateriaPrima;
	private int estProduto;
	private float preco;
	
	//Parametros
	private float custoMarketing;
	private int compraInsumo;
	private int quantidadeProduzir;
	private int quantidadeSolicitada;
	private int funcionario;
	private float percentuallucro;
	
	//custo
	private float custoInsumo;
	private float custoFuncionario;
	private float custoHomemHora;
	
	//Historico de Estrategia
	private List<Individuo> historicoEstrategia = new ArrayList<Individuo>();
	
	//Historico Vendido
	private int quantidadeVendida;
	
	public Empresa(float capital){
		this.setCapital(capital);
		this.setQuantidadeVendida(0);
		this.setEstMateriaPrima(0);
		this.setQuantidadeSolicitada(0);
	
	}
	
	//decisoes
	public void atualiza(){
		this.setHomemhora(8*this.getFuncionario());
		this.setEstMateriaPrima(this.getEstMateriaPrima()+this.getCompraInsumo());
		this.setEstProduto(this.getEstProduto()+this.getQuantidadeProduzir());
		this.setPreco((calculaCustoTotal()/this.getQuantidadeProduzir())*this.getPercentuallucro());
		this.setCapital(this.getCapital()-calculaCustoTotal());
		this.historicoEstrategia.clear();
	}
	
	public void atualizaCapital(){
		this.setCapital(this.getCapital()+this.getQuantidadeVendida()*this.getPreco());
	}

	
	public void mostrarResultado(){
		System.out.println("Quantidade que o mercado solicitou:"+this.getQuantidadeSolicitada());
		DecimalFormat df = new DecimalFormat("0.00");
		System.out.println("Custo Total: "+df.format(this.calculaCustoTotal()));
		System.out.println("Capital: "+ df.format(this.getCapital()));
	}
	
	//restricoes
	public boolean resQuantidadeProducao(int quantidadeProduzir, int estoqueMateriaPrima){
		if((quantidadeProduzir*3)<=estoqueMateriaPrima){
			return true;
		}else{
			return false;
		}
			
	}
	
	public boolean resMaoDeObra(int quatidadeProducao, int custoHomemHora){
		if ((quatidadeProducao* 2 <= custoHomemHora)){
			return true;
		} else 
			return false;
	}
	
	public boolean resCustoProducao(int custoInsumo, int custoFuncionario, int custoMarketing){
		if (custoInsumo + custoFuncionario + custoMarketing <= getCapital()){
			return true;
		} else return false;
	}
	
	public boolean atendeRestricao(int quantidadeProduzir, int funcionarios, 
			  int custoMarketing, int compraInsumo, int percetualLucro){
		int quaProduzir = quantidadeProduzir;
		int estoqueMateriaPrima = getEstMateriaPrima() + compraInsumo;
		int custoHomemHora = funcionarios * 8;
		int custoInsumo = compraInsumo * 2;
		int custoFuncionario = funcionarios *150;
		if ((resQuantidadeProducao(quaProduzir, estoqueMateriaPrima))
				&& (resMaoDeObra(quaProduzir , custoHomemHora))
				&& (resCustoProducao(custoInsumo, custoFuncionario, custoMarketing))){
			return true;
		} else return false;
			
	}
	
	public void aplicaEstrategia(){
		
	}
	
	public void mostraEstrategia(){
		System.out.println("Quantidade Produzir:" + this.getQuantidadeProduzir());
		System.out.println("Quantidade Funcion�rios:" + this.getFuncionario());
		System.out.println("Quantidade Marketing:" + this.getCustoMarketing());
		System.out.println("Quantidade Compra Insumo:" + this.getCompraInsumo());
		System.out.println("Quantidade Percentual Lucro:" + this.getPercentuallucro());
	}
	
	
	public float simulaReceita(int quantidadeProduzir, int funcionarios, int custoMarketing, int compraInsumo, int percetualLucro){
		float lucro = 0;
		float custoTotal=0;
		int custoInsumo = compraInsumo * 2;
		int custoFuncionario = funcionarios *150;
		
		custoTotal = custoInsumo +  custoFuncionario+custoMarketing;  
		
		lucro = (float) (((this.getQuantidadeSolicitada()*(this.getQuantidadeSolicitada()+0.3)) * (percetualLucro * (custoTotal/quantidadeProduzir))));
		
		return lucro;
	}
	
	public float calculaCustoTotal(){
		float custoTotal=0;
		
		int custoInsumo = this.getCompraInsumo() * 2;
		int custoFuncionario = this.getFuncionario() *150;
		
		custoTotal = custoInsumo + + custoFuncionario+this.getCustoMarketing();
		
		return custoTotal;
	}
	
	public Individuo selecionaMelhor(List<Individuo> populacao){
		Individuo escolhido = populacao.get(0);
		Converter converter = new Converter();
		for (Individuo i: populacao){
			if(i.getValor()>escolhido.getValor() && (converter.Converter(i.getCromossomo().get(0),0)+this.getEstProduto())>= quantidadeSolicitada ){
				escolhido = i;
			}
			
		}
		
		return escolhido;
		 
		
	}
	
	public boolean resCustoProducao(){
		return false;
		
	}
	
	//atualiza valores
	public void atualizaCustoInsumo(float custo){
		this.setCustoInsumo(custo);
	}
	
	private void setCustoInsumo(float custo) {
		// TODO Auto-generated method stub
		
	}

	//funcao Objetivo
	public float lucro(float custoProducao,float receita){
		return receita - custoProducao;
	}
	
	//setter and getters
	public float getCapital() {
		return capital;
	}
	public void setCapital(float capital) {
		this.capital = capital;
	}
	public int getHomemhora() {
		return homemhora;
	}
	public void setHomemhora(int homemhora) {
		this.homemhora = homemhora;
	}
	public int getEstMateriaPrima() {
		return estMateriaPrima;
	}
	public void setEstMateriaPrima(int estMateriaPrima) {
		this.estMateriaPrima = estMateriaPrima;
	}
	public int getEstProduto() {
		return estProduto;
	}
	public void setEstProduto(int estProduto) {
		this.estProduto = estProduto;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public float getCustoMarketing() {
		return custoMarketing;
	}
	public void setCustoMarketing(float custoMarketing) {
		this.custoMarketing = custoMarketing;
	}
	public int getCompraInsumo() {
		return compraInsumo;
	}
	public void setCompraInsumo(int compraInsumo) {
		this.compraInsumo = compraInsumo;
	}
	public int getQuantidadeProduzir() {
		return quantidadeProduzir;
	}
	public void setQuantidadeProduzir(int quantidadeProduzir) {
		this.quantidadeProduzir = quantidadeProduzir;
	}
	public int getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(int funcionario) {
		this.funcionario = funcionario;
	}
	public float getPercentuallucro() {
		return percentuallucro;
	}
	public void setPercentuallucro(float percentuallucro) {
		this.percentuallucro = percentuallucro;
	}

	

	public int getQuantidadeSolicitada() {
		return quantidadeSolicitada;
	}

	public void setQuantidadeSolicitada(int quantidadeSolicitada) {
		this.quantidadeSolicitada = quantidadeSolicitada;
	}

	public void addHistorico(Individuo individuo){
		historicoEstrategia.add(individuo);
	}

	public int getQuantidadeVendida() {
		return quantidadeVendida;
	}

	public void setQuantidadeVendida(int quantidadeVendida) {
		
		this.setQuantidadeSolicitada(quantidadeVendida);

		
		
		if(this.getEstProduto()>=quantidadeVendida){
			this.quantidadeVendida = quantidadeVendida;
			this.setEstProduto(this.getEstProduto()-quantidadeVendida);
		}else{
			this.quantidadeVendida = this.getEstProduto();
			this.setEstProduto(0);
		}
		
	}

	public List<Individuo> getHistoricoEstrategia() {
		return historicoEstrategia;
	}
	
	
	
	

}
