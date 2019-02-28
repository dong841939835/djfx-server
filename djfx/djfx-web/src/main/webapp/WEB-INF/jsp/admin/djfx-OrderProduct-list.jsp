<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../taglib.inc.jsp" %>

<title>货单信息管理</title>

<!-- ajax layout which only needs content area -->
<div class="page-header">
    <h1>
        货单信息管理
        <small>
            <i class="ace-icon fa fa-angle-double-right"></i>
            列表
        </small>
        <button class="btn btn-primary" style="float: right;" onclick="exportFun()">一键导出</button>
    </h1>
</div><!-- /.page-header -->

<div class="row">
    <div class="col-xs-12">

        <div class="table-header">
            货单信息列表
        </div>

        <!-- <div class="table-responsive"> -->

        <!-- <div class="dataTables_borderWrap"> -->
        <div>
            <div class="dataTables_wrapper form-inline no-footer">
               <div class="row">
					<div class="col-xs-6">
						<div style="float:left;">
				             <form action="#admin/orderProduct/list" onsubmit="listFormSearch(this); return false">
				                 <div class="dataTables_length">
									
									<select name="state" id="state" style="width:110px;height:33px;">
                                     	<option value="">请选择状态</option>
                                     	<option value="1" <c:if test="${query.state eq 1}">selected="selected"</c:if>>未发货</option>
                                     	<option value="2" <c:if test="${query.state eq 2}">selected="selected"</c:if>>发货中</option>
                                     	<option value="3" <c:if test="${query.state eq 3}">selected="selected"</c:if>>已送达</option>
                                     	<option value="4" <c:if test="${query.state eq 4}">selected="selected"</c:if>>暂停处理</option>
                                     </select>
									
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
                                                <th>商品名称&数量</th>           
                                                <th>总价格</th>    
                                                <th>收货人</th>
                                                <th>收货地址</th>
                                                <th>电话</th>
                                                <th>状态</th>
                                                <!-- <th class="sorting_disabled">操作</th> -->
                    </tr>
                    </thead>

                    <tbody>
                           <c:forEach items="${result}" var="item" varStatus="current"> 
                            <tr>            
                                                        <td>${item.productName}</td>                         
                                                        <td>${item.sum}</td> 
                                                        <td>${item.roleName}</td>
                                                        <td>${item.address}</td>
                                                        <td>${item.phone}</td>
                                                        <td>${item.stateStr}</td>
                                                        <%-- <td>
                                <div class="hidden-sm hidden-xs action-buttons">
                                    <a title="修改基本信息" class="green" 
                                       href="#admin/orderProduct/toEdit?id=${item.id}&queryStr=${queryStr}">
                                        <i class="ace-icon fa fa-pencil bigger-130"></i>
                                    </a>							                                 
                                </div>
                            </td> --%>
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
        
    });
    
     //导出
   	function exportFun(){
       	var url = "/admin/orderProduct/exportManifest.do?state=" + $("#state").val();
       	window.open(url);
     }
</script>
