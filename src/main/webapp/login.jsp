<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
	<div class="container" style="margin-top: 10%;">
		<div class="col-md-6" style="margin: 0 auto">
			<div class="card">
				<div class="card-header">Autenticar-se</div>
				
				<div class="card-body">
					<c:if test="${error == 1}">
						<div class="alert alert-danger">Usuário e/ou senha incorretos!</div>
					</c:if>
					
					<c:if test="${logout == 1}">
						<div class="alert alert-primary">Volte sempre!</div>
					</c:if>
					
					<c:if test="${cadastrado == 1}">
						<div class="alert alert-success">Usuário cadastrado com sucesso!</div>
					</c:if>
				
					<form action="login" method="POST">
						<div class="form-group">
							<label for="usuario">Usuário: </label>
							<input type="text" id="usuario" class="form-control" name="usuario" placeholder="Insira o seu usuário..." />
						</div>
						
						<div class="form-group">
							<label for="senha">Senha: </label>
							<input type="password" id="senha" class="form-control" name="senha" placeholder="Insira a sua senha..." />
						</div>
						
						<input type="submit" style="float: right" class="btn btn-outline-success" value="Entrar" />
					</form>
					
					<a href="cadastrar.jsp">Cadastrar</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>