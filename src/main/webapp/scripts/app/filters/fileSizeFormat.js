/**
 * Created by sergey.shumski on 23.12.2014.
 */
var FileSizeFormat = function () {
    return function (size) {
        return filesize(size);
    };
};