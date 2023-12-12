package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Cuenta;
import entidades.TipoCuentas;
import negocioImpl.CuentaNegocioImpl;


@WebServlet("/ServletCuenta")
public class ServletCuenta extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CuentaNegocioImpl cuentaNeg = new CuentaNegocioImpl();


	public ServletCuenta() {
		super();

	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String usuario = request.getParameter("usuario");
		request.setAttribute("usuario" ,usuario);
		RequestDispatcher dispatcher;
		
		if(request.getParameter("Param")!=null) {
			inicializarAdminCuenta(request,response,null);
		}
		if(request.getParameter("eliminarCuenta")!=null) {

			int id=Integer.parseInt( request.getParameter("eliminarCuenta"));
			String msgEliminado= "";

			if(cuentaNeg.eliminarCuenta(id))
			{
				msgEliminado = "Cuenta eliminada correctamente";
				request.setAttribute("msgEliminado", msgEliminado);
			}
			else
			{
				msgEliminado = "Error al Eliminar";
				request.setAttribute("msgErrorEliminar", msgEliminado);
			}

			request.setAttribute("ListaCuentas" ,cuentaNeg.ListarCuentas());

			dispatcher = request.getRequestDispatcher("/AdmCuentas.jsp");
			dispatcher.forward(request, response);
		}

		if(request.getParameter("modificarCuenta")!=null) {

			int id2=Integer.parseInt( request.getParameter("modificarCuenta"));

			Cuenta cta= cuentaNeg.obtenerCuenta(id2);
			
			request.setAttribute("modificarv2", cta);
			
			// Obtengo la lista de Localidades desde la capa Negocio.
			List <TipoCuentas> ListaTipoCuentas = null;
			ListaTipoCuentas = cuentaNeg.ListarTipoCuentas();
			
			// Seteo la lista al request para enviarla a la pagina de regreso.
			if(ListaTipoCuentas!=null) {
				request.setAttribute("ListaTipoCuentas", ListaTipoCuentas);
			}

			dispatcher = request.getRequestDispatcher("/AdmModificarCuenta.jsp");
			dispatcher.forward(request, response);
		}
		if(request.getParameter("btnAceptarModificacionCuenta")!=null) {

			Cuenta cta = new Cuenta();
			TipoCuentas tc = new TipoCuentas();
			
			String msgMod= "";
			
			cta.setNumCuenta_Cta(Integer.parseInt(request.getParameter("hiddenId")));
			cta.setCBU_Cta(Integer.parseInt(request.getParameter("txtCBU")));
			cta.setSaldo_Cta(Float.parseFloat(request.getParameter("txtSaldo")));
			
			tc.setIdTipo_TC(Integer.parseInt(request.getParameter("ddlTipoCuentas")));
			
			cta.setIdTipoCuenta_Cta(tc);
			
			System.out.println("----------------------------------------------------");
			System.out.println(cta.toString());

			if(cuentaNeg.modificarCuenta(cta)) {
				msgMod = "Modificado con Exito";
				System.out.println(msgMod);
				request.setAttribute("msgModificado", msgMod);
			}
			else
			{
				msgMod = "Error al Modificar";
				System.out.println(msgMod);
				request.setAttribute("msgError", msgMod);
				
			}
			request.setAttribute("ListaCuentas" ,cuentaNeg.ListarCuentas());

			dispatcher = request.getRequestDispatcher("/AdmCuentas.jsp");
			dispatcher.forward(request, response);
		}
		if (request.getParameter("buscarCuenta")!=null) {
			
		}


	}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	if(request.getParameter("btnAltaCuenta") != null) {

		int idUsuario =Integer.parseInt(request.getParameter("idUsuario"));
		int tipoMovimiento = 1; // alta de cuenta
		float montoInicial = Float.parseFloat(request.getParameter("montoInicial"));
		String detalleString = request.getParameter("detalle");
		String tipoCuentaString = request.getParameter("radioBtn");
		int tipoCuenta = Integer.parseInt(tipoCuentaString);  
		int numCbu = Integer.parseInt(request.getParameter("nroCbu"));
		String msgAlta ="";

		System.out.println("tipoCuenta: "+tipoCuenta);
		System.out.println("numCbu: "+numCbu);
		System.out.println("montoInicial: "+montoInicial);
		System.out.println("detalleString: "+detalleString);

		if(cuentaNeg.altaCuenta(idUsuario, tipoCuenta, numCbu, montoInicial, detalleString, tipoMovimiento )){
			int cantidadCuenta = cuentaNeg.validarTotalCuentas(idUsuario);
			System.out.println("servlet cuentas: cantidad cuentas "+cantidadCuenta);
			request.setAttribute("totalCuentas", cantidadCuenta);
			request.setAttribute("isCreated", true);
			
			
			msgAlta = "Cuenta dada de Alta con Exito";
			System.out.println(msgAlta);
			request.setAttribute("msgAlta", msgAlta);
			
		}else {
			msgAlta = "Error al dar de Alta";
			System.out.println(msgAlta);
			request.setAttribute("msgErrorAlta", msgAlta);
			
			request.setAttribute("isCreated", false);
		}

		response.sendRedirect("/TPIntegrador_Grupo_6/ServletAdmin?Param=listarClientes");
	}
	
	if(request.getParameter("btnBuscar")!=null) {
		
		RequestDispatcher dispatcher;
		String filtro= request.getParameter("filtroValor").toString();
		
		if(filtro!=null ) {
			request.setAttribute("ListaCuentas" ,cuentaNeg.filtrarListaCuentas(filtro));
			
			dispatcher = request.getRequestDispatcher("/AdmCuentas.jsp");
			dispatcher.forward(request, response);
			
		}else {
			request.setAttribute("ListaCuentas" ,cuentaNeg.ListarCuentas());
			
			dispatcher = request.getRequestDispatcher("/AdmCuentas.jsp");
			dispatcher.forward(request, response);
		}
		
		
	}
	
	if(request.getParameter("btnFiltrar")!=null) {
		
		RequestDispatcher dispatcher;
		String campo= request.getParameter("ddlCampo");
		String criterio= request.getParameter("ddlCriterio");
		String filtro= request.getParameter("filtro");
		
		System.out.println(campo+criterio+filtro);
		
		
		request.setAttribute("ListaCuentas" ,cuentaNeg.queryFiltro(campo, criterio, filtro));
		
		dispatcher = request.getRequestDispatcher("/AdmCuentas.jsp");
		dispatcher.forward(request, response);
	}
	
	if(request.getParameter("btnQuitarFiltro")!=null) {
		request.setAttribute("ListaCuentas" ,cuentaNeg.ListarCuentas());	
		RequestDispatcher dispatcher = request.getRequestDispatcher("/AdmCuentas.jsp");
		dispatcher.forward(request, response);
	}

}


public void inicializarAdminCuenta(HttpServletRequest request, HttpServletResponse response, List<Cuenta> ListaCuentas) throws ServletException, IOException {
	if(ListaCuentas == null) {		
		List<Cuenta> listaCuentaCompleta = cuentaNeg.ListarCuentas();
		request.setAttribute("ListaCuentas", listaCuentaCompleta); 
	}
	else {
		request.setAttribute("ListaCuentas", ListaCuentas); 
	}


	RequestDispatcher rd = request.getRequestDispatcher("/AdmCuentas.jsp");  
	rd.forward(request, response);	
}

}
