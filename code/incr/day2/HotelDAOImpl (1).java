package com.examly.springapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.examly.springapp.exception.LowRankingException;
import com.examly.springapp.model.Hotel;

public class HotelDAOImpl implements HotelDAO {

    private ArrayList<Hotel> hotelList = new ArrayList<>();

    public HotelDAOImpl() {
        Hotel hotel1 = new Hotel(5, "aaa", "loc-1", 4.1f, true, false, true);
        Hotel hotel2 = new Hotel(5, "aaa", "loc-1", 4.1f, true, false, true);
        Hotel hotel3 = new Hotel(5, "aaa", "loc-1", 4.1f, true, false, true);
        Hotel hotel4 = new Hotel(5, "aaa", "loc-1", 4.1f, true, false, true);
        Hotel hotel5 = new Hotel(5, "aaa", "loc-1", 4.1f, true, false, true);
        hotelList.add(hotel1);
        hotelList.add(hotel2);
        hotelList.add(hotel3);
        hotelList.add(hotel4);
        hotelList.add(hotel5);
    }

    @Override
    public void addHoteldetailsInList(Hotel hotel) {
        hotelList.add(hotel);
    }

    public void displayAllHotels() {
        hotelList.forEach(h -> System.out.println(
                h.getHotelId() + " " + h.getHotelName() + " " + h.getHotelLocation() + " " + h.getHotelRanking() + " "
                        + h.isGymAvailable() + " " + h.isPoolAvailable() + " " + h.isSpaAvailable()));
    }

    //********************** Day 2 ******************************************/

    @Override
    public void createHotel(Hotel hotel) {
        Connection con = JDBCUtils.createDBConnection();
        String sql = "insert into hotels values(?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, hotel.getHotelId());
            ps.setString(2, hotel.getHotelName());
            ps.setString(3, hotel.getHotelLocation());
            ps.setFloat(4, hotel.getHotelRanking());
            ps.setBoolean(5, hotel.isGymAvailable());
            ps.setBoolean(6, hotel.isPoolAvailable());
            ps.setBoolean(7, hotel.isSpaAvailable());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public void updateHotel(Hotel hotel) {
        Connection con = JDBCUtils.createDBConnection();
        String sql = "update hotels set hotelName=?,hotelLocation=?,hotelRanking=?,gymAvailable=?,poolAvailable=?,spaAvailable=? where hotelId = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(7, hotel.getHotelId());
            ps.setString(1, hotel.getHotelName());
            ps.setString(2, hotel.getHotelLocation());
            ps.setFloat(3, hotel.getHotelRanking());
            ps.setBoolean(4, hotel.isGymAvailable());
            ps.setBoolean(5, hotel.isPoolAvailable());
            ps.setBoolean(6, hotel.isSpaAvailable());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public List<Hotel> viewAllHotels() throws LowRankingException {
        List<Hotel> hotels = new ArrayList<>();
        Connection con = JDBCUtils.createDBConnection();
        String sql = "select * from hotels";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Hotel hotel = new Hotel();
                hotel.setHotelId(rs.getInt(1));
                hotel.setHotelName(rs.getString(2));
                hotel.setHotelLocation(rs.getString(3));
                hotel.setHotelRanking(rs.getFloat(4));
                hotel.setGymAvailable(rs.getBoolean(5));
                hotel.setPoolAvailable(rs.getBoolean(6));
                hotel.setSpaAvailable(rs.getBoolean(7));
                hotels.add(hotel);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return hotels;
    }

    @Override
    public Hotel getHotelById(int id) throws LowRankingException {
        Connection con = JDBCUtils.createDBConnection();
        String sql = "select * from hotels";
        Hotel hotel = null;
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                hotel = new Hotel();
                hotel.setHotelId(rs.getInt(1));
                hotel.setHotelName(rs.getString(2));
                hotel.setHotelLocation(rs.getString(3));
                hotel.setHotelRanking(rs.getFloat(4));
                hotel.setGymAvailable(rs.getBoolean(5));
                hotel.setPoolAvailable(rs.getBoolean(6));
                hotel.setSpaAvailable(rs.getBoolean(7));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return hotel;
    }

    @Override
    public void deleteHotel(int id) {
        Connection con = JDBCUtils.createDBConnection();
        String sql = "delete from hotels where hotelId=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
