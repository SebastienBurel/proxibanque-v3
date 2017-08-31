package fr.gtm.projetwebservice.service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.gtm.projetwebservice.domaine.Conseiller;
import fr.gtm.projetwebservice.presentation.AuthentificationService;
import fr.gtm.projetwebservice.presentation.ConseillerService;


public class ValidAuthentification extends HttpServlet{

	private static final long serialVersionUID = 1L;
    
	private AuthentificationService authentificationService = new AuthentificationService();
	private ConseillerService conseillerService = new ConseillerService();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidAuthentification() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = null;		
		
		response.setContentType("text/html");
		
		// Get parameters send via authentification.jsp form
		String login =request.getParameter("login");
		String pwd =request.getParameter("pwd");
		
		// Check if authentification is valid
		if(authentificationService.isAuthentificationValid(login, pwd)) {
			
			// Get conseiller object who logged from service
			Conseiller conseiller = conseillerService.getConseillerByLogin(login);
			
			// Get http session
			HttpSession session = request.getSession();

			// Put conseiller login and id in session
			session.setAttribute("conseillerLogin", conseiller.getLogin());
			session.setAttribute("conseillerId", conseiller.getId());
			
			// Remove error message of login
			session.removeAttribute("errorLogin");
			
			// Choose to go on list of client jsp
			dispatcher = request.getRequestDispatcher("/listofclients.jsp");
		}
		else {
			
			// Get http session
			HttpSession session = request.getSession();
			
			// Put error message of login in session
			session.setAttribute("errorLogin", "Echec authentification Conseiller. Essayer à nouveau");
			
			// Choose to go back on authentification jsp
			dispatcher = request.getRequestDispatcher("/authentification.jsp?error");
		}
		
		// Redirect to the jsp chose before
		dispatcher.forward(request, response);
		
	}
}
