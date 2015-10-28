angular.module("listaTelefonica").controller("novoContatoCtrl", 
		function($scope, contatosAPI, serialGenerator, $location, operadoras) {
	
	$scope.operadoras = operadoras.data;


	$scope.adicionarContato = function (contato) {
		contato.serial = serialGenerator.generate();		
		contato.dataCadastro = new Date();
		contatosAPI.saveContato(contato)
			.success(function (data) {
				delete $scope.contato;
				$scope.contatoForm.$setPristine;
				$location.path("/contatos");
			});

	};
});