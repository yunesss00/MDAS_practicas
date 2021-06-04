package es.uco.mdas.negocio.socio.datos;


public interface Datos <T>{
		
	public T consutarPorID(String idAbono);
	
	public boolean modificar(T abono);
	
	public boolean insertar(T abono);
	
	public boolean borrar(String idAbono);
}