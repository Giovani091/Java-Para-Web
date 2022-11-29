<%@page contentType="text/html"%>
<%@page pageEncoding="ISO-8859-1"%>
<%@page import="java.text.SimpleDateFormat"%>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href = "estilo.css" />
        <title>Consulta Produtos</title>
    </head>
   <body>
        <h2 align="center">Consulta de Produtos</h2>
        <jsp:useBean id="produto" scope="session" type="br.edu.unicid.bean.Produto" />
		
        <form>
            <center>
            <table>
                 <tr>
                    <td>Codigo:</td>
                    <td>
                        <input type="text" maxlength="60"  size = "60" name="txtCodigo" 
                            value="<%= produto.getCodigo() %>" readonly="readonly" />
                    </td>
                </tr>
                <tr>
                    <td>Nome:</td>
                    <td>
                        <input type="text" maxlength="60"  size = "60" name="txtNome" 
                        value="<%= produto.getNome() %>" readonly="readonly" />
                    </td>
                </tr>
                 <tr>
                    <td>Descricao:</td>
                    <td>
                        <input type="text" maxlength="60"  size = "60" name="txtDescricao" 
                        value="<%= produto.getDescricao() %>"  />
                    </td>
                </tr>
               <tr>
                    <td>Quantidade:</td>
                    <td>
                        <input type="text" maxlength="60"  size = "60" name="txtQuantidade" 
                        value="<%= produto.getQuantidade() %>" />
                    </td>
                </tr>
				<tr>
					<td colspan="2" align="center"><a href="index.jsp">Pagina  Principal</a></td>
				</tr>             
             </table>
            </center>
        </form>
    </body>
</html>