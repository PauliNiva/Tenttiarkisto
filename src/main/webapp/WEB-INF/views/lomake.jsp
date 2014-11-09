<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h2>Lisää uusi tentti</h2>
<form method="POST" action="/tents" id="lomakeform">
        <p>Tiedosto</p><input type="file" name="tiedosto" />
        <p>Kurssi</p><input type="text" name="kurssi" />
        <p>Päivämäärä</p><input type="text" name="pvm" id="datepicker" />
        <p>Tyyppi</p>
        <select name="tyyppi">
                <option>Kurssikoe</option>
                <option>Erilliskoe</option>
        </select>
        <p>Kieli</p>	
        <select name="kieli">
                <option>Suomi</option>
                <option>English</option>
        </select>
        <p>Pitäjä</p><input type="text" name="pitaja" />
        <p><br/><input class="btn btn-default" type="submit" value="Lähetä"/>
</form>