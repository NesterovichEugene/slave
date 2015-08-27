angular.module('notifications.services').provider('notifications', [function () {

    this.$get = [function () {
        return {
            /**
             * Error Notification
             *
             * @param  header  string
             * @param  msg  string
             */
            error: function (header, msg) {
                return $.amaran({
                    'theme': 'colorful',
                    'content': {
                        bgcolor: '#AE2727',
                        color: '#fff',
                        message: msg
                    },
                    'position': 'bottom right',
                    'inEffect': 'slideRight',
                    'outEffect': 'slideRight',
                    'closeOnClick': true,
                    'delay': 10000
                });
            },

            fatal: function (header, msg) {
                return $.amaran({
                    'theme': 'colorful',
                    'content': {
                        bgcolor: '#AE2727',
                        color: '#fff',
                        message: msg
                    },
                    'position': 'center center',
                    'closeOnClick': true,
                    'delay': 10000
                });
            },

            /**
             * success Notification
             *
             * @param  header  string
             * @param  msg  string
             */
            success: function (header, msg) {
                return $.amaran({
                    'theme': 'colorful',
                    'content': {
                        bgcolor: '#27ae60',
                        color: '#fff',
                        message: msg
                    },
                    'position': 'top right',
                    'inEffect': 'slideRight',
                    'outEffect': 'slideRight',
                    'closeOnClick': true,
                    'delay': 5000
                });
            }
        };
    }]; // end $get
}]);