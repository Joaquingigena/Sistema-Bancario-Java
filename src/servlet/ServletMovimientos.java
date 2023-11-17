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
	
        int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
        int numCuenta = Integer.parseInt(request.getParameter("numCuenta"));    
        
        List<Movimientos> movimientos = movNeg.obtenerMovimientosPorUsuario(idUsuario, numCuenta);
        
        request.setAttribute("movimientos", movimientos);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/movimiento.jsp");
        dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
