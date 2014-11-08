<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page="header.jsp" />

<!-- Main Content -->
<div class="container keski">
    <div class="row">
        <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">

            <table>
                <tr>
                    <th>Kurssi:</th>
                    <td>${tentti.kurssi.nimi}</td>
                </tr>
                <tr>
                    <th>PVM:</th>
                    <td>${tentti.pvm}</td>
                </tr>
                <tr>
                    <th>Pitäjä:</th>
                    <td>${tentti.pitaja}</td>
                </tr>
                <tr>
                    <th>Tyyppi:</th>
                    <td>${tentti.tyyppi}</td>
                </tr>
                <tr>
                    <th>Kieli:</th>
                    <td>${tentti.kieli}</td>
                </tr>
                <tr>
                    <th>URL:</th>
                    <td>${tentti.fileURL}</td>

                </tr>
            </table>

        </div>
    </div>
</div>

<jsp:include page="footer.jsp" />