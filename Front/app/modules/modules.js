import layout from './layout/layout';
import login from './login/login';

let modules = angular.module('modules',[
	layout.name,
	login.name
])
export default modules;
