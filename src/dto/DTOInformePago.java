package dto;

import java.util.Date;

import jdo.MetodoPago;

public class DTOInformePago {

	private String idInformePago = "";
	private double coste = 0;
	private Date fecha = null;
	private MetodoPago MetodoPago = null;
	
	
	public String getIdInformePago() {
		return idInformePago;
	}
	public void setIdInformePago(String idInformePago) {
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
	public MetodoPago getMetodoPago() {
		return MetodoPago;
	}
	public void setMetodoPago(MetodoPago metodoPago) {
		MetodoPago = metodoPago;
	}
}
