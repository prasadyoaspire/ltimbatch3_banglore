package com.examly.springapp.dao;

import java.util.List;

import com.examly.springapp.exception.LowRankingException;
import com.examly.springapp.model.Hotel;

public interface HotelDAO {

    void addHoteldetailsInList(Hotel hotel);

    //********************** Day 2 ******************************************/
    void createHotel(Hotel hotel);

    void updateHotel(Hotel hotel);

    List<Hotel> viewAllHotels() throws LowRankingException;

    Hotel getHotelById(int id) throws LowRankingException;

    void deleteHotel(int id);
}
