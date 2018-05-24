var app = angular.module('app',['ngRoute']);

app.config(function($routeProvider, $locationProvider)
{
 

   $routeProvider
   // para a rota '/', carregaremos o template home.html e o controller 'HomeCtrl'
   .when('/', {
      templateUrl : 'app/views/form.html',
   })
   .when('/home', {
      templateUrl : 'app/views/home.html',
   }) 
   .when('/produto', {
      templateUrl : 'app/views/produto.html',
   })
       .when('/cliente', {
      templateUrl : 'app/views/cliente.html',
   })
   // caso não seja nenhum desses, redirecione para a rota '/'
   .otherwise ({ redirectTo: '/' });
});
