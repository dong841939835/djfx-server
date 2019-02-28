<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@include file="../taglib.inc.jsp" %>
<style>
	.select-product-dialog {
        top: 50px;
    }
    .select-product-dialog tr {
        word-break: break-all;
    }
    .select-product-dialog .modal-content {
        min-height: 500px;
        min-width: 800px;
    }
</style>
<div class="row">
    <div class="col-xs-12">
<div class="row">
            <form action="/admin/productCategory/listProductCategory4Select.do">
                <div class="col-xs-6">
                    <label>
                        <div class="input-group" style="display:flex;">
                            <input type="search" maxlength="25" class="width-100" placeholder="请输入商品类型名称" name="typeName" 
                            	value="${query.typeName}" style="margin-right:10px;">
                            <span class="input-group-btn">
                                <button type="submit" class="btn btn-purple btn-sm search-button searchBtn" style="margin-right:10px;">
                                    <i class="ace-icon fa fa-search icon-on-right bigger-110"></i>搜索
                                </button>
                                <button type="button" class="btn btn-purple btn-sm search-button confirmBtn">
                                    <i class="ace-icon fa fa-search icon-on-right bigger-110"></i>确认
                                </button>
                            </span>
                        </div>
                    </label>
                </div>
            </form>
        </div>
            <div class="dataTables_wrapper form-inline no-footer">
                <table
					class="table table-striped table-bordered table-hover dataTable no-footer">
					<thead>
						<tr role="row">
							<th>ID</th>
							<th>商品类型</th>
							<th>商品类型名称</th>
							<th class="sorting_disabled">操作</th>
						</tr>
					</thead>

					<tbody>
						<c:forEach items="${result}" var="item" varStatus="current">
							<tr>
								<td>${item.id}</td>
								<td>${item.type}</td>
								<td>${item.typeName}</td>
								<td>
									<div class="hidden-sm hidden-xs action-buttons">
										<input name="jobRadio" type="radio" class="ace" value="${item.id},${item.typeName}">
										<span class="lbl"></span>
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

