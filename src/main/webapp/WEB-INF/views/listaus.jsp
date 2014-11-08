<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<h2>
    Kurssilistaus
</h2>
<ul>
    <c:forEach var="kurssi" items="${kurssit}">
        <li>
            ${kurssi.nimi}
            <ul> 
                <c:forEach var="tentti" items="${kurssi.kurssinTentit}">
                    <li><a href="/tentit/${tentti.id}">${tentti.pvm}</a>
                    </li>
                </c:forEach>
            </ul>
        </li>
    </c:forEach>
</ul>