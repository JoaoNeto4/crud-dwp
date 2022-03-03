package br.com.ifpr;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cliente/lista")
public class ListaCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Banco banco = new Banco();
		
		List<Cliente> lista = banco.getListaCliente();
		
		request.setAttribute("clientes", lista);
		
		RequestDispatcher rd = request.getRequestDispatcher("/cliente-lista.jsp");
		rd.forward(request, response);
		// http://localhost:8080/crud-dwp/cliente/lista
		
	}

}
