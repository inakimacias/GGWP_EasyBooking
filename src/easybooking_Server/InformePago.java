package easybooking_Server;

import java.util.Date;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class InformePago {
	
	@PrimaryKey
	String idInformePago = "";
	double coste = 0;
	Date fecha = null;
	
	public InformePago(double coste, Date fecha, String idInformePago) {
		this.coste = coste;
		this.fecha = fecha;
		this.idInformePago = idInformePago;
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

}
