<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@include file="../taglib.inc.jsp" %>
<script type="text/javascript" src="/qcloud-admin/assets/js/jquery.ztree.core.js"></script>
<script type="text/javascript" src="/qcloud-admin/assets/js/jquery.ztree.excheck.js"></script>
<link rel="stylesheet" href="/qcloud-admin/assets/css/zTreeStyle.css" />
<style>
	.select-product-dialog {
        top: 50px;
    }
    .select-product-dialog tr {
        word-break: break-all;
    }
    .select-product-dialog .modal-content {
        min-height: 500px;
        max-height: 700px;
        min-width: 600px;
        overflow:scroll;
    }
</style>
<div class="row">
    <div class="col-xs-12">
		<div class="row">
            <form action="">
                <div class="col-xs-6">
                    <label>
                        <div class="input-group" style="display:flex;">
                            <span class="input-group-btn">
                                <button type="button" class="btn btn-purple btn-sm orgDepConfirmButton">
                                    <i class="ace-icon fa fa-search icon-on-right bigger-110"></i>确认
                                </button>
                                <c:if test="${type eq 'radio'}">
	                                <button type="button" class="btn btn-purple btn-sm clearOrgDepBtn" style="margin-left:38px;">
	                                    	清空选择
	                                </button>
                                </c:if>
                            </span>
                        </div>
                    </label>
                </div>
            </form>
        </div>
            <div class="dataTables_wrapper form-inline no-footer">
                <div class="zTreeDemoBackground left">
					<ul id="treeDemo" class="ztree"></ul>
				</div>
            </div>
            <input type="hidden" id="userIdStr">
            <input type="hidden" id="userNameStr">
            <input type="hidden" id="userIdStr4Radio">
            <input type="hidden" id="userNameStr4Radio">
            <input type="hidden" id="superiorIdStr">
            <input type="hidden" id="superiorNameStr">
            <input type="hidden" id="superiorIdStr4Radio">
            <input type="hidden" id="superiorNameStr4Radio">
       </div>
</div>

<script type="text/javascript">
    var scripts = [null, null];
    ace.load_ajax_scripts(scripts, function () {
    	$(".clearOrgDepBtn").on("click", function () {
    		$(".showOrgDep").each(function(){
    			$(this).val("");
    		});
    		$(".hiddenOrgDep").each(function(){
    			$(this).val("");
    		});
    		var ztreeObj = $.fn.zTree.getZTreeObj("treeDemo");
        	var nodes = ztreeObj.getCheckedNodes(true);
        	for (var i=0, l=nodes.length; i < l; i++) {
        		ztreeObj.checkNode(nodes[i], false, false);
        	}
    	});
    });
    
    var setting = {
		check: {
			enable: true
		},
		data: {
			simpleData: {
				enable: true,
				idKey: "id",
				pIdKey: "pId",
				rootPId: 0
			}
		},
		async: {
			enable: true,
			url: "/admin/pageSelect/getUserTreeAjax.do",
			dataFilter: ajaxDataFilter,
			dataType:"json"
			/* otherParam: {"rStr":"${rStr}", "bStr":"${bStr}"} */
		},
		check: {
			enable: true,
			chkStyle: "${type}",
			radioType: "all"
		},
		callback: {
			onCheck: zTreeOnCheck
		}
	};

	$(document).ready(function(){
		$.fn.zTree.init($("#treeDemo"), setting);
	});
	
	function ajaxDataFilter(treeId, parentNode, responseData) {
	    return responseData.data.zNodes;
	};
	
	function zTreeOnCheck(event, treeId, treeNode) {
	    /* console.info(treeNode.tId + ", " + treeNode.name + "," + treeNode.checked); */
		if(treeNode.pId == 0){
			$("#userNameStr4Radio").val(treeNode.name);
			$("#userIdStr4Radio").val(treeNode.id);
	    }else{
	    	var pnode = treeNode.getParentNode();
	    	$("#superiorNameStr4Radio").val(pnode.name);
			$("#superiorIdStr4Radio").val(pnode.id);
			$("#userNameStr4Radio").val(treeNode.name);
			$("#userIdStr4Radio").val(treeNode.id);
	    }
	    
		var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
		var nodes = treeObj.getCheckedNodes(true);
		var regionNameStr = "";
		var branchNameStr = "";
		var regionId = "";
		var branchId = "";
		for(var i = 0;i < nodes.length;i++){
			if(nodes[i].pId == 0){
				regionNameStr += nodes[i].name + ",";
				regionId += nodes[i].id + ",";
			}else{
				branchNameStr += nodes[i].name + ",";
				branchId += nodes[i].id + ",";
			}
		}
		$("#superiorNameStr").val(regionNameStr.substring(0,regionNameStr.lastIndexOf(",")));
		$("#userNameStr").val(branchNameStr.substring(0,branchNameStr.lastIndexOf(",")));
		$("#superiorIdStr").val(regionId.substring(0,regionId.lastIndexOf(",")));
		$("#userIdStr").val(branchId.substring(0,branchId.lastIndexOf(",")));
	};
</script>
