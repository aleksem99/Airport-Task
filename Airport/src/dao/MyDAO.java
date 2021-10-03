/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import controller.AirlinesJpaController;
import controller.AirplanesJpaController;
import controller.AirportsJpaController;
import controller.FlightJpaController;
import controller.PassangersJpaController;
import controller.RouteJpaController;
import entity.Airlines;
import entity.Airplanes;
import entity.Airports;
import entity.Flight;
import entity.Passangers;
import entity.Route;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alex
 */
public class MyDAO {
     private String message = "";
    
    private AirlinesJpaController l = new AirlinesJpaController();
   private Airlines airline = new Airlines();
    
    private AirplanesJpaController pl = new AirplanesJpaController();
    private Airplanes plane = new Airplanes();
    
    private AirportsJpaController po = new AirportsJpaController();
    private Airports port = new Airports();
    
    private FlightJpaController fl = new FlightJpaController();
    private Flight flight = new Flight();
    
   private PassangersJpaController pa = new PassangersJpaController();
    private Passangers passanger = new Passangers();
    
     private RouteJpaController ro = new RouteJpaController();
    private Route rou = new Route();
    
    //Crud for Airlines 
    public String addAirlineInfo(String nameAirline){
        try{
        airline.setIdAirlines(Integer.MIN_VALUE);
        airline.setNameAirline(nameAirline);
        l.create(airline);
        message = "Correctly added information";
        }catch(Exception e){
            message="Error" ;
        }
    return message;
    }
    
    public String updateAirlineInfo(int id, String nameAirline){
         try{
        airline.setIdAirlines(id);
        airline.setNameAirline(nameAirline);
        l.edit(airline);
        message = "Correctly updated information";
        }catch(Exception e){
            message="Error" ;
        }
    return message;
    }
    
    public String removeAirlineInfo(int id){
        try{
            l.destroy(id);
            message = "Removed information";
        }catch(Exception e){message ="Error";}
    return message;
    
    
    
    
    
}
    
    //Crud for Airplanes 
    public String addAirplaneInfo(String airplaneManufacter, String airplaneModel){
       try{
        plane.setIdAirplanes(Integer.MIN_VALUE);
        plane.setAirplaneManufacter(airplaneManufacter);
        plane.setAirplaneModel(airplaneModel);
        pl.create(plane);
        message = "Correctly added information";
        }catch(Exception e){
            message="Error" ;
        }
    return message;
    }
    
    public String updateAirplaneInfo(int id, String airplaneManufacter, String airplaneModel){
     try{
        plane.setIdAirplanes(id);
        plane.setAirplaneManufacter(airplaneManufacter);
        plane.setAirplaneModel(airplaneModel);
        pl.edit(plane);
        message = "Correctly updated information";
        }catch(Exception e){
            message="Error" ;
        }
    return message;
    }
    
    public String removeAirplaneInfo(int id){
     try{
           pl.destroy(id);
            message = "Removed information";
        }catch(Exception e){message ="Error";}
    return message;
     }
    
    //Crud Airports
    public String addAirportsInfo(String airportCountry, String airportName, String airportTerminal){
   try{ port.setIdAirports(Integer.MAX_VALUE);
    port.setAirportCountry(airportCountry);
    port.setAirportName(airportName);
   port.setAirportTerminal(0);
   po.create(port);
    message = "Correctly added information";
        }catch(Exception e){
            message="Error" ;
        }
    return message;
   } 
    
    public String updateAirortsInfo(int id, String airportCountry, String airportName, String airportTerminal){
       try{ port.setIdAirports(id);
    port.setAirportCountry(airportCountry);
    port.setAirportName(airportName);
   port.setAirportTerminal(0);
   po.edit(port);
    message = "Correctly updated information";
        }catch(Exception e){
            message="Error" ;
        }
    return message; 
    } 
    
    public String removeAirportsInfo(int id){
    try{
           po.destroy(id);
            message = "Removed information";
        }catch(Exception e){message ="Error";}
    return message;
    }
    
    
    //Crud Routes
    
    public String addRouteInfo(String departureCountry , String departureCity, String entryCountry,String entryCity , String scaledCountry, String scaledCity){
        try{rou.setIdRoute(Integer.MAX_VALUE);
        rou.setDepartureCountry(departureCountry);
        rou.setDepartureCity(departureCity);
        rou.setEntryCountry(entryCountry);
        rou.setEntryCity(entryCity);
        rou.setScaledCountry(scaledCountry);
        rou.setScaledCity(scaledCity);
        ro.create(rou);
    message = "Correctly added information";
        }catch(Exception e){
            message="Error" ;
        }
    return message;
}
    
    public String updateRouteInfo(int id, String departureCountry , String departureCity, String entryCountry,String entryCity , String scaledCountry, String scaledCity){
     try{rou.setIdRoute(id);
        rou.setDepartureCountry(departureCountry);
        rou.setDepartureCity(departureCity);
        rou.setEntryCountry(entryCountry);
        rou.setEntryCity(entryCity);
        rou.setScaledCountry(scaledCountry);
        rou.setScaledCity(scaledCity);
        ro.edit(rou);
    message = "Correctly updated information";
        }catch(Exception e){
            message="Error" ;
        }
    return message;
    
    }
    
    public String removeRouteInfo(int id){
        try{
           ro.destroy(id);
            message = "Removed information";
        }catch(Exception e){message ="Error";}
    return message; 
    }


    public void ShowDataAirplane(JTable table){
    DefaultTableModel model;
    String [] title  = {"ID" , "Manufacter" , "Model"} ;
    model = new DefaultTableModel(null,title);
    List<Airplanes> data = pl.findAirplanesEntities();
    String [] PlaneData = new  String [3]; 
        for ( Airplanes ap : data){
            PlaneData[0] = ap.getIdAirplanes()+"";
            PlaneData[1] = ap.getAirplaneManufacter()+"";
            PlaneData[2] = ap.getAirplaneModel()+"";
            model.addRow(PlaneData);
        }
        table.setModel(model);
    }
     public void ShowDataAirlines(JTable table){
    DefaultTableModel model;
    String [] title  = {"ID" , "Airline Name"} ;
    model = new DefaultTableModel(null,title);
    List<Airlines> data = l.findAirlinesEntities();
    String [] AirLineData = new  String [2]; 
        for ( Airlines al : data){
            AirLineData[0] = al.getIdAirlines()+"";
            AirLineData[1] = al.getNameAirline()+"";
            model.addRow(AirLineData);
        }
        table.setModel(model);
    }
      public void ShowDataFlight(JTable table){
    DefaultTableModel model;
    String [] title  = {"ID", "Flight Name"} ;
    model = new DefaultTableModel(null,title);
    List<Flight> data = fl.findFlightEntities();
    String [] FlightData = new  String [2]; 
        for ( Flight f : data){
            FlightData[0] = f.getFlightID()+"";
            FlightData[1] = f.getNameFlight()+"";
            model.addRow(FlightData);
        }
        table.setModel(model);
    }
}
    
    
    
   

