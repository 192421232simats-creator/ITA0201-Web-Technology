package com.visitor;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/unsafe")
public class UnsafeCounterServlet extends HttpServlet {

    private int visitorCount = 0;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int currentCount = visitorCount;

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        visitorCount = currentCount + 1;

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Unsafe Visitor Counter</title>");

        out.println("<style>");
        out.println("body{margin:0;font-family:Arial;background:linear-gradient(135deg,#ff416c,#ff4b2b);color:white;}");
        out.println(".container{width:650px;margin:80px auto;background:white;color:#222;padding:40px;border-radius:25px;text-align:center;box-shadow:0 15px 40px rgba(0,0,0,.3);}");
        out.println("h1{color:#ff416c;font-size:32px;}");
        out.println(".count{font-size:65px;font-weight:bold;color:#ff4b2b;margin:25px;}");
        out.println(".warning{background:#fff3cd;padding:18px;border-radius:12px;color:#856404;}");
        out.println(".info{margin-top:20px;line-height:1.7;}");
        out.println("a{display:inline-block;margin:10px;padding:12px 20px;background:#ff416c;color:white;text-decoration:none;border-radius:10px;}");
        out.println("</style>");

        out.println("</head>");
        out.println("<body>");

        out.println("<div class='container'>");

        out.println("<h1>⚠ Unsafe Visitor Counter</h1>");

        out.println("<p>Current Visitor Count</p>");

        out.println("<div class='count'>" + visitorCount + "</div>");

        out.println("<div class='warning'>");
        out.println("<b>Race Condition Risk!</b><br>");
        out.println("This servlet uses a shared instance variable without synchronization.");
        out.println("</div>");

        out.println("<div class='info'>");
        out.println("<b>Shared Variable:</b> visitorCount<br>");
        out.println("<b>Thread Safety:</b> Not Safe<br>");
        out.println("<b>Problem:</b> Multiple requests can modify the variable simultaneously.");
        out.println("</div>");

        out.println("<a href='unsafe'>Refresh Counter</a>");
        out.println("<a href='safe'>Open Safe Counter</a>");

        out.println("</div>");

        out.println("</body>");
        out.println("</html>");
    }
}