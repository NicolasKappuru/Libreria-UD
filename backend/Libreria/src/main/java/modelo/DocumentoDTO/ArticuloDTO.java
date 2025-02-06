package modelo.DocumentoDTO;

public class ArticuloDTO extends DocumentoDTO {

    private static final long serialVersionUID = 1L;
    private int idArticulo;
    private String ssn;

    public ArticuloDTO(BuilderArticulo builder) {
        super(builder);
        this.idArticulo = builder.idArticulo;
        this.ssn = builder.ssn;
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public String getSsn() {
        return ssn;
    }

    public static class BuilderArticulo extends BuilderDoc {
        private int idArticulo;
        private String ssn;

        public BuilderArticulo setIdArticulo(int idArticulo) {
            this.idArticulo = idArticulo;
            return this;
        }

        public BuilderArticulo setSsn(String ssn) {
            this.ssn = ssn;
            return this;
        }

        @Override
        public BuilderArticulo setIdDocumento(int idDocumento) {
            super.setIdDocumento(idDocumento);
            return this;
        }

        @Override
        public BuilderArticulo setTitulo(String titulo) {
            super.setTitulo(titulo);
            return this;
        }

        @Override
        public BuilderArticulo setFechaPublicacion(String fechaPublicacion) {
            super.setFechaPublicacion(fechaPublicacion);
            return this;
        }

        @Override
        public BuilderArticulo setDiaPublicacion(String diaPublicacion) {
            super.setDiaPublicacion(diaPublicacion);
            return this;
        }

        @Override
        public BuilderArticulo setEditorial(String editorial) {
            super.setEditorial(editorial);
            return this;
        }

        @Override
        public BuilderArticulo setEstado(String estado) {
            super.setEstado(estado);
            return this;
        }

        @Override
        public BuilderArticulo setPropietario(String propietario) {
            super.setPropietario(propietario);
            return this;
        }

        @Override
        public ArticuloDTO build() {
            return new ArticuloDTO(this);
        }
    }
}