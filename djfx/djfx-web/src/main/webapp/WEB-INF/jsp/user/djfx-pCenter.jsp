<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../taglib.inc.jsp" %>

<title>个人中心</title>

<!-- ajax layout which only needs content area -->
<div class="page-header">
    <h1>
        个人信息管理
        <small>
            <i class="ace-icon fa fa-angle-double-right"></i>
            列表
        </small>
    </h1>
</div><!-- /.page-header -->

<div class="row">
    <div class="col-xs-12">
		
        <div class="table-header">
            个人信息列表
        </div>

        <!-- <div class="table-responsive"> -->

        <!-- <div class="dataTables_borderWrap"> -->
        <div>
            <div class="dataTables_wrapper form-inline no-footer">
                
                <table class="table table-striped table-bordered table-hover dataTable no-footer">
                    <thead>
                    <tr role="row">     
                    							
                                                <th>账号</th>           
                                                <th>密码</th> 
                                                <th>上级</th>
                                                <th>昵称</th>
                                                <th>级别</th>
                                                <th>邮箱</th>
                                                <th>身份证</th>
                                                <th>电话</th>
                                                <th>地址</th>
                                                <th>创建时间</th>           
                                                <th class="sorting_disabled">操作</th>
                    </tr>
                    </thead>

                    <tbody>
                            <tr>            
                            							
                                                        <td>${user.userName}</td>                         
                                                        <td>${user.password}</td> 
                                                        <td>${user.superiorName}</td>
                                                        <td>${user.name}</td>
                                                        <td>${user.roleCategoryStr}</td> 
                                                        <td>${user.email}</td>
                                                        <td>${user.idCard}</td>
                                                        <td>${user.phone}</td>
                                                        <td>${user.contactAddress}</td>
                                                        <td>${user.createTimeStr}</td>                        
                                                        <td>
                                <div class="hidden-sm hidden-xs action-buttons">
                                    <a title="修改基本信息" class="green" 
                                       href="#admin/user/toEdit?id=${user.id}&queryStr=${queryStr}">
                                        修改个人信息
                                    </a>
                                </div>
                            </td>
                        </tr>
                    </tbody>
                </table>
                <br/>
                <br/>
                <div class="table-header">
			            下级信息列表
			    </div>
			    <div class="row">
                     <!-- <div class="col-xs-6">
                        <div class="dataTables_length">
                            <a title="新增" class="btn btn-sm btn-info"
                               href="#admin/init/toAdd">
                                <i class="ace-icon fa fa-plus align-bottom bigger-125"></i>
                                添&nbsp;加
                            </a>                           
                        </div>
                    </div> -->
                    <button type="button" class="btn btn-info btn-sm" href-data="/admin/user/toAddSubordinate.do"
						    onclick="addMaterialType(this)">
						        <i class="ace-icon fa fa-plus align-bottom bigger-125"></i>
						      	 添&nbsp;加
					</button>   
                </div>
                
			    <table class="table table-striped table-bordered table-hover dataTable no-footer">
                    <thead>
                    <tr role="row">     
                    							
                                                <th>账号</th>           
                                                <th>密码</th> 
                                                <th>上级</th>
                                                <th>昵称</th>
                                                <th>级别</th>
                                                <th>邮箱</th>
                                                <th>身份证</th>
                                                <th>电话</th>
                                                <th>地址</th>
                                                <th>创建时间</th>           
                                                <th class="sorting_disabled">操作</th>
                    </tr>
                    </thead>
                    <tbody>
						<c:forEach items="${result}" var="item" varStatus="current">
                            <tr>            
                            							
                                                        <td>${item.userName}</td>                         
                                                        <td>${item.password}</td> 
                                                        <td>${item.superiorName}</td>
                                                        <td>${item.name}</td>
                                                        <td>${item.roleCategoryStr}</td> 
                                                        <td>${item.email}</td>
                                                        <td>${item.idCard}</td>
                                                        <td>${item.phone}</td>
                                                        <td>${item.contactAddress}</td>
                                                        <td>${item.createTimeStr}</td>                        
                                                        <td>
                                <div class="hidden-sm hidden-xs action-buttons">
                                    <a title="删除基本信息" class="red delete" data-id="${item.id}" style="cursor:pointer;"
												api-path="/admin/user/delete.do">删除 
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
    var scripts = [null, null];
    ace.load_ajax_scripts(scripts, function () {
        //inline scripts related to this page
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
    });
    
  	//新增方法
	function addMaterialType(obj){
		var toAddAlertUrl = $(obj).attr("href-data");
        BootstrapDialog.show({
            title: '新增',
            message: $('<div></div>').load(toAddAlertUrl),
            cssClass: "select-product-dialog",
            draggable: true,
             buttons: [{
                label: '保存',
                cssClass: 'btn btn-primary',
                
                 action: function (dialogItself) {
					
                	 var array = $("#model-form").serializeArray();
                	 
                	 var query_str = "/admin/user/addSubordinate.do?";
                	 
                	 $.each(array, function (i, data) {
                         if ($.trim(data['value'])) {
                        	 
                             query_str += (query_str == '') ? '?' + data['name'] + '=' + data['value'] : '&' + data['name'] + '=' + data['value'];
                         }
                     });
                	 var saveMaterialUrl = query_str;
                	 
            		  $.ajax({
            			type: "POST",
                        url: saveMaterialUrl,
                        dataType: "json",
                        success: function (response) {
                            if (response.status == "200") {
                            	dialogItself.close();
	                        	window.location.reload(true);
                            }
                            else {
                            	BootstrapDialog.alert({
                                    type: BootstrapDialog.TYPE_WARNING,
                                    title: '提示',
                                    message: response.message,
                                    buttonLabel: "确定"
                                });
                            	dialogItself.close();
                            }
                        }
            		}); 
                  
               } 
            }, {
                label: '取消',
                action: function (dialogItself) {
                    dialogItself.close();
                }
            }], 
            //在页面显示前调用的方法
            onshow: function (dialog) {
                //keydown按下
            	$(dialog).keydown(function(e){
            	    if(e.keyCode==13){
            	        event.preventDefault();//禁用默认回车事件
            	    }
            	})
            }
        });
	}
    
</script>
