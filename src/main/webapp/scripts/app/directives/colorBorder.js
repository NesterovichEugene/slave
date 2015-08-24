/**
 * Created by sergei.svirepa on 23.12.2014.
 */
var ColorBorder = function () {
    return {
        restrict: 'A',
        link: function ($scope, $element, $attrs) {
            $scope.$watch(function () {
                return $attrs.colorBorder;
            }, function () {
                if ($attrs.colorBorder) {
                    $element.css({"border-color": $attrs.colorBorder,
                        "border-weight": "1px",
                        "border-style": "solid"});
                } else {
                    $element.css({"border": "none"});
                }
            });

        }
    };
};