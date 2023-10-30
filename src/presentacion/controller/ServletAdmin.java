package presentacion.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocioImpl.AdminNegocioImpl;

@WebServlet("/ServletAdmin")
public class ServletAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminNegocioImpl adminNeg= new AdminNegocioImpl();
       
 
    public ServletAdmin() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("Param")!=null) {
			
			String opcion= request.getParameter("Param").toString();
			
			switch(opcion) {
			
			case "listarClientes":
				
				request.setAttribute("cargar" ,adminNeg.listarUsuarios());
					
				RequestDispatcher dispatcher = request.getRequestDispatcher("/AdmClientes.jsp");
				dispatcher.forward(request, response);
				
				break;
			
			default:
				break;
			}
			
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
