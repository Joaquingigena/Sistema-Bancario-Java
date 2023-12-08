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

import entidades.Prestamos;
import entidades.Usuario;
import entidades.Cuenta;
import entidades.PagoCuotasPrestamo;
import entidades.Personas;
import negocioImpl.AdminNegocioImpl;
import negocioImpl.CuentaNegocioImpl;
import negocioImpl.InformeNegocioImpl;
import negocioImpl.PagoPresNegocioImpl;
import negocioImpl.PrestamosNegocioImpl;

@WebServlet("/ServletPagoPrestamos")
public class ServletPagoPrestamos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CuentaNegocioImpl cuentaNegocioImpl = new CuentaNegocioImpl();
	private PagoPresNegocioImpl pagoNeg = new PagoPresNegocioImpl();
	private AdminNegocioImpl admNeg = new AdminNegocioImpl();
	private PrestamosNegocioImpl presNeg = new PrestamosNegocioImpl();
       
 
    public ServletPagoPrestamos() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher;
		String nombre = request.getParameter("usuario");
		List<Cuenta> cuentas = new ArrayList<Cuenta>();
		if(cuentas.isEmpty()) cuentas = cuentaNegocioImpl.listarCuentasPorUsuario(nombre);
		if (request.getParameter("Param") != null) {

			String opcion = request.getParameter("Param").toString();
			
			switch (opcion) {
			case "pagos":
				request.setAttribute("cuentas" , cuentas);		
				dispatcher = request.getRequestDispatcher("/PagosPrestamos.jsp?usuario" + nombre);
				dispatcher.forward(request, response);
				break;

			default:

				break;
			}
		}
		if (request.getParameter("validarDatos") != null) {
			String opcion = request.getParameter("validarDatos").toString();
			PagoCuotasPrestamo pago = null;
			
			switch (opcion) {
				
			case "Verificar datos" :
				
					int numCuenta = Integer.parseInt(request.getParameter("ddlCuenta"));
					pago = pagoNeg.getPagoPorCuenta(numCuenta);
					request.setAttribute("listpago", pago);

				
				
				
				request.setAttribute("cuentas", cuentas);
				request.setAttribute("datosOk", true);
				
				RequestDispatcher rd = request.getRequestDispatcher("/PagosPrestamos.jsp?usuario=" + nombre);
				rd.forward(request, response);	
				
				break;
			
			}
			
		}

		
		

		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
