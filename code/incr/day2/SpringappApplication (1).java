package com.examly.springapp;


import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.examly.springapp.exception.LowRankingException;
import com.examly.springapp.model.Hotel;
import com.examly.springapp.service.HotelService;


@SpringBootApplication
public class SpringappApplication {

    public static void main(String[] args) throws LowRankingException {
        SpringApplication.run(SpringappApplication.class, args);

        System.out.println("1.Add Hotel Details");
        System.out.println("2.Display All Hotels");
        System.out.println("3.Update Hotel by ID");
        System.out.println("4.Delete Hotel by ID");
        System.out.println("5.Exit");

        HotelService hotelService = new HotelService();

        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                //read hotel input data
                System.out.println("Enter Hotel ID");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.println("Enter Hotel Name");
                String name = sc.nextLine();
                System.out.println("Enter Hotel Location");
                String location = sc.nextLine();
                System.out.println("Enter Hotel Ranking");
                float rank = sc.nextFloat();
                System.out.println("Is Gym Available? (true/false)");
                boolean isGymAvailable = sc.nextBoolean();
                System.out.println("Is Pool Available? (true/false)");
                boolean isPoolAvailable = sc.nextBoolean();
                System.out.println("Is Spa Available? (true/false)");
                boolean isSpaAvailable = sc.nextBoolean();
                
                //create hotel object
                Hotel hotel = new Hotel(id,name,location,rank,isGymAvailable,isPoolAvailable,isSpaAvailable);
                //call service to create a new hotel 
                hotelService.createHotel(hotel);
                break;
            case 2:
                List<Hotel> hotels = hotelService.viewAllHotels();
                if(hotels.isEmpty()){
                    System.out.println("No Hotels Found.");
                }
                else {
                    for(Hotel h: hotels) {
                        System.out.println(h.getHotelId()+" "+h.getHotelName()+" "+h.getHotelLocation()+" "+h.isGymAvailable()+" "+h.isPoolAvailable()+" "+h.isSpaAvailable());
                    }
                }              
                break;
            case 3:
                  //read hotel input data
                  System.out.println("Enter Hotel ID");
                  int id2 = sc.nextInt();
                  sc.nextLine();
                  System.out.println("Enter Hotel Name");
                  String name2 = sc.nextLine();
                  System.out.println("Enter Hotel Location");
                  String location2 = sc.nextLine();
                  System.out.println("Enter Hotel Ranking");
                  float rank2 = sc.nextFloat();
                  System.out.println("Is Gym Available? (true/false)");
                  boolean isGymAvailable2 = sc.nextBoolean();
                  System.out.println("Is Pool Available? (true/false)");
                  boolean isPoolAvailable2 = sc.nextBoolean();
                  System.out.println("Is Spa Available? (true/false)");
                  boolean isSpaAvailable2 = sc.nextBoolean();
             
                  Hotel hotel2 = new Hotel(id2,name2,location2,rank2,isGymAvailable2,isPoolAvailable2,isSpaAvailable2);
        
                  hotelService.updateHotel(hotel2);
                break;
            case 4:
                System.out.println("Enter Hotel ID");
                int idToDelete = sc.nextInt();
                hotelService.deleteHotel(idToDelete);
                break;
            case 5:
                break;          
            default:
                System.out.println("Invalid choice");
        }
        sc.close();
    }
    // Rest of the methods for sorting and displaying data


}
