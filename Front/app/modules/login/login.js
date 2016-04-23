import configLogin from './config.login';
let login = angular.module('login', [])
    .config(configLogin)
login.run(function($templateCache) {
    $templateCache.put('log.html', './views/login.html');
})
export default login;
