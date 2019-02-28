<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../taglib.inc.jsp" %>
<title>商品类别管理</title>

<!-- ajax layout which only needs content area -->
<div class="page-header">
    <h1>
        商品类别管理
        <small>
            <i class="ace-icon fa fa-angle-double-right"></i>
            列表
        </small>
    </h1>
</div><!-- /.page-header -->

<div class="row">
    <div class="col-xs-12">

        <div class="table-header">
           商品类别列表
        </div>

        <!-- <div class="table-responsive"> -->

        <!-- <div class="dataTables_borderWrap"> -->
        <div>
            <div class="dataTables_wrapper form-inline no-footer">
                <div class="row">
                    <div class="col-xs-6">
                        <div class="dataTables_length">
                            <a title="新增" class="btn btn-sm btn-info"
                               href="#admin/productCategory/toAdd">
                                <i class="ace-icon fa fa-plus align-bottom bigger-125"></i>
                                新&nbsp;增
                            </a>                           
                        </div>
                    </div>                    
                </div>
                <table class="table table-striped table-bordered table-hover dataTable no-footer">
                    <thead>
                    <tr role="row">     
                                                <th>缩略图</th>           
                                                <th>产品类型</th>           
                                                <th>类型名称</th>           
                                                <th class="sorting_disabled">操作</th>
                    </tr>
                    </thead>

                    <tbody>
                           <c:forEach items="${result}" var="item" varStatus="current"> 
                            <tr>            
                        			<td style="width:178px"><img width="150" height="100"  class="imgs"
                        					src="<%=request.getContextPath()%>/qcloud-admin/assets/img/${item.thumbnail}"/></td>
                        		<!-- 放大后的图片 -->
						       <div id="outerdiv" style="position:fixed;top:0;left:0;background:rgba(0,0,0,0.7);z-index:2000;width:100%;height:100%;display:none;">
						       		<div id="innerdiv" style="margin: 0 auto;width: 650px;padding-top:150px;">
						       			<img id="bigimg" style="border:5px solid #fff;width: 650px;" src="" />
						       		</div>
						       	</div> 
                                                        <td>${item.type}</td>                         
                                                        <td>${item.typeName}</td>                         
                                                        <td>
                                <div class="hidden-sm hidden-xs action-buttons">
                                    <a title="修改基本信息" class="green" 
                                       href="#admin/productCategory/toEdit?id=${item.id}&queryStr=${queryStr}">
                                        修改
                                    </a>	
                                    <a title="删除基本信息" class="red delete" data-id="${item.id}" style="cursor:pointer;"
												api-path="/admin/productCategory/delete.do">删除 
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
    
  //图片放大
    $(function(){
        $(".imgs").click(function(){
          var _this = $(this);//将当前的pimg元素作为_this传入函数  
          imgShow("#outerdiv", "#innerdiv", "#bigimg", _this);  
        });
  	});  
    
    function imgShow(outerdiv, innerdiv, bigimg, _this){
	    var src = _this.attr("src");//获取当前点击的pimg元素中的src属性  
	    $('#outerdiv').attr('display','block');
	    $(bigimg).attr("src", src);//设置#bigimg元素的src属性  
        $(outerdiv).fadeIn("fast");
        
		$(outerdiv).click(function(){//再次点击淡出消失弹出层  
	         $(this).fadeOut("fast");  
	    }
	)};  
</script>
