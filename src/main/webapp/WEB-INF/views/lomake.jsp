<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:set var="url" value="${pageContext.request.requestURI}" />

    <header class="intro-header">
    <div class="container tumma" id="lomake">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">

            <h2>Lisää uusi tentti</h2>
            <form method="POST" action="/tentit" id="lomakeform" enctype="multipart/form-data">
                    <p>Tiedosto</p><input type="file" name="tiedosto" />

                    <p>Kurssi</p><!--<input type="text" name="kurssi" />-->
                    
                     <select id="kurssihaku" name="kurssi">
                            <c:choose>
                                <c:when test="${fn:indexOf(url, 'tentit') ne 1}">
                                    <option value="${tentti.kurssi.nimi}">${tentti.kurssi.nimi}</option>
                                </c:when>
                                <c:otherwise>
                                    <option></option> <!-- placeholderille -->
                                </c:otherwise>
                            </c:choose>
                            <c:forEach var="kurssi" items="${kurssit}">
                                <option value="${kurssi.nimi}">${kurssi.nimi}</option>
                            </c:forEach>
                    </select>

                    <p>Päivämäärä</p><input type="text" name="pvm" id="datepicker" />

                    <p>Tyyppi</p>
                    <select name="tyyppi">
                        <c:forEach var="tyyppi" items="${tyypit}">
                            <option value="${tyyppi.id}">${tyyppi}</option>
                        </c:forEach>
                    </select>

                    <p>Kieli</p>	
                    <select name="kieli">
                        <c:forEach var="kieli" items="${kielet}">
                            <option value="${kieli.id}">${kieli.nimi}</option>
                        </c:forEach>
                    </select>

                    <p>Pitäjä</p><input type="text" name="pitaja" />
                    
                     <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                    <p><br/><input class="btn btn-default" type="submit" value="Lähetä"/>
            </form>
            <br/>

            </div>
        </div>
    </div>
    </header>