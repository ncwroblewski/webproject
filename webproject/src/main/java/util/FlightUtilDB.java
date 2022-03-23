/**
 */
package main.java.util;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import datamodel.Flight;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @since JavaSE-1.8
 */
public class FlightUtilDB {
   static SessionFactory sessionFactory = null;

   public static SessionFactory getSessionFactory() {
      if (sessionFactory != null) {
         return sessionFactory;
      }
      Configuration configuration = new Configuration().configure();
      StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
      sessionFactory = configuration.buildSessionFactory(builder.build());
      return sessionFactory;
   }

   public static List<Flight> listFlight() {
      List<Flight> resultList = new ArrayList<Flight>();

      Session session = getSessionFactory().openSession();
      Transaction tx = null;

      try {
         tx = session.beginTransaction();
         List<?> flights = session.createQuery("FROM Flight").list();
         for (Iterator<?> iterator = flights.iterator(); iterator.hasNext();) {
            Flight flight = (Flight) iterator.next();
            resultList.add(flight);
         }
         tx.commit();
      } catch (HibernateException e) {
         if (tx != null)
            tx.rollback();
         e.printStackTrace();
      } finally {
         session.close();
      }
      return resultList;
   }

   public static List<Flight> listFlights(String keyword) {
      List<Flight> resultList = new ArrayList<Flight>();

      Session session = getSessionFactory().openSession();
      Transaction tx = null;

      try {
         tx = session.beginTransaction();
         List<?> flights = session.createQuery("FROM Flight").list();
         for (Iterator<?> iterator = flights.iterator(); iterator.hasNext();) {
            Flight flight = (Flight) iterator.next();
            if (flight.getFlightNumber().startsWith(keyword)) {
               resultList.add(flight);
            }
         }
         tx.commit();
      } catch (HibernateException e) {
         if (tx != null)
            tx.rollback();
         e.printStackTrace();
      } finally {
         session.close();
      }
      return resultList;
   }

   public static void createFlights(String flightNumber, String departureTime, String eta, String planeNumber, String destination, String travelDistance) {
      Session session = getSessionFactory().openSession();
      Transaction tx = null;
      try {
         tx = session.beginTransaction();
         session.save(new Flight(flightNumber, departureTime, eta, Integer.valueOf(planeNumber), destination, travelDistance));
         tx.commit();
      } catch (HibernateException e) {
         if (tx != null)
            tx.rollback();
         e.printStackTrace();
      } finally {
         session.close();
      }
   }
}
