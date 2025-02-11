package modelo;

public class Documento {
    
	private int iddocumento;
	private String tipo;
    private String titulo;
    private String fechaPublicacion;
    private String autores;
    private String editorial;
    private String isbn;
    private String nombreCongreso;
    private String numPaginas;
    private String ssn;
    private String estado;
    private String propietario;
    
    
    
    
    public String getPropietario() {
		return propietario;
	}

	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getIddocumento() {
		return iddocumento;
	}

	public void setIddocumento(int iddocumento) {
		this.iddocumento = iddocumento;
	}

    public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getNombreCongreso() {
		return nombreCongreso;
	}

	public void setNombreCongreso(String nombreCongreso) {
		this.nombreCongreso = nombreCongreso;
	}

	public String getNumPaginas() {
		return numPaginas;
	}

	public void setNumPaginas(String numPaginas) {
		this.numPaginas = numPaginas;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	// Constructor vacío
    public Documento() {}

    // Getters y Setters
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getAutores() {
        return autores;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    // Método toString()
    @Override
    public String toString() {
        return "Documento{" +
                "tipo='" + tipo + '\'' +
                ", titulo='" + titulo + '\'' +
                ", fechaPublicacion='" + fechaPublicacion + '\'' +
                ", autores='" + autores + '\'' +
                ", editorial='" + editorial + '\'' +
                '}';
    }
}
