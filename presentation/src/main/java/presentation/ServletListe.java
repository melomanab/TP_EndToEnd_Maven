package presentation;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domaine.Client;
import service.ServiceClient;

/**
 * Servlet implementation class ServletListe
 */
@WebServlet("/ServletListe")
public class ServletListe extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletListe() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 
		response.getWriter().append("Test connextion Servlet ServletListe: OK\n").append(request.getContextPath());

		// 1.--Recuperations information request : NE SAPPLIQUE PAS

		// 2.--Solliciter la couche service
		ServiceClient servC = new ServiceClient();
		ArrayList<Client> maListe = servC.getListeClients();
		
		response.getWriter().append("Test liste charg�e:" + !maListe.isEmpty() +"\n").append(request.getContextPath());


		// 3. --Elaborer reponse � envoyer au client
		// Pour passer la liste, il faut la rajouter comme attribut � la session 
		HttpSession maSession = request.getSession();
		maSession.setAttribute("list", maListe);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/ListeClients.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
