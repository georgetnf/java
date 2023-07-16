//As classes filhas não são publicas
class Filha1 extends Moeda{
	
	public Filha1(String nome, double valor) {
        //construtor da classe mae = moeda
		super(nome, valor);
    }

    public void info() {
        System.out.println("Filha1: " + nome + ", Valor: " + valor);
    }

}