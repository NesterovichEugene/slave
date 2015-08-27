angular.module('general-module').service('remoteService', RemoteService);
/**
 *
 * @param $http
 * @param {$q} $q
 * @param HttpMethods
 * @return {{}}
 * @constructor
 */
function RemoteService($http, $q, HttpMethods) {
    var service = this;

    /**
     *
     * @param command
     * @param data
     * @return {Promise|promise}
     */
    service.createPromise = function (command, data) {
        return basePromise(HttpMethods.POST, command, null, data);
    };
    /**
     *
     * @param command
     * @param params
     * @return {promise}
     */
    service.deletePromise = function (command, params) {
        return basePromise(HttpMethods.DELETE, command, params, null);
    };
    /**
     *
     * @param command
     * @param data
     * @return {promise}
     */
    service.updatePromise = function (command, data) {
        return basePromise(HttpMethods.PUT, command, null, data);
    };
    /**
     *
     * @param command
     * @param {Object=}params
     * @return {promise}
     */
    service.loadPromise = function (command, params) {
        return basePromise(HttpMethods.GET, command, params, null);
    };

    /**
     *
     * @param command
     * @param data
     * @param params
     * @return {promise}
     */
    service.uploadFilePromise = function (command, data, params) {
        var deferred = createDefer();
        var formData = new FormData();
        formData.append('file', data);
        $http.post(command, formData, {
            params: params,
            headers: {'Content-Type': undefined},
            transformRequest: angular.identity
        }).
            success(function (responce) {
                deferred.resolve(responce);
            }).
            error(function (err) {
                deferred.reject(err);
            });
        return deferred.promise;
    };
    /**
     * @private
     * @return {Deferred}
     */
    function createDefer() {
        return $q.defer();
    }

    /**
     * @private
     *
     * @param command
     * @param params
     * @param method {'GET'|'HEAD'|'POST'|'PUT'|'DELETE'|'JSONP'|'PATCH'}
     * @param data
     * @return {promise}
     */
    function basePromise(method, command, params, data) {
        var deferred = createDefer();
        $http({method: method, url: command, params: params, data: data}).
            success(function (page) {
                deferred.resolve(page);
            }).
            error(function (err) {
                deferred.reject(err);
            }
        );
        return deferred.promise;
    }


}
