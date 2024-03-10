package entities;

public class PessoaFisica extends Pessoa {

	private Double gastosSaude;
	
	public PessoaFisica() {
		super();
	}

	public PessoaFisica(String nome, double rendaAnual, Double gastosSaude) {
		super(nome, rendaAnual);
		this.gastosSaude = gastosSaude;
	}

	public Double getGastosSaude() {
		return gastosSaude;
	}

	public void setGastosSaude(Double gastosSaude) {
		this.gastosSaude = gastosSaude;
	}
	
	@Override
	public double calculoImposto() {
		if (super.getRendaAnual() < 20000) {
			return 0.15*super.getRendaAnual()-gastosSaude/2;
		}
		else {
			return 0.25*super.getRendaAnual()-gastosSaude/2;
		}
	}
}
