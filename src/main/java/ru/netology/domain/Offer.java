package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Offer implements Comparable<Offer> {
    private int id;
    private int cost;
    private String fromAirport;
    private String toAirport;
    private int flightTime;

    @Override
    public int compareTo(Offer o) {
        return cost - o.getCost();
    }
}
