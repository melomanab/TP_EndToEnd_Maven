package presentation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domaine.Client;
import service.ServiceClient;

/**
 * Servlet implementation class ServletFormulaire
 */
@WebServlet("/ServletFormulaire")
public class ServletFormulaire extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletFormulaire() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("doPost sur servlet  ").append(request.getContextPath());
		
		// 1.--Recup infos formulaire
				String vNom = request.getParameter("nom");
				String vPrenom = request.getParameter("prenom");
				int vAge = Integer.parseInt(request.getParameter("age"));
				int vIdConseiller = Integer.parseInt(request.getParameter("idConseiller"));
//				String vMail= request.getParameter("mail");
//				String vTel= request.getParameter("tel");
		
		// 2.--Passer les infos � couche service
				
			// new Service()...
				
				// --- Creer Client			
				ServiceClient servC = new ServiceClient();
				int ID_FICTIF = 1;
				Client monClient = new Client(ID_FICTIF, vNom, vPrenom, vAge, vIdConseiller);
				
				boolean resCreate = servC.createNewClient(monClient);		
				
		// 3.--Choisir la page � retourner au client
				// response.getWriter().append("/nClient cree: " + resCreate).append(request.getContextPath());
				RequestDispatcher distpatcher;
				
				if (resCreate) {
					distpatcher=request.getRequestDispatcher("/bravo.html");
				}else {
					distpatcher=request.getRequestDispatcher("/fail.html");
				}
	
				distpatcher.forward(request, response);
	}

}
