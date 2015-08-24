/**
 * Created by sergei.svirepa on 25.12.2014.
 */
var TreeItemLabel = function ($sce, TreeNodeTypes) {
    return function (item) {
        var label = "";
        switch (item.type) {
            case TreeNodeTypes.FRAME_ORDER:
                label = item.data.number + (item.data.isyNumber ? '<span style="margin-left: 70px">' + " isy: " + item.data.isyNumber + '</span>' : "");
                break;
            case TreeNodeTypes.ORDER_TYPE:
                label = item.data.name;
                break;
            case TreeNodeTypes.ORDER:
                label = item.data.number + (item.data.advertisingMedia ? " - " + item.data.advertisingMedia : "");
                break;
            default:

        }
        return $sce.trustAsHtml(label);
    };
};