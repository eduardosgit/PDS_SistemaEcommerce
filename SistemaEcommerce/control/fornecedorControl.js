var app = angular.module('fornecedorModule',[]);
app.controller('fornecedorControl',function($scope,$http) {

    var url = 'http://localhost:8080/fornecedores';

    $scope.pesquisar = function() {
        $http.get(url).then(function (response) {
            $scope.fornecedores = response.data;
        }, function (error) {
            alert(error);
            console.log(error);
        });
    }

    $scope.salvar = function() {
        if (typeof $scope.fornecedor.codigo == 'undefined') {            
            $http.post(url,$scope.fornecedor).then(function (response) {
                $scope.fornecedores.push(response.data);
                $scope.novo();
            }, function (error) {
                alert(error);
                console.log(error);
            });
        } else {
            $http.put(url,$scope.fornecedor).then(function () {
                $scope.pesquisar();
                $scope.novo();
            }, function (error) {
                alert(error);
                console.log(error);
            });
        } 
    }

    $scope.excluir = function() {
        if (typeof $scope.fornecedor.codigo == 'undefined') {
            alert('Escolha um fornecedor');
        } else {
            urlExcluir = url+"/"+$scope.fornecedor.codigo;
            $http.delete(urlExcluir).then(function () {
                $scope.pesquisar();
                $scope.novo();
            }, function (error) {
                alert(error);
                console.log(error);
            }); 
        }
    }

    $scope.novo = function() {
        $scope.fornecedor = {};
    }        

    $scope.seleciona = function(fornecedor) {
        $scope.fornecedor = fornecedor;
    }

    $scope.pesquisar();
    $scope.novo();

});