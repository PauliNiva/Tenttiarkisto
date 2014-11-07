<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>Tenttiarkisto</title>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<!--[if lte IE 8]><script src="css/ie/html5shiv.js"></script><![endif]-->
		<script src="js/jquery.min.js"></script>
		<script src="js/jquery.scrolly.min.js"></script>
		<script src="js/skel.min.js"></script>
		<script src="js/init.js"></script>
		<noscript>
			<link rel="stylesheet" href="css/skel.css" />
			<link rel="stylesheet" href="css/style.css" />
			<link rel="stylesheet" href="css/style-wide.css" />
		</noscript>
		<!--[if lte IE 8]><link rel="stylesheet" href="css/ie/v8.css" /><![endif]-->
		<!--[if lte IE 9]><link rel="stylesheet" href="css/ie/v9.css" /><![endif]-->
	</head>
	<body>

		<!-- Header -->
			<section id="header" class="dark">
				<header>
					<h1>Tenttiarkisto</h1>
					<p>All your tents</p>
				</header>
				<footer>
					<a href="#lomake" class="button scrolly">Lisää uusi tentti</a>
				</footer>
			</section>
			
		<!-- First -->
			<section id="first" class="main">
				<header>
					<div class="container">
						<h2>Tenttilistaus</h2>
						
						<p>palvelimelta saatu teksti: ${viesti}</p>
						
					</div>
				</header>
				<div class="content dark style1 featured">
					<div class="container">
						<div class="row">
							<div class="12u">
								<section id="lomake">
									<header>
										<h3>Lisää uusi tentti</h3>
									</header>

									<form method="POST" action="/tents">
										<p><span>Kurssi</span><input type="text" name="kurssi"/></p>
										<p><span>Päivämäärä</span><input type="text" name="pvm"/></p>
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
    										<p><span>Tiedosto</span><br/><input type="file" name="tiedosto" /></p>
									    	<p><br/><input type="submit" value="Lähetä"/></p>
									</form>
								</section>
							</div>
						</div>
					</div>
				</div>
			</section>
			
		
		<!-- Fourth -->
			<!--<section id="fourth" class="main">
				<header>
					<div class="container">
						<h2>Sed feugiat ipsum consequat</h2>
						<p>Gravida dis placerat lectus ante vel nunc euismod eget ornare varius gravida euismod lorem ipsum dolor sit amet consequat<br />
						feugiat. Gravida dis placerat lectus ante vel nunc euismod eget ornare varius gravida euismod lorem ipsum dolor sit amet.</p>
					</div>
				</header>
				<div class="content style4 featured">
					<div class="container small">
						<form method="post" action="#">
							<div class="row half">
								<div class="6u"><input type="text" placeholder="Name" /></div>
								<div class="6u"><input type="text" placeholder="Email" /></div>
							</div>
							<div class="row half">
								<div class="12u"><textarea name="message" placeholder="Message"></textarea></div>
							</div>
							<div class="row">
								<div class="12u">
									<ul class="actions">
										<li><input type="submit" class="button" value="Send Message" /></li>
										<li><input type="reset" class="button alt" value="Clear Form" /></li>
									</ul>
								</div>
							</div>
						</form>
					</div>
				</div>
			</section>-->
			
		<!-- Footer -->
			<!--<section id="footer">
				<ul class="icons">
					<li><a href="#" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
					<li><a href="#" class="icon fa-facebook"><span class="label">Facebook</span></a></li>
					<li><a href="#" class="icon fa-instagram"><span class="label">Instagram</span></a></li>
					<li><a href="#" class="icon fa-dribbble"><span class="label">Dribbble</span></a></li>
					<li><a href="#" class="icon fa-github"><span class="label">GitHub</span></a></li>
				</ul>
			</section>-->

	</body>
</html>
