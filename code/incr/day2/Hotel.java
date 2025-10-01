package com.examly.springapp.model;

import com.examly.springapp.exception.LowRankingException;

public class Hotel {
    private int hotelId;
    private String hotelName;
    private String hotelLocation;
    private float hotelRanking;
    private boolean gymAvailable;
    private boolean poolAvailable;
    private boolean spaAvailable;

    public Hotel() {

    }

    public Hotel(int hotelId, String hotelName, String hotelLocation, float hotelRanking, boolean gymAvailable,
            boolean poolAvailable, boolean spaAvailable) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.hotelLocation = hotelLocation;
        this.hotelRanking = hotelRanking;
        this.gymAvailable = gymAvailable;
        this.poolAvailable = poolAvailable;
        this.spaAvailable = spaAvailable;
    }

    public static void main(String[] args) {

        try {
            Hotel hotel1 = new Hotel();
            hotel1.setHotelId(1);
            hotel1.setHotelName("abc");
            hotel1.setHotelLocation("Chennai");
            hotel1.setHotelRanking(4);
            hotel1.setGymAvailable(true);
            hotel1.setPoolAvailable(false);
            hotel1.setSpaAvailable(true);

            Hotel hotel2 = new Hotel();
            hotel2.setHotelId(2);
            hotel2.setHotelName("xuz");
            hotel2.setHotelLocation("Hyd");
            hotel2.setHotelRanking(4);
            hotel2.setGymAvailable(true);
            hotel2.setPoolAvailable(false);
            hotel2.setSpaAvailable(true);

            System.out.println("Hotel1 Details");
            System.out.println(hotel1.getHotelId());
            System.out.println(hotel1.getHotelName());
            System.out.println(hotel1.getHotelLocation());
            System.out.println(hotel1.getHotelRanking());
            System.out.println(hotel1.isGymAvailable());
            System.out.println(hotel1.isPoolAvailable());
            System.out.println(hotel1.isSpaAvailable());

            System.out.println("Hotel2 Details");
            System.out.println(hotel2.getHotelId());
            System.out.println(hotel2.getHotelName());
            System.out.println(hotel2.getHotelLocation());
            System.out.println(hotel2.getHotelRanking());
            System.out.println(hotel2.isGymAvailable());
            System.out.println(hotel2.isPoolAvailable());
            System.out.println(hotel2.isSpaAvailable());
        } catch (LowRankingException e) {
            System.out.println(e.getMessage());
        }
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelLocation() {
        return hotelLocation;
    }

    public void setHotelLocation(String hotelLocation) {
        this.hotelLocation = hotelLocation;
    }

    public float getHotelRanking() {
        return hotelRanking;
    }

    public void setHotelRanking(float hotelRanking) throws LowRankingException {
        if (hotelRanking < 4.0) {
            throw new LowRankingException("Low Ranking Exception");
        }
        this.hotelRanking = hotelRanking;
    }

    public boolean isGymAvailable() {
        return gymAvailable;
    }

    public void setGymAvailable(boolean gymAvailable) {
        this.gymAvailable = gymAvailable;
    }

    public boolean isPoolAvailable() {
        return poolAvailable;
    }

    public void setPoolAvailable(boolean poolAvailable) {
        this.poolAvailable = poolAvailable;
    }

    public boolean isSpaAvailable() {
        return spaAvailable;
    }

    public void setSpaAvailable(boolean spaAvailable) {
        this.spaAvailable = spaAvailable;
    }

}
