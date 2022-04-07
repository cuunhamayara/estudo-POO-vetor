public class ImovelArray {
	
	private int idImovel; 
	private String tipo; 
	private int leituraAnterior;
	private int leituraAtual; 
	private int consumo = 0;
	private double valorConta;
	
	public ImovelArray(int idImovel, String tipo, int leituraAtual) {
		this.idImovel = idImovel;
		this.tipo = tipo;
		this.leituraAtual = leituraAtual;
		this.leituraAnterior = this.leituraAtual;
	}
		
	public int getIdImovel() {
		return idImovel;
	}

	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getLeituraAnterior() {
		return leituraAnterior;
	}
	
	public void setLeituraAnterior(int leituraAnterior) {
		this.leituraAnterior = leituraAnterior;
	}
	
	public int getLeituraAtual() {
		return leituraAtual;
	}
		
	public void setLeituraAtual(int leituraAtual) {
		this.leituraAtual = leituraAtual;
	}

	public int getConsumo() {
		return consumo;
	}
	
	public void setConsumo(int consumo) {
		this.consumo = consumo;
	}
	
	public double getValorConta() {
		return valorConta;
	}
	
	public void setValorConta(double valorConta) {
		this.valorConta = valorConta;
	}
	
    @Override
    public String toString() {
        return "Imóvel {" +
                "Identificador: '" + idImovel + '\'' +
                " - Tipo:'" + tipo + '\'' +
                " - Leitura atual:'" + leituraAtual + '\'' +
                '}';
    }
	
	public void registrarLeitura(int leitura) {
		setLeituraAtual(leitura);
		setConsumo(this.getLeituraAtual() - this.getLeituraAnterior());
		this.setLeituraAnterior(leitura);	
	}
	
	public void calcularConta() {
		if (this.tipo.equals("C")) {
			this.setValorConta(this.getConsumo() * 0.7);
		}
		if (this.tipo.equals("I")) {
			this.setValorConta(this.getConsumo() * 0.4);
		}
		if (this.tipo.equals("R")) {
			this.setValorConta(this.getConsumo() * 0.5);
		}		
	}
}