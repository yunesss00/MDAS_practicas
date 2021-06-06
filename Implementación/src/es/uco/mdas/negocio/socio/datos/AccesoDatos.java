package es.uco.mdas.negocio.socio.datos;


public interface AccesoDatos <T>{
		
	public boolean insertar(T objeto);
	
	public boolean borrar(Long idObjeto);

	public T buscar(Long idObjeto);
	
	public boolean modificar(T objeto);
	
	
}