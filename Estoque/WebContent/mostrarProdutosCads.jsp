<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="br.edu.unicid.bean.Produto" %>

<%@page contentType="text/html"%>
<%@page pageEncoding="ISO-8859-1"%>


<html>
<head>
<title>Lista Produtos</title>
</head>
<body>
	<center>
	<table width= "100%" border="1" cellpadding="2" cellspacing="0">
		<tr>
			<th colspan="6"><h3>Lista de Produtos</h3></th>
		
		</tr>
		<tr>
			<th>Codigo</th>
			<th>Nome</th>
			<th>Descricao</th>
			<th>Quantidade</th>
		</tr>
          	<%
          		SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
          		List <Produto> lista = new ArrayList<Produto>();
          		lista = (ArrayList)request.getAttribute ("produtosList");
               	for(Produto produto: lista ){%>
		<tr>		
				<td><%=produto.getCodigo()%></td>
				<td><%=produto.getNome()%></td>
				<td><%=produto.getDescricao()%></td>
				<td><%=produto.getQuantidade()%></td>
		</tr>
            <%
                }
          %>
		<tr>
			<td colspan="6" align="center"><a href="index.jsp">Pagina Principal</a></td>
		</tr>	
	</table>
	</center>
	</body>
</html>