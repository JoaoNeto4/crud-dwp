package br.com.ifpr;

import java.util.ArrayList;
import java.util.List;

public class Banco {

	private static List<Cliente> listaCliente = new ArrayList<>();
	
	public void salvaCliente(Cliente obj) {
		if(obj.getId() > 0) {
			atualizaCliente(obj);
		}else {
			obj.setId(this.getTamanhoListaCliente()+1);
			listaCliente.add(obj);			
		}
	}
	
	private void atualizaCliente(Cliente obj) {
		for(int i=0; i<Banco.listaCliente.size(); i++) {
			if(Banco.listaCliente.get(i).getId() == obj.getId()) {
				Banco.listaCliente.set(i, obj);
			}
		}
	}
	
	public List<Cliente> getListaCliente(){
		return Banco.listaCliente;
	}
	
	public Integer getTamanhoListaCliente() {
		return Banco.listaCliente.size();
	}
	
	public Cliente getClienteById(Integer id)	{
		Cliente localiza = new Cliente();
		for(Cliente cliente : Banco.listaCliente) {
			if(cliente.getId()==id) {
				localiza = cliente;
			}
		}
		return localiza;
	}
	
	public void deletaCliente(Integer id) {
		for(int i = 0; i< Banco.listaCliente.size(); i++) {
			if(Banco.listaCliente.get(i).getId() == id) {
				Banco.listaCliente.remove(i);
			}
		}
	}
}
