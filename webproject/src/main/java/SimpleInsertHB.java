package main.java;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.util.Info;
import main.java.util.FlightUtilDB;

@WebServlet("/SimpleInsertHB")
public class SimpleInsertHB extends HttpServlet implements Info {
   private static final long serialVersionUID = 1L;

   public SimpleInsertHB() {
      super();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String flightNumber = request.getParameter("flightNumber").trim();
      String departureTime = request.getParameter("departureTime").trim();
      String eta = request.getParameter("eta").trim();
      String planeNumber = request.getParameter("planeNumber").trim();
      String destination = request.getParameter("destination").trim();
      String travelDistance = request.getParameter("travelDistance").trim();
      FlightUtilDB.createFlights(flightNumber, departureTime, eta, planeNumber, destination, travelDistance);

      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      String title = "Database Result";
      String docType = "<!doctype html public \"-//w3c//dtd html 4.0 transitional//en\">\n"; //
      out.println(docType + //
            "<html>\n" + //
            "<head><title>" + title + "</title></head>\n" + //
            "<body bgcolor=\"#f0f0f0\">\n" + //
            "<h1 align=\"center\">" + title + "</h1>\n");
      out.println("<ul>");
      out.println("<li> Flight Number: " + flightNumber);
      out.println("<li> Departure Time: " + departureTime);
      out.println("<li> ETA: " + eta);
      out.println("<li> Plane Number: " + planeNumber);
      out.println("<li> Destination: " + destination);
      out.println("<li> Travel Distance: " + travelDistance);
      out.println("</ul>");
      out.println("<a href=/" + projectName + "/" + searchWebName + ">Search Data</a> <br>");
      out.println("</body></html>");
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }
}
