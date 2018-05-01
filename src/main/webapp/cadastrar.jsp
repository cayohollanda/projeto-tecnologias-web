<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro</title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
</head>
<body>
	<div class="container" style="margin-top: 10%;">
		<div class="col-md-6" style="margin: 0 auto">
			<div class="card">
				<div class="card-header">Cadastre-se</div>
				
				<div class="card-body">
					<form action="cadastrar" method="POST">
						<div class="form-group">
							<label for="usuario">Usuário: </label>
							<input type="text" id="usuario" class="form-control" name="usuario" placeholder="Insira o seu usuário..." />
						</div>
						
						<div class="form-group">
							<label for="senha">Senha: </label>
							<input type="password" id="senha" class="form-control" name="senha" placeholder="Insira a sua senha..." />
						</div>
						
						<input type="submit" style="float: right" class="btn btn-primary" value="Cadastrar" />
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>