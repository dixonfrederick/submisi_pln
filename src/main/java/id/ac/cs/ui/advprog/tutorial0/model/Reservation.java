package id.ac.cs.ui.advprog.tutorial0.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class Reservation {
    private String id;
    private String userid;
    private String unit;
    private String ruangan;
    private Date tanggal;
    private Integer waktumulai;
    private Integer waktuselesai;
    private String jeniskonsumsi;
    private Integer danakonsumsi;
}
