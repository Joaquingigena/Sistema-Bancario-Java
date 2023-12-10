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
import entidades.Usuario;
import jdk.nashorn.internal.ir.RuntimeNode.Request;
import negocioImpl.AdminNegocioImpl;
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
	private UsuarioNegocioImpl userImpl = new UsuarioNegocioImpl();
	
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
		
		System.out.println(request.getAttribute("Usuario"));
		
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
		
		int id = userImpl.idUsuario(nombre);
		request.setAttribute("idUser", id);
		
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
		if(request.getParameter("btnQuitarFiltro")!=null) {
			request.setAttribute("cargarPrestamos" , preNeg.listarPrestamos());	
			dispatcher = request.getRequestDispatcher("/AdmPrestamos.jsp");
			dispatcher.forward(request, response);
		}
		
		if(request.getParameter("btnAceptarPrestamo") != null) {

			int numPrestamo = Integer.parseInt(request.getParameter("txtPrestamo"));
			int numCuenta = Integer.parseInt(request.getParameter("txtCuenta1"));
			int idUsuario = Integer.parseInt(request.getParameter("txtCliente"));
			float importe = Float.parseFloat(request.getParameter("txtImporte"));
			
			// Se utilizó para probar resultados por consola --------------------
			System.out.println("NUMERO DE PRESTAMO: " + numPrestamo);
			System.out.println("NUMERO DE CUENTA: " + numCuenta);
			System.out.println("NUMERO DE USUARIO: " + idUsuario);
			System.out.println("IMPORTE: " + importe);
			//--------------------------------------------------------------------
			
			/*if(preNeg.altaPrestamo(numPrestamo)){
				request.setAttribute("isCreated", true);
			}else {
				request.setAttribute("isCreated", false);
			}*/
			
			preNeg.aceptarPrestamo(numPrestamo,numCuenta, idUsuario, importe);
			
			request.setAttribute("cargarPrestamos" ,preNeg.listarPrestamos());	
			dispatcher = request.getRequestDispatcher("/AdmPrestamos.jsp");
			dispatcher.forward(request, response);
		}
		if(request.getParameter("btnRechazarPrestamo") != null) {
			int numPrestamo = Integer.parseInt(request.getParameter("txtPrestamo"));
			int numCuenta = Integer.parseInt(request.getParameter("txtCuenta1"));
			int idUsuario = Integer.parseInt(request.getParameter("txtCliente"));
			float importe = Float.parseFloat(request.getParameter("txtImporte"));

			preNeg.rechazarPrestamo(numPrestamo,numCuenta, idUsuario, importe);
			
			request.setAttribute("cargarPrestamos" ,preNeg.listarPrestamos());	
			dispatcher = request.getRequestDispatcher("/AdmPrestamos.jsp");
			dispatcher.forward(request, response);
		}
		
		
		if (request.getParameter("btnSolicitarPrestamo") != null) {
			Usuario user = new Usuario();
			AdminNegocioImpl adminNeg = new AdminNegocioImpl();
			
			user = adminNeg.obtenerUsuariov2(nombre);
			request.setAttribute("Usuario", user);
			
			int idUser = Integer.parseInt(request.getParameter("IDusuario"));
			int numCtaOrigen = Integer.parseInt(request.getParameter("ddlCuentaOrigen"));
			int cuotas = Integer.parseInt(request.getParameter("ddlCuotas"));
			float importe = Float.parseFloat(request.getParameter("MontoTotal").toString());
			float importePrestamo = Float.parseFloat(request.getParameter("monto").toString());
			String plazo = request.getParameter("plazo").toString() + " Meses";//"24";
			boolean estado = false;
			boolean autorizado = true;
			
			String msgString = "";
			System.out.println("ID USUARIO:::: "+idUser);
			System.out.println("IMPORTE PRESTAMO:::: "+importePrestamo);
			
			if(!preNeg.validarPrestamo(numCtaOrigen)) {
				System.out.println("ERROOOOOOOOOR!!!!!");
				msgString = " No puede tener mas de un prestamo activo en la misma cuenta o ya tiene un prestamo a la espera de ser aceptado";
				request.setAttribute("msgPrestamo", msgString);
				
			}
			else {
				boolean prestado = preNeg.insertPrestamo(numCtaOrigen, idUser, importe, importePrestamo, plazo, cuotas, estado, autorizado);
				
				if(prestado)
				{
					System.out.println("Solicitud exitosa!!");
					msgString = " Prestamo exitoso, a la espera de confirmacion";
					request.setAttribute("msgTransferencia", msgString);
				}
				else
				{
					msgString = " Error al solicitar el Prestamo";
					request.setAttribute("msgError", msgString);
				}
				
			}
			
			List<Cuenta> cuentas = new ArrayList<Cuenta>();
			cuentas = cuentaNegocioImpl.listarCuentasPorUsuario(nombre);
			List<Cuotas> cuo = new ArrayList<Cuotas>();
			cuo = preNeg.listarCuotas();
			
			request.setAttribute("usuario", nombre);
			request.setAttribute("cuentas", cuentas);
			request.setAttribute("cuotas", cuo);
			
			RequestDispatcher rd = request.getRequestDispatcher("/Prestamos.jsp");
			rd.forward(request, response);
			
				
		}
		
		
		List<Cuenta> cuentas = new ArrayList<Cuenta>();
		cuentas = cuentaNegocioImpl.listarCuentasPorUsuario(nombre);
		request.setAttribute("cuentas", cuentas);
		dispatcher = request.getRequestDispatcher("/Prestamos.jsp?usuario" + nombre);
		dispatcher.forward(request, response);
	}
	
	}
