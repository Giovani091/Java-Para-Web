<%@page contentType="text/html"%>
<%@page pageEncoding="ISO-8859-1"%>
<%@page import="java.text.SimpleDateFormat"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <link rel="stylesheet" type="text/css" href = "estilo.css" />
        <title>Excluir Produtos</title>
    </head>
    <body>
        <h2 align="center">Exclusï¿½o de Produtos</h2>
        <jsp:useBean id="produto" scope="session" type="br.edu.unicid.bean.Produto" />
        <% SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy"); %>

        <form action="ServletProdutos?cmd=excluir" method="post">
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
                    <th colspan="2">
                        <input type="submit" maxlength="60"  size = "60" name="btnExcluir" value="Confirma Exclusão" />
                    </th>
                </tr>		
            </table>
            </center>
        </form>
     </body>
</html>