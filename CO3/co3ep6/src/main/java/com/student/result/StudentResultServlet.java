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

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String register = request.getParameter("register");
        String mark1Text = request.getParameter("mark1");
        String mark2Text = request.getParameter("mark2");
        String mark3Text = request.getParameter("mark3");

        if (name == null || name.trim().isEmpty()
                || register == null || register.trim().isEmpty()
                || mark1Text == null || mark1Text.trim().isEmpty()
                || mark2Text == null || mark2Text.trim().isEmpty()
                || mark3Text == null || mark3Text.trim().isEmpty()) {

            showError(out, "Missing Information",
                    "Please enter the student name, register number and all three marks.");
            return;
        }

        try {

            int mark1 = Integer.parseInt(mark1Text);
            int mark2 = Integer.parseInt(mark2Text);
            int mark3 = Integer.parseInt(mark3Text);

            if (mark1 < 0 || mark1 > 100
                    || mark2 < 0 || mark2 > 100
                    || mark3 < 0 || mark3 > 100) {

                showError(out, "Invalid Marks",
                        "All subject marks must be between 0 and 100.");
                return;
            }

            int total = mark1 + mark2 + mark3;

            double average = total / 3.0;

            int highest = Math.max(mark1, Math.max(mark2, mark3));

            String result;

            if (mark1 >= 40 && mark2 >= 40 && mark3 >= 40) {
                result = "PASS";
            } else {
                result = "FAIL";
            }

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
            out.println("<title>MeritDesk Result</title>");

            out.println("<style>");

            out.println("*{margin:0;padding:0;box-sizing:border-box;font-family:Segoe UI,Arial,sans-serif;}");

            out.println("body{");
            out.println("min-height:100vh;");
            out.println("background:");
            out.println("radial-gradient(circle at 12% 12%,rgba(212,106,76,.16),transparent 28%),");
            out.println("radial-gradient(circle at 88% 88%,rgba(128,0,32,.13),transparent 30%),");
            out.println("#f7f1e8;");
            out.println("display:flex;");
            out.println("justify-content:center;");
            out.println("align-items:center;");
            out.println("padding:30px;");
            out.println("color:#382b2b;");
            out.println("}");

            out.println(".result-card{");
            out.println("width:850px;");
            out.println("max-width:100%;");
            out.println("background:#fffdfb;");
            out.println("border:1px solid #eadfd6;");
            out.println("border-radius:28px;");
            out.println("padding:38px;");
            out.println("box-shadow:0 25px 65px rgba(74,48,42,.17);");
            out.println("}");

            out.println(".header{text-align:center;margin-bottom:30px;}");

            out.println(".label{");
            out.println("display:inline-block;");
            out.println("padding:8px 16px;");
            out.println("border-radius:30px;");
            out.println("background:#f5e8e0;");
            out.println("color:#8b1e3f;");
            out.println("font-size:10px;");
            out.println("font-weight:800;");
            out.println("letter-spacing:1.7px;");
            out.println("}");

            out.println("h1{");
            out.println("margin-top:15px;");
            out.println("font-size:34px;");
            out.println("color:#4a1f2a;");
            out.println("}");

            out.println(".subtitle{");
            out.println("margin-top:8px;");
            out.println("color:#8c7b75;");
            out.println("font-size:13px;");
            out.println("}");

            out.println(".student-info{");
            out.println("display:grid;");
            out.println("grid-template-columns:1fr 1fr;");
            out.println("gap:15px;");
            out.println("margin-bottom:20px;");
            out.println("}");

            out.println(".info{");
            out.println("padding:18px;");
            out.println("background:#fff8f2;");
            out.println("border:1px solid #eadfd6;");
            out.println("border-radius:15px;");
            out.println("}");

            out.println(".info span{");
            out.println("display:block;");
            out.println("font-size:10px;");
            out.println("font-weight:800;");
            out.println("letter-spacing:1.3px;");
            out.println("color:#a17e72;");
            out.println("margin-bottom:7px;");
            out.println("}");

            out.println(".info strong{");
            out.println("font-size:15px;");
            out.println("color:#4a1f2a;");
            out.println("}");

            out.println(".marks{");
            out.println("display:grid;");
            out.println("grid-template-columns:repeat(3,1fr);");
            out.println("gap:15px;");
            out.println("}");

            out.println(".mark{");
            out.println("text-align:center;");
            out.println("padding:21px;");
            out.println("background:linear-gradient(145deg,#fff8f2,#f8eee7);");
            out.println("border:1px solid #eadfd6;");
            out.println("border-radius:17px;");
            out.println("}");

            out.println(".mark span{");
            out.println("display:block;");
            out.println("font-size:10px;");
            out.println("font-weight:800;");
            out.println("letter-spacing:1.2px;");
            out.println("color:#a17e72;");
            out.println("margin-bottom:9px;");
            out.println("}");

            out.println(".mark b{");
            out.println("font-size:28px;");
            out.println("color:#8b1e3f;");
            out.println("}");

            out.println(".summary{");
            out.println("display:grid;");
            out.println("grid-template-columns:repeat(3,1fr);");
            out.println("gap:15px;");
            out.println("margin-top:18px;");
            out.println("}");

            out.println(".summary-box{");
            out.println("padding:20px;");
            out.println("text-align:center;");
            out.println("border-radius:17px;");
            out.println("background:#4a1f2a;");
            out.println("color:white;");
            out.println("}");

            out.println(".summary-box span{");
            out.println("display:block;");
            out.println("font-size:9px;");
            out.println("letter-spacing:1.3px;");
            out.println("color:#e7cfc5;");
            out.println("margin-bottom:8px;");
            out.println("}");

            out.println(".summary-box strong{");
            out.println("font-size:21px;");
            out.println("}");

            out.println(".pass{");
            out.println("margin-top:20px;");
            out.println("padding:18px;");
            out.println("text-align:center;");
            out.println("border-radius:15px;");
            out.println("background:#e8f5ec;");
            out.println("border:1px solid #b8dfc5;");
            out.println("color:#237a3b;");
            out.println("font-size:18px;");
            out.println("font-weight:800;");
            out.println("}");

            out.println(".fail{");
            out.println("margin-top:20px;");
            out.println("padding:18px;");
            out.println("text-align:center;");
            out.println("border-radius:15px;");
            out.println("background:#fbe9e7;");
            out.println("border:1px solid #edbbb6;");
            out.println("color:#b42318;");
            out.println("font-size:18px;");
            out.println("font-weight:800;");
            out.println("}");

            out.println(".back{");
            out.println("display:block;");
            out.println("text-align:center;");
            out.println("margin-top:25px;");
            out.println("color:#8b1e3f;");
            out.println("font-size:13px;");
            out.println("font-weight:700;");
            out.println("text-decoration:none;");
            out.println("}");

            out.println("@media(max-width:650px){");
            out.println(".student-info,.marks,.summary{grid-template-columns:1fr;}");
            out.println(".result-card{padding:25px;}");
            out.println("}");

            out.println("</style>");
            out.println("</head>");

            out.println("<body>");

            out.println("<div class='result-card'>");

            out.println("<div class='header'>");
            out.println("<span class='label'>MERITDESK • OFFICIAL RESULT</span>");
            out.println("<h1>Academic Performance</h1>");
            out.println("<div class='subtitle'>Result generated by Java Servlet processing</div>");
            out.println("</div>");

            out.println("<div class='student-info'>");

            out.println("<div class='info'>");
            out.println("<span>STUDENT NAME</span>");
            out.println("<strong>" + escape(name) + "</strong>");
            out.println("</div>");

            out.println("<div class='info'>");
            out.println("<span>REGISTER NUMBER</span>");
            out.println("<strong>" + escape(register) + "</strong>");
            out.println("</div>");

            out.println("</div>");

            out.println("<div class='marks'>");

            out.println("<div class='mark'>");
            out.println("<span>SUBJECT 01</span>");
            out.println("<b>" + mark1 + "</b>");
            out.println("</div>");

            out.println("<div class='mark'>");
            out.println("<span>SUBJECT 02</span>");
            out.println("<b>" + mark2 + "</b>");
            out.println("</div>");

            out.println("<div class='mark'>");
            out.println("<span>SUBJECT 03</span>");
            out.println("<b>" + mark3 + "</b>");
            out.println("</div>");

            out.println("</div>");

            out.println("<div class='summary'>");

            out.println("<div class='summary-box'>");
            out.println("<span>TOTAL MARK</span>");
            out.println("<strong>" + total + " / 300</strong>");
            out.println("</div>");

            out.println("<div class='summary-box'>");
            out.println("<span>AVERAGE</span>");
            out.println("<strong>" + String.format("%.2f", average) + "</strong>");
            out.println("</div>");

            out.println("<div class='summary-box'>");
            out.println("<span>HIGHEST MARK</span>");
            out.println("<strong>" + highest + "</strong>");
            out.println("</div>");

            out.println("</div>");

            if (result.equals("PASS")) {
                out.println("<div class='pass'>✓ RESULT STATUS : PASS</div>");
            } else {
                out.println("<div class='fail'>✕ RESULT STATUS : FAIL</div>");
            }

            out.println("<a class='back' href='index.html'>← Process Another Student</a>");

            out.println("</div>");

            out.println("</body>");
            out.println("</html>");
        }

        catch (NumberFormatException e) {

            showError(
                out,
                "Invalid Mark Format",
                "Please enter numbers only for the three subject marks."
            );
        }
    }

    private void showError(PrintWriter out, String title, String message) {

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>MeritDesk Error</title>");

        out.println("<style>");

        out.println("body{");
        out.println("margin:0;");
        out.println("min-height:100vh;");
        out.println("background:#f7f1e8;");
        out.println("display:flex;");
        out.println("justify-content:center;");
        out.println("align-items:center;");
        out.println("font-family:Segoe UI,Arial,sans-serif;");
        out.println("}");

        out.println(".error{");
        out.println("width:500px;");
        out.println("max-width:90%;");
        out.println("padding:40px;");
        out.println("background:#fffdfb;");
        out.println("border:1px solid #eadfd6;");
        out.println("border-radius:25px;");
        out.println("text-align:center;");
        out.println("box-shadow:0 25px 60px rgba(74,48,42,.15);");
        out.println("}");

        out.println(".icon{");
        out.println("font-size:45px;");
        out.println("color:#b24b38;");
        out.println("}");

        out.println("h1{color:#4a1f2a;}");

        out.println("p{");
        out.println("color:#806f6a;");
        out.println("line-height:1.7;");
        out.println("}");

        out.println("a{");
        out.println("display:inline-block;");
        out.println("margin-top:15px;");
        out.println("color:#8b1e3f;");
        out.println("font-weight:700;");
        out.println("text-decoration:none;");
        out.println("}");

        out.println("</style>");

        out.println("</head>");

        out.println("<body>");

        out.println("<div class='error'>");

        out.println("<div class='icon'>⚠</div>");

        out.println("<h1>" + title + "</h1>");

        out.println("<p>" + message + "</p>");

        out.println("<a href='index.html'>← Return to Result Form</a>");

        out.println("</div>");

        out.println("</body>");

        out.println("</html>");
    }

    private String escape(String value) {

        return value
                .replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&#39;");
    }
}