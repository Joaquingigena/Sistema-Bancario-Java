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

import negocioImpl.CuentaNegocioImpl;


@WebServlet("/ServletCuenta")
public class ServletCuenta extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CuentaNegocioImpl cuentaNeg = new CuentaNegocioImpl();
       
 
    public ServletCuenta() {
        super();

    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		inicializarAdminCuenta(request,response,null);
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

			System.out.println("tipoCuenta: "+tipoCuenta);
			System.out.println("numCbu: "+numCbu);
			System.out.println("montoInicial: "+montoInicial);
			System.out.println("detalleString: "+detalleString);
			
			if(cuentaNeg.altaCuenta(idUsuario, tipoCuenta, numCbu, montoInicial, detalleString, tipoMovimiento )){
				request.setAttribute("isCreated", true);
			}else {
				request.setAttribute("isCreated", false);
			}
			
		}
		
		response.sendRedirect("/TPIntegrador_Grupo_6/ServletAdmin?Param=listarClientes");
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
