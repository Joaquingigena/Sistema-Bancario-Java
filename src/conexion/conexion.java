package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class conexion {

	public static conexion instancia;
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";//root
	private String dbName = "bd_tpint_grupo_6_lab4";

	protected Connection connection;
	
	public Connection Open()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");// com.mysql.jdbc.Driver
			this.connection = DriverManager.getConnection(host+dbName, user, pass);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return this.connection;
	}
	
	public ResultSet query(String query)
	{
		Statement st;
		ResultSet rs=null;
		try
		{
			st= connection.createStatement();
			rs= st.executeQuery(query);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	
	public boolean execute(String query)
	{
		Statement st;
		boolean save = true;
		try {
			st = connection.createStatement();
		    st.executeUpdate(query);
		}
		catch(SQLException e)
		{
			save = false;
			e.printStackTrace();
		}
		return save;
	}
	
	public boolean executeDelete(String query) {
	    Statement st;
	    boolean deleted = true;
	    try {
	        st = connection.createStatement();
	        st.executeUpdate(query);
	    } catch(SQLException e) {
	        deleted = false;
	        e.printStackTrace();
	    }
	    return deleted;
	}
	
	public boolean close()
	{
		boolean ok=true;
		try {
			connection.close();
		}
		catch(Exception e)
		{
			ok= false;
			e.printStackTrace();
		}
		return ok;
	}
	
	public static conexion getConexion()  
	{								
		if(instancia == null)
		{
			instancia = new conexion();
		}
		return instancia;
	}

	public Connection getSQLConexion() 
	{
		return this.connection;
	}
}

