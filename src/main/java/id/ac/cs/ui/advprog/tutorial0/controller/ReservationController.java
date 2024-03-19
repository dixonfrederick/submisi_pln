package id.ac.cs.ui.advprog.tutorial0.controller;

import id.ac.cs.ui.advprog.tutorial0.exception.DuplicateReservationNameException;
import id.ac.cs.ui.advprog.tutorial0.model.Reservation;
import id.ac.cs.ui.advprog.tutorial0.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    private ReservationService service;

    @GetMapping("/list")
    public String reservationListPage(Model model) {
        List<Reservation> allReservations = service.findAll();
        model.addAttribute("reservations", allReservations);
        return "reservationList";
    }

    @GetMapping("/create")
    public String createreservationPage(Model model) {
        Reservation reservation = new Reservation();
        model.addAttribute("reservation", reservation);
        return "createReservation";
    }

    @PostMapping("/create")
    public String createreservationPost(@ModelAttribute Reservation reservation, Model model) {
        try {
            service.create(reservation);
        } catch (DuplicateReservationNameException e) {
            model.addAttribute("error", e);
            model.addAttribute("reservation", reservation);
            return "createReservation";
        }
        return "redirect:list";
    }

}