package com.student.result;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/StudentResultServlet")
public class StudentResultServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();

        String studentName = request.getParameter("studentName");
        String registerNumber = request.getParameter("registerNumber");
        String email = request.getParameter("email");
        String department = request.getParameter("department");
        String semester = request.getParameter("semester");

        String m1 = request.getParameter("mark1");
        String m2 = request.getParameter("mark2");
        String m3 = request.getParameter("mark3");
        String m4 = request.getParameter("mark4");
        String m5 = request.getParameter("mark5");

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.println("<title>EduPulse | Result</title>");

        out.println("<style>");

        out.println("*{box-sizing:border-box;margin:0;padding:0;font-family:Arial,Helvetica,sans-serif;}");

        out.println("body{min-height:100vh;background:linear-gradient(135deg,#0f172a,#172554,#312e81);color:white;padding:35px 20px;}");

        out.println(".container{max-width:950px;margin:auto;}");

        out.println(".header{display:flex;justify-content:space-between;align-items:center;margin-bottom:30px;}");

        out.println(".brand{display:flex;align-items:center;gap:14px;}");

        out.println(".logo{width:52px;height:52px;border-radius:15px;background:linear-gradient(135deg,#38bdf8,#6366f1);display:flex;align-items:center;justify-content:center;font-size:24px;font-weight:bold;}");

        out.println(".brand h2{font-size:22px;}");

        out.println(".brand span{color:#93c5fd;font-size:12px;letter-spacing:1px;}");

        out.println(".status{padding:9px 15px;border-radius:30px;background:rgba(255,255,255,.08);color:#86efac;font-size:13px;}");

        out.println(".title{text-align:center;margin-bottom:30px;}");

        out.println(".title h1{font-size:40px;margin-bottom:10px;background:linear-gradient(90deg,#fff,#93c5fd,#c4b5fd);-webkit-background-clip:text;-webkit-text-fill-color:transparent;}");

        out.println(".title p{color:#cbd5e1;}");

        out.println(".card{background:rgba(255,255,255,.09);border:1px solid rgba(255,255,255,.15);backdrop-filter:blur(18px);border-radius:24px;padding:30px;box-shadow:0 25px 70px rgba(0,0,0,.3);}");

        out.println(".student{display:grid;grid-template-columns:repeat(2,1fr);gap:15px;margin-bottom:30px;}");

        out.println(".info{background:rgba(15,23,42,.5);padding:16px;border-radius:12px;border:1px solid rgba(255,255,255,.08);}");

        out.println(".info label{display:block;color:#94a3b8;font-size:12px;margin-bottom:6px;text-transform:uppercase;}");

        out.println(".info p{font-size:15px;font-weight:bold;color:#e2e8f0;}");

        out.println("table{width:100%;border-collapse:collapse;overflow:hidden;border-radius:14px;}");

        out.println("th{background:#3730a3;color:white;padding:15px;text-align:left;}");

        out.println("td{padding:14px;border-bottom:1px solid rgba(255,255,255,.08);color:#e2e8f0;}");

        out.println("tr:nth-child(even){background:rgba(255,255,255,.04);}");

        out.println(".highlight{font-weight:bold;color:#93c5fd;}");

        out.println(".pass{color:#86efac;font-weight:bold;}");

        out.println(".fail{color:#fca5a5;font-weight:bold;}");

        out.println(".footer{text-align:center;color:#64748b;font-size:12px;margin-top:22px;}");

        out.println("@media(max-width:600px){.student{grid-template-columns:1fr;}.title h1{font-size:30px;}.card{padding:18px;} .header{flex-direction:column;gap:15px;}}");

        out.println("</style>");
        out.println("</head>");

        out.println("<body>");

        out.println("<div class='container'>");

        out.println("<div class='header'>");

        out.println("<div class='brand'>");
        out.println("<div class='logo'>EP</div>");
        out.println("<div><h2>EduPulse</h2><span>ACADEMIC RESULT PORTAL</span></div>");
        out.println("</div>");

        out.println("<div class='status'>● Result Generated</div>");

        out.println("</div>");

        if (studentName == null || studentName.trim().isEmpty() ||
            registerNumber == null || registerNumber.trim().isEmpty() ||
            email == null || email.trim().isEmpty() ||
            department == null || department.trim().isEmpty() ||
            semester == null || semester.trim().isEmpty() ||
            m1 == null || m1.trim().isEmpty() ||
            m2 == null || m2.trim().isEmpty() ||
            m3 == null || m3.trim().isEmpty() ||
            m4 == null || m4.trim().isEmpty() ||
            m5 == null || m5.trim().isEmpty()) {

            out.println("<div class='card'>");
            out.println("<h2>Validation Error</h2>");
            out.println("<br>");
            out.println("<p>Please fill in all fields.</p>");
            out.println("</div>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
            return;
        }

        try {

            int mark1 = Integer.parseInt(m1);
            int mark2 = Integer.parseInt(m2);
            int mark3 = Integer.parseInt(m3);
            int mark4 = Integer.parseInt(m4);
            int mark5 = Integer.parseInt(m5);

            if (mark1 < 0 || mark1 > 100 ||
                mark2 < 0 || mark2 > 100 ||
                mark3 < 0 || mark3 > 100 ||
                mark4 < 0 || mark4 > 100 ||
                mark5 < 0 || mark5 > 100) {

                out.println("<div class='card'>");
                out.println("<h2>Validation Error</h2>");
                out.println("<br>");
                out.println("<p>Marks must be between 0 and 100.</p>");
                out.println("</div>");
                out.println("</div>");
                out.println("</body>");
                out.println("</html>");
                return;
            }

            int total = mark1 + mark2 + mark3 + mark4 + mark5;

            double average = total / 5.0;

            int highest = Math.max(mark1,
                    Math.max(mark2,
                    Math.max(mark3,
                    Math.max(mark4, mark5))));

            int lowest = Math.min(mark1,
                    Math.min(mark2,
                    Math.min(mark3,
                    Math.min(mark4, mark5))));

            String grade;

            if (average >= 90) {
                grade = "A+";
            } else if (average >= 80) {
                grade = "A";
            } else if (average >= 70) {
                grade = "B";
            } else if (average >= 60) {
                grade = "C";
            } else if (average >= 50) {
                grade = "D";
            } else {
                grade = "F";
            }

            String status;

            if (mark1 >= 40 &&
                mark2 >= 40 &&
                mark3 >= 40 &&
                mark4 >= 40 &&
                mark5 >= 40) {

                status = "PASS";

            } else {

                status = "FAIL";
            }

            out.println("<div class='title'>");
            out.println("<h1>Student Result</h1>");
            out.println("<p>Academic performance report generated successfully</p>");
            out.println("</div>");

            out.println("<div class='card'>");

            out.println("<div class='student'>");

            out.println("<div class='info'>");
            out.println("<label>Student Name</label>");
            out.println("<p>" + studentName + "</p>");
            out.println("</div>");

            out.println("<div class='info'>");
            out.println("<label>Register Number</label>");
            out.println("<p>" + registerNumber + "</p>");
            out.println("</div>");

            out.println("<div class='info'>");
            out.println("<label>Email</label>");
            out.println("<p>" + email + "</p>");
            out.println("</div>");

            out.println("<div class='info'>");
            out.println("<label>Department</label>");
            out.println("<p>" + department + "</p>");
            out.println("</div>");

            out.println("<div class='info'>");
            out.println("<label>Semester</label>");
            out.println("<p>" + semester + "</p>");
            out.println("</div>");

            out.println("</div>");

            out.println("<table>");

            out.println("<tr>");
            out.println("<th>Result Parameter</th>");
            out.println("<th>Value</th>");
            out.println("</tr>");

            out.println("<tr><td>Subject 1</td><td>" + mark1 + "</td></tr>");
            out.println("<tr><td>Subject 2</td><td>" + mark2 + "</td></tr>");
            out.println("<tr><td>Subject 3</td><td>" + mark3 + "</td></tr>");
            out.println("<tr><td>Subject 4</td><td>" + mark4 + "</td></tr>");
            out.println("<tr><td>Subject 5</td><td>" + mark5 + "</td></tr>");

            out.println("<tr><td class='highlight'>Total</td><td class='highlight'>" + total + " / 500</td></tr>");

            out.println("<tr><td class='highlight'>Average</td><td class='highlight'>" +
                    String.format("%.2f", average) + "%</td></tr>");

            out.println("<tr><td class='highlight'>Highest Mark</td><td class='highlight'>" +
                    highest + "</td></tr>");

            out.println("<tr><td class='highlight'>Lowest Mark</td><td class='highlight'>" +
                    lowest + "</td></tr>");

            out.println("<tr><td class='highlight'>Grade</td><td class='highlight'>" +
                    grade + "</td></tr>");

            if (status.equals("PASS")) {

                out.println("<tr><td class='highlight'>Pass / Fail</td><td class='pass'>" +
                        status + " ✓</td></tr>");

            } else {

                out.println("<tr><td class='highlight'>Pass / Fail</td><td class='fail'>" +
                        status + " ✗</td></tr>");
            }

            out.println("</table>");

            out.println("</div>");

        } catch (NumberFormatException e) {

            out.println("<div class='card'>");
            out.println("<h2>Validation Error</h2>");
            out.println("<br>");
            out.println("<p>Marks must be numeric values.</p>");
            out.println("</div>");
        }

        out.println("<div class='footer'>");
        out.println("EduPulse Student Result Portal • Secure Academic Processing");
        out.println("</div>");

        out.println("</div>");

        out.println("</body>");
        out.println("</html>");
    }
}