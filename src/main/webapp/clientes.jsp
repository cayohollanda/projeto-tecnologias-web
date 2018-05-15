<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bem vindo (a), ${usuario}!</title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script>
	// Definindo os segundos (10 minutos)
	var i = 540;
	
	// Montando função para fazer a contagem regressiva
	function contagemRegressiva() {
		
		// Se o índice for 0, significa que a sessão expirou, então
		// mostra-se na tela que a sessão foi expirada, senão, tira
		// um do índice e atualiza na tela o índice
		if(i == 0){
		 	document.getElementById('cronometro').innerHTML = 'Sessão expirada'
		 	window.location.replace('login.jsp');
		} else {
			i--;
			
			// Arredondando minutos, para não ficar quebrado. Ex.: 9.8:34
			var minutos = Math.round(i/60);
			
			// Definindo segundos (resto da divisão de i por 60)
			var segundos = i % 60;
			
			// Inserindo valor no HTML, se for menos de 10 segundos, fizemos o if
			// porquê estava ficando 0:9, então filtramos para colocar 0:09
			if(segundos < 10) {
				document.getElementById('cronometro').innerHTML = minutos + ':' + '0' + segundos + ' minutos';
			} else {
				document.getElementById('cronometro').innerHTML = minutos + ':' + segundos + ' minutos';
			}
		}
	}
	
	// Setando o intervalo no qual o script vai agir sobre a função
	// este método (setInterval) é padrão do Javascript e tem a função
	// de chamar o método passado como parâmetro no intervalo de tempo
	// passado no segundo parâmetro
	setInterval("contagemRegressiva()", 1000);
</script>
</head>
<body>

<%-- 	<c:if test="${usuario == null}"> --%>
<!-- 		<script>
 			window.location.replace('login.jsp');
<!-- 		</script> -->
<%-- 	</c:if> --%>

	<div class="container" align="right" style="margin-top: 10px">
		<span style="font-size: 10px">
			A sessão expira em: <span id="cronometro"></span><br><br>
		</span>
		
		<h1 align="left">
			Clientes 
			<a style="float: right" href="sair">
				<button type="button" class="btn btn-outline-danger">Sair</button>
			</a>
		</h1>
	
		<c:if test="${mensagem != null}">
			<div class="alert alert-success">${mensagem}</div>
		</c:if>

		<div id="accordion">
			<div class="card">
				<div class="card-header" id="headingOne">
					<h5 class="mb-0">
						<button class="btn btn-link collapsed" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne" style="float: left">
							<i class="fa fa-angle-double-down" style="margin-right: 10px"></i>Salvar Cliente (clique para minimizar)
						</button>
					</h5>
				</div>

				<div id="collapseOne" class="collapse show"
					aria-labelledby="headingOne" data-parent="#accordion">
					<div class="card-body">
						<form action="salvaCliente" method="POST">
							<input type="hidden" name="id" value="${cliente.id}" /> 
							<input type="hidden" name="idContato" value="${cliente.contato.id}" />
							<input type="hidden" name="idEndereco" value="${cliente.endereco.id}" />

							<div class="form-group row">
								<div class="col-md-6">
									<label for="nome" style="float: left">Nome: </label>
									<input type="text" class="form-control" name="nome" value="${cliente.nome}" />
								</div>

								<div class="col-md-6">
									<label for="cpf" style="float: left">CPF: </label>
									<input type="text" class="form-control" name="cpf" value="${cliente.cpf}" />
								</div>
							</div>

							<div class="form-group row">
								<div class="col-md-12">
									<label for="rua" style="float: left">Rua: </label>
									<input type="text" class="form-control" name="rua" value="${cliente.endereco.rua}" />
								</div>
							</div>

							<div class="form-group row">
								<div class="col-md-6">
									<label for="bairro" style="float: left">Bairro: </label>
									<input type="text" class="form-control" name="bairro" value="${cliente.endereco.bairro}" />
								</div>

								<div class="col-md-6">
									<label for="estado" style="float: left">Estado: </label>
									<input type="text" class="form-control" name="estado" value="${cliente.endereco.estado}" /> <br>
								</div>
							</div>

							<div class="form-group row">
								<div class="col-md-6">
									<label for="cidade" style="float: left">Cidade: </label>
									<input type="text" class="form-control" name="cidade" value="${cliente.endereco.cidade}" />
								</div>

								<div class="col-md-6">
									<label for="numero" style="float: left">Número: </label>
									<input type="number" class="form-control" name="numero" value="${cliente.endereco.numero}" />
								</div>
							</div>

							<div class="form-group row">
								<div class="col-md-12">
									<label for="obs" style="float: left">Observações: </label>
									<textarea class="form-control" name="obs">${cliente.endereco.obs}</textarea>
								</div>
							</div>

							<div class="form-group row">
								<div class="col-md-6">
									<label for="telefone" style="float: left">Telefone: </label>
									<input type="text" class="form-control" name="telefone"	value="${cliente.contato.telefone}" />
								</div>

								<div class="col-md-6">
									<label for="email" style="float: left">E-mail: </label>
									<input type="email" class="form-control" name="email" value="${cliente.contato.email}" />
								</div>
							</div>

							<div class="form-group row">
								<div class="col-md-12">
									<input type="submit" style="float: left; margin-right: 10px" class="btn btn-outline-success" value="Gravar" /> 
									<input type="reset" style="float: left" class="btn btn-outline-primary" value="Limpar" />
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>

		<table class="table" style="margin-top: 10px">
			<thead class="thead-dark">
				<tr>
					<th>#</th>
					<th>Nome</th>
					<th>CPF</th>
					<th>E-mail</th>
					<th>Ações</th>
				</tr>
			</thead>

			<c:forEach var="cliente" items="${clientes}">
				<tr>
					<td>${cliente.id}</td>
					<td>${cliente.nome}</td>
					<td>${cliente.cpf}</td>
					<td>${cliente.contato.email}</td>
					<td colspan="2"><a href="editaCliente?id=${cliente.id}">Editar</a>
						| <a href="removeCliente?id=${cliente.id}">Apagar</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<script src="js/jquery.min.js"></script>
	<script src="js/popper.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>