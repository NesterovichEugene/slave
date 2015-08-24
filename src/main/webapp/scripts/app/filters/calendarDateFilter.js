/**
 * Created by sergey.shumski on 09.06.2015.
 */
var CalendarDateFilter = function () {
    return function (input, momentFn /*, param1, param2, etc... */) {
        var args = Array.prototype.slice.call(arguments, 2);
        var momentObj = moment(input, args[0]);
        if (input.split(' ')[0] === 'Heute') {
            return momentObj = 'Heute '
        }
        return momentObj[momentFn].apply(momentObj, args);
    };
};