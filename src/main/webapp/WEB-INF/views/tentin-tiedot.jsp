<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page="header.jsp" />

<!-- Main Content -->
<div class="container keski">
    <div class="row">
        <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">

            <div class="row">
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <p class="tiedot-label">Linkki:</p>
                </div>
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <a class="tiedot-tieto" href="${tentti.fileURL}">Lataa</a>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <p class="tiedot-label">Kurssi:</p>
                </div>
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <p class="tiedot-tieto">${tentti.kurssi.nimi}</p>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <p class="tiedot-label">Päivämäärä:</p>
                </div>
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <p class="tiedot-tieto">${tentti.pvm}</p>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <p class="tiedot-label">Pitäjä:</p>
                </div>
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <p class="tiedot-tieto">${tentti.pitaja}</p>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <p class="tiedot-label">Tyyppi:</p>
                </div>
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <p class="tiedot-tieto">${tentti.tyyppi}</p>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <p class="tiedot-label">Kieli:</p>
                </div>
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <p class="tiedot-tieto">${tentti.kieli}</p>
                </div>
            </div>

        </div>
    </div>
</div>
                    
<jsp:include page="lomake.jsp" />                    

<jsp:include page="footer.jsp" />