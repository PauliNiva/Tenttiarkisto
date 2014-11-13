<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h2>
    Kurssilistaus
</h2>

<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
    <c:forEach var="kurssi" items="${kurssit}">
        <div class="panel-heading" role="tab" id="heading">
          <h4 class="panel-title">
            <a data-toggle="collapse" data-parent="#accordion" href="#collapse${kurssi.id}" aria-expanded="true" aria-controls="collapse${kurssi.id}">
              ${kurssi.nimi}
              <div class="glyphicon glyphicon-chevron-right"></div>
            </a>
          </h4>
        </div>
        <div id="collapse${kurssi.id}" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="heading">
          <div class="panel-body">
            <c:forEach var="tentti" items="${kurssi.kurssinTentit}">
                <a href="/tentit/${tentti.id}">${tentti.pvm} ${tentti.tyyppi}</a><br/>
            </c:forEach>
          </div>
        </div>
    </c:forEach>  
</div>