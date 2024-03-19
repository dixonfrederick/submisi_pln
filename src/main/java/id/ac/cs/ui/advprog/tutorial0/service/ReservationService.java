package id.ac.cs.ui.advprog.tutorial0.service;

import id.ac.cs.ui.advprog.tutorial0.model.Reservation;

import java.util.List;

public interface ReservationService {

    public Reservation create(Reservation reservation);
    public List<Reservation> findAll();
}
