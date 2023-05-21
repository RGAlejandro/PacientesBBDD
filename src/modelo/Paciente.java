package modelo;

import java.time.LocalDate;

import excepciones.CampoVacioException;
import excepciones.IsbnException;

public class Paciente {
	private String historiaClinica;
	private String nombre;
	private String servicio;
	private String seguroMedico;
	private double importe;
	private boolean atentido;
	private LocalDate fechaServicio;

	public Paciente() {
		// TODO Auto-generated constructor stub
	}
	
	public Paciente(String historiaClinica, String nombre, String servicio, String seguroMedico, String importe,
			String atentido, String fechaServicio) throws IsbnException, CampoVacioException {
		
		this.setHistoriaClinica(historiaClinica);
		this.setNombre(nombre);
		this.setServicio(fechaServicio);
		this.setSeguroMedico(seguroMedico);
		this.setImporte(importe);
		this.setAtentido(atentido);
		this.setFechaServicio(fechaServicio);
	}

	public String getHistoriaClinica() {
		return historiaClinica;
	}

	public void setHistoriaClinica(String historiaClinica) throws IsbnException {
		if(compruebaIsbn(historiaClinica)) {
			this.historiaClinica = historiaClinica;
		}
		else {
			throw new IsbnException();
		}
	}

	private boolean compruebaIsbn(String isbn) {
		// TODO Auto-generated method stub
		boolean esValido=true;
		isbn=isbn.replace("-", "");
		if(isbn.length()!=13) {
			return false;
		}
		double compruebaNums=0;
		try {
			compruebaNums=Double.parseDouble(isbn);
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		String parteCalculable=isbn.substring(0, 12);
		
		String digControlPuesto=isbn.substring(12);
		

		char[] calcular=parteCalculable.toCharArray();
		int acumulador=0;
		int pos=1;
		int suma=0;
		for(int x=0;x<calcular.length;x++) {
			acumulador=Integer.parseInt(Character.toString(calcular[x]));
			if(pos%2==0) {
				suma+=acumulador*3;
			}
			else {
				suma+=acumulador;
			}
			pos++;
		}
		int dig=10-(suma%10);
		if(dig==10) {
			dig=0;
		}
		String digCalc=String.valueOf(dig);
		if(!digCalc.equals(digControlPuesto)) {
			return false;
		}
		
		return esValido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) throws CampoVacioException {
		if(nombre.isEmpty()) {
			throw new CampoVacioException();
		}
		else {
			this.nombre = nombre;
		}
	}

	public String getServicio() {
		return servicio;
	}

	public void setServicio(String servicio) throws CampoVacioException {
		if(servicio.isEmpty()) {
			throw new CampoVacioException();
		}
		else {
			this.servicio = servicio;
		}
		
	}

	public String getSeguroMedico() {
		return seguroMedico;
	}

	public void setSeguroMedico(String seguroMedico) throws CampoVacioException {
		if(seguroMedico.isEmpty()) {
			throw new CampoVacioException();
		}
		else {
			this.seguroMedico = seguroMedico;
		}
		
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(String importe) throws CampoVacioException {
		if(importe.isEmpty()) {
			throw new CampoVacioException();
		}
		else {
			this.importe = Double.parseDouble(importe);
		}
		
	}

	public boolean isAtentido() {
		return atentido;
	}

	public void setAtentido(String atentido) throws CampoVacioException {
		if(atentido.isEmpty()) {
			throw new CampoVacioException();
		}
		else {
			this.atentido = Boolean.parseBoolean(atentido);
		}
		
	}

	public LocalDate getFechaServicio() {
		return fechaServicio;
	}

	public void setFechaServicio(String fechaServicio) throws CampoVacioException {
		if(fechaServicio.isEmpty()) {
			throw new CampoVacioException();
		}
		else {
			this.fechaServicio = LocalDate.parse(fechaServicio);
		}
		
	}

	@Override
	public String toString() {
		return historiaClinica + "," + nombre + "," + servicio
				+ "," + seguroMedico + "," + importe + "," + atentido
				+ "," + fechaServicio;
	}
	
}
