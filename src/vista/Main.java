package vista;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import controler.PacienteControler;
import dao.DbConnection;
import excepciones.CampoVacioException;
import excepciones.IsbnException;
import modelo.Paciente;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
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
		*/
		Scanner leer=new Scanner(System.in);
		boolean sigue=true;
		String opcion="";
		do {
			System.out.println("1.-CONSULTA A TODA LA BBDD");
			System.out.println("2.-AÑADIR A LA BBDD");
			System.out.println("3.-ELIMINAR A LA BBDD");
			System.out.println("4.-FILTRADO A LA BBDD");
			System.out.println("5.-ATENDER PACIENTE EN LA BBDD");
			System.out.println("6.-APAGAR");
			opcion=leer.next();
			switch(opcion) {
			case "1":
				Connection conn;
				DbConnection dbc=new DbConnection();
				conn=dbc.getConnection();
				PacienteControler controler=new PacienteControler(conn);
				String sql="select * from paciente";
				try {
					List<Paciente> clinica=controler.getClinica(sql);
					mostrar(clinica);
				} catch (SQLException | IsbnException | CampoVacioException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
			break;
			
			case "2":
				
			break;
			
			case "3":
				
			break;
			
			case "4":
				
			break;
			
			case "5":
				
			break;
			
			case "6":
				sigue=false;
			break;
			
			default:
			System.out.println("Elige un numero del 1 al 6");	
			}
		}while(sigue);
		
	}

	private static void mostrar(List<Paciente> clinica) {
		// TODO Auto-generated method stub
		for (Paciente p : clinica) {
			System.out.println(p);
		}
	}

}
