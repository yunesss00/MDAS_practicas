package es.uco.mdas.negocio.socio.datos;


public interface Datos <T>{
		
	public T buscar(Long idObjeto);
	
	public void modificar(T objeto);
	
	public void insertar(T objeto);
	
	public void borrar(Long idObjeto);
}