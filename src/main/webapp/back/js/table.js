$(function () {
     var columns=[
        {
            title: '序号',
            align: 'center',
            formatter: function (value, row, index) {
                var pageSize=$('#tableLottery').bootstrapTable('getOptions').pageSize;//通过表的#id 可以得到每页多少条
                var pageNumber=$('#tableLottery').bootstrapTable('getOptions').pageNumber;//通过表的#id 可以得到当前第几页
                return pageSize * (pageNumber - 1) + index + 1;//返回每条的序号： 每页条数 * （当前页 - 1 ）+ 序号
            }
        },
        {field: 'id', title: '期数'},
        {field: 'redNumberOne', title: '红1'},
        {field: 'redNumberTwo', title: '红2'},
        {field: 'redNumberThree', title: '红3'},
        {field: 'redNumberThour', title: '红4'},
        {field: 'redNumberFive', title: '红5'},
        {field: 'redNumberSix', title: '红6'},
        {field: 'blueOne', title: '蓝1'}
    ];
     var path='lottery/findAll';
     //FunExt.RequestFun.BootStrap("tableLottery",path,columns);
    //BootStrap("tableLottery","lottery/findAll",columns);


})