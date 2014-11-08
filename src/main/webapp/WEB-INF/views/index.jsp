<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <jsp:include page="header.jsp" />

    <!-- Main Content -->
    <div class="container keski">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">

                        <jsp:include page="listaus.jsp" />

            </div>
        </div>
    </div>

    <header class="intro-header">
    <div class="container tumma" id="lomake">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">

                        <jsp:include page="lomake.jsp" />

            </div>
        </div>
    </div>
    </header>

    <jsp:include page="footer.jsp" />
