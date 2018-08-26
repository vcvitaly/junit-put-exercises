package com.practicalunittesting.chp04.bookingsystem;

import java.util.List;

public interface BookingSystem {
    List<Integer> getBookedHours();
    void book(String timeFrom, double hours);
}
