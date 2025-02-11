package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocioImpl.AdminNegocioImpl;
import negocioImpl.CuentaNegocioImpl;
import negocioImpl.MovimientoNegocioImpl;
import negocioImpl.PagoPresNegocioImpl;
import negocioImpl.PrestamosNegocioImpl;
import entidades.Cuenta;
import entidades.Movimientos;
import entidades.PagoCuotasPrestamo;
import entidades.Prestamos;
import entidades.Usuario;

@WebServlet("/ServletMovimientos")
public class ServletMovimientos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CuentaNegocioImpl cuentaNeg = new CuentaNegocioImpl();
	private MovimientoNegocioImpl movNeg = new MovimientoNegocioImpl();
	private CuentaNegocioImpl cuentaNegocioImpl = new CuentaNegocioImpl();
	private PagoPresNegocioImpl pagoNeg = new PagoPresNegocioImpl();
	private AdminNegocioImpl admNeg = new AdminNegocioImpl();
	private PrestamosNegocioImpl presNeg = new PrestamosNegocioImpl();
	public ServletMovimientos() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher;
		String nombre = request.getParameter("usuario");
		Usuario cliente= admNeg.obtenerUsuariov2(nombre);
		List<Prestamos> prestamosxCliente = presNeg.listarPrestamos(cliente.getIdUsuario_U());
		
		System.out.println("nombre : " + nombre);
		System.out.println("cliente : " + cliente);
		System.out.println("lista : " + prestamosxCliente);
		
		///ACA NOSE COMO SEGUIR 
		///int numPrestamo = Integer.parseInt(request.getParameter("ddlCuotas"));
		
		List<Movimientos> movimientos = new ArrayList<Movimientos>();
		List<Cuenta> cuentas = new ArrayList<Cuenta>();
		List<PagoCuotasPrestamo> listaCuota = new ArrayList<PagoCuotasPrestamo>();
		if(cuentas.isEmpty()) cuentas = cuentaNegocioImpl.listarCuentasPorUsuario(nombre);
		///if(listaCuota.isEmpty()) listaCuota = pagoNeg.listarCuotas(numPrestamo);
		
		if(request.getParameter("buscarCuenta") != null) {
			
			int numCuenta = Integer.parseInt(request.getParameter("numCuenta"));
			
			if(numCuenta == 0) {
				movimientos = movNeg.obtenerMovimientosPorUsuario(nombre);
			}
			else {
				movimientos = movNeg.getMovimientosPorCuenta(numCuenta);				
			}
			
			Cuenta cuentaFilter = cuentaNegocioImpl.obtenerCuenta(numCuenta);
			
			request.setAttribute("cuentaFilter", cuentaFilter);
			request.setAttribute("cuentas", cuentas);
			request.setAttribute("numCuenta", numCuenta);
			request.setAttribute("Movimientos", movimientos);

			dispatcher = request.getRequestDispatcher("/Movimientos.jsp?usuario=" + nombre);
			dispatcher.forward(request, response);		
		}
		
		if (listaCuota != null && !listaCuota.isEmpty()) {
			request.setAttribute("pagocuotasprestamo", listaCuota);
		}
		
		
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
				cargarCuentasDestino(request);
				RequestDispatcher rd = request.getRequestDispatcher("/Transferencias.jsp?usuario" + nombre);
				rd.forward(request, response);	
				break;
			case "prestamos":
				dispatcher = request.getRequestDispatcher("/Prestamos.jsp?usuario" + nombre);
				dispatcher.forward(request, response);
				break;
			case "pagos":
				request.setAttribute("cuentas" , cuentas);		
				System.out.println("prestamos: " + prestamosxCliente);
				request.setAttribute("prestamos" , prestamosxCliente);	
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("usuario");
		
		
		if(request.getParameter("btnFiltrarFechaMovimiento")!=null)
		{
			RequestDispatcher dispatcher;
			
			
			
			String fechaHoraInicio = request.getParameter("fechaInicio");
			String fechaHoraFin = request.getParameter("fechaFin");
			int numCuenta = Integer.parseInt(request.getParameter("cuenta"));
			List<Movimientos> movimientos = new ArrayList<Movimientos>();
			List<Cuenta> cuentas = new ArrayList<Cuenta>();
			if(cuentas.isEmpty()) cuentas = cuentaNegocioImpl.listarCuentasPorUsuario(nombre);
			Cuenta cuentaFilter = cuentaNegocioImpl.obtenerCuenta(numCuenta);
			
			
			
			SimpleDateFormat formatoHTML = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
			
			try {
			    // Convertir formato de fecha y hora del formulario a un formato compatible con TIMESTAMP en la base de datos
			    SimpleDateFormat formatoBD = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			    Date fechaInicio = formatoHTML.parse(fechaHoraInicio);
			    Date fechaFin = formatoHTML.parse(fechaHoraFin);

			    // Formatear las fechas al formato de TIMESTAMP de la base de datos
			    String fechaHoraInicioBD = formatoBD.format(fechaInicio);
			    String fechaHoraFinBD = formatoBD.format(fechaFin);
			    
			    System.out.println(fechaHoraInicioBD);
			    System.out.println(fechaHoraFinBD);
			    System.out.println(nombre);
			    System.out.println(numCuenta);
			    
			    

			    if(numCuenta == 0)
			    {
			    	movimientos= movNeg.filtroFechaPorUsuario(fechaHoraInicioBD, fechaHoraFinBD, nombre);
				    request.setAttribute("Movimientos", movimientos);
				    request.setAttribute("cuentas", cuentas);
				    request.setAttribute("cuentaFilter", cuentaFilter);
			    }
			    else
			    {
			    movimientos= movNeg.filtroFechaPorCuenta(fechaHoraInicioBD, fechaHoraFinBD, numCuenta);
			    request.setAttribute("Movimientos", movimientos);
			    request.setAttribute("cuentas", cuentas);
				request.setAttribute("cuentaFilter", cuentaFilter);
			    }


			} catch (ParseException e) {
			    e.printStackTrace();
			    
			}
			
			dispatcher = request.getRequestDispatcher("/Movimientos.jsp?usuario=" + nombre);
			dispatcher.forward(request, response);

		}

		
	}
	
	private void cargarCuentasDestino(HttpServletRequest request) {
		ArrayList<Cuenta> listaCuentasDestino = cuentaNegocioImpl.obtenerTodos();
		request.setAttribute("listaCuentasDestino", listaCuentasDestino);
		
	}

}
