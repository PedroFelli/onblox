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

              //teste de listar
              console.log($scope.produtos);

              //push
              $scope.addNew = function(produto){
                  $http.post("http://localhost:8080/onblox/api/produto/", produto)
                  console.log(produto);
                  $scope.produtos.push(produto);
                  $scope.current = {};
              };


              $scope.remove = function(produto){
                  $http.delete("http://localhost:8080/onblox/api/produto/"+produto.id)
                  var index = $scope.produtos.indexOf(produto);
                  $scope.produtos.splice(index,1);
              };

              $scope.edit = function(produto){
                  $scope.current = produto;
              };


              $scope.save = function(produto){
                  console.log(produto);
                  $http.put('http://localhost:8080/onblox/api/produto/' + produto.id , {
                      "id" : produto.id,
                      "name": produto.name,
                      "quantidade": produto.quantidade,
                      "preco": produto.preco});
                  $scope.current = {};
              }
            $scope.current = {};
          })
  });


app.controller('clienteCtrl', function($scope , $http){
    $http.get("http://localhost:8080/onblox/api/cliente/")
        .success(function (data) {
            $scope.clientes = data;
        })
    console.log($scope.clientes);
});


