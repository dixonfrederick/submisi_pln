package id.ac.cs.ui.advprog.tutorial0.exception;

public class DuplicateReservationNameException extends RuntimeException {

    public DuplicateReservationNameException(String id) {
        super(String.format("The id %s is a duplicate!",id));
    }
}