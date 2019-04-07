var app = angular.module('categoriaModule',[]);
app.controller('categoriaControl',function($scope,$http) {
s
    var url = 'http://localhost:8080/categorias';

    $scope.pesquisar = function() {
        $http.get(url).then(function (response) {
            $scope.categorias = response.data;
        }, function (error) {
            alert(error);
            console.log(error);
        });
    }

    $scope.salvar = function() {
        if (typeof $scope.categoria.id == 'undefined') {            
            $http.post(url, $scope.categoria).then(function (response) {
                $scope.categorias.push(response.data);
                $scope.novo();
            }, function (error) {
                alert(error);
                console.log(error);
            });
        } else {
            $http.put(url, $scope.categoria).then(function () {
                $scope.pesquisar();
                $scope.novo();
            }, function (error) {
                alert(error);
                console.log(error);
            });
        } 
    }

    $scope.excluir = function() {
        if (typeof $scope.categoria.id == 'undefined') {
            alert('Escolha uma categoria');
        } else {
            urlExcluir = url + "/" + $scope.categoria.id;
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
        $scope.categoria = {};
    }        

    $scope.seleciona = function (categoria) {
        $scope.categoria = categoria;
    }

    $scope.pesquisar();
    $scope.novo();

});