package easybooking_Server;

import java.util.Date;

import javax.jdo.annotations.ForeignKey;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class InformePago {
	
	@PrimaryKey
	private String idInformePago = "";
	private double coste = 0;
	private Date fecha = null;
	private MetodoPago MetodoPago = null;
	
	

	public InformePago() {
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

	public MetodoPago getMetodoPago() {
		return MetodoPago;
	}

	public void setMetodoPago(MetodoPago metodoPago) {
		MetodoPago = metodoPago;
	}
}
