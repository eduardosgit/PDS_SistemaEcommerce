var app = angular.module('produtoModule',[]);
app.controller('produtoControl',function($scope,$http) {

    var url = 'http://localhost:8080/produtos';

    $scope.pesquisar = function() {
        $http.get(url).then(function (response) {
            $scope.produtos = response.data;
        }, function (error) {
            alert(error);
            console.log(error);
        });
    }

    $scope.salvar = function() {
        if (typeof $scope.produto.id == 'undefined') {            
            $http.post(url,$scope.produto).then(function (response) {
                $scope.produtos.push(response.data);
                $scope.novo();
            }, function (error) {
                alert(error);
                console.log(error);
            });
        } else {
            $http.put(url,$scope.produto).then(function () {
                $scope.pesquisar();
                $scope.novo();
            }, function (error) {
                alert(error);
                console.log(error);
            });
        } 
    }

    $scope.excluir = function() {
        if (typeof $scope.produto.id == 'undefined') {
            alert('Escolha um produto');
        } else {
            urlExcluir = url+"/"+$scope.produto.id;
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
        $scope.produto = {};
    }        

    $scope.seleciona = function(produto) {
        $scope.produto = produto;
    }

    $scope.pesquisar();
    $scope.novo();

});