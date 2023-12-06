package daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import conexion.conexion;
import dao.ICuenta;
import entidades.Cuenta;
import entidades.Personas;
import entidades.Usuario;
import entidades.TipoCuentas;


public class CuentaDaoImpl implements ICuenta {

	private conexion conexion; 
	
		public List<Cuenta> listarCuentas() {
		
			List <Cuenta> lista= new ArrayList<Cuenta>();
			conexion= new conexion();
			String query= "SELECT\r\n" + 
					"    C.NumCuenta_Cta,\r\n" + 
					"    C.IdUsuario_Cta,\r\n" + 
					"    P.Nombre_P,\r\n" + 
					"    P.Apellido_P,\r\n" + 
					"    C.FechaCreacion_Cta,\r\n" + 
					"    C.IdTipoCuenta_Cta,\r\n" + 
					"    C.CBU_Cta,\r\n" + 
					"    C.Saldo_Cta\r\n" + 
					"FROM\r\n" + 
					"    cuenta AS C\r\n" + 
					"INNER JOIN\r\n" + 
					"    usuario AS U ON U.IdUsuario_U = C.IdUsuario_Cta\r\n" + 
					"INNER JOIN\r\n" + 
					"    personas AS P ON U.IdPersona_U = P.IdPersona_P\r\n" + 
					"INNER JOIN\r\n" + 
					"    TipoCuentas AS TC ON TC.IdTipo_TC = C.IdTipoCuenta_Cta\r\n" + 
					"WHERE\r\n" + 
					"    C.Estado_Cta = true;";
			
			try {
				conexion.Open();
				ResultSet rs= conexion.query(query);
				
				while(rs.next()) {
					Cuenta cuenta= new Cuenta();
					
					cuenta.setNumCuenta_Cta(rs.getInt(1));
					cuenta.getIdUsuario_Cta().setIdUsuario_U(rs.getInt(2));
					cuenta.getIdUsuario_Cta().getIdPersona_U().setNombre_P(rs.getString(3));
					cuenta.getIdUsuario_Cta().getIdPersona_U().setApellido_P(rs.getString(4));
					cuenta.setFechaCreacion_Cta(rs.getDate(5));
					cuenta.setCBU_Cta(rs.getInt(7));
					cuenta.setSaldo_Cta(rs.getFloat(8));
				
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
		
		@Override
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
				boolean estado = true ;
				// Crear una declaración preparada con la consulta SQL
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				
				// Establecer los valores para las columnas utilizando métodos setXXX
				preparedStatement.setInt(1, numCuenta); 
				preparedStatement.setDate(2, sqlDate); 
				preparedStatement.setString(3, descripcion); 
				preparedStatement.setFloat(4, importe);
				preparedStatement.setInt(5, tipoMovimiento);
				preparedStatement.setBoolean(6, estado);
				// Ejecutar la declaración de inserción
				preparedStatement.executeUpdate();
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				conexion.close();
			}
			
		}
		

		@Override
		public List<TipoCuentas> listarTipoCuentas() {
			
			List <TipoCuentas> Lista = new ArrayList<TipoCuentas>();
			conexion= new conexion();
			String query= "SELECT IdTipo_TC, Descripcion_TC FROM TipoCuentas";
			try {
				conexion.Open();
				ResultSet rs = conexion.query(query);
				
				while(rs.next()) {
					TipoCuentas tc = new TipoCuentas();
					
					tc.setIdTipo_TC(rs.getInt("IdTipo_TC"));
					tc.setDescripcion_TC(rs.getString("Descripcion_TC"));
					
					Lista.add(tc);
				}

			}
			catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				conexion.close();
			}
			return Lista;

		}
		
		@Override
		public Cuenta obtenerCuenta(int id) {
			
			conexion= new conexion();
			Cuenta Cta= new Cuenta();
			Usuario user = new Usuario();
			TipoCuentas TP = new TipoCuentas();
			
			String query= "select C.NumCuenta_Cta as numCuenta, C.IdUsuario_Cta as idUsuario, C.FechaCreacion_Cta as fechaCreacion, C.IdTipoCuenta_Cta as idTipoCuenta, C.CBU_Cta as CBU, C.Saldo_Cta as saldo from Cuenta as C inner join Usuario U on U.IdUsuario_U = C.IdUsuario_Cta inner join TipoCuentas TC on TC.IdTipo_TC = C.IdTipoCuenta_Cta where C.NumCuenta_Cta = "+ id;
			
			try {
				conexion.Open();
				
				ResultSet rs= conexion.query(query);
				
				rs.next();
				Cta.setNumCuenta_Cta(rs.getInt("numCuenta"));
				user.setIdUsuario_U(rs.getInt("idUsuario"));
				Cta.setIdUsuario_Cta(user);
				Cta.setFechaCreacion_Cta(rs.getDate("fechaCreacion"));
				TP.setIdTipo_TC(rs.getInt("idTipoCuenta"));
				Cta.setIdTipoCuenta_Cta(TP);
				Cta.setCBU_Cta(rs.getInt("CBU"));
				Cta.setSaldo_Cta(rs.getFloat("saldo"));
				
				System.out.println(Cta.toString());
				
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				conexion.close();
			}
			
			return Cta;
		}


		@Override
		public boolean modificarCuenta(Cuenta cta) {
			
			boolean exito=false;
			conexion= new conexion();
			
			String queryPersona= "update Cuenta set IdTipoCuenta_Cta="+cta.getIdTipoCuenta_Cta().getIdTipo_TC()+", CBU_Cta"+cta.getCBU_Cta()+",Saldo_Cta='"+cta.getSaldo_Cta()+"' where NumCuenta_Cta="+cta.getNumCuenta_Cta()+"";
			
			try {
				conexion.Open();
				
				if(conexion.execute(queryPersona)) {
					
					exito=true;
				}
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				conexion.close();
			}
			
			return exito;
		}


		@Override
		public boolean modificate(Cuenta cta) {
			boolean r=false;
			conexion= new conexion();
			try {
				CallableStatement st = conexion.Open().prepareCall("CALL SPActualizarCuentas(?,?,?,?)");
				st.setInt(1,cta.getNumCuenta_Cta());
				st.setInt(2,cta.getIdTipoCuenta_Cta().getIdTipo_TC());
				st.setInt(3,cta.getCBU_Cta());
				st.setFloat(4, cta.getSaldo_Cta());
				if (st.executeUpdate()>0) r=true;
				
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			  finally {
				conexion.close();
			}
			return r;
		}


		@Override
		public List<Cuenta> filtrarListaCuentas(String filtro) {
			List <Cuenta> lista= new ArrayList<Cuenta>();
			conexion= new conexion();
			String query= "Select C.NumCuenta_Cta,C.IdUsuario_Cta, C.FechaCreacion_Cta, C.IdTipoCuenta_Cta, C.CBU_Cta, C.Saldo_Cta FROM cuenta AS C inner join usuario U on U.IdUsuario_U = C.IdUsuario_Cta inner join TipoCuentas tc on tc.IdTipo_TC = C.IdTipoCuenta_Cta where Estado_Cta=true and NumCuenta_Cta LIKE '%"+filtro+"%'";
			
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
		public List<Cuenta> filtroAvanzado(String query) {
			List <Cuenta> lista= new ArrayList<Cuenta>();
			conexion= new conexion();
			System.out.println("La query que llega al dao es: " + query);
			
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
				System.err.println(lista);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return lista;
		}


		@Override
		public List<Cuenta> listarCuentasPorUsuario(String nombre) {
			
			List <Cuenta> lista= new ArrayList<Cuenta>();
			conexion= new conexion();
			
			UsuarioDaoImp usuarioDaoImp = new UsuarioDaoImp();
			int idUsuario = usuarioDaoImp.ObtenerIdUsuario(nombre);
			
			String query= "Select * FROM cuenta where IdUsuario_Cta = "+idUsuario;
			
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
		public ArrayList<Cuenta> obtenerTodos() {
			ResultSet rs; //Guarda el resultado de la query
			ArrayList<Cuenta> cuenta= new ArrayList<Cuenta>();
			conexion= new conexion();
			String consulta = 
			"Select * from cuenta inner join tipocuentas " + 
			"	on (cuenta.IdTipoCuenta_Cta = tipocuentas.IdTipo_TC) inner join usuario " + 
			"		on (cuenta.IdUsuario_Cta = usuario.IdUsuario_U)"; 
			try 
			{
				conexion.Open();
				rs= conexion.query(consulta);
				while(rs.next())
				{
					Cuenta cta= new Cuenta();
					
					cta.setNumCuenta_Cta(rs.getInt(1));
					cta.getIdUsuario_Cta().setIdUsuario_U(rs.getInt(2));
					cta.setFechaCreacion_Cta(rs.getDate(3));
					cta.setCBU_Cta(rs.getInt(5));
					cta.setSaldo_Cta(rs.getFloat(6));
					cuenta.add(cta);
				}
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				conexion.close();
			}
			return cuenta;
		}


		@Override
		public ArrayList<Cuenta> cuentasXPropietario(String nombre) {
			ResultSet rs; //Guarda el resultado de la query
			ArrayList<Cuenta> cuenta= new ArrayList<Cuenta>();
			
			UsuarioDaoImp usuarioDaoImp = new UsuarioDaoImp();
	        int idUsuario = usuarioDaoImp.ObtenerIdUsuario(nombre);
			String consulta = 
			"Select * from cuenta inner join tipocuentas " + 
			"	on (cuenta.IdTipoCuenta_Cta = tipocuentas.IdTipo_TC) inner join usuario on (cuenta.IdUsuario_Cta = usuario.IdUsuario_U)" +  
			"where  usuario.IdUsuario_U = '" + idUsuario + "'"; 
			try 
			{
				conexion.Open();
				rs= conexion.query(consulta);
				while(rs.next())
				{
					Cuenta cta= new Cuenta();
					
					cta.setNumCuenta_Cta(rs.getInt(1));
					cta.getIdUsuario_Cta().setIdUsuario_U(rs.getInt(2));
					cta.setFechaCreacion_Cta(rs.getDate(3));
					cta.setCBU_Cta(rs.getInt(5));
					cta.setSaldo_Cta(rs.getFloat(6));
					cuenta.add(cta);
				}
				
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				conexion.close();
			}
			return cuenta;
		}


		@Override
		public boolean transaccionCuentaPorUsuario(int numCta, String cbuOrigen, float saldo, String cbuDestino) {
			Connection connection = null;
			conexion= new conexion();
			PreparedStatement preparedStatement = null;
			try {
				
				connection = conexion.Open();
				String text = " UPDATE bd_tpint_grupo_6_lab4.cuenta SET Saldo_Cta = Saldo_Cta ";
				String query = "";
				
				if(!cbuOrigen.isEmpty()) {
					query = text + " - " + saldo + " WHERE CBU_Cta = " + "'"+ cbuOrigen + "'";					
				}
				else {
					query = text + " + " + saldo + " WHERE CBU_Cta = " + "'"+ cbuDestino + "'";					
				}
				
				Date fechaCreacionDate = new Date();
				java.sql.Date sqlDate = new java.sql.Date(fechaCreacionDate.getTime());
				String estado = "Aprobado" ;
				// Crear una declaración preparada con la consulta SQL
				preparedStatement = connection.prepareStatement(query);

	            // Establece los parámetros
	            preparedStatement.setFloat(1, saldo);
	            preparedStatement.setString(2, (!cbuOrigen.isEmpty()) ? cbuOrigen : cbuDestino);

	            // Ejecuta la actualización
	            preparedStatement.executeUpdate();

	            // Si llegamos aquí, la actualización fue exitosa
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            // Cierra los recursos
	            try {
	                if (preparedStatement != null) {
	                    preparedStatement.close();
	                }
	                if (connection != null) {
	                    connection.close();
	                }
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
						
			return true;
		}


		@Override
		public boolean validarSaldo(int numCtaOrigen, float importe) {
			ResultSet rs; //Guarda el resultado de la query
			conexion= new conexion();
			String consulta = "Select Saldo_Cta from cuenta where NumCuenta_Cta ="+ numCtaOrigen;
			boolean esValido = true;
			float saldo = 0;
			
			
			try 
			{
				conexion.Open();
				rs= conexion.query(consulta);
				while(rs.next()) {
					saldo = rs.getFloat(1);
				}
				System.out.println("saldo: "+ saldo);
				
				if (saldo >= importe) {
					esValido = true;
				}else {
					esValido = false;
				}
				
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				conexion.close();
			}
			return esValido;
		}
				

}
