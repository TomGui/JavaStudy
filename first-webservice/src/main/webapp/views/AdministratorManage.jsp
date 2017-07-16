<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="ot" tagdir="/WEB-INF/tags" %>
<ot:mainLayout title="后台账户管理">
    <div class="row">
        <div class="col-md-12">
            <div class="portlet light portlet-fit ">
                <div class="portlet-title">
                    <div class="caption">
                        <i class="icon-settings font-dark"></i>
                        <span class="caption-subject font-dark sbold uppercase">系统用户列表</span>
                    </div>
                    <div class="actions">
                        <div class="btn-group btn-group-devided" data-toggle="buttons">
                            <button type="button" class="btn btn-circle btn-primary" data-toggle="modal"
                                    onclick="Edit()">
                                添加系统用户
                            </button>
                        </div>
                    </div>
                    <form class="form-horizontal" role="form" asp-controller="Administrator" asp-action="List"
                          method="get" id="searchform">
                        <input asp-for="PageIndex" hidden/>
                        <input asp-for="HospitalId" value="-1" hidden/>
                    </form>
                </div>
                <div class="portlet-body" id="datagrid">
                </div>
            </div>
        </div>
    </div>
    <div class="modal fade" id="editmodal" tabindex="-1" role="dialog" aria-hidden="true" style="display: none;">

    </div>
    <div class="modal fade" id="promptmodal" tabindex="-1" role="dialog" aria-hidden="true" style="display: none;">

    </div>
    <div class="modal fade" id="errormodal" tabindex="-1" role="dialog" aria-hidden="true" style="display: none;">

    </div>
    <div class="modal fade" id="deletemodal" tabindex="-1" role="dialog" aria-hidden="true" style="display: none;">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
                    <h4 class="modal-title">删除</h4>
                </div>
                <div class="modal-body">
                    是否确定删除？
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn dark btn-outline" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn red" onclick="Confirm()">确定</button>
                </div>
            </div>
        </div>
    </div>
    <script>
        $(function () {
            $("#systemnav").addClass("start active open");
            Search();
        })

        function Search() {
            $("#PageIndex").val(1);
            $.ajax({
                type: "GET",
                url: "${pageContext.request.contextPath}/user/login",
                data: $("#searchform").serialize(),
                success: function (data) {
                    $("#datagrid").empty();
                    $("#datagrid").html(data);
                }
            });
        }

        function Confirm() {
            $.ajax({
                type: "POST",
                url: "${pageContext.request.contextPath}/user/login" + "?id=" + userId,
                success: function (data) {
                    $("#deletemodal").modal("hide");
                    if (data.IsSuccess) {
                        $(".modal-backdrop.fade.in").remove();
                        //提示框
                        $("#promptmodal").empty();
                        $("#promptmodal").load("${pageContext.request.contextPath}/user/login" + "?isSuccess=" + data.IsSuccess + "&message=" + data.Message + "&url=" + "${pageContext.request.contextPath}/user/login"
                    )
                        ;
                        $("#promptmodal").modal("show");
                    } else {
                        //错误框
                        $("#errormodal").empty();
                        $("#errormodal").load("${pageContext.request.contextPath}/user/login" + "?isSuccess=" + data.IsSuccess + "&message=" + data.Message
                    )
                        ;
                        $("#errormodal").modal("show");
                    }
                }
            });
        }
    </script>
</ot:mainLayout>