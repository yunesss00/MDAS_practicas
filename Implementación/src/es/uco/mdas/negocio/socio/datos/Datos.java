package es.uco.mdas.negocio.socio.datos;


public interface Datos <T>{
		
	public T consutarPorID(String idObjeto);
	
	public void modificar(T objeto);
	
	public void insertar(T objeto);
	
	public void borrar(String idObjeto);
}