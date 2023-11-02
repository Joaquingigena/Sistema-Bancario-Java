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
		doGet(request, response);
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
