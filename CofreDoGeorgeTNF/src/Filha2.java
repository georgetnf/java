//As classes filhas não são publicas
class Filha2 extends Moeda{
	
	public Filha2(String nome, double valor) {
        //construtor da classe mae = moeda
		super(nome, valor);
    }

    public void info() {
        System.out.println("Filha2: " + nome + ", Valor: " + valor);
    }

}