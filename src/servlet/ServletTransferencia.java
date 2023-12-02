package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoImpl.UsuarioDaoImp;
import entidades.Cuenta;
import entidades.Movimientos;
import entidades.Personas;
import negocioImpl.CuentaNegocioImpl;
import negocioImpl.MovimientoNegocioImpl;
import negocioImpl.UsuarioNegocioImpl;

/**
 * Servlet implementation class ServletTransferencia
 */
@WebServlet("/ServletTransferencia")
public class ServletTransferencia extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MovimientoNegocioImpl movNeg = new MovimientoNegocioImpl();
	private CuentaNegocioImpl cuentaNegocioImpl = new CuentaNegocioImpl();
	private UsuarioNegocioImpl usuarioNegocioImpl = new UsuarioNegocioImpl();
	
	//Tipos de movimientos
	public static final int ALTA_CUENTA = 1; 
	public static final int ALTA_PRESTAMO = 2;
	public static final int PAGO_PRESTAMO = 3;
	public static final int TRANSFERENCIA = 4;
	public static final int EXTRACCION = 5;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletTransferencia() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher;
		String nombre = request.getParameter("usuario");
		
		List<Movimientos> movimientos = new ArrayList<Movimientos>();
		List<Cuenta> cuentas = new ArrayList<Cuenta>();
		cuentas = cuentaNegocioImpl.listarCuentasPorUsuario(nombre);
		if (request.getParameter("Param") != null) {

			String opcion = request.getParameter("Param").toString();
			
			switch (opcion) {

			case "listarMovimientos":

				movimientos = movNeg.obtenerMovimientosPorUsuario(nombre);

				request.setAttribute("Movimientos", movimientos);
				request.setAttribute("cuentas", cuentas);

				dispatcher = request.getRequestDispatcher("/Movimientos.jsp?usuario" + nombre);
				dispatcher.forward(request, response);

				break;
			case "transferencias":
				request.setAttribute("cuentas", cuentas);
				RequestDispatcher rd = request.getRequestDispatcher("/Transferencias.jsp?usuario" + nombre);
				rd.forward(request, response);	
				break;
			case "prestamos":
				dispatcher = request.getRequestDispatcher("/Prestamos.jsp?usuario" + nombre);
				dispatcher.forward(request, response);
				break;
			case "pagos":
				dispatcher = request.getRequestDispatcher("/PagosPrestamos.jsp?usuario" + nombre);
				dispatcher.forward(request, response);
				break;
			case "misDatos":
				dispatcher = request.getRequestDispatcher("/MisDatos.jsp?usuario" + nombre);
				dispatcher.forward(request, response);
				break;

			default:

				break;
			}
		}
		
		if (request.getParameter("validarDatos") != null) {
			String opcion = request.getParameter("validarDatos").toString();
			Personas listPersonas = new Personas();
			
			switch (opcion) {
				
			case "Verificar datos" :
				String cbuDestino = request.getParameter("CBUDestino");
				listPersonas = usuarioNegocioImpl.getUsuarioPorCBU(cbuDestino);
				
				request.setAttribute("listPersonas", listPersonas);
				System.out.println("persona: "+ listPersonas.getApellido_P());
				
				request.setAttribute("cuentas", cuentas);
				request.setAttribute("datosOk", true);
				
				RequestDispatcher rd = request.getRequestDispatcher("/Transferencias.jsp?usuario" + nombre);
				rd.forward(request, response);	
				
				break;
			
			}
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher;
		String nombre = request.getParameter("usuario");
		
		if (request.getParameter("btnTransferir") != null) {
			int numCtaOrigen = Integer.parseInt(request.getParameter("ddlCuentaOrigen"));
			int cbuDestino = Integer.parseInt(request.getParameter("CBUDestino"));
			String detalle = request.getParameter("txtDetalle");
			float importe = Float.parseFloat(request.getParameter("txtImporte"));
			
			int numCtaDestino = cuentaNegocioImpl.obtenerNumCuenta(cbuDestino);
			
			String msgString = "";
			if(cuentaNegocioImpl.validarSaldo(numCtaOrigen, importe)) {
				//acá se ejecuta el trigger actualizarSaldoCuentas despues de hacer el insert
				boolean creado = movNeg.insertMovimientoPorUsuario(numCtaOrigen, numCtaDestino, detalle, importe, TRANSFERENCIA, true);
				
				if (creado) {
					msgString = " Transferencia exitosa";
					request.setAttribute("msgTransferencia", msgString);
				}
				else {
					msgString = " Transferencia rechazada";
					request.setAttribute("msgTransferencia", msgString);
				}				
			}
			else {
				msgString = " Saldo insuficiente para realizar operacion";
				request.setAttribute("msgTransferencia", msgString);
			}	
			System.out.println(numCtaOrigen + " " + numCtaDestino + " " +  detalle + " " + importe);
			
			
		}
		List<Cuenta> cuentas = new ArrayList<Cuenta>();
		cuentas = cuentaNegocioImpl.listarCuentasPorUsuario(nombre);
		request.setAttribute("cuentas", cuentas);
		dispatcher = request.getRequestDispatcher("/Transferencias.jsp?usuario" + nombre);
		dispatcher.forward(request, response);
	}

}
