package conversorAlura;

public class Moneda {
	private String codigo;
    private String nombre;
    private String simbolo;

    public Moneda(String codigo, String nombre, String simbolo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.simbolo = simbolo;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSimbolo() {
		return simbolo;
	}

	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}
}
