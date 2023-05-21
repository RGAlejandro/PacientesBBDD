package controler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.PacienteDao;
import excepciones.CampoVacioException;
import excepciones.IsbnException;
import modelo.Paciente;

public class PacienteControler {
	private List<Paciente> clinica=new ArrayList<Paciente>();
	private Connection conn;
	public PacienteControler(Connection conn) {
		// TODO Auto-generated constructor stub
		this.conn=conn;
	}
	public List<Paciente> getClinica(String sql) throws SQLException, IsbnException, CampoVacioException {
		PacienteDao dao=new PacienteDao(conn);
		
		return dao.getClinica(sql);
	}
	

}
