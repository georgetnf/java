//Classe "mae"
abstract class Moeda {

	protected String nome;
	protected double valor;

    public Moeda(String nome, double valor) {
        this.nome = nome;
        this.valor = valor;
    }

    //informações
    public abstract void info();
    
    //Nome da moeda
    public String getNome() {
        return nome;
    }
    
    public double getValor() {
    	return valor;
    }
	
}