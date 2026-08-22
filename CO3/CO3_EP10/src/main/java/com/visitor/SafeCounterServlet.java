package com.visitor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicInteger;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/safe")
public class SafeCounterServlet extends HttpServlet {

    private final AtomicInteger visitorCount = new AtomicInteger(0);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int currentCount = visitorCount.incrementAndGet();

        String message = "Request processed safely";

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Thread Safe Visitor Counter</title>");

        out.println("<style>");
        out.println("body{margin:0;font-family:Arial;background:linear-gradient(135deg,#11998e,#38ef7d);color:white;}");
        out.println(".container{width:650px;margin:80px auto;background:white;color:#222;padding:40px;border-radius:25px;text-align:center;box-shadow:0 15px 40px rgba(0,0,0,.3);}");
        out.println("h1{color:#11998e;font-size:32px;}");
        out.println(".count{font-size:65px;font-weight:bold;color:#11998e;margin:25px;}");
        out.println(".success{background:#d1fae5;padding:18px;border-radius:12px;color:#065f46;}");
        out.println(".info{margin-top:20px;line-height:1.7;}");
        out.println("a{display:inline-block;margin:10px;padding:12px 20px;background:#11998e;color:white;text-decoration:none;border-radius:10px;}");
        out.println("</style>");

        out.println("</head>");
        out.println("<body>");

        out.println("<div class='container'>");

        out.println("<h1>✓ Thread-Safe Visitor Counter</h1>");

        out.println("<p>Total Visitors</p>");

        out.println("<div class='count'>" + currentCount + "</div>");

        out.println("<div class='success'>");
        out.println("<b>Thread Safe!</b><br>");
        out.println(message);
        out.println("</div>");

        out.println("<div class='info'>");
        out.println("<b>Shared Variable:</b> AtomicInteger visitorCount<br>");
        out.println("<b>Thread Safety:</b> Safe<br>");
        out.println("<b>Operation:</b> incrementAndGet()<br>");
        out.println("<b>Local Variable:</b> currentCount");
        out.println("</div>");

        out.println("<a href='safe'>Refresh Counter</a>");
        out.println("<a href='unsafe'>Open Unsafe Counter</a>");

        out.println("</div>");

        out.println("</body>");
        out.println("</html>");
    }
}