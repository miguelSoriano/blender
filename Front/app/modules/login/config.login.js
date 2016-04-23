import controller from 'controllers/login.controller';
let configLogin = function($urlRouterProvider,$stateProvider){
	$urlRouterProvider.otherwise("/");
	$stateProvider
	.state('login',{
		url:'/login',
		templateUrl:'app/modules/login/views/login.html',
		controller
	})
}
configLogin.$inject=['$urlRouterProvider','$stateProvider'];
export default configLogin;