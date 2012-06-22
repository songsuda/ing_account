<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Bootstrap, from Twitter</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <!-- Le styles -->
        <link href="css/bootstrap.css" rel="stylesheet">
        <style type="text/css">
            body {
                padding-top: 60px;
                padding-bottom: 40px;
            }
            .sidebar-nav {
                padding: 9px 0;
            }
        </style>
        <link href="css/bootstrap-responsive.css" rel="stylesheet">

        <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
          <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->

        <!-- Le fav and touch icons -->
        <link rel="shortcut icon" href="../assets/ico/favicon.ico">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="../assets/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="../assets/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="../assets/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="../assets/ico/apple-touch-icon-57-precomposed.png">
    </head>

    <body>

        <div class="navbar navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container-fluid">
                    <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </a>
                    <a class="brand" href="#">ING Account Management</a>
                    <div class="btn-group pull-right">
                        <a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
                            <i class="icon-user"></i> 
                            <c:out value="${sessionScope.currentUser.username}" />
                            <span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href="#">Profile</a></li>
                            <li class="divider"></li>
                            <li><a href="#">Sign Out</a></li>
                        </ul>
                    </div>
                    <div class="nav-collapse">
                        <ul class="nav">
                            <li class="active"><a href="mainPanel.jsp">Home</a></li>
                            <li><a href="#about">About</a></li>
                            <li><a href="#contact">Contact</a></li>
                        </ul>
                    </div><!--/.nav-collapse -->
                </div>
            </div>
        </div>

        <div class="container-fluid">
            <div class="row-fluid">
                <div class="span3">
                    <div class="well sidebar-nav">
                        <ul class="nav nav-list">
                            <li class="nav-header">Sidebar</li>                            
                            <li><a href="./ListAllAccount">All Accounts</a></li>
                            <li><a href="#">Create New Account</a></li>
                            <li><a href="#">Search For Account</a></li>
                        </ul>
                    </div><!--/.well -->
                </div><!--/span-->
                <div class="span9">



                    <h1>${account.code}:${account.name}</h1>
                    <p>Current Balance: ${account.balance}</p>
                    <form class="well" action="DepositController" method="POST">
                        <input name="code" type="hidden" value="<c:out value="${requestScope.code}"/>" />
                        <label>Amount</label>
                        <input name="amount" type="text" class="span3" placeholder="0">
                        <span class="help-block">Amount money to deposit</span>
                        <button type="submit" class="btn">Submit</button>
                    </form>

                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>#</th>
                                <th>Transaction Date:Time</th>
                                <th>Transaction Type</th>
                                <th>Amount</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="history" items="${account.transactionHistory}">  
                                <tr>
                                    <td>#</td>
                                    <td>${history.transactionDate}</td>
                                    <td>${history.code}</td>
                                    <td align="right"><fmt:formatNumber type="number" maxFractionDigits="2"  value="${history.amount}" /></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>

                </div><!--/span-->
            </div><!--/row-->

            <hr>

            <footer>
                <p>&copy; Company 2012</p>
            </footer>

        </div><!--/.fluid-container-->

        <!-- Le javascript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->


    </body>
</html>
