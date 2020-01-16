package gateways;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ILoginGw fgw = FacebookGw.getInstance();
		ILoginGw ggw = GoogleGw.getInstance();
		IAerolineaGw ibe = IberiaGw.getInstance();
		IAerolineaGw rya = RyannairGw.getInstance();
		IAerolineaGw vue = VuelingGw.getInstance();
		IPagoGw pay = PaypalGw.getInstance();
		IPagoGw eba = EntidadGw.getInstance();
		
		fgw.autenticar("DanielDiez", "elDani");
		ggw.autenticar("inaki@gmail.com", "elInaki");
		ibe.buscarVuelo("Bilbao", "Madrid");
		ibe.reservarVuelo("003", 6);
		rya.buscarVuelo("Bilbao", "Madrid");
		rya.reservarVuelo("001", 3);
		vue.buscarVuelo("Barcelona", "Madrid");
		vue.reservarVuelo("004", 7);
		pay.pagar("ruben@gmail.com", 28.87);
		eba.pagar("03030303", 32.0);
	}

}
