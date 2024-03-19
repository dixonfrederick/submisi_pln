package id.ac.cs.ui.advprog.tutorial0.service;

import id.ac.cs.ui.advprog.tutorial0.exception.DuplicateReservationNameException;
import id.ac.cs.ui.advprog.tutorial0.model.Reservation;
import id.ac.cs.ui.advprog.tutorial0.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public Reservation create(Reservation reservation) {

        if (reservation.getWaktuselesai() < 11) {
            reservation.setJeniskonsumsi("Snack");
            reservation.setDanakonsumsi(20000);
        }
        else if (reservation.getWaktumulai() < 11 && reservation.getWaktuselesai() <= 14) {
            reservation.setJeniskonsumsi("Snack+Makan");
            reservation.setDanakonsumsi(50000);
        }
        else if (reservation.getWaktumulai() >= 11 && reservation.getWaktuselesai() <= 14) {
            reservation.setJeniskonsumsi("Makan");
            reservation.setDanakonsumsi(30000);
        }
        else if (reservation.getWaktumulai() >= 11 && reservation.getWaktuselesai() > 14) {
            reservation.setJeniskonsumsi("Snack+Makan");
            reservation.setDanakonsumsi(50000);
        }
        else if (reservation.getWaktumulai() < 11 && reservation.getWaktuselesai() > 14) {
            reservation.setJeniskonsumsi("Snack+Makan");
            reservation.setDanakonsumsi(70000);
        }
        else{
            reservation.setJeniskonsumsi("Snack");
            reservation.setDanakonsumsi(20000);
        }
        reservationRepository.create(reservation);
        return reservation;
    }

    private void validateName(Reservation reservation) {
        List<Reservation> allReservations = findAll();
        for(Reservation dbReservation : allReservations) {
            if(dbReservation.getId().equals(reservation.getId())) {
                throw new DuplicateReservationNameException(reservation.getId());
            }
        }
    }

    @Override
    public List<Reservation> findAll() {
        Iterator<Reservation> reservationIterator = reservationRepository.findAll();
        List<Reservation> allReservations = new ArrayList<>();
        reservationIterator.forEachRemaining(allReservations::add);
        return allReservations;
    }
}