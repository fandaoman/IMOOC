var FunExt={
    RequestFun:{
        BootStrap: function (tableId,path,column) {
            //用户信息的展示
            $("#"+tableId).bootstrapTable({
                url: path,         //请求后台的URL（*）
                method: 'post',                      //请求方式（*）
                toolbar: '#toolbar',
                singleSelect : true,
                cache: false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
                clickToSelect: true,                //是否启用点击选中行
                success:function (data) {
                    $("#"+tableId).bootstrapTable({
                        columns: column,
                        data: data,
                        pagination: false,
                        //exportDataType: "basic",              //basic', 'all', 'selected'.
                        //导出功能设置（关键代码）
                        exportDataType:'all',//'basic':当前页的数据, 'all':全部的数据, 'selected':选中的数据
                        showExport: true,  //是否显示导出按钮
                        initExport: true,   //仅初始化是注册一次导出按钮click事件，刷新时需设置为false
                        buttonsAlign:"right",  //按钮位置
                        //exportButton: $('#exportExcel'),     //为按钮btn_export  绑定导出事件  自定义导出按钮(可以不用)
                        exportTypes:['xlsx','pdf'],  //导出文件类型，[ 'csv', 'txt', 'sql', 'doc', 'excel', 'xlsx', 'pdf']

                    });
                }
            });
        }
    }


}