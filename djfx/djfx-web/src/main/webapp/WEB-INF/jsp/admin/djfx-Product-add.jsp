<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../taglib.inc.jsp" %>

<title>新增商品</title>
<link rel="stylesheet" href="/qcloud-admin/assets/css/colorbox.css"/>
<link rel="stylesheet" href="/qcloud-admin/assets/css/chosen.css" />

<!-- ajax layout which only needs content area -->
<div class="page-header">
    <h1>
        商品信息管理
        <small>
            <i class="ace-icon fa fa-angle-double-right"></i>
            新增
        </small>
    </h1>
</div><!-- /.page-header -->

<div class="row">
    <div class="col-xs-12">
        <!-- PAGE CONTENT BEGINS -->
        <form id="model-form" class="form-horizontal"  role="form" action="/admin/product/add.do"
        enctype="multipart/form-data" method="post">
            <!-- #section:elements.form -->

                  		<div class="space-4"></div>
            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="productName"> 产品名称<span style="color:red">*</span> </label>
                <div class="col-sm-9">
					<span class="col-sm-5 no-padding block input-icon input-icon-right mr10">
						<input type="text" class="width-100" maxlength="20" id="productName" name="productName" placeholder="产品名称" value=""/>
						<i class="ace-icon fa"></i>
					</span>
                </div>
            </div>
                  		<div class="space-4"></div>
            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="thumbnail"> 产品缩略图 </label>
                <div class="col-sm-9">
					<span class="col-sm-5 no-padding block input-icon input-icon-right mr10">
						<input type="file" class="width-100 btn btn-purple btn-sm" maxlength="20" id="file" name="file" placeholder="产品缩略图" value=""/>
						<i class="ace-icon fa"></i>
					</span>
                </div>
            </div>
                  		<div class="space-4"></div>
            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="detailMap"> 产品详情图 </label>
                <div class="col-sm-9">
					<span class="col-sm-5 no-padding block input-icon input-icon-right mr10">
						<input type="text" class="width-100" maxlength="20" id="detailMap" name="detailMap" placeholder="产品详情图" value=""/>
						<i class="ace-icon fa"></i>
					</span>
                </div>
            </div>
                  		<div class="space-4"></div>
            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="introduce"> 产品介绍 </label>
                <div class="col-sm-9">
					<span class="col-sm-5 no-padding block input-icon input-icon-right mr10">
						<textarea rows="5" class="width-100" id="introduce" style="height:250px!important;width:520px!important;"
							name="introduce" placeholder="产品介绍"></textarea>
						<i class="ace-icon fa"></i>
					</span>
                </div>
            </div>
                  		<div class="space-4"></div>
            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="price"> 产品价格<span style="color:red">*</span> </label>
                <div class="col-sm-9">
					<span class="col-sm-5 no-padding block input-icon input-icon-right mr10">
						<input type="text" class="width-100" maxlength="20" id="price" name="price" placeholder="产品价格" value=""/>
						<i class="ace-icon fa"></i>
					</span>
                </div>
            </div>
                  		<div class="space-4"></div>
            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="concessionalRate"> 优惠价 </label>
                <div class="col-sm-9">
					<span class="col-sm-5 no-padding block input-icon input-icon-right mr10">
						<input type="text" class="width-100" maxlength="20" id="concessionalRate" name="concessionalRate" placeholder="优惠价" value=""/>
						<i class="ace-icon fa"></i>
					</span>
                </div>
            </div>
                  		<div class="space-4"></div>
            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="specifications"> 规格<span style="color:red">*</span> </label>
                <div class="col-sm-9">
					<span class="col-sm-5 no-padding block input-icon input-icon-right mr10">
						<input type="text" class="width-100" maxlength="20" id="specifications" name="specifications" placeholder="规格（150ml/瓶）" value=""/>
						<i class="ace-icon fa"></i>
					</span>
                </div>
            </div>
                  		<!-- <div class="space-4"></div>
            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="sockId"> 库存ID<span style="color:red">*</span> </label>
                <div class="col-sm-9">
					<span class="col-sm-5 no-padding block input-icon input-icon-right mr10">
						<input type="text" class="width-100" maxlength="20" id="sockId" name="sockId" placeholder="库存id" value=""/>
						<i class="ace-icon fa"></i>
					</span>
                </div>
            </div> -->
                  		<div class="space-4"></div>
            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="productCategoryId"> 产品类型<span style="color:red">*</span> </label>
                <div class="col-sm-9">
					<!-- <span class="col-sm-5 no-padding block input-icon input-icon-right mr10">
						<input type="text" class="width-100" maxlength="20" id="productCategoryId" name="productCategoryId" placeholder="产品类型id" value=""/>
						<i class="ace-icon fa"></i>
					</span> -->
					<span class="col-sm-5 no-padding block input-icon input-icon-right mr10">
						<input type="hidden" id="productCategoryId" name="productCategoryId"> 
						<input type="text" class="width-100 showProductCategorySelect" id="productCategoryStr"
						name="productCategoryStr" style="width: 120px;" placeholder="请选择商品类型"
						readonly="readonly" api-path="/admin/productCategory/listProductCategory4Select.do" />
						<i class="ace-icon fa"></i>
					</span>
                </div>
            </div>
                     

            <div class="space-4"></div>
            <div class="clearfix form-actions">
                <div class="col-md-offset-3 col-md-9">
                    <button class="btn btn-info" type="submit"><i class="ace-icon fa fa-check bigger-110"></i>&nbsp;保&nbsp;存&nbsp;</button>
                    &nbsp; &nbsp; &nbsp;
                    <button id="back" class="btn" type="button"><i class="ace-icon fa fa-undo bigger-110"></i>&nbsp;返&nbsp;回&nbsp;</button>
                </div>
            </div>

        </form>
        <!-- PAGE CONTENT ENDS -->
    </div>
    <!-- /.col -->
</div><!-- /.row -->

<script type="text/javascript">
    var scripts = [null, "/qcloud-admin/assets/js/jquery.colorbox-min.js","/qcloud-admin/assets/js/upload-img.js","/qcloud-admin/assets/js/chosen.jquery.min.js", null];
    ace.load_ajax_scripts(scripts, function () {
        //inline scripts related to this page
        
        //富文本编辑
        window.UMEDITOR_HOME_URL = "/qcloud-admin/umeditor/";
        var um = UM.getEditor('introduce', {
        	toolbar:[
                'source | undo redo | bold italic underline strikethrough | superscript subscript | forecolor backcolor | removeformat |',
                'insertorderedlist insertunorderedlist | selectall cleardoc paragraph | fontfamily fontsize' ,
                '| justifyleft justifycenter justifyright justifyjustify |'
            ],
            lang: /^zh/.test(navigator.language || navigator.browserLanguage || navigator.userLanguage) ? 'zh-cn' : 'en',
            langPath: UMEDITOR_CONFIG.UMEDITOR_HOME_URL + "lang/"
        });
        UM.clearCache('introduce');
        
    	//岗位dialog
        $(".showProductCategorySelect").on("click", function () {
        	var url = $(this).attr('api-path');
            BootstrapDialog.show({
                title: '请选择商品类型',
                message: $('<div></div>').load(url),
                cssClass: "select-product-dialog",
                draggable: true,
                onshow: function (dialog) {
                	$(document).off("click", ".modal-body .paginate_button a");
                    $(document).on("click", ".modal-body .paginate_button a", function (e) {
                        e.preventDefault();
                        var obj = $(this);
                        var urlNew = obj.attr("href").replace(/#/, "/");
                       	if (urlNew != "javascript:;" && urlNew) {
                       		if(urlNew.indexOf(".do") == -1){
                       			urlNew = urlNew.substring(0,urlNew.indexOf("?")) + ".do" + urlNew.substring(urlNew.indexOf("?")); 
                       		}
                            dialog.getModalBody().html($('<div></div>').load(urlNew));
                            return false;
                        }
                        return false;
                    });
                    $(document).off("click", ".searchBtn");
                    $(document).on("click", ".searchBtn", function (e) {
                        e.preventDefault();
                        var obj = $(this);
                        if (obj.hasClass("searchBtn")) {
                            var form = obj.parents("form").eq(0);
                            if (form) {
                                var url = form.prop("action");
                                var fieldArray = form.serializeArray();
                                var query_str = "";
                                $.each(fieldArray, function (i, data) {
                                    if ($.trim(data['value'])) {
                                        query_str += (query_str == '') ? '?' + data['name'] + '=' + data['value'] : '&' + data['name'] + '=' + data['value'];
                                    }
                                });
                                url && dialog.getModalBody().html($('<div></div>').load(url + query_str));
                            }
                            return false;
                        }
                        var urlNew = obj.attr("href").replace(/#/, "/");
                        if (urlNew != "javascript:;" && urlNew) {
                            dialog.getModalBody().html($('<div></div>').load(urlNew));         
                            return false;
                        }
                        return false;
                    });
                    $(document).off("click", ".confirmBtn");
                    $(document).on("click", ".confirmBtn", function (e) {
                        var temp = $("input[name='jobRadio']:checked:checked").val();
                        $("#productCategoryStr").val(temp.substring(temp.indexOf(",") + 1));
                        $("#productCategoryId").val(temp.substring(0,temp.indexOf(",")));
                        dialog.close();
                    });
                }
            });
        });
        
        
        /* jQuery(function ($) {
            $(window)
            .off('resize.chosen')
            .on('resize.chosen', function() {
                $('.chosen-select').each(function() {
                     var $this = $(this);
                     $this.next().css({'width': $this.parent().width()});
                })
            }).trigger('resize.chosen');
                   
            //表单验证
            $("#model-form").validate({
                errorElement: 'div',
                errorClass: 'help-block col-xs-12 col-sm-reset inline',
                focusInvalid: false,
                rules: {
                	productName: {
                        required: true
                    },
                    price: {
                        required: true
                    },
                    specifications: {
                        required: true
                    },
                    sockId: {
                        required: true
                    },
                    productCategoryId: {
                        required: true
                    }
                },

                messages: {
                	productName: {
                        required: "商品名称不能为空"
                    },
                    price: {
                        required: "商品价格不能为空"
                    },
                    specifications: {
                        required: "商品规格不能为空"
                    },
                    sockId: {
                        required: "商品库存不能为空"
                    },
                    productCategoryId: {
                        required: "商品类型不能为空"
                    }
                },

                highlight: function (e) {
                    $(e).closest('.form-group').removeClass('has-success').addClass('has-error');
                },

                success: function (e) {
                    $(e).closest('.form-group').removeClass('has-error').addClass('has-success');
                    $(e).remove();
                },

                errorPlacement: function (error, element) {
                    if (element.is('input[type=checkbox]') || element.is('input[type=radio]')) {
                        var controls = element.closest('div[class*="col-"]');
                        if (controls.find(':checkbox,:radio').length > 1) controls.append(error);
                        else error.insertAfter(element.nextAll('.lbl:eq(0)').eq(0));
                    }
                    else if (element.is('.select2')) {
                        error.insertAfter(element.siblings('[class*="select2-container"]:eq(0)'));
                    }
                    else if (element.is('.chosen-select')) {
                        error.insertAfter(element.siblings('[class*="chosen-container"]:eq(0)'));
                    }
                    else error.insertAfter(element.parent());
                },

                submitHandler: function (form) {
                    postForm('model-form');
                },
                invalidHandler: function (form) {
                }
            });
        }); */
    })
</script>
