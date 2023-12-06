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

import negocioImpl.CuentaNegocioImpl;
import negocioImpl.MovimientoNegocioImpl;
import negocioImpl.PagoPresNegocioImpl;
import entidades.Cuenta;
import entidades.Movimientos;
import entidades.PagoCuotasPrestamo;
import entidades.Usuario;

@WebServlet("/ServletMovimientos")
public class ServletMovimientos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CuentaNegocioImpl cuentaNeg = new CuentaNegocioImpl();
	private MovimientoNegocioImpl movNeg = new MovimientoNegocioImpl();
	private CuentaNegocioImpl cuentaNegocioImpl = new CuentaNegocioImpl();
	private PagoPresNegocioImpl pagoNeg = new PagoPresNegocioImpl();
	public ServletMovimientos() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher;
		String nombre = request.getParameter("usuario");
		///ACA NOSE COMO SEGUIR 
		///int numPrestamo = Integer.parseInt(request.getParameter("ddlCuotas"));
		
		List<Movimientos> movimientos = new ArrayList<Movimientos>();
		List<Cuenta> cuentas = new ArrayList<Cuenta>();
		List<PagoCuotasPrestamo> listaCuota = new ArrayList<PagoCuotasPrestamo>();
		if(cuentas.isEmpty()) cuentas = cuentaNegocioImpl.listarCuentasPorUsuario(nombre);
		///if(listaCuota.isEmpty()) listaCuota = pagoNeg.listarCuotas(numPrestamo);
		
		if(request.getParameter("buscarCuenta") != null) {
			
			int numCuenta = Integer.parseInt(request.getParameter("numCuenta"));
			
			if(numCuenta == 0) {
				movimientos = movNeg.obtenerMovimientosPorUsuario(nombre);
			}
			else {
				movimientos = movNeg.getMovimientosPorCuenta(numCuenta);				
			}
			
			Cuenta cuentaFilter = cuentaNegocioImpl.obtenerCuenta(numCuenta);
			
			request.setAttribute("cuentaFilter", cuentaFilter);
			request.setAttribute("cuentas", cuentas);
			request.setAttribute("numCuenta", numCuenta);
			request.setAttribute("Movimientos", movimientos);

			dispatcher = request.getRequestDispatcher("/Movimientos.jsp?usuario=" + nombre);
			dispatcher.forward(request, response);		
		}
		
		if (listaCuota != null && !listaCuota.isEmpty()) {
			request.setAttribute("pagocuotasprestamo", listaCuota);
		}
		
		
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
				cargarCuentasDestino(request);
				RequestDispatcher rd = request.getRequestDispatcher("/Transferencias.jsp?usuario" + nombre);
				rd.forward(request, response);	
				break;
			case "prestamos":
				dispatcher = request.getRequestDispatcher("/Prestamos.jsp?usuario" + nombre);
				dispatcher.forward(request, response);
				break;
			case "pagos":
				request.setAttribute("cuentas" , cuentas);		
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
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
	
	private void cargarCuentasDestino(HttpServletRequest request) {
		ArrayList<Cuenta> listaCuentasDestino = cuentaNegocioImpl.obtenerTodos();
		request.setAttribute("listaCuentasDestino", listaCuentasDestino);
		
	}

}
