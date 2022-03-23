package datamodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @since J2SE-1.8
 CREATE TABLE FlightTable (
  id INT NOT NULL AUTO_INCREMENT, 
  flightNumber VARCHAR(30) NOT NULL,   
  departureTime VARCHAR(30) NOT NULL,
  ETA VARCHAR(30) NOT NULL,
  planeNumber INT NOT NULL,
  destination VARCHAR(30) NOT NULL,
  travelDistance VARCHAR(30) NOT NULL,
  PRIMARY KEY (id));
 */
@Entity
@Table(name = "FlightTable")
public class Flight {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
   private Integer id;

   @Column(name = "flightNumber")
   private String flightNumber;
   
   @Column(name = "departureTime")
   private String departureTime;
   
   @Column(name = "ETA")
   private String eta;

   @Column(name = "planeNumber")
   private Integer planeNumber;
   
   @Column(name = "destination")
   private String destination;
   
   @Column(name = "travelDistance")
   private String travelDistance;

   public Flight() {
   }

   public Flight(Integer id, String flightNumber, String departureTime, String eta, Integer planeNumber, String destination, String travelDistance) {
      this.id = id;
      this.flightNumber = flightNumber;
      this.departureTime = departureTime;
      this.eta = eta;
      this.planeNumber = planeNumber;
      this.destination = destination;
      this.travelDistance = travelDistance;
   }

   public Flight(String flightNumber, String departureTime, String eta, int planeNumber, String destination, String travelDistance) {
	  this.flightNumber = flightNumber;
	  this.departureTime = departureTime;
      this.eta = eta;
      this.planeNumber = planeNumber;
      this.destination = destination;
      this.travelDistance = travelDistance;
   }

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public String getFlightNumber() {
      return flightNumber;
   }

   public void setFlightNumber(String flightNumber) {
	   this.flightNumber = flightNumber;
   }
   
   public String getDepartureTime() {
      return departureTime;
   }

   public void setDepartureTime(String departureTime) {
	  this.departureTime = departureTime;
   }
   
   public String getETA() {
	  return eta;
   }

   public void setETA(String eta) {
	  this.eta = eta;
   }

   public Integer getPlaneNumber() {
      return planeNumber;
   }

   public void setPlaneNumber(Integer planeNumber) {
	  this.planeNumber = planeNumber;
   }
   
   public String getDestination() {
	  return destination;
   }

   public void setDestination(String destination) {
	  this.destination = destination;
   }
	   
   public String getTravelDistance() {
	  return travelDistance;
   }

   public void setTravelDistance(String travelDistance) {
	  this.travelDistance = travelDistance;
   }

   @Override
   public String toString() {
      return "Employee: " + this.id + ", " + this.flightNumber + ", " + this.departureTime + ", " + this.eta + ", " + this.planeNumber + ", " + this.destination + ", " + this.travelDistance;
   }
}