<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page="header.jsp" />

<!-- Main Content -->
<div class="container keski">
    <div class="row">
        <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">

            <div class="row">
                <div class="col-lg-10 col-md-10 col-sm-10 col-lg-offset-1">
                    <a class="tiedot-linkki" href="${tentti.fileURL}">Katso tentti tästä <div class="glyphicon glyphicon-log-in"></div></a><br/><br/>

                    <table class="table tiedot">
                        <tr><td class="tiedot-label">Kurssi</td><td class="tiedot-tieto">${tentti.kurssi.nimi}</td></tr>
                        <tr><td class="tiedot-label">Päivämäärä</td><td class="tiedot-tieto">${tentti.pvm}</td></tr>
                        <tr><td class="tiedot-label">Pitäjä</td><td class="tiedot-tieto">${tentti.pitaja}</td></tr>
                        <tr><td class="tiedot-label">Tyyppi</td><td class="tiedot-tieto">${tentti.tyyppi}</td></tr>
                        <tr><td class="tiedot-label">Kieli</td><td class="tiedot-tieto">${tentti.kieli}</td></tr>                        
                    </table>

                    <a href="/">Takaisin</a>


                </div>

            </div>

        </div>
    </div>
    <div class="row">
        <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
            <br/><hr/>
            <h3>Kommentoi</h3>
            <form action="/kommentit" method="post">
                <div><p>Nimi:</p><input type="text" name="nimi"/></div>
                <div><p>Kommentti:</p><textarea cols="40" rows="5" name="kommentti"></textarea></div>
                <br/>
                <div><input class="btn" type="submit" value="Lähetä"/></div>
            </form>


            </ul>
        </div>
    </div>
</div>

<jsp:include page="lomake.jsp" />                    

<jsp:include page="footer.jsp" />