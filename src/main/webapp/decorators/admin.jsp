<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/common/taglib.jsp" %>
<html lang="en">

<!-- Head -->
<%@ include file="/common/admin/header.jsp" %>

<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
        <%@ include file="/common/admin/sidebar.jsp" %>
        <!-- End of Sidebar -->

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <!-- Topbar -->
                <%@ include file="/common/admin/topbar.jsp" %>
                <!-- End of Topbar -->
                
                <!--Content-->
                <dec:body></dec:body>
                
            </div>
            <!-- End of Main Content -->

            <!-- Footer -->
            <%@ include file="/common/admin/footer.jsp" %>
            <!-- End of Footer -->

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <!-- Scroll to Top Button-->
    <%@ include file="/common/admin/scroll-to-top.jsp" %>

    <!-- Logout Modal-->
    


    
	<%@ include file="/common/admin/script.jsp" %>
    <!-- Page level plugins -->
    
    <script src="<c:url value='/template/admin/vendor/chart.js/Chart.min.js'/>"></script>

    <!-- Page level custom scripts -->
    
    <script src="<c:url value='/template/admin/js/demo/chart-area-demo.js'/>"></script>
    
    <script src="<c:url value='/template/admin/js/demo/chart-pie-demo.js'/>"></script>
    

</body>

</html>