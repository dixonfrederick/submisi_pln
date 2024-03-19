package id.ac.cs.ui.advprog.tutorial0.repository;

import id.ac.cs.ui.advprog.tutorial0.model.Reservation;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class ReservationRepository {

    private List<Reservation> reservationsInMemory = new ArrayList<>();

    public Reservation create(Reservation reservation) {
        reservationsInMemory.add(reservation);
        return reservation;
    }

    public Iterator<Reservation> findAll(){
        return reservationsInMemory.iterator();
    }
}
