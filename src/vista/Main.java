package vista;

import java.time.LocalDate;

import excepciones.CampoVacioException;
import excepciones.IsbnException;
import modelo.Paciente;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String historiaClinica="978-84-204-4290-7";
		String nombre="Alejandro";
		String servicio="Lesion de ligamentos";
		String seguroMedico="SANITAS";
		String importe="200";
		String atentido="true";
		String fechaServicio="2023-05-23";
		try {
			Paciente prueba=new Paciente(historiaClinica, nombre, servicio, seguroMedico, importe, atentido, fechaServicio);
			System.out.println(prueba);
		} catch (IsbnException | CampoVacioException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}

}
