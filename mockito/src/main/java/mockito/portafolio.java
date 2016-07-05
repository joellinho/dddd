package mockito;

import java.util.ArrayList;
import java.util.List;

public class portafolio {
	
	List<Stock> lista = new ArrayList<Stock>();
	ServiceStock servicestock ;
	
	
	protected List<Stock> getLista() {
		return lista;
	}
	protected void setLista(List<Stock> lista) {
		this.lista = lista;
	}
	protected ServiceStock getServicestock() {
		return servicestock;
	}
	protected void setServicestock(ServiceStock servicestock) {
		this.servicestock = servicestock;
	}
	
	public double valorcartera(){
		double preciomarket=0.0;
		for (Stock stock : lista) {
			preciomarket += stock.getCantidad()*servicestock.getPrecio(stock);
		}
		
		return preciomarket;
	}
	
}
