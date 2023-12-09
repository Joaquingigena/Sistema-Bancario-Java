package servlet;

import java.io.IOException;
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

import entidades.Movimientos;
import negocioImpl.InformeNegocioImpl;

@WebServlet("/ServletInformes")
public class ServletInformes extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private InformeNegocioImpl infNeg= new InformeNegocioImpl();
       
 
    public ServletInformes() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		inicializarAdminInformesv2(request,response,null);
		String usuario = request.getParameter("usuario");
		request.setAttribute("usuario" ,usuario);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("btnFiltrar")!=null) {
					
					RequestDispatcher dispatcher;
					String campo= request.getParameter("ddlCampo");
					String criterio= request.getParameter("ddlCriterio");
					String filtro= request.getParameter("filtro");
					
					request.setAttribute("listaInformes" ,infNeg.queryFiltro(campo, criterio, filtro));
					
					dispatcher = request.getRequestDispatcher("/AdmInformes.jsp");
					dispatcher.forward(request, response);
				}
		if(request.getParameter("btnFiltrarFecha")!=null)
		{
			RequestDispatcher dispatcher;
			String fechaHoraInicio = request.getParameter("fechaInicio");
			String fechaHoraFin = request.getParameter("fechaFin");
			
			SimpleDateFormat formatoHTML = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
			
			try {
			    // Convertir formato de fecha y hora del formulario a un formato compatible con TIMESTAMP en la base de datos
			    SimpleDateFormat formatoBD = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			    Date fechaInicio = formatoHTML.parse(fechaHoraInicio);
			    Date fechaFin = formatoHTML.parse(fechaHoraFin);

			    // Formatear las fechas al formato de TIMESTAMP de la base de datos
			    String fechaHoraInicioBD = formatoBD.format(fechaInicio);
			    String fechaHoraFinBD = formatoBD.format(fechaFin);
			    

			    
			    int movimientos= infNeg.filtroPorMovimientosRealizado(fechaHoraInicioBD, fechaHoraFinBD);
			    float montoPrestamos= infNeg.filtroPorMontoPrestamos(fechaHoraInicioBD, fechaHoraFinBD);
			    float montoCuotas = infNeg.filtroPorMontoCuotas(fechaHoraInicioBD, fechaHoraFinBD);
				int cantUsuarios = infNeg.filtroCantUsuariosSF();
				int cantPrestamos = infNeg.filtroCantPrestamosSF();
			    request.setAttribute("movimientos", movimientos);
			    request.setAttribute("MontoPrestamos", montoPrestamos);
			    request.setAttribute("MontoCuotas", montoCuotas);
			    request.setAttribute("cantU", cantUsuarios);
			    request.setAttribute("cantP", cantPrestamos);


			} catch (ParseException e) {
			    e.printStackTrace();
			    
			}
			
			dispatcher = request.getRequestDispatcher("/AdmInformes.jsp");
			dispatcher.forward(request, response);

		}
		
	}
	
	public void inicializarAdminInformes(HttpServletRequest request, HttpServletResponse response, List<Movimientos> listaMovimientos) throws ServletException, IOException {
		System.out.println("lista informes" + listaMovimientos);
		if(listaMovimientos == null) {	
			System.out.println("entraa???");
			List<Movimientos> listaMovimientosCompleta = infNeg.listarMovimientos();
			request.setAttribute("listaInformes", listaMovimientosCompleta); 
		}
		else {
			request.setAttribute("listaInformes", listaMovimientos); 
		}
		
		
    	RequestDispatcher rd = request.getRequestDispatcher("/AdmInformes.jsp");  
		rd.forward(request, response);	
	}
	
	public void inicializarAdminInformesv2(HttpServletRequest request, HttpServletResponse response, List<Movimientos> listaMovimientos) throws ServletException, IOException {
		
		if (request.getParameter("Param") != null) {

			String opcion = request.getParameter("Param").toString();
			
			/*System.out.println("lista informes" + listaMovimientos);*/
			
			switch (opcion) {

			case "listarInformes":
				
				/*if(listaMovimientos == null) {	
					System.out.println("entraa???");
					List<Movimientos> listaMovimientosCompleta = infNeg.listarMovimientos();
					request.setAttribute("listaInformes", listaMovimientosCompleta); 
				}
				else {
					request.setAttribute("listaInformes", listaMovimientos); 
				}*/

				float montoPrestamos = infNeg.filtroPorMontoPrestamosSF();
				float montoCuotas = infNeg.filtroPorMontoCuotasSF();
				int cantUsuarios = infNeg.filtroCantUsuariosSF();
				int cantPrestamos = infNeg.filtroCantPrestamosSF();
				int movimientos = infNeg.filtroPorMovimientosRealizadoSF();

				
			    request.setAttribute("movimientos", movimientos);
			    request.setAttribute("MontoPrestamos", montoPrestamos);
			    request.setAttribute("MontoCuotas", montoCuotas);
			    request.setAttribute("cantU", cantUsuarios);
			    request.setAttribute("cantP", cantPrestamos);

				RequestDispatcher rd = request.getRequestDispatcher("/AdmInformes.jsp");  
				rd.forward(request, response);	

				break;
	
	}
		}

}
	
}
