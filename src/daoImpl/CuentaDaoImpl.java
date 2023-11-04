package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import conexion.conexion;
import dao.ICuenta;
import entidades.Cuenta;

public class CuentaDaoImpl implements ICuenta {

	private conexion conexion; 
	
		public List<Cuenta> listarCuentas() {
		
			List <Cuenta> lista= new ArrayList<Cuenta>();
			conexion= new conexion();
			String query= "Select C.NumCuenta_Cta,C.IdUsuario_Cta, C.FechaCreacion_Cta, C.IdTipoCuenta_Cta, C.CBU_Cta, C.Saldo_Cta FROM cuenta AS C inner join usuario U on U.IdUsuario_U = C.IdUsuario_Cta where Estado_Cta=true";
			
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
		
		
		@Override
		public boolean eliminarCuenta(int id) {
			
			conexion= new conexion();
			boolean guardado=true;
			
			String query= "update Cuenta set Estado_Cta=false where NumCuenta_Cta="+id;
			try {
				conexion.Open();
				guardado=conexion.execute(query);	
				
			} catch (Exception e) {
				guardado=false;
				e.printStackTrace();
			}
			finally {
				conexion.close();
			}

			
			return guardado;
		}
		
		
		@Override
		public boolean altaCuenta(int idUsuario, int idTipoCta, int cbu, float saldo, String detalle, int tipoMovimiento) {
			Connection connection = null;
			conexion= new conexion();
			boolean isCreate = false;
			
			try {
				
				if(validarTotalCuentas(idUsuario) <= 3) {
					
					connection = conexion.Open();
					String query = "INSERT INTO bd_tpint_grupo_6_lab4.cuenta (IdUsuario_Cta, FechaCreacion_Cta, IdTipoCuenta_Cta, CBU_Cta, Saldo_Cta) VALUES (?, ?, ?, ?, ?)";
					
					Date fechaCreacionDate = new Date();
					java.sql.Date sqlDate = new java.sql.Date(fechaCreacionDate.getTime());
					// Crear una declaración preparada con la consulta SQL
					PreparedStatement preparedStatement = connection.prepareStatement(query);
					
					// Establecer los valores para las columnas utilizando métodos setXXX 
					preparedStatement.setInt(1, idUsuario); 
					preparedStatement.setDate(2, sqlDate); 
					preparedStatement.setInt(3, idTipoCta);
					preparedStatement.setInt(4, cbu);
					preparedStatement.setFloat(5, saldo);
					
					// Ejecutar la declaración de inserción
					preparedStatement.executeUpdate();
					
					logMovimientos(cbu,detalle, saldo, tipoMovimiento);
					isCreate = true;
				}
				else {
					isCreate = false;
				}
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				conexion.close();
			}
			return isCreate;
		}
	

		@Override
		public int validarTotalCuentas(int idUsuario) {
			conexion= new conexion();
			String query= "SELECT count(IdUsuario_Cta) FROM bd_tpint_grupo_6_lab4.cuenta where IdUsuario_Cta = " + "'" + idUsuario +"'";
			int count = 0;
			try {
				conexion.Open();
				ResultSet rs= conexion.query(query);
				
				while(rs.next()) {
					count = rs.getInt(1);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				conexion.close();
			}
			return count;
		}
		
		public int obtenerNumCuenta(int cbu) {
			conexion= new conexion();
			String query= "SELECT NumCuenta_Cta FROM bd_tpint_grupo_6_lab4.cuenta where CBU_Cta = " + "'" + cbu +"'";
			int id = 0;
			try {
				conexion.Open();
				ResultSet rs= conexion.query(query);
				
				while(rs.next()) {
					id = rs.getInt(1);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				conexion.close();
			}
			
			return id;
		}
		
			

		@Override
		public void logMovimientos(int cbu, String descripcion, float importe, int tipoMovimiento) {
			Connection connection = null;
			conexion= new conexion();
			
			try {
				
				connection = conexion.Open();
				String query = "INSERT INTO bd_tpint_grupo_6_lab4.movimientos (NumCuenta_M, FechaMovimiento_M, Detalle_M, Importe_M, IdTipoMovimiento_M, Estado_M) VALUES (?, ?, ?, ?, ?, ?)";
				
				Date fechaCreacionDate = new Date();
				java.sql.Date sqlDate = new java.sql.Date(fechaCreacionDate.getTime());
				int numCuenta = obtenerNumCuenta(cbu);
				String estado = "Completado" ;
				// Crear una declaración preparada con la consulta SQL
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				
				// Establecer los valores para las columnas utilizando métodos setXXX
				preparedStatement.setInt(1, numCuenta); 
				preparedStatement.setDate(2, sqlDate); 
				preparedStatement.setString(3, descripcion); 
				preparedStatement.setFloat(4, importe);
				preparedStatement.setInt(5, tipoMovimiento);
				preparedStatement.setString(6, estado);
				// Ejecutar la declaración de inserción
				preparedStatement.executeUpdate();
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				conexion.close();
			}
			
		}

}
