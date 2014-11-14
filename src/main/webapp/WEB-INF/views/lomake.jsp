<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

    <header class="intro-header">
    <div class="container tumma" id="lomake">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">

            <h2>Lisää uusi tentti</h2>
            <form method="POST" action="/tentit" id="lomakeform" enctype="multipart/form-data">
                    <p>Tiedosto</p><input type="file" name="tiedosto" />

                    <p>Kurssi</p><input type="text" name="kurssi" />

                    <p>Päivämäärä</p><input type="text" name="pvm" id="datepicker" />

                    <p>Tyyppi</p>
                    <select name="tyyppi">
                        <c:forEach var="tyyppi" items="${tyypit}">
                            <option value="${tyyppi.id}">${tyyppi}</option>
                        </c:forEach>
                    </select>

                    <p>Kieli</p>	
                    <select name="kieli">
                            <option>Suomi</option>
                            <option>English</option>
                    </select>

                    <p>Pitäjä</p><input type="text" name="pitaja" />

                    <p><br/><input class="btn btn-default" type="submit" value="Lähetä"/>
            </form>
            <br/>

            </div>
        </div>
    </div>
    </header>