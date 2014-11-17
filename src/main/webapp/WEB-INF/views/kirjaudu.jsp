<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <jsp:include page="header.jsp" />

    <!-- Main Content -->
    <div class="container keski">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">

                <form action="/tervetuloa" method="post">
                    <div><label> Käyttäjä: <input type="text" name="kayttaja"/> </label></div>
                    <div><label> Salasana: <input type="salasana" name="salasana"/> </label></div>
                    <div><input type="submit" value="Kirjaudu"/></div>
                </form>

            </div>
        </div>
    </div>


    <jsp:include page="footer.jsp" />