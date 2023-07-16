//As classes filhas não são publicas
class Filha3 extends Moeda{
	
	public Filha3(String nome, double valor) {
        //construtor da classe mae = moeda
		super(nome, valor);
    }

    public void info() {
        System.out.println("Filha3: " + nome + ", Valor: " + valor);
    }

}