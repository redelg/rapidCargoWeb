package all;

public class daoDetalleEncomienda {
	
	public static daoDetalleEncomienda _Instancia;
	private daoDetalleEncomienda() {}
	public static daoDetalleEncomienda Instancia() {
		if(_Instancia==null) {
			_Instancia = new daoDetalleEncomienda();
		}
		return _Instancia;
	}
}
