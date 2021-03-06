<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../taglib.inc.jsp" %>

<title>用户信息展示</title>

<!-- ajax layout which only needs content area -->
<div class="page-header">
    <h1>
        用户信息
        <small>
            <i class="ace-icon fa fa-angle-double-right"></i>
            列表
        </small>
    </h1>
</div><!-- /.page-header -->

<div class="row">
    <div class="col-xs-12">

        <div class="table-header">
            用户信息列表
        </div>

        <!-- <div class="table-responsive"> -->

        <!-- <div class="dataTables_borderWrap"> -->
        <div>
            <div class="dataTables_wrapper form-inline no-footer">
                <div class="row">
                    <div class="col-xs-6">
                        <div class="dataTables_length">
                            <a title="新增" class="btn btn-sm btn-info"
                               href="#admin/user/toAdd">
                                <i class="ace-icon fa fa-plus align-bottom bigger-125"></i>
                                新&nbsp;增
                            </a>                           
                        </div>
                    </div>                    
                </div>
                <table class="table table-striped table-bordered table-hover dataTable no-footer">
                    <thead>
                    <tr role="row">     
                    							<th>昵称</th>
                                                <th>账号</th>           
                                                <th>密码</th> 
                                                <th>授权码</th> 
                                                <th>上级名字</th>
                                                <th>角色类型</th>
                                                <th>创建时间</th>           
                                                <th class="sorting_disabled">操作</th>
                    </tr>
                    </thead>

                    <tbody>
                           <c:forEach items="${result}" var="item" varStatus="current"> 
                            <tr>            
                            							<th>${item.name}</th>
                                                        <td>${item.userName}</td>                         
                                                        <td>${item.password}</td> 
                                                        <td>${item.authorizationCode}</td>
                                                        <td>${item.superiorName}</td>
                                                        <td>${item.roleCategoryStr}</td> 
                                                        <td>${item.createTimeStr}</td>                        
                                                        <td>
                                <div class="hidden-sm hidden-xs action-buttons">
                                    <a title="修改基本信息" class="green" 
                                       href="#admin/user/toEdit?id=${item.id}&queryStr=${queryStr}">
                                        修改
                                    </a>
                                    <a title="查看基本信息" class="blue" 
                                       href="#admin/user/show?id=${item.id}&queryStr=${queryStr}">
                                        详情
                                    </a>
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
</script>
