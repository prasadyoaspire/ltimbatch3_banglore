package com.examly.springapp.service;

import java.util.List;

import com.examly.springapp.dao.HotelDAOImpl;
import com.examly.springapp.exception.LowRankingException;
import com.examly.springapp.model.Hotel;

public class HotelService {
    
    public void addHoteldetailsInList(Hotel hotel) {
        HotelDAOImpl hotelDAOImpl = new HotelDAOImpl();
        hotelDAOImpl.addHoteldetailsInList(hotel);
        hotelDAOImpl.displayAllHotels();
    }

    //********************** Day 2 ******************************************/
    public void createHotel(Hotel hotel) {
        HotelDAOImpl hotelDao = new HotelDAOImpl();
        hotelDao.createHotel(hotel);        
    }

    public void updateHotel(Hotel hotel) {
        HotelDAOImpl hotelDao = new HotelDAOImpl();
        hotelDao.createHotel(hotel);        
    }

    public List<Hotel> viewAllHotels() throws LowRankingException {
        HotelDAOImpl hotelDao = new HotelDAOImpl();
        List<Hotel> hotels = hotelDao.viewAllHotels();
        return hotels;
    }

    public Hotel getHotelById(int id) throws LowRankingException {
        HotelDAOImpl hotelDao = new HotelDAOImpl();
        Hotel hotel = hotelDao.getHotelById(id);
        return hotel;
    }
    public void deleteHotel(int id) {
        HotelDAOImpl hotelDao = new HotelDAOImpl();
        hotelDao.deleteHotel(id);
    }
}
