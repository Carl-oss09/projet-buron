package com.example.myapi.controller;

import com.example.myapi.model.Reservation;
import com.example.myapi.service.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;

@RestController
@RequestMapping("/api/reservations")
@Tag(name = "Reservation API", description = "API for managing reservations")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @Operation(summary = "Get all reservations", description = "Retrieve all reservations from the database")
    @GetMapping
    public ResponseEntity<List<Reservation>> getAllReservations() {
        return ResponseEntity.ok(reservationService.getAllReservations());
    }

    @PostMapping
    public ResponseEntity<Reservation> addReservation(@RequestBody Reservation reservation) {
        Reservation newReservation = reservationService.addReservation(reservation);
        return new ResponseEntity<>(newReservation, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable Long id) {
        Reservation reservation = reservationService.getReservationById(id);
        if (reservation != null) {
            return ResponseEntity.ok(reservation);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateReservation(@PathVariable Long id, @RequestBody Reservation updatedReservation) {
        Reservation existingReservation = reservationService.getReservationById(id);
        if (existingReservation != null) {
            existingReservation.setId_cours(updatedReservation.getId_cours());
            existingReservation.setIdEleve(updatedReservation.getIdEleve());
            reservationService.updateReservation(existingReservation);
            return ResponseEntity.ok("Reservation mise à jour");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Reservation non trouvée");
        }
    }

    @Operation(summary = "Get reservations by student ID", description = "Retrieve all reservations for a specific student")
    @GetMapping("student/{id_eleve}")
    public ResponseEntity<List<Reservation>> getReservationsByStudentId(@PathVariable Long id_eleve) {
        List<Reservation> reservations = reservationService.getReservationsByStudentId(id_eleve);
        if (!reservations.isEmpty()) {
            return ResponseEntity.ok(reservations);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReservation(@PathVariable Long id) {
        reservationService.deleteReservation(id);
        return ResponseEntity.ok("Reservation supprimée");
    }
}