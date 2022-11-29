package br.edu.unicid.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionFactory {

	public static Connection getConnection() throws Exception {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/db_estoque";
			String login = "root";
			String senha = "";

			return DriverManager.getConnection(url, login, senha);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public static void main(String[] args) {	
		
		try {
			/*
			Connection conn = ConnectionFactory.getConnection();
			ProdutoDAO dao = new ProdutoDAO();
			Produto produto = new Produto(3,"Josefa", "três", 56);
			dao.salvar(produto);
			*/
			/*
			Connection conn = ConnectionFactory.getConnection();
			ProdutoDAO dao = new ProdutoDAO();
			Produto produto = new Produto(3,"Josef", "atualizar", 34);
			dao.atualizar(produto);
			*/
			/*Connection conn = ConnectionFactory.getConnection();
			ProdutoDAO dao = new ProdutoDAO();
			Produto produto = new Produto(1,"felipe", "com", 61);
			dao.excluir(produto);
			*/
			/*
			ProdutoDAO dao = new ProdutoDAO();
			Produto produto = dao.procurarProduto(1);
			JOptionPane.showMessageDialog(null, "Codigo: " + produto.getCodigo() + "Nome: " + produto.getNome() + "Descição: " + produto.getDescricao() + "Qtd: " + produto.getQuantidade());
			*/
			/*
			ProdutoDAO dao = new ProdutoDAO();
			List<Produto> produto = dao.todosProduto(null);
			for(Produto a: produto) {
				JOptionPane.showMessageDialog(null, "Codigo: " + a.getCodigo() + "Nome: " + a.getNome() + "Descição: " + a.getDescricao() + "Qtd: " + a.getQuantidade());
			}
			*/
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}	
	
	public static void closeConnection(Connection conn, Statement stmt, ResultSet rs) throws Exception
	{
		close(conn, stmt, rs);
	}
	
	public static void closeConnection(Connection conn, Statement stmt) throws Exception
	{
		close(conn, stmt, null);
	}
	
	public static void closeConnection(Connection conn) throws Exception
	{
		close(conn, null, null);
	}
		
	private static void close(Connection conn, Statement stmt, ResultSet rs) throws Exception {
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}
