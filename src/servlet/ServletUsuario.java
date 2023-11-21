package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocioImpl.UsuarioNegocioImpl;

/**
 * Servlet implementation class ServletUsuario
 */

@WebServlet("/ServletUsuario")
public class ServletUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UsuarioNegocioImpl usuarioNegocioImpl = new UsuarioNegocioImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletUsuario() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario = request.getParameter("usuario");
		request.setAttribute("usuario" ,usuario);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("btnIngresar")!= null) {
			String usuario = request.getParameter("usuario"); 
			String pass = request.getParameter("password");
			RequestDispatcher dispatcher;
			
			int codValidacion = usuarioNegocioImpl.LoginUser(usuario, pass);
			System.out.println("codValidacion: "+codValidacion);
			switch (codValidacion) {
			case -1:// usuario no existe  o datos son inválidos
				String msgString = "Verifique los datos ingresados. Si no tiene cuenta REGISTRESE.";
				request.setAttribute("msgError", msgString);
				dispatcher = request.getRequestDispatcher("/Login.jsp");
				dispatcher.forward(request, response);
				break;
			case 0:
				request.setAttribute("nombre", usuario);	
				System.out.println("user: "+usuario);
				response.sendRedirect("/TPIntegrador_Grupo_6/ServletMovimientos?Param=listarMovimientos&usuario="+usuario);
				
				break;
			case 1: // usuario admin
				request.setAttribute("nombre", usuario);
				//dispatcher = request.getRequestDispatcher("/AdmCuentas.jsp");
				//dispatcher.forward(request, response);
				response.sendRedirect("/TPIntegrador_Grupo_6/ServletAdmin?btnSolicitudes=ver solicittudes&usuario="+usuario);
				break;

			default:
				dispatcher = request.getRequestDispatcher("/Inicio.jsp");
				dispatcher.forward(request, response);
				break;
			}
					
		}
	}

}
