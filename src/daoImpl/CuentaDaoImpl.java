package daoImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentNavigableMap;

import conexion.conexion;
import dao.ICuenta;
import entidades.Cuenta;

public class CuentaDaoImpl implements ICuenta {

	private conexion conexion; 
	
		public List<Cuenta> listarCuentas() {
		
		List <Cuenta> lista= new ArrayList<Cuenta>();
		conexion= new conexion();
		String query= "Select C.NumCuenta_Cta,C.IdUsuario_Cta, C.FechaCreacion_Cta, C.IdTipoCuenta_Cta, C.CBU_Cta, C.Saldo_Cta, U.IdUsuario_U FROM cuenta AS C inner join usuario U on U.IdUsuario_U = C.IdUsuario_Cta;";
		
		try {
			conexion.Open();
			ResultSet rs= conexion.query(query);
			
			while(rs.next()) {
				Cuenta cuenta= new Cuenta();
				
				cuenta.setNumCuenta_Cta(rs.getInt(1));
				cuenta.getIdUsuario_Cta().setIdUsuario_U(rs.getInt(2));
				cuenta.setFechaCreacion_Cta(rs.getDate(3));
				cuenta.setCBU_Cta(rs.getInt(5));
				cuenta.setSaldo_Cta(rs.getFloat(6));
			
				lista.add(cuenta);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			conexion.close();
		}
		
		return lista;
	}

}


