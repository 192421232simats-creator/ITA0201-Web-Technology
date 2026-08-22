package com.student.registration;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/StudentRegistrationServlet")
public class StudentRegistrationServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();

        String studentName = request.getParameter("studentName");
        String registerNumber = request.getParameter("registerNumber");
        String email = request.getParameter("email");
        String department = request.getParameter("department");
        String semester = request.getParameter("semester");

        boolean invalid =
                studentName == null || studentName.trim().isEmpty() ||
                registerNumber == null || registerNumber.trim().isEmpty() ||
                email == null || email.trim().isEmpty() ||
                department == null || department.trim().isEmpty() ||
                semester == null || semester.trim().isEmpty();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");

        out.println("<meta charset='UTF-8'>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");

        out.println("<title>UniSphere | Registration Status</title>");

        out.println("<style>");

        out.println("*{margin:0;padding:0;box-sizing:border-box;font-family:'Segoe UI',Arial,sans-serif;}");

        out.println("body{min-height:100vh;background:#eef2ff;display:flex;align-items:center;justify-content:center;padding:25px;}");

        out.println(".container{width:100%;max-width:900px;background:white;border-radius:28px;overflow:hidden;box-shadow:0 25px 70px rgba(30,41,59,.18);}");

        out.println(".top{background:linear-gradient(135deg,#312e81,#4338ca,#2563eb);color:white;padding:45px;text-align:center;}");

        out.println(".check{width:70px;height:70px;margin:auto;border-radius:50%;background:rgba(255,255,255,.15);border:2px solid rgba(255,255,255,.3);display:flex;align-items:center;justify-content:center;font-size:30px;}");

        out.println(".top h1{font-size:32px;margin-top:18px;}");

        out.println(".top p{margin-top:8px;color:#dbeafe;font-size:14px;}");

        out.println(".content{padding:40px;}");

        out.println(".success{background:#ecfdf5;border:1px solid #bbf7d0;color:#166534;padding:15px;border-radius:13px;text-align:center;margin-bottom:25px;font-size:14px;font-weight:600;}");

        out.println(".details{display:grid;grid-template-columns:1fr 1fr;gap:16px;}");

        out.println(".detail{padding:18px;background:#f8fafc;border:1px solid #e5e7eb;border-radius:14px;}");

        out.println(".detail label{display:block;text-transform:uppercase;font-size:10px;font-weight:bold;color:#818cf8;letter-spacing:1px;margin-bottom:7px;}");

        out.println(".detail p{font-size:15px;color:#111827;font-weight:600;word-break:break-word;}");

        out.println(".error{background:#fff1f2;border:1px solid #fecdd3;color:#be123c;padding:20px;border-radius:14px;text-align:center;}");

        out.println(".back{display:block;width:100%;margin-top:25px;padding:14px;text-align:center;text-decoration:none;border-radius:12px;background:#4f46e5;color:white;font-weight:bold;font-size:13px;}");

        out.println(".footer{text-align:center;color:#9ca3af;font-size:10px;margin-top:22px;}");

        out.println("@media(max-width:600px){.details{grid-template-columns:1fr;}.content{padding:25px;}.top{padding:35px 20px;}.top h1{font-size:27px;}}");

        out.println("</style>");

        out.println("</head>");

        out.println("<body>");

        out.println("<div class='container'>");

        if (invalid) {

            out.println("<div class='top'>");

            out.println("<div class='check'>!</div>");

            out.println("<h1>Registration Incomplete</h1>");

            out.println("<p>Some required information is missing.</p>");

            out.println("</div>");

            out.println("<div class='content'>");

            out.println("<div class='error'>");
            out.println("Please fill in all required fields before submitting the registration form.");
            out.println("</div>");

            out.println("<a class='back' href='index.html'>← Return to Registration</a>");

            out.println("</div>");

        } else {

            out.println("<div class='top'>");

            out.println("<div class='check'>✓</div>");

            out.println("<h1>Registration Complete!</h1>");

            out.println("<p>Welcome to UniSphere. Your student profile has been created.</p>");

            out.println("</div>");

            out.println("<div class='content'>");

            out.println("<div class='success'>");
            out.println("✓ Student details submitted successfully");
            out.println("</div>");

            out.println("<div class='details'>");

            out.println("<div class='detail'>");
            out.println("<label>Student Name</label>");
            out.println("<p>" + studentName + "</p>");
            out.println("</div>");

            out.println("<div class='detail'>");
            out.println("<label>Register Number</label>");
            out.println("<p>" + registerNumber + "</p>");
            out.println("</div>");

            out.println("<div class='detail'>");
            out.println("<label>Email Address</label>");
            out.println("<p>" + email + "</p>");
            out.println("</div>");

            out.println("<div class='detail'>");
            out.println("<label>Department</label>");
            out.println("<p>" + department + "</p>");
            out.println("</div>");

            out.println("<div class='detail'>");
            out.println("<label>Semester</label>");
            out.println("<p>" + semester + "</p>");
            out.println("</div>");

            out.println("</div>");

            out.println("<a class='back' href='index.html'>← Register Another Student</a>");

            out.println("<div class='footer'>");
            out.println("UniSphere Student Portal • Servlet Based Registration System");
            out.println("</div>");

            out.println("</div>");
        }

        out.println("</div>");

        out.println("</body>");
        out.println("</html>");
    }
}