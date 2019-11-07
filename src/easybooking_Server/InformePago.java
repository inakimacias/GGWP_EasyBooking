package easybooking_Server;

import java.util.Date;

import javax.jdo.annotations.ForeignKey;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class InformePago {
	
	@PrimaryKey
	String idInformePago = "";
	double coste = 0;
	Date fecha = null;
	
	@ForeignKey
	String idMetodoPago = null;
	
	

	public InformePago(String idInformePago, double coste, Date fecha, String idMetodoPago) {
		this.idInformePago = idInformePago;
		this.coste = coste;
		this.fecha = fecha;
		this.idMetodoPago = idMetodoPago;
	}

	public double getCoste() {
		return coste;
	}

	public void setCoste(double coste) {
		this.coste = coste;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getIdInformePago() {
		return idInformePago;
	}

	public void setIdInformePago(String idInformePago) {
		this.idInformePago = idInformePago;
	}

	public String getIdMetodoPago() {
		return idMetodoPago;
	}

	public void setIdMetodoPago(String idMetodoPago) {
		this.idMetodoPago = idMetodoPago;
	}

}
