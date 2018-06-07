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




