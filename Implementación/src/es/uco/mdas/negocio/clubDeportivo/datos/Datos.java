package es.uco.mdas.negocio.clubDeportivo.datos;

public interface Datos <T>{
	
	public boolean insertar(T objeto);
	
	public boolean borrar(T objeto);

	public T buscar(Long idObjeto);
	
	public boolean modificar(T objeto);
	
}