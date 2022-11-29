package br.edu.unicid.teste;

import javax.swing.JOptionPane;

import br.edu.unicid.bean.Produto;
import br.edu.unicid.dao.ProdutoDAO;

public class Principal {
	
	public static void main(String args[]) throws Exception{
		
		try {
			Produto produto = new Produto(3, "teste","teste", 1253);
			ProdutoDAO dao = new ProdutoDAO();
			dao.salvar(produto);
			
			
			JOptionPane.showMessageDialog(null, "Seu Celso");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
