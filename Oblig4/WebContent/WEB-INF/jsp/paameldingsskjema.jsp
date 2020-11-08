<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="no">
  <head>
    <link rel="shortcut icon" href="#">
    <link href="css/main.css" rel="stylesheet" type="text/css" />
    <link href="css/formcontroller.css" rel="stylesheet" type="text/css" />
    <script src="js/validator.js" defer></script>
<!--     <script src="js/formcontroller.js" defer></script> -->

    <title>Påmelding</title>
  </head>
  <body>
    <h2>Påmelding</h2>

    <div id="root">
      <form method="post" action="paamelding">
        <fieldset>
          <label for="fornavn">Fornavn:</label> <input type="text" name="fornavn" id="fornavn" value="${deltagerForm.fornavn}" />
          <span class="melding"><font color="red">${deltagerForm.fornavnMelding}</font></span>

          <label for="etternavn">Etternavn:</label> <input type="text" name="etternavn" id="etternavn" value="${deltagerForm.etternavn}" />
          <span class="melding"><font color="red">${deltagerForm.etternavnMelding}</font></span>

          <label for="mobil">Mobil (8 siffer):</label> <input type="text" name="mobil" id="mobil" value="${deltagerForm.mobil}" />
          <span class="melding"><font color="red">${deltagerForm.mobilMelding}</font></span>

          <label for="passord">Passord:</label> <input type="password" name="passord" id="passord" />
          <span class="melding"><font color="red">${deltagerForm.passordMelding}</font></span>

          <label for="passordRepetert">Passord repetert:</label> <input type="password" name="passordRepetert" id="passordRepetert" />
          <span class="melding"><font color="red">${deltagerForm.passordRepetertMelding}</font></span>

<div id="infoPassord">
				<p>Info om passordstyrke:</p>
				<p> <font color="red">Rødt</font> - Under 8 tegn, Ugyldig passord</p>
				<p> <font color="yellow">Gult</font> - Mellom 8-12 tegn, Gyldig, men middels sterkt</p>
				<p> <font color="green">Grønt</font> - Over 12 tegn, Gyldig og sterkt </p>
</div>

          <span class="columnfirst">Kjønn:</span>
          <span data-kjonn>
            <label><input type="radio" name="kjonn" value="mann" ${deltagerForm.kjonn eq "mann" ? "checked=\"checked\"" : ""} /> mann</label>
            <label><input type="radio" name="kjonn" value="kvinne" ${deltagerForm.kjonn eq "kvinne" ? "checked=\"checked\"" : ""} />kvinne</label>
          </span>
          <span class="melding"><font color="red">${deltagerForm.kjonnMelding}</font></span>

          <button type="submit">Meld meg på</button>
        </fieldset>
      </form>
        <div data-info="passord"></div>
        <div data-info="submit"></div>
    </div>
  </body>
</html>