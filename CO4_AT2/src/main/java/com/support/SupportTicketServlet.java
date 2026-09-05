package com.support;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/SupportTicketServlet")
public class SupportTicketServlet extends HttpServlet {

    private static int ticketCounter = 2000;

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String employeeCode = request.getParameter("employeeCode");
        String employeeName = request.getParameter("employeeName");
        String department = request.getParameter("department");
        String problemType = request.getParameter("problemType");
        String problemDetails = request.getParameter("problemDetails");
        String priorityLevel = request.getParameter("priorityLevel");

        // Server-side validation
        if (isBlank(employeeCode) ||
            isBlank(employeeName) ||
            isBlank(department) ||
            isBlank(problemType) ||
            isBlank(problemDetails) ||
            isBlank(priorityLevel)) {

            response.setContentType("text/html");

            response.getWriter().println(
                "<h2>Error: Please fill all required fields.</h2>"
            );

            return;
        }

        // Create Model object
        SupportTicket ticket = new SupportTicket(
                employeeCode,
                employeeName,
                department,
                problemType,
                problemDetails,
                priorityLevel
        );

        // Generate ticket number
        String supportNumber = "IT-" + (++ticketCounter);

        // Send data to JSP
        request.setAttribute("ticket", ticket);
        request.setAttribute("supportNumber", supportNumber);

        // Forward to confirmation page
        request.getRequestDispatcher("ticketConfirmation.jsp")
               .forward(request, response);
    }

    private boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }
}