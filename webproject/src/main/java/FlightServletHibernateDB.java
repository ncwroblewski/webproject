package main.java;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datamodel.Flight;
import main.java.util.FlightUtilDB;

@WebServlet("/FlightServletHibernateDB")
public class FlightServletHibernateDB extends HttpServlet {
   private static final long serialVersionUID = 1L;

   public FlightServletHibernateDB() {
      super();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.setContentType("text/html");

      // #1
      FlightUtilDB.createFlights("G149", "9:15 AM", "6:00 PM", "42", "New York", "215 miles");
      
      // #2
      retrieveDisplayData(response.getWriter());
   }

   void retrieveDisplayData(PrintWriter out) {
      String title = "Database Result";
      String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + //
            "transitional//en\">\n"; //
      out.println(docType + //
            "<html>\n" + //
            "<head><title>" + title + "</title></head>\n" + //
            "<body bgcolor=\"#f0f0f0\">\n" + //
            "<h1 align=\"center\">" + title + "</h1>\n");
      out.println("<ul>");
      List<Flight> listFlights = FlightUtilDB.listFlight();
      for (Flight flight : listFlights) {
         System.out.println("[DBG] " + flight.getId() + ", " //
               + flight.getFlightNumber() + ", " //
               + flight.getDepartureTime() + ", " //
               + flight.getETA() + ", " //
               + flight.getPlaneNumber() + ", " //
               + flight.getDestination() + ", " //
               + flight.getTravelDistance());

         out.println("<li>" + flight.getId() + ", " //
        		 + flight.getFlightNumber() + ", " //
                 + flight.getDepartureTime() + ", " //
                 + flight.getETA() + ", " //
                 + flight.getPlaneNumber() + ", " //
                 + flight.getDestination() + ", " //
                 + flight.getTravelDistance());
      }
      out.println("</ul>");
      out.println("</body></html>");
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }
}
