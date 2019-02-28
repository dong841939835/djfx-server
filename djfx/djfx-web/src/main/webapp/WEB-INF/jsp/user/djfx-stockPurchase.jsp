<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../taglib.inc.jsp" %>

<title>进货管理</title>

<!-- ajax layout which only needs content area -->
<div class="page-header">
    <h1>
        商品信息管理
        <small>
            <i class="ace-icon fa fa-angle-double-right"></i>
            列表
        </small>
    </h1>
</div><!-- /.page-header -->

<div class="row">
    <div class="col-xs-12">

        <div class="table-header">
            商品信息列表
        </div>

        <!-- <div class="table-responsive"> -->

        <!-- <div class="dataTables_borderWrap"> -->
        <div>
            <div class="dataTables_wrapper form-inline no-footer">
                <div class="row">
                    <div class="col-xs-6">
                        <div class="dataTables_length">
                            <a title="新增" class="btn btn-sm btn-info"
                               href="#admin/order/shoppingCart">
                                购物车
                            </a>                           
                        </div>
                    </div>
                    <div class="col-xs-6">
						<div style="float:right;">
				             <form action="#admin/product/stockPurchase" onsubmit="listFormSearch(this); return false">
				                 <div class="dataTables_length">
									 <input type="text" class="form-control" id="productName" name="productName" style="width:150px;"
                                        value="${query.productName}" placeholder="可输入模糊商品名称"/>
                                        	
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
                                                <th>产品图</th>
                                                <th>产品名称</th>
                                                <th>原价</th>
                                                <th>优惠价</th>           
                                                <th>类型</th>
                                                <th>规格</th>           
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
                                                        <td>${item.productName}</td>  
									  					<td>${item.price}</td>
							  					<c:choose> 
							  						<c:when test="${item.concessionalRate != 0.0}"> 
							  							<th>${item.concessionalRate}</th>
							  						</c:when>
							  						<c:otherwise>
							  							<td>敬请期待</td>
							  						</c:otherwise>
							  					</c:choose>
                                                        <td>${item.productCategoryStr}</td>
                                                        <td>${item.specifications }</td>                         
                                                        <td>
                                <div class="hidden-sm hidden-xs action-buttons">
                                    <button type="button" class="btn btn-info btn-sm button1" href-data="/admin/product/toAddOrder.do"
										    onclick="addMaterialType(this,${item.id})" product-id="${item.id}">
										        <i class="ace-icon fa fa-plus align-bottom bigger-125"></i>
										      	 加入购物车
									</button>  	
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
    	
    });
    
  //新增方法
	function addMaterialType(obj,productId){
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
                	 
                	 var query_str = "/admin/product/addOrder.do?productId="+productId+"&";
                	 
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
