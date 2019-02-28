<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../taglib.inc.jsp" %>

<title>订单信息管理</title>

<!-- ajax layout which only needs content area -->
<div class="page-header">
    <h1>
        订单信息管理
        <small>
            <i class="ace-icon fa fa-angle-double-right"></i>
            列表
        </small>
    </h1>
</div><!-- /.page-header -->

<div class="row">
    <div class="col-xs-12">

        <div class="table-header">
            订单信息列表
        </div>

        <!-- <div class="table-responsive"> -->

        <!-- <div class="dataTables_borderWrap"> -->
        <div>
            <div class="dataTables_wrapper form-inline no-footer">
                <!-- <div class="row">
                    <div class="col-xs-6">
                        <div class="dataTables_length">
                            <a title="新增" class="btn btn-sm btn-info"
                               href="#admin/order/toAdd">
                                <i class="ace-icon fa fa-plus align-bottom bigger-125"></i>
                                新&nbsp;增
                            </a>                           
                        </div>
                    </div>                    
                </div> -->
                <div class="row">
					<div class="col-xs-11">
						<div style="float:left;">
				             <form action="#admin/order/orderForm" onsubmit="listFormSearch(this); return false">
				                 <div class="dataTables_length">
									 <input type="text" class="form-control" id="oNumber" name="oNumber" style="width:180px;"
                                        value="${query.oNumber}" placeholder="可输入模糊订单号"/>
                                     <select name="searchState2" id="searchState2" style="width:110px;height:33px;">
                                     	<option value="">请选择状态</option>
                                     	<option value="1" <c:if test="${query.searchState eq 1}">selected="selected"</c:if>>已下单</option>
                                     	<option value="2" <c:if test="${query.searchState eq 2}">selected="selected"</c:if>>撤下中</option>
                                     	<option value="9" <c:if test="${query.searchState eq 3}">selected="selected"</c:if>>已收货</option>
                                     </select>   	
                                        	
                                        	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;下单时间：
									 <input type="text" class="form-control" readonly="" id="startTime" name="startTime" style="width:120px;"
                                        placeholder="开始时间" value="${query.startTime}"/>
                                        ~
									 <input type="text" class="form-control" readonly="" id="endTime" name="endTime" style="width:120px;"
                                        placeholder="结束时间" value="${query.endTime}"/>
                                    
                                     <button type="button" class="btn btn-purple btn-sm clearTimeBtn">清空时间
				                     </button>
                                        
				                     <button type="submit" class="btn btn-purple btn-sm">查询
				                         <i class="ace-icon fa fa-search icon-on-right bigger-110"></i>
				                     </button>
				                 </div>
				             </form>
		         		</div>
	         		</div>
				</div>
                <table class="table table-striped table-bordered table-hover dataTable no-footer">
                    <thead>
                    <tr role="row">     
                                                <th>订单号</th>           
                                                <th>总金额</th>           
                                                <th>目标地址</th>           
                                                <th>产品名称</th>           
                                                <th>数量</th>           
                                                <th>创建时间</th>           
                                                <th>订单状态</th>           
                                                <th class="sorting_disabled">订单操作</th>
                    </tr>
                    </thead>

                    <tbody>
                           <c:forEach items="${result}" var="item" varStatus="current"> 
                            <tr>            
                                                        <td>${item.oNumber}</td>                         
                                                        <td>${item.oSum}</td>                         
                                                        <td>${item.oAddress}</td>                         
                                                        <td>${item.productName}</td>                         
                                                        <td>${item.oPNumber}</td>                         
                                                        <td>${item.createTimeStr}</td>                         
                                                        <td>${item.stateStr}</td>                         
                                                        <td>
                                <div class="hidden-sm hidden-xs action-buttons">
                                	<c:if test="${item.state eq 2}">
                                    <a title="下单" class="blue xiadan" data-id="${item.id}" style="cursor:pointer;"
												api-path="/admin/order/placeOrder.do">重新下单
									</a>
									<a title="已收货" class="red shanchu" data-id="${item.id}" style="cursor:pointer;"
												api-path="/admin/order/falseDeletion.do">删除订单
									</a>
									</c:if>
									<c:if test="${item.state eq 1}">
	                                	<a title="撤下" class="green quxiao" data-id="${item.id}" style="cursor:pointer;"
													api-path="/admin/order/cancelOrder.do">取消订单
										</a>
										<c:if test="${item.processingState eq 2}">
											<a title="已收货" class="blue shouhuo" data-id="${item.id}" style="cursor:pointer;"
														api-path="/admin/order/receivingGoods.do">确认收货
											</a>
										</c:if>
									</c:if>
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
    	//清空时间
        $(".clearTimeBtn").on("click", function () {
        	$('#startTime').val("");
        	$('#endTime').val("");
        });
    	
        //xiadan处理
    	$('.xiadan').click(function () {
            var id = $(this).attr("data-id");
            var delUrl=$(this).attr("api-path");
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
            
    	});
        
    	//quxiao处理
    	$('.quxiao').click(function () {
            var id = $(this).attr("data-id");
            var delUrl=$(this).attr("api-path");
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
            
    	});
    	
    	
    	//shouhuo处理
    	$('.shouhuo').click(function () {
            var id = $(this).attr("data-id");
            var delUrl=$(this).attr("api-path");
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
            
    	});
    	
    	//shanchu处理
    	$('.shanchu').click(function () {
            var id = $(this).attr("data-id");
            var delUrl=$(this).attr("api-path");
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
            
    	});
        
    });
</script>
