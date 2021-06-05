package es.uco.mdas.negocio.socio.datos;


public interface Datos <T>{
		
	public T buscar(Long idObjeto);
	
	public boolean modificar(T objeto);
	
	public boolean insertar(T objeto);
	
	public boolean borrar(Long idObjeto);
}