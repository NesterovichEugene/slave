(function () {
    'use strict';
    /**
     * Utils methods
     */
    _.mixin({
        guid: function () {
            function _p8(s) {
                var p = (Math.random().toString(16) + "000000000").substr(2, 8);
                return s ? "-" + p.substr(0, 4) + "-" + p.substr(4, 4) : p;
            }

            return _p8() + _p8(true) + _p8(true) + _p8();
        }
    });
    _.mixin({
        isNotEmpty: function (collection) {
            return !_.isEmpty(collection);
        }
    });
    _.mixin({
        removeItem: function (collection, item) {
            _.remove(collection, function (iter) {
                return iter === item;
            });
        }
    });

    _.mixin({
        removeItems: function (collection, items) {
            _.each(items, function (item) {
                _.removeItem(collection, item);
            });
        }
    });


    _.mixin({
        empty: function (val) {
            return _.isEmpty(val) && !_.isNumber(val) && !_.isBoolean(val) || _.isNaN(val);
        }
    });

    _.mixin({
        defaultIfNull: function (val, defaultValue) {
            defaultValue = defaultValue || "";
            return val || defaultValue;
        }
    });
})();

