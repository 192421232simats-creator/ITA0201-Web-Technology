<%@ page import="com.support.SupportTicket" %>

<%
    SupportTicket ticket =
        (SupportTicket) request.getAttribute("ticket");

    String supportNumber =
        (String) request.getAttribute("supportNumber");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Support Request Confirmation</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f1f5f9;
            padding: 40px;
        }

        .result-box {
            width: 600px;
            margin: auto;
            background: white;
            padding: 30px;
            border-radius: 12px;
            box-shadow: 0 4px 15px rgba(0,0,0,0.15);
        }

        h1 {
            text-align: center;
            color: #3949ab;
        }

        .success {
            background: #e0f2fe;
            color: #075985;
            padding: 15px;
            text-align: center;
            border-radius: 8px;
            font-weight: bold;
            margin: 20px 0;
        }

        .number {
            text-align: center;
            font-size: 21px;
            font-weight: bold;
            color: #3949ab;
            margin-bottom: 20px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        td {
            padding: 12px;
            border-bottom: 1px solid #ddd;
        }

        td:first-child {
            font-weight: bold;
            width: 40%;
            color: #333;
        }
    </style>
</head>

<body>

<div class="result-box">

    <h1>Request Submitted</h1>

    <div class="success">
        Your IT support request has been submitted successfully!
    </div>

    <div class="number">
        Support Number: <%= supportNumber %>
    </div>

    <table>

        <tr>
            <td>Employee Code</td>
            <td><%= ticket.getEmployeeCode() %></td>
        </tr>

        <tr>
            <td>Employee Name</td>
            <td><%= ticket.getEmployeeName() %></td>
        </tr>

        <tr>
            <td>Department</td>
            <td><%= ticket.getDepartment() %></td>
        </tr>

        <tr>
            <td>Problem Type</td>
            <td><%= ticket.getProblemType() %></td>
        </tr>

        <tr>
            <td>Priority Level</td>
            <td><%= ticket.getPriorityLevel() %></td>
        </tr>

        <tr>
            <td>Problem Details</td>
            <td><%= ticket.getProblemDetails() %></td>
        </tr>

    </table>

</div>

</body>
</html>