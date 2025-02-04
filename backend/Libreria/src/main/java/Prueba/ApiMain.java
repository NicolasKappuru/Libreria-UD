package Prueba;

import modelo.DocumentoDTO.PonenciaDTO;
import modelo.DocumentoDTO.ArticuloDTO;
import modelo.DocumentoDTO.LibroDTO;

public class ApiMain {

	public static void main(String[] args) {

		LibroDTO libro = new LibroDTO.BuilderLibro()
                .setIdDocumento(15)
                .setTitulo("El Arte de la Programación")
                .setFechaPublicacion("2025-02-02")
                .setDiaPublicacion("Lunes")
                .setEditorial("Addison-Wesley")
                .setEstado("Publicado")
                .setPropietario("Donald Knuth")
                .setIsbn("978-0321751041")
                .build();
		System.out.println(libro.toString());

		PonenciaDTO ponencia = new PonenciaDTO.BuilderPonencia()
                .setIdDocumento(17)
                .setTitulo("Instituto demanda")
                .setFechaPublicacion("2025-10-05")
                .setDiaPublicacion("Lunes")
                .setEditorial("Addison-Wesley")
                .setEstado("Publicado")
                .setPropietario("Donald Knuth")
                .setIdPonencia(13)
                .setIsbn("12908UIOI22")
                .setCongreso("Vaticano")
                .build();
		System.out.println(ponencia.toString());
		
		ArticuloDTO articulo = new ArticuloDTO.BuilderArticulo()
                .setIdDocumento(16)
                .setTitulo("Descubrimiento sobre IA")
                .setFechaPublicacion("2025-08-14")
                .setDiaPublicacion("Lunes")
                .setEditorial("Addison-Wesley")
                .setEstado("Publicado")
                .setPropietario("Donald Knuth")
                .setIdArticulo(19)
                .setSsn("1000012002")
                .build();
		System.out.println(articulo.toString());
	}

}
