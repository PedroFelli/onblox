
app.controller('loginCtrl', function($scope, $location) {
      $scope.submit = function(){
          if($scope.name == 'admin' && $scope.password == 'admin'){
              $location.path('/home');
              console.log('login')
          } else {
              console.log('Senha ou login errado')
          }
          
      };
  });




  app.controller('produtoCtrl', function($scope , $http){
      $http.get("http://localhost:8080/onblox/api/produto/")
          .success(function (data) {
              $scope.produtos = data;
          })
      console.log($scope.produtos);
  });


app.controller('clienteCtrl', function($scope , $http){
    $http.get("http://localhost:8080/onblox/api/cliente/")
        .success(function (data) {
            $scope.clientes = data;
        })
    console.log($scope.clientes);
});


