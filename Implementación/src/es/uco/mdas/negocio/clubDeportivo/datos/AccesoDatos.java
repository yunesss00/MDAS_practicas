package es.uco.mdas.negocio.clubDeportivo.datos;

public interface AccesoDatos <T>{
	
	public boolean insertar(T objeto);
	
	public T buscar(long idObjeto);
	
	public boolean modificar(T objeto);
	
}