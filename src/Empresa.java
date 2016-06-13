
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
	private int funcionario;
	private float percentuallucro;
	
	//custo
	private float custoInsumo;
	
	public void Empresa(float capital){
		this.setCapital(capital);
	}
	
	//decisoes
	
	//restricoes
	public boolean resQuantidadeProducao(int quantidadeProduzir, int estoqueMateriaPrima){
		if((quantidadeProduzir*3)<=estoqueMateriaPrima){
			return true;
		}else{
			return false;
		}
			
	}
	
	
	public boolean resMaoObra(int quantidadeProduzir){
		return false;
		
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
	
	
	
	
	

}
