angular.module('tree', [])
    .controller('TreeController', function ($http) {
        var tree = this;

        $http.get('/service/frame_order/loadFrameOrders').success(function (data) {
            tree.nodes = data;
            
            tree.nodes.forEach(function (node) {
                node.frameOrderStartTime = node.frameOrderStartTime.toString().substring(0, 10).replace(/\-/g, '.');
                node.frameOrderExecutionTime = node.frameOrderExecutionTime.toString().substring(0, 10).replace(/\-/g, '.');
            });
        });

        //tree.nodes=[
        //    {name: 'Order1', children:[{name:'ept'},{name:'eklmn'},{name:'elki-palki'}], startDate:"01.01.2001", executeDate:"02.03.2001"},
        //    {name: 'Order1', children:[{name:'ept'},{name:'eklmn'},{name:'elki-palki'}], startDate:"01.01.2001", executeDate:"02.03.2001"},
        //    {name: 'Order1', children:[{name:'ept'},{name:'eklmn'},{name:'elki-palki'}], startDate:"01.01.2001", executeDate:"02.03.2001"},
        //    {name: 'Order1', children:[{name:'ept'},{name:'eklmn'},{name:'elki-palki'}], startDate:"01.01.2001", executeDate:"02.03.2001"},
        //    {name: 'Order1', children:[{name:'ept'},{name:'eklmn'},{name:'elki-palki'}], startDate:"01.01.2001", executeDate:"02.03.2001"},
        //    {name: 'Order1', children:[{name:'ept'},{name:'eklmn'},{name:'elki-palki'}], startDate:"01.01.2001", executeDate:"02.03.2001"}
        //
        //];
        //tree.delete = function(data) {
        //    tree.nodes = [];
        //};
        //$scope.add = function(data) {
        //    var post = data.nodes.length + 1;
        //    var newName = data.name + '-' + post;
        //    data.nodes.push({name: newName,nodes: []});
        //};
        //$scope.tree = [{name: 'Node', nodes: []}];
    });
