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

import entidades.Cuenta;
import entidades.Movimientos;
import negocioImpl.CuentaNegocioImpl;
import negocioImpl.MovimientoNegocioImpl;

/**
 * Servlet implementation class ServletTransferencia
 */
@WebServlet("/ServletTransferencia")
public class ServletTransferencia extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MovimientoNegocioImpl movNeg = new MovimientoNegocioImpl();
	private CuentaNegocioImpl cuentaNegocioImpl = new CuentaNegocioImpl();
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher;
		String nombre = request.getParameter("usuario");
		
		if (request.getParameter("btnTransferir") != null) {
			String ddlString = request.getParameter("ddlCuentaOrigen");
			String cbuDestino = request.getParameter("CBUDestino");
			String detalle = request.getParameter("txtDetalle");
			String importe = request.getParameter("txtImporte");
			System.out.println(ddlString + " " + cbuDestino + " " +  detalle + " " + importe);
		}
		
		dispatcher = request.getRequestDispatcher("/Transferencias.jsp?usuario" + nombre);
		dispatcher.forward(request, response);
	}

}
