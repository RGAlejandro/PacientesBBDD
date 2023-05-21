package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import excepciones.CampoVacioException;
import excepciones.IsbnException;
import modelo.Paciente;

public class PacienteDao {
	private Connection conn;
	public PacienteDao(Connection conn) {
		// TODO Auto-generated constructor stub
		this.conn=conn;
	}
	public List<Paciente> getClinica(String sql) throws SQLException, IsbnException, CampoVacioException{
		List<Paciente> clinica=new ArrayList<Paciente>();
		PreparedStatement pst=conn.prepareStatement(sql);
		ResultSet rs=pst.executeQuery();
		Paciente paciente=null;
		while(rs.next()) {
			String historiaClinica=rs.getString("historiaClinica");
			String nombre=rs.getString("nombre");
			String servicio=rs.getString("servicio");
			String seguroMedico=rs.getString("seguroMedico");
			double importe=rs.getDouble("importe");
			boolean atendido=rs.getBoolean("atendido");
			LocalDate fechaServicio=rs.getDate("fechaServicio").toLocalDate();
			paciente=new Paciente(historiaClinica, nombre, servicio, seguroMedico, importe, atendido, fechaServicio);
			clinica.add(paciente);
			paciente=null;
		}
		
		return clinica;
	}
}
