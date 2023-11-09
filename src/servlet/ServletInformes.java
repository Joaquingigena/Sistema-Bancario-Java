package servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Movimientos;
import negocioImpl.InformeNegocioImpl;

@WebServlet("/ServletInformes")
public class ServletInformes extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private InformeNegocioImpl infNeg= new InformeNegocioImpl();
       
 
    public ServletInformes() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		inicializarAdminInformes(request,response,null);
		String usuario = request.getParameter("usuario");
		request.setAttribute("usuario" ,usuario);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	
	public void inicializarAdminInformes(HttpServletRequest request, HttpServletResponse response, List<Movimientos> listaMovimientos) throws ServletException, IOException {
		if(listaMovimientos == null) {		
			List<Movimientos> listaMovimientosCompleta = infNeg.listarMovimientos();
			request.setAttribute("listaInformes", listaMovimientosCompleta); 
		}
		else {
			request.setAttribute("listaInformes", listaMovimientos); 
		}
		
		
    	RequestDispatcher rd = request.getRequestDispatcher("/AdmInformes.jsp");  
		rd.forward(request, response);	
	}

}
