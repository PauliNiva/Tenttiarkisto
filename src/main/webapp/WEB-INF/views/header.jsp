<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fi">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Tenttiarkisto</title>

        <link rel="icon" type="image/png" href="/assets/images/favicon.png" />

        <!-- Bootstrap Core CSS -->
        <link href="/assets/css/bootstrap.min.css" rel="stylesheet">
        <!-- Custom CSS -->
        <link href="/assets/css/clean-blog.css" rel="stylesheet">
        <!-- jQuery UI -->
        <link href="/assets/jquery-ui/jquery-ui.css" rel="stylesheet">
        <!-- bootstrapvalidator -->
        <%--<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.2/css/bootstrapValidator.min.css"/>--%>
        <!-- Tenttiarkisto CSS -->
        <link href="/assets/css/tenttiarkisto.css" rel="stylesheet">
        <!-- Select2 CSS -->
        <link href="/assets/select2/select2.css" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
        <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

    </head>

    <body>

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-custom navbar-fixed-top">
            <div class="container-fluid">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header page-scroll">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav navbar-right">
                        <li id="lisaauusilinkki">
                            <a href="#lomake">Lisää uusi tentti</a>
                        </li> 
                        <li>
                            <a href="/">Etusivu</a>
                        </li>
                        <li>
                            <a href="/kirjaudu">Kirjaudu</a>
                        </li>                 
                        <li>
                            <sec:authorize url="/logout">
                                <a href="/logout" onclick="document.getElementById('logout-form').submit();">Kirjaudu ulos</a>
                                <form action="/logout" method="post" id="logout-form">
                                    <input type="hidden" 
                                           name="${_csrf.parameterName}"
                                           value="${_csrf.token}" />
                                </form>
                            </sec:authorize>
                        </li>                   
                    </ul>
                </div>
                <!-- /.navbar-collapse -->
            </div>
            <!-- /.container -->
        </nav>

        <!-- Page Header -->
        <!-- Set your background image for this header on the line below. -->
        <header class="intro-header">
            <div class="container">
                <div class="row">
                    <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
                        <div class="site-heading">
                            <h1>Tenttiarkisto</h1>
                            <c:if test="${not fn:endsWith(pageContext.request.requestURI, 'kirjaudu.jsp')}">
                                <p><a href="#lomake" class="btn btn-default lisaauusi">Lisää uusi tentti</a></p>
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>
        </header>
