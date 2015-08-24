var bar1 = document.querySelector.bind(document);
var bar2 = document.querySelector.bind(document);
var bar3 = document.querySelector.bind(document);

var updateSize = function () {
    var width = parseInt(bar1('#width').value, 10);
    var height = parseInt(bar1('#height').value, 10);
    var container = bar1('#Scrollbar1');
    container.style.width = width + 'px';
    container.style.height = height + 'px';
    Ps.update(document.querySelector('#Scrollbar1'));

    var width = parseInt(bar2('#width').value, 10);
    var height = parseInt(bar2('#height').value, 10);
    var container = bar2('#Scrollbar2');
    container.style.width = width + 'px';
    container.style.height = height + 'px';
    Ps.update(document.querySelector('#Scrollbar2'));

    var width = parseInt(bar3('#width').value, 10);
    var height = parseInt(bar3('#height').value, 10);
    var container = bar3('#Scrollbar3');
    container.style.width = width + 'px';
    container.style.height = height + 'px';
    Ps.update(document.querySelector('#Scrollbar3'));
};
/**
 * Created by neste on 17.08.2015.
 */


window.onload = function () {
    Ps.initialize(bar2('#Scrollbar2'));
    Ps.initialize(bar1('#Scrollbar1'));
    Ps.initialize(bar1('#Scrollbar3'));
};
/**
 * Created by neste on 17.08.2015.
 */
