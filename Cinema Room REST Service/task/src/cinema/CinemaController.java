package cinema;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class CinemaController {
    Cinema cinema = new Cinema(9, 9);
    List<Seat> seats = cinema.availableSeats;
    List<Ticket> soldTickets = new ArrayList<>();
    Stats stats = new Stats(0,81,0);

    @GetMapping("/seats")
    public Cinema getSeats() {
        return cinema;
    }

    @PostMapping("/purchase")
    ResponseEntity<?> buyTicket(@RequestBody Seat seatToSell) {
        if (isValidRange(seatToSell)) {
            return new ResponseEntity<>(new Error("The number of a row or a column is out of bounds!"), HttpStatus.BAD_REQUEST);
        }
        for (Seat seat: seats) {
            if (isCorrectRowAndColumn(seatToSell, seat) && !seat.isAvailable()) {
                return new ResponseEntity<>(new Error("The ticket has been already purchased!"), HttpStatus.BAD_REQUEST);
            } else if (isCorrectRowAndColumn(seatToSell, seat) && seat.isAvailable()) {
                sellTicketUpdateStats(seat);
                Ticket ticket = new Ticket(UUID.randomUUID(), seat);
                soldTickets.add(ticket);
                return new ResponseEntity<>(ticket, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(new Error("Unknown error"), HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/return")
    ResponseEntity<?> returnedTicket(@RequestBody Ticket ticket) {
        for (Ticket soldTicket: soldTickets) {
            if (ticket.getToken().equals(soldTicket.getToken())) {
                ReturnedTicket returnedTicket = new ReturnedTicket(soldTicket.getSeat());
                for (Seat seat: seats) {
                    if (seat.getRow() == returnedTicket.seat.getRow()
                            && seat.getColumn() == returnedTicket.seat.getColumn()) {
                        returnTicketUpdateStats(seat);
                    }
                }
                soldTickets.remove(soldTicket);
                return new ResponseEntity<>(returnedTicket, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(new Error("Wrong token!"), HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/stats")
    ResponseEntity<?> getStats(@RequestParam(required = false) String password) {
        if (!"super_secret".equals(password)) {
            resetCinema();
            return new ResponseEntity<>(new Error("The password is wrong!"), HttpStatus.UNAUTHORIZED);
        }
        resetCinema();
        return new ResponseEntity<>(stats, HttpStatus.OK);
    }

    private void resetCinema() {
        cinema.setTotalColumns(9);
        cinema.setTotalRows(9);
    }

    private boolean isCorrectRowAndColumn(@RequestBody Seat seatToSell, Seat seat) {
        return seat.getRow() == seatToSell.getRow() && seat.getColumn() == seatToSell.getColumn();
    }

    private void sellTicketUpdateStats(Seat seat) {
        seat.setAvailable(false);
        stats.currentIncome += seat.getPrice();
        stats.numberOfPurchasedTickets++;
        stats.numberOfAvailableSeats--;
    }

    private void returnTicketUpdateStats(Seat seat) {
        seat.setAvailable(true);
        stats.currentIncome -= seat.getPrice();
        stats.numberOfPurchasedTickets--;
        stats.numberOfAvailableSeats++;
    }

    private boolean isValidRange(Seat seatToSell) {
        return cinema.getTotalRows() <= seatToSell.getRow()
                || cinema.getTotalColumns() < seatToSell.getColumn()
                || seatToSell.getRow() <= 0
                || seatToSell.getColumn() <= 0;
    }
}