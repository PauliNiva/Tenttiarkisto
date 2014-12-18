<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page="header.jsp" />

<!-- Main Content -->
<div class="container keski">
    <div class="row">
        <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">

            <div class="row">
                <div class="col-lg-10 col-md-10 col-sm-10 col-lg-offset-1 col-md-offset-1 col-sm-offset-1">
                    <a class="tiedot-linkki" href="${tentti.fileURL}">Katso tentti tästä <div class="glyphicon glyphicon-log-in"></div></a><br/><br/>

                    <table class="table tiedot">
                        <tr><td class="tiedot-label">Kurssi</td><td class="tiedot-tieto">${tentti.kurssi.nimi}</td></tr>
                        <tr><td class="tiedot-label">Päivämäärä</td><td class="tiedot-tieto">${tentti.pvm}</td></tr>
                        <tr><td class="tiedot-label">Pitäjä</td><td class="tiedot-tieto">${tentti.pitaja}</td></tr>
                        <tr><td class="tiedot-label">Tyyppi</td><td class="tiedot-tieto">${tentti.tyyppi}</td></tr>
                        <tr><td class="tiedot-label">Kieli</td><td class="tiedot-tieto">${tentti.kieli}</td></tr>    
                    </table>

                    <sec:authorize access="hasRole('ROLE_ADMIN')">
                        <p>
                        <form action="/tentit/${id}" method="POST" onsubmit="return confirm('Haluatko varmasti poistaa tentin?');">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> 
                            <input type="hidden" name="_method" value="DELETE"/>
                            <input type="submit" value="poista tentti" class="btn"/>
                        </form>
                        </p>
                    </sec:authorize>


                    <a href="/">Takaisin</a>

                </div>
            </div>

        </div>
    </div>
    <div class="row">
        <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
            <br/><hr/>
            <h3>Lisää mallivastaus</h3>
            <form action="/tentit/${tentti.id}/mallivastaus" method="post" id="mallivastausform" enctype="multipart/form-data">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> 
                <div><br/><input type="file" name="tiedosto" required /></div>
                <br/>
                <div><input class="btn" type="submit" value="Lähetä"/></div>
            </form>


            <br/>
        </div>
    </div>                       
    <div class="row kommentit">
        <br/><hr/>
        <h3>Kommentit</h3><br/>
        <c:forEach var="kommentti" items="${tentti.tentinKommentit}"> 
            <div class="panel-heading">
                <p class="kommentinkirjoittaja"><strong>${kommentti.kirjoittaja}</strong> (${kommentti.pvm})</span></p>
                <p class="kommentinsisalto">${kommentti.sisalto}</p>
                <sec:authorize access="hasRole('ROLE_ADMIN')">
                    <p>
                    <form action="/tentit/${tentti.id}/kommentit/${kommentti.id}" method="POST"  onsubmit="return confirm('Haluatko varmasti poistaa kommentin?');">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> 
                        <input type="hidden" name="_method" value="DELETE"/>
                        <input type="submit" value="poista kommentti" class="btn"/>
                    </form>
                    </p>
                </sec:authorize>
            </div>
        </c:forEach>  
    </div>                        
    <div class="row">
        <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
            <br/>
            <h4>Lisää kommentti</h4>
            <form action="/tentit/${tentti.id}/kommentit" method="post">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> 
                <div><p>Nimi:</p><input type="text" name="nimi"/></div>
                <div><p>Kommentti:</p><textarea cols="40" rows="5" name="kommentti"></textarea></div>
                <br/>
                <div><input class="btn" type="submit" value="Lähetä"/></div>
            </form>


            <br/>
        </div>
    </div>         
</div>

<jsp:include page="lomake.jsp" />                    

<jsp:include page="footer.jsp" />