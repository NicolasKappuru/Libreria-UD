package modelo;

public class Reserva {
	
	private int idreserva;
	private String fechareserva;
	private String fechaentrega;
	private String estado;
	private int documento;
	private String usuario;
	
	
	public Reserva() {
		
	}
	
	public int getIdreserva() {
		return idreserva;
	}
	public void setIdreserva(int idreserva) {
		this.idreserva = idreserva;
	}
	public String getFechareserva() {
		return fechareserva;
	}
	public void setFechareserva(String fechareserva) {
		this.fechareserva = fechareserva;
	}
	public String getFechaentrega() {
		return fechaentrega;
	}
	public void setFechaentrega(String fechaentrega) {
		this.fechaentrega = fechaentrega;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public int getDocumento() {
		return documento;
	}
	public void setDocumento(int documento) {
		this.documento = documento;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
}
