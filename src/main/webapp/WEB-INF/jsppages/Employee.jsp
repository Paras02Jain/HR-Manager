<%@ page import="java.util.List" %>
<%@ page import="com.nagarro.entity.Employee" %>
<%@ page import="com.nagarro.services.EmployeeService" %>
<%@ page import="com.nagarro.services.EmployeeServiceImpl" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">

    <style>
        fieldset.scheduler-border {
            border: 3px groove black !important;
            padding: 0 1.4em 1.4em 1.4em !important;
            margin-top: 20px;
            -webkit-box-shadow:  0px 0px 0px 0px #000;
            box-shadow:  0px 0px 0px 0px #000;
        }

         body{
    height:650px;}
    
        legend.scheduler-border {
            width:inherit; /* Or auto */
            padding:0 10px; /* To give a bit of padding on the left and right */
            border-bottom:none;
        }
        .two_buttons{
            align-items: flex-start;
        }



        input[type=submit], input[type=button] {
            background-color: grey;
            color: black;
            padding-right: 30%;

        }

    </style>
    <title>Employee</title>
</head>




<body>

<header style="background-image: linear-gradient(#AFAEFD, #efe8de);">
		<H3 class="text-center my-10" style="padding-top: 10px">Employee Details</H3>
		<span class="navbar-brand mb-0 h1"
              style="font-color: #6AABD2; font-size: 20px">Welcome!<c:out value=" ${user.username}"></c:out></span> <a href="logout" style="float: right;font-size: 20px">Logout</a>
	</header>

<div class="container">
    <fieldset class="scheduler-border">
    <legend class="scheduler-border">Employee Listings</legend>
    <div class="mt-3 p-4 d-flex mx-30x two_buttons">
        <table>
            <tr>
                <form action="upload">
                    <input class="mr-2" type="submit" name="updateEmployee"
                           value="Upload Employee Details" />
                </form>
            </tr>
            <tr>

            </tr>
            <tr>
                <form action="download/customers.xlsx">
                    <input class="mr-2" type="submit" name="downloadEmployee"
                           value="Download Employee Details" />
                </form>
            </tr>
        </table>


    </div>


    <div class="container-fluid" style="align-content: center"> 
        <table class="table table-bordered table-condensed" id="employeeList" style="bordercolor:black">
            <thead class="text-dark">
            <tr>
                <th>Employee Code</th>
                <th>Employee name</th>
                <th>Location</th>
                <th>Email</th>
                <th>Date Of birth</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody >
            <%!
                int employeeCode;
                String employeeName;
                String email;
                String location;
                String dateOfBirth;

            %>
            <%
                EmployeeService employeeService = new EmployeeServiceImpl();
                List<Employee> employeeDetails = employeeService.getEmployeeDetails();
                for (Employee employee : employeeDetails) {
                    employeeCode = employee.getEmployeecode();
                    employeeName = employee.getEmployeename();
                    email = employee.getEmail();
                    location = employee.getLocation();
                    dateOfBirth = employee.getDateofbirth();
            %>
            <tr>
                <td><%=employeeCode %>
                </td>
                <td><%=employeeName %>
                </td>
                <td><%=email %>
                </td>
                <td><%=location %>
                </td>
                <td><%=dateOfBirth %>
                </td>
                <td>

                    <a href="editEmployee?employeeCode=<%=employeeCode%>">Edit </a>

                </td>

            </tr>
            <%
                }
            %>
            </tbody>
        </table>
    </div>
    </fieldset>
</div>

<div class="footer">
<footer style="background-image: linear-gradient(#AFAEFD, #efe8de); margin-top:16px">
		<H4 class="text-center my-10 ">@copyright 2020-2021 Fresher Training </H4>
	</footer>
     
</div>

</body>
</html>
