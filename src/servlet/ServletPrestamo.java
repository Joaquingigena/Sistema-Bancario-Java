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
import negocioImpl.MovimientoNegocioImpl;
import negocioImpl.PrestamosNegocioImpl;
import negocioImpl.UsuarioNegocioImpl;

@WebServlet("/ServletPrestamo")
public class ServletPrestamo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PrestamosNegocioImpl preNeg = new PrestamosNegocioImpl();
	private CuentaNegocioImpl cuentaNegocioImpl = new CuentaNegocioImpl();
	private MovimientoNegocioImpl movNeg = new MovimientoNegocioImpl();
	
	//Tipos de movimientos
	public static final int ALTA_CUENTA = 1; 
	public static final int ALTA_PRESTAMO = 2;
	public static final int PAGO_PRESTAMO = 3;
	public static final int TRANSFERENCIA = 4;
	public static final int EXTRACCION = 5;
       

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
		RequestDispatcher dispatcher;
		String nombre = request.getParameter("usuario");
		
		if(request.getParameter("btnFiltrar")!=null) {
			
			String campo= request.getParameter("ddlCampo");
			String criterio= request.getParameter("ddlCriterio");
			String filtro= request.getParameter("filtro");
			
			request.setAttribute("cargarPrestamos" ,preNeg.queryFiltro(campo, criterio, filtro));
			
			dispatcher = request.getRequestDispatcher("/AdmPrestamos.jsp");
			dispatcher.forward(request, response);
		}
		/*
		if(request.getParameter("btnAceptarPrestamo") != null) {

			int numPrestamo =Integer.parseInt(request.getParameter("numPrestamo"));

			if(preNeg.altaPrestamo(numPrestamo)){
				request.setAttribute("isCreated", true);
			}else {
				request.setAttribute("isCreated", false);
			}

			response.sendRedirect("/TPIntegrador_Grupo_6/ServletPrestamo?Param=listarPrestamos");
		}
		if(request.getParameter("btnRechazarPrestamo") != null) {

			int numPrestamo =Integer.parseInt(request.getParameter("numPrestamo"));

			if(preNeg.deletePrestamo(numPrestamo)){
				request.setAttribute("isCreated", true);
			}else {
				request.setAttribute("isCreated", false);
			}

			response.sendRedirect("/TPIntegrador_Grupo_6/ServletPrestamo?Param=listarPrestamos");
		}
		
		
		if (request.getParameter("btnSolicitarPrestamo") != null) {
			int numCtaOrigen = Integer.parseInt(request.getParameter("ddlCuentaOrigen"));
			int cuotas = Integer.parseInt(request.getParameter("ddlCuotas"));
			float importe = Float.parseFloat(request.getParameter("monto"));
			float importePrestamo = (float) (importe*0.70);
			
			
			String msgString = "";
			if(preNeg.validarPrestamo(numCtaOrigen)) {
				//acá se ejecuta el trigger actualizarSaldoCuentas despues de hacer el insert
				boolean prestado = preNeg.insertPrestamo(numCtaOrigen,importePrestamo,importe,cuotas,false);
				
				if (prestado) {
					msgString = " Prestamo exitoso, a la espera de confirmacion";
					request.setAttribute("msgTransferencia", msgString);
				}				
			}
			else {
				msgString = " No puede tener mas de un prestamo activo en la misma cuenta";
				request.setAttribute("msgTransferencia", msgString);
			}	
			
			
		}
		List<Cuenta> cuentas = new ArrayList<Cuenta>();
		cuentas = cuentaNegocioImpl.listarCuentasPorUsuario(nombre);
		request.setAttribute("cuentas", cuentas);
		dispatcher = request.getRequestDispatcher("/Prestamos.jsp?usuario" + nombre);
		dispatcher.forward(request, response);*/
	}
	
	}


