package br.com.ifpr;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/cliente/novo")
public class NovoCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("/cliente-novo.jsp");
		rd.forward(request, response);
		// http://localhost:8080/crud-dwp/cliente/novo
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("cadastrando novo cliente");
		
		String id = request.getParameter("id");
		if(id.isEmpty()) {
			id="0";
		}
		
		String nome = request.getParameter("nome");
		String tipo = request.getParameter("tipo");
		String email = request.getParameter("email");
		String cpf_cnpj = request.getParameter("cpf_cnpj");
		String telefone = request.getParameter("telefone");
		
		List<String> mensagens = new ArrayList<String>();
		
		if(nome.isEmpty()) {
			mensagens.add("Campo Nome é Obrigatório!");
		}
		if(tipo==null || tipo.isEmpty()) {
			mensagens.add("Campo Tipo é Obrigatório!");
		}
		if(email.isEmpty()) {
			mensagens.add("Campo Email é Obrigatório!");
		}
		if(cpf_cnpj.isEmpty()) {
			mensagens.add("CPF/CNPJ é Obrigatório!");
		}
		if(telefone.isEmpty()) {
			mensagens.add("Campo Telefone é Obrigatório!");
		}
		
		if(mensagens.size() > 0) {
			request.setAttribute("mensagens", mensagens);
			request.setAttribute("nome", nome);
			request.setAttribute("tipo", tipo);
			request.setAttribute("email", email);
			request.setAttribute("cpf_cnpj", cpf_cnpj);
			request.setAttribute("telefone", telefone);
		}else {
		
			Cliente cliente = new Cliente();
			cliente.setId(Integer.parseInt(id));
			cliente.setNome(nome);
			cliente.setEmail(email);
			cliente.setTipo(tipo);
			cliente.setCpf_cnpj(cpf_cnpj);
			cliente.setTelefone(telefone);
			
			Banco banco = new Banco();
			
			banco.salvaCliente(cliente);
			System.out.println("Cliente Cadastrado com Sucesso!!");
			
			request.setAttribute("sucesso", "Cliente cadastrado com sucesso!");
		}
		
		doGet(request, response);
	}

}
