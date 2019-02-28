<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../taglib.inc.jsp" %>

<title>购物车</title>

<!-- ajax layout which only needs content area -->
<div class="page-header">
    <h1>
        购物车
        <small>
            <i class="ace-icon fa fa-angle-double-right"></i>
            列表
        </small>
    </h1>
</div><!-- /.page-header -->

<div class="row">
    <div class="col-xs-12">

        <div class="table-header">
            购物车列表
        </div>

        <!-- <div class="table-responsive"> -->

        <!-- <div class="dataTables_borderWrap"> -->
        <div>
            <div class="dataTables_wrapper form-inline no-footer">
                <div class="row">
                    <div class="col-xs-6">
                        <div class="dataTables_length">
                            <a title="下单" class="btn btn-sm btn-info placeAnOrder"
                                api-path="/admin/orderProduct/placeAnOrder.do">
                                下&nbsp;单
                            </a>                           
                        </div>
                    </div>
                 </div>
                
                <table class="table table-striped table-bordered table-hover dataTable no-footer" id="list-table">
                    <thead>
                    <tr role="row">     
                                                <th class="sorting_disabled">选择</th>           
                                                <th>总金额</th>           
                                                <th>目标地址</th>           
                                                <th>下单人</th>           
                                                <th>产品名称</th>           
                                                <th>数量</th>           
                                                <th>创建时间</th>           
                                                <th>订单状态</th>           
                                                <th class="sorting_disabled">操作</th>
                    </tr>
                    </thead>

                    <tbody>
                           <c:forEach items="${result}" var="item" varStatus="current"> 
                            <tr>            
                                                        <td><input type="checkbox" name="box" data-Id="${item.id}" /></td>                         
                                                        <td>${item.oSum}</td>                         
                                                        <td>${item.oAddress}</td>                         
                                                        <td>${item.roleName}</td>                         
                                                        <td>${item.productName}</td>                         
                                                        <td>${item.oPNumber}</td>                         
                                                        <td>${item.createTimeStr}</td>                         
                                                        <td>${item.stateStr}</td>                         
                                                        <td>
                                <div class="hidden-sm hidden-xs action-buttons">
                                	<a title="删除基本信息" class="red delete" data-id="${item.id}" style="cursor:pointer;"
												api-path="/admin/order/delete.do">删除 
									</a>								                                 
                                </div>
                            </td>
                        </tr>
						</c:forEach>
                    </tbody>
                </table>    
                <div class="row">
                    <div class="col-xs-12">                  
                       	<%@include file="../page.inc.jsp" %>
                    </div>
                </div>          
            </div>
        </div>
    </div>
</div>

<!-- page specific plugin scripts -->
<script type="text/javascript">
    var scripts = [null, "/qcloud-admin/assets/js/datetimepicker.js", null];
    ace.load_ajax_scripts(scripts, function () {
        //inline scripts related to this page
        
        // 开始时间
        $('#startTime').datetimepicker({
            timepicker: true,
            closeOnWithoutClick: true,
            allowBlank: true,
            format:'Y-m-d'
		});
    	// 结束时间        
        $('#endTime').datetimepicker({
            timepicker: true,
            closeOnWithoutClick: true,
            allowBlank: true,
            format:'Y-m-d'
		});
        
      //删除
        $('.delete').click(function () {
            var id = $(this).attr("data-id");
            var delUrl=$(this).attr("api-path");
            new BootstrapDialog({
                title: '提示',
                message: '确定删除该数据？',
                closable: false,
                buttons: [{
                	label: '确定',
                    cssClass: 'btn-primary',
                    action: function (dialog) {
                        $.ajax({
                            type: "POST",
                            url: delUrl,
                            data: {id: id},
                            dataType: "json",
                            success: function (response) {
                                if (response.status == "200") {
                                    window.location.reload();
                                    dialog.close();
                                }
                                else {
                                    BootstrapDialog.alert({
                                        type: BootstrapDialog.TYPE_WARNING,
                                        title: '提示',
                                        message: data.message,
                                        buttonLabel: "确定"
                                    });
                                }
                            }
                        });
                        
                    }
                }, {
                       label: '取消',
                    action: function (dialog) {
                        dialog.close();
                    }
                }]
            }).open();
    	});
      
      //下单
        $('.placeAnOrder').click(function () {
        	
        	//获取表单的值
        	var ids = [];    //定义一个空数组
   			var chkBoxes = $('#list-table').find('input:checked');
   			if (chkBoxes.length == 0) {         //如果不勾选弹出警告框
   		      alert('请至少选择一个数据集');
   		      return false;
   		    }
   			//遍历被选中的checkbox集
   		    $(chkBoxes).each(function () { 
   		      ids.push( $(this).attr('data-Id') );   //找到对应checkbox中data-id属性值，然后push给空数组$ids
   		    });
   		    var ids_str = ids.join('-');              //将数组转化为用逗号隔开的字符串
   		    //( 还有一种写法：var $ids_str += ','+($ids + '') ) ，Number型加上空字符串''可以将Number转化为字符串
   		    console.log(ids_str);                  // =>1,2
        	
            var delUrl=$(this).attr("api-path");
   		    
	            $.ajax({
	                type: "POST",
	                url: delUrl,
	                data: {ids_str: ids_str},
	                dataType: "json",
	                success: function (response) {
	                    if (response.status == "200") {
	                        window.location.reload();
	                        dialog.close();
	                    }
	                    else {
	                    	BootstrapDialog.alert({
                                type: BootstrapDialog.TYPE_WARNING,
                                title: '提示',
                                message: response.message,
                                buttonLabel: "确定"
                            });
	                    	dialog.close();
	                    }
	                }
	            });
    	});
      
    });
</script>
