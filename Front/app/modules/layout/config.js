import controller from 'controllers/layout.controller';
let config = function($urlRouterProvider,$stateProvider){
	$urlRouterProvider.otherwise("/");
	$stateProvider
	.state('/',{
		url:'/',
		template:'',
		controller
	})
}
config.$inject=['$urlRouterProvider','$stateProvider'];
export default config;