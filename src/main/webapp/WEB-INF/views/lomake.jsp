<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h2>Lisää uusi tentti</h2>
<form method="POST" action="/tents">
        <p><span>Tiedosto</span><br/><input type="file" name="tiedosto" /></p>
        <p><span>Kurssi</span><input type="text" name="kurssi"/></p>
        <p><span>Päivämäärä</span><input type="text" name="pvm" id="datepicker" /></p>
        <p><span>Tyyppi</span>
        <select name="tyyppi">
                <option>Kurssikoe</option>
                <option>Erilliskoe</option>
        </select></p>
        <p><span>Kieli<span>	
        <select name="kieli">
                <option>Suomi</option>
                <option>English</option>
        </select></p>
        <p><span>Pitäjä</span><input type="text" name="pitaja"/></p>
        <p><br/><input class="btn btn-default" type="submit" value="Lähetä"/></p>
</form>