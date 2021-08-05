package cinema;

import java.util.ArrayList;
import java.util.List;

public class Cinema {
    private int totalRows;
    private int totalColumns;
    List<Seat> availableSeats;


    public Cinema() {}

    public Cinema(int totalRows, int totalColumns) {
        this.totalRows = totalRows;
        this.totalColumns = totalColumns;
        this.availableSeats = createCinema();
    }

    public List<Seat> getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(List<Seat> availableSeats) {
        this.availableSeats = availableSeats;
    }

    List<Seat> createCinema() {
        List<Seat> seats = new ArrayList<>();
        for (int i = 1; i < this.totalRows + 1; i++) {
            for (int j = 1; j < this.totalColumns + 1; j++) {
                seats.add(new Seat(i, j, calculatePrice(i), true));
            }
        }
        return seats;
    }

    private int calculatePrice(int row) {
        return row <= 4 ? 10 : 8;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public int getTotalColumns() {
        return totalColumns;
    }

    public void setTotalColumns(int totalColumns) {
        this.totalColumns = totalColumns;
    }
}