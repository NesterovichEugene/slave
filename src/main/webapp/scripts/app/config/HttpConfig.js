/**
 * Created by sergei.svirepa on 17.12.2014.
 */
function HttpConfig($httpProvider) {
    $httpProvider.interceptors.push(['$q', 'notifications', unAuthorizedInterceptor]);

    /**
     *
     * @param $q
     * @return {{responseError: Function}}
     * @param notifications
     */
    function unAuthorizedInterceptor($q, notifications) {
        return {
            'responseError': function (rejection) {
                notifications.error("", toStringError(rejection.data));
                return $q.reject(rejection);
            }
        };
    }

    function toStringError(data) {
        if (_.isEmpty(data)) {
            return "Unexpexted Erorr";
        }
        if (typeof data === 'string') {
            return data;
        }
        if (typeof data === 'object') {
            return toStringError(data.result);
        }
        return "Unexpexted Erorr: " + data;
    }


}
