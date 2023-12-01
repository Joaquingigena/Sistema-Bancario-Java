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

import org.apache.jasper.tagplugins.jstl.core.If;

import entidades.Cuenta;
import entidades.Cuotas;
import jdk.nashorn.internal.ir.RuntimeNode.Request;
import negocioImpl.CuentaNegocioImpl;
import negocioImpl.PrestamosNegocioImpl;

@WebServlet("/ServletPrestamo")
public class ServletPrestamo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PrestamosNegocioImpl preNeg = new PrestamosNegocioImpl();
	private CuentaNegocioImpl cuentaNegocioImpl = new CuentaNegocioImpl();
       

    public ServletPrestamo() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String nombre = request.getParameter("usuario");
		List<Cuenta> cuentas = new ArrayList<Cuenta>();
		cuentas = cuentaNegocioImpl.listarCuentasPorUsuario(nombre);
		List<Cuotas> cuotas = new ArrayList<Cuotas>();
		cuotas = preNeg.listarCuotas();
		if(request.getParameter("Param")!=null) {
			
			String opcion= request.getParameter("Param").toString();
			switch(opcion) {
	case "listarPrestamos":
		
		request.setAttribute("cargarPrestamos" ,preNeg.listarPrestamos());	
		RequestDispatcher dispatcher = request.getRequestDispatcher("/AdmPrestamos.jsp");
		dispatcher.forward(request, response);
		break;
	case "prestamos":
		request.setAttribute("cuentas", cuentas);
		request.setAttribute("cuotas", cuotas);
		dispatcher = request.getRequestDispatcher("/Prestamos.jsp?usuario" + nombre);
		dispatcher.forward(request, response);
		break;
			}
	if (request.getParameter("btnSolicitarPrestamo") != null) {
		
	PrestamosNegocioImpl PresNeg = new PrestamosNegocioImpl();
	
	int estado = 1;
	String monto = request.getParameter("monto").toString();
	int Cuotas = Integer.parseInt(request.getParameter("cuota").trim());
	int Cuenta = Integer.parseInt(request.getParameter("destino").trim());
	
	//alta de prestamos
	preNeg.agregarPrestamo(monto, Cuotas, Cuenta);
	
	
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
