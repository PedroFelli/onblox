app.controller('clienteCtrl', function($scope , $http){
    $http.get("http://localhost:8080/onblox/api/cliente/")
        .success(function (data) {
            $scope.clientes = data;
        })
    console.log($scope.clientes);
});


