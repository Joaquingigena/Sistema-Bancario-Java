package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import negocioImpl.MovimientoNegocioImpl;
import entidades.Movimientos;;

@WebServlet("/ServletMovimientos")
public class ServletMovimientos extends HttpServlet {
	private static final long serialVersionUID = 1L;
    // private CuentaNegocioImpl cuentaNeg = new CuentaNegocioImpl();
	private MovimientoNegocioImpl movNeg = new MovimientoNegocioImpl();
   
    public ServletMovimientos() {
        super();     
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	RequestDispatcher dispatcher;
	if(request.getParameter("Param")!=null) {
			
		String opcion= request.getParameter("Param").toString();
		String nombre = request.getParameter("usuario"); 
		
			switch(opcion) {
			
			case "listarMovimientos":
				
		        List<Movimientos> movimientos = movNeg.obtenerMovimientosPorUsuario(nombre);
		        
		        request.setAttribute("Movimientos", movimientos);
		        dispatcher = request.getRequestDispatcher("/Movimientos.jsp?usuario"+nombre);
		        dispatcher.forward(request, response);
				
				break;
			case "transferencias" :
				dispatcher = request.getRequestDispatcher("/Transferencias.jsp?usuario"+nombre);
		        dispatcher.forward(request, response);
				break;
			case "prestamos" :
				dispatcher = request.getRequestDispatcher("/Prestamos.jsp?usuario"+nombre);
		        dispatcher.forward(request, response);
				break;
			case "pagos" :
				dispatcher = request.getRequestDispatcher("/PagosPrestamos.jsp?usuario"+nombre);
		        dispatcher.forward(request, response);
				break;
			case "misDatos" :
				dispatcher = request.getRequestDispatcher("/MisDatos.jsp?usuario"+nombre);
		        dispatcher.forward(request, response);
				break;
			default:
					
				break;
			}
		 }
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
