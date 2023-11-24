package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocioImpl.PrestamosNegocioImpl;

@WebServlet("/ServletPrestamo")
public class ServletPrestamo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PrestamosNegocioImpl preNeg = new PrestamosNegocioImpl();
       

    public ServletPrestamo() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		response.getWriter().append("Served at: ").append(request.getContextPath());
		if(request.getParameter("Param")!=null) {
			
			String opcion= request.getParameter("Param").toString();
			switch(opcion) {
	case "listarPrestamos":
		
		request.setAttribute("cargarPrestamos" ,preNeg.listarPrestamos());	
		RequestDispatcher dispatcher = request.getRequestDispatcher("/AdmPrestamos.jsp");
		dispatcher.forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		if(request.getParameter("btnFiltrar")!=null) {
			
			RequestDispatcher dispatcher;
			String campo= request.getParameter("ddlCampo");
			String criterio= request.getParameter("ddlCriterio");
			String filtro= request.getParameter("filtro");
			
			request.setAttribute("cargarPrestamos" ,preNeg.queryFiltro(campo, criterio, filtro));
			
			dispatcher = request.getRequestDispatcher("/AdmPrestamos.jsp");
			dispatcher.forward(request, response);
		}
	}

}
