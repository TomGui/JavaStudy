<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Tom
  Date: 2017/7/18
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="table-scrollable table-scrollable-borderless">
    <table class="table table-hover table-light">
        <thead>
        <tr class="uppercase">
            <th>登录名</th>
            <th>医院</th>
            <th>备注</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <%--<c:if test="${items!=null&&items.size()>0}">--%>
            <%--<c:forEach var="item" items="${items}">--%>
                <tr>
                    <%--<td>${item.loginName}</td>--%>
                    <%--<td>${item.hospitalId}</td>--%>
                    <%--<td>${item.userDesc}</td>--%>
                        <td>1</td>
                        <td>1</td>
                        <td>2</td>
                    <td>
                        <button type="button" class="btn btn-default btn-sm" data-toggle="modal"
                                onclick="Edit(2)">
                            编辑
                        </button>
                        <button type="button" class="btn btn-danger btn-sm" data-toggle="modal"
                                onclick="Delete(3)">
                            删除
                        </button>
                    </td>
                </tr>
            <%--</c:forEach>--%>
        <%--</c:if>--%>
        </tbody>
    </table>
</div>
<hr style="margin-top: 0">
<div id="pagetoolbar"></div>
<script>
    $(function () {
        $("#pagetoolbar").bs_pagination({
            currentPage: 1,
            rowsPerPage: 10,
            maxRowsPerPage: 100,
            totalPages: 100,
            totalRows: 100,
            showGoToPage: true,
            showRowsPerPage: false,
            showRowsInfo: false,
            showRowsDefaultInfo: true,

            onChangePage: function (data, param) { // 点击后返回page_num和rows_per_page
                $("#PageIndex").val(param.currentPage);
                $.ajax({
                    type: "GET",
                    url: "${pageContext.request.contextPath}/administrator/list",
                    data: $("#searchform").serialize(),
                    success: function (data) {
                        $("#datagrid").empty();
                        $("#datagrid").html(data);
                    }
                });
            }

            ,
            onLoad: function () { // 在插件加载时返回page_num和rows_per_page
            }
        })
        ;
    });

    var userId;
    function Delete(id) {
        userId = id;
        $("#deletemodal").modal("show");
    }
</script>