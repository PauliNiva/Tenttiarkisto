<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <jsp:include page="header.jsp" />

    <!-- Main Content -->
    <div class="container keski">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">

                <form action="/tervetuloa" method="POST">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> 
                    <div><p>Käyttäjä:</p><input type="text" name="kayttaja"/></div>
                    <div><p>Salasana:</p><input type="text" name="salasana"/></div><br/>
                    <div><input class="btn" type="submit" value="Kirjaudu"/></div>
                </form>
                <br/>
            </div>
        </div>
    </div>
    
    <header class="intro-header">
    <div class="container tumma" id="lomake">
        <div class="row">
            
        </div>
    </div>
    </header>

    <jsp:include page="footer.jsp" />