<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<%@taglib prefix="t" uri="/WEB-INF/tenttisort.tld" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h2>Kurssilistaus</h2>

<input id="haku" type="text" name="haku" autocomplete="off" placeholder="Hae kurssia..." style="margin-top:10px;" />

<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
    <c:forEach var="kurssi" items="${kurssit}"> <c:if test="${fn:length(kurssi.kurssinTentit) gt 0}">
            <div class="panel-heading" role="tab" id="heading${kurssi.id}">
              <h4 class="panel-title">
                <a class="kurssilinkki" data-toggle="collapse" data-parent="#accordion" href="#collapse${kurssi.id}" aria-expanded="true" aria-controls="collapse${kurssi.id}">
                  ${kurssi.nimi}
                  <div class="glyphicon glyphicon-chevron-right"></div>
                </a>
              </h4>
            </div>
            <div id="collapse${kurssi.id}" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="heading">
              <div class="panel-body">
                  <table class="table kurssintentit" align="center">
                    <c:forEach var="tentti" items="${t:sortByDate(kurssi.kurssinTentit)}">
                        <tr>
                            <td><strong>${tentti.pvm}</strong></td><td>${tentti.tyyppi}</td><td><a href="${tentti.fileURL}"><div class="glyphicon glyphicon-download"></div></a></td><td><a href="/tentit/${tentti.id}">Tentin tiedot</a></td>
                        </tr>
                    </c:forEach>
                  </table>
              </div>
            </div>
        </c:if> </c:forEach>  
</div>