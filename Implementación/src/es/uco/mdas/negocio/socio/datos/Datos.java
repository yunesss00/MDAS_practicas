package es.uco.mdas.negocio.socio.datos;


public interface Datos <T>{
		
	public T consutarPorID(Long long1);
	
	public void modificar(T objeto);
	
	public void insertar(T objeto);
	
	public void borrar(long idObjeto);
}