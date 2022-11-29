package br.edu.unicid.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.unicid.bean.Produto;
import br.edu.unicid.dao.ProdutoDAO;

/**
 * Servlet implementation class ServletAlunos
 */
@WebServlet("/ServletProdutos")
public class ServletProdutos extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	

	// m�todo para convers�o de String para data
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        // a vari�vel cmd indica o tipo de a��o - incluir, alterar, consulta.....
        String cmd = request.getParameter("cmd");
        // cria um objeto dao - CRUD
        ProdutoDAO dao;
        // cria um objeto do tipo aluno
        Produto produto = new Produto(0, cmd, cmd, 0);
        if (cmd != null) {
            try {
                // inicializa os atributos da classe Alunos
            	   produto.setCodigo(Integer.parseInt(request.getParameter("txtCodigo")));  
            	   produto.setNome(request.getParameter("txtNome"));
                produto.setDescricao((request.getParameter("txtDescricao")));
                produto.setQuantidade(Integer.parseInt(request.getParameter("txtQuantidade")));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        try {
        	// cria a instancia do objeto dao
            dao = new ProdutoDAO();
            RequestDispatcher rd = null;
            // lista todos os alunos
            if (cmd.equalsIgnoreCase("listar")) {
                List<Produto> produtosList = dao.todosProdutos(null);
                // cria uma sess�o para encaminhar a lista para uma JSP
                request.setAttribute("produtosList", produtosList);
                // redireciona para a JSP mostraAlunosCads
                rd = request.getRequestDispatcher("/mostrarProdutosCads.jsp");
            }
            
            // incluir aluno
            else if (cmd.equalsIgnoreCase("incluir")) {
                dao.salvar(produto);
                rd = request.getRequestDispatcher("ServletProdutos?cmd=listar");
             
            // consulta aluno para exclus�o    
            } else if (cmd.equalsIgnoreCase("exc")) {
                produto = dao.procurarProduto(produto.getCodigo());
                HttpSession session = request.getSession(true);
                session.setAttribute("produto", produto);
                rd = request.getRequestDispatcher("/formExcProduto.jsp");
             
            // exclui aluno
            } else if (cmd.equalsIgnoreCase("excluir")) {
                dao.excluir(produto);
                rd = request.getRequestDispatcher("ServletProdutos?cmd=listar");
            
            // consulta aluno para altera��o
            }  else if (cmd.equalsIgnoreCase("atu")) {
                produto = dao.procurarProduto(produto.getCodigo());
                HttpSession session = request.getSession(true);
                session.setAttribute("produto", produto);
                rd = request.getRequestDispatcher("/formAtuProduto.jsp");
             
            // consulta aluno
            } else if (cmd.equalsIgnoreCase("con")) {
                produto = dao.procurarProduto(produto.getCodigo());
                HttpSession session = request.getSession(true);
                session.setAttribute("produto", produto);
                rd = request.getRequestDispatcher("/formConsProduto.jsp");
            
             // altera aluno    
            } else if (cmd.equalsIgnoreCase("atualizar")) {
                dao.atualizar(produto);
                rd = request.getRequestDispatcher("ServletProdutos?cmd=listar");
            
            // direciona para a p�gina principal
            } else if (cmd.equalsIgnoreCase("principal")) {
                rd = request.getRequestDispatcher("/index.jsp");
            }            
            // executa a a��o de direcionar para a p�gina JSP
            rd.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    } 

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);

	}

}
