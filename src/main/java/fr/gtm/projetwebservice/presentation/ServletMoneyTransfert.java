package fr.gtm.projetwebservice.presentation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.gtm.projetwebservice.domaine.Compte;
import fr.gtm.projetwebservice.domaine.Conseiller;
import fr.gtm.projetwebservice.presentation.AuthentificationService;
import fr.gtm.projetwebservice.service.ConseillerService;


public class ServletMoneyTransfert extends HttpServlet{

	private static final long serialVersionUID = 1L;
    
	private ConseillerService conseillerService = new ConseillerService();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletMoneyTransfert() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		traitement(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		traitement(request,response);
	}
	protected void traitement(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = null;		
		
		response.setContentType("text/html");
		
		// Get parameters send via authentification.jsp form
		String string_idDebit =request.getParameter("idDebit");
		int idDebit = Integer.parseInt("string_idDebit");
		String string_idCredit =request.getParameter("idCredit");
		int idCredit = Integer.parseInt("string_idCredit");
		String string_amount =request.getParameter("amount");
		float amount = Float.parseFloat("string_amount");
		
			// Get conseiller object who logged from service
			Compte compteCrediteur = new Compte(idCredit,amount);
			Compte compteDebiteur = new Compte(idDebit, amount);
			
			// Get http session
			HttpSession session = request.getSession();

			// Put conseiller login and id in session
			session.setAttribute("CompteCredit", compteCrediteur);
			session.setAttribute("CompteDebit", compteDebiteur);
				
					
			// Choose to go on list of client jsp
			dispatcher = request.getRequestDispatcher("/html/Transfer.jsp");
				
		
		// Redirect to the jsp chose before
		dispatcher.forward(request, response);
		
	}
}
