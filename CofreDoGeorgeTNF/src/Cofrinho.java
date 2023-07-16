import java.util.ArrayList;
import java.util.Iterator;

public class Cofrinho {

	//Lista de moedas
	private ArrayList<Moeda> moedas;
	
	public Cofrinho() {
		moedas = new ArrayList<>();
		AdicionarMoeda(new Filha1("Euro", 6.0));
		AdicionarMoeda(new Filha2("Dolar", 4.50));
		AdicionarMoeda(new Filha3("Real", 1.0));
	}
	
	public ArrayList<Moeda> getMoedas() {
		return moedas;
	}
	
	public void setMoedas(ArrayList<Moeda> moedas) {
        this.moedas = moedas;
    }

	//função para adicionar moedas
	public void AdicionarMoeda(Moeda moeda) {
		//add moeda(desta função) na lista moedas
		getMoedas().add(moeda);
	}

	//Remover moedas
	public void RemoverMoeda(String nomeMoeda) {
		//moedas.removeIf(moeda -> moeda.getNome().equals(nomeMoeda));
		
		for (int i = 0; i < getMoedas().size(); i++) {
			Moeda moeda = getMoedas().get(i);
			
			//Se o nome da moeda for igual ao nome da moeda desta função, ele vai remover a moeda e parar.
			if(moeda.getNome().equals(nomeMoeda)) {
				getMoedas().remove(i);
				break;
			}
			else{
				System.out.println("Moeda não encontrada, por favor digita uma moeda vália....");
			}
			
		}
	}
	
	//Função que lista todos as moedas, ele faz um for que percorre toda lista
	public void ListarMoedas() {
		for(Moeda moeda: getMoedas()) {
			if (moeda != null) {
				moeda.info();
			 }
		}
	}
	
	//Função conversor para real
	public double CalcularValorTotalEmReal() {
        double valorTotal = 0.0;
        
        for (Moeda moeda : moedas) {
            valorTotal += moeda.getValor();
        }
        return valorTotal;
    }


}
