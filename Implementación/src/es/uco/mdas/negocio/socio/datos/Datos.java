package es.uco.mdas.negocio.socio.datos;


public interface Datos <T>{
		
	public boolean insertar(T objeto);
	
	public boolean borrar(Long idObjeto);

	public T buscar(long idObjeto);
	
	public boolean modificar(T objeto);
	
	
}