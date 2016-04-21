import controller from 'controllers/layout.controller';
let config = function($urlRouterProvider,$stateProvider){
	$urlRouterProvider.otherwise("/");
	$stateProvider
	.state('/',{
		url:'/',
		template:'<h1>Hello</h1>',
		controller
	})
}
config.$inject=['$urlRouterProvider','$stateProvider'];
export default config;