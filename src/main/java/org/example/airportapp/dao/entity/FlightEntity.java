package org.example.airportapp.dao.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(schema = "bookings", name = "flights_v")
public class FlightEntity {
    @Id
    @Column(name = "flight_id")
    private String flightId;
    @Column(name = "flight_no")
    private String flightNo;
    @Column(name = "scheduled_departure")
    private LocalDate scheduledDeparture;
    @Column(name = "scheduled_departure_local")
    private LocalDate scheduledDepartureLocal;
    @Column(name = "scheduled_arrival")
    private LocalDate scheduledArrival;
    @Column(name = "scheduled_arrival_local")
    private LocalDate scheduledArrivalLocal;
    @Column(name = "scheduled_duration")
    private String scheduledDuration;
    @Column(name = "departure_airport")
    private String departureAirport;
    @Column(name = "departure_airport_name")
    private String departureAirportName;
    @Column(name = "departure_city")
    private String departureCity;
    @Column(name = "arrival_airport")
    private String arrivalAirport;
    @Column(name = "arrival_airport_name")
    private String arrivalAirportName;
    @Column(name = "arrival_city")
    private String arrivalCity;
    private String status;
    @Column(name = "aircraft_code")
    private String aircraftCode;
    @Column(name = "actual_departure")
    private LocalDate actualDeparture;
    @Column(name = "actual_departure_local")
    private LocalDate actualDepartureLocal;
    @Column(name = "actual_arrival")
    private LocalDate actualArrival;
    @Column(name = "actual_arrival_local")
    private LocalDate actualArrivalLocal;
    @Column(name = "actual_duration")
    private String actualDuration;

    public FlightEntity() {
    }

    public FlightEntity(String flightId, String flightNo, LocalDate scheduledDeparture,
                        LocalDate scheduledDepartureLocal, LocalDate scheduledArrival,
                        LocalDate scheduledArrivalLocal, String scheduledDuration, String departureAirport,
                        String departureAirportName, String departureCity, String arrivalAirport,
                        String arrivalAirportName, String arrivalCity, String status,
                        String aircraftCode, LocalDate actualDeparture, LocalDate actualDepartureLocal,
                        LocalDate actualArrival, LocalDate actualArrivalLocal, String actualDuration) {
        this.flightId = flightId;
        this.flightNo = flightNo;
        this.scheduledDeparture = scheduledDeparture;
        this.scheduledDepartureLocal = scheduledDepartureLocal;
        this.scheduledArrival = scheduledArrival;
        this.scheduledArrivalLocal = scheduledArrivalLocal;
        this.scheduledDuration = scheduledDuration;
        this.departureAirport = departureAirport;
        this.departureAirportName = departureAirportName;
        this.departureCity = departureCity;
        this.arrivalAirport = arrivalAirport;
        this.arrivalAirportName = arrivalAirportName;
        this.arrivalCity = arrivalCity;
        this.status = status;
        this.aircraftCode = aircraftCode;
        this.actualDeparture = actualDeparture;
        this.actualDepartureLocal = actualDepartureLocal;
        this.actualArrival = actualArrival;
        this.actualArrivalLocal = actualArrivalLocal;
        this.actualDuration = actualDuration;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public LocalDate getScheduledDeparture() {
        return scheduledDeparture;
    }

    public void setScheduledDeparture(LocalDate scheduledDeparture) {
        this.scheduledDeparture = scheduledDeparture;
    }

    public LocalDate getScheduledDepartureLocal() {
        return scheduledDepartureLocal;
    }

    public void setScheduledDepartureLocal(LocalDate scheduledDepartureLocal) {
        this.scheduledDepartureLocal = scheduledDepartureLocal;
    }

    public LocalDate getScheduledArrival() {
        return scheduledArrival;
    }

    public void setScheduledArrival(LocalDate scheduledArrival) {
        this.scheduledArrival = scheduledArrival;
    }

    public LocalDate getScheduledArrivalLocal() {
        return scheduledArrivalLocal;
    }

    public void setScheduledArrivalLocal(LocalDate scheduledArrivalLocal) {
        this.scheduledArrivalLocal = scheduledArrivalLocal;
    }

    public String getScheduledDuration() {
        return scheduledDuration;
    }

    public void setScheduledDuration(String scheduledDuration) {
        this.scheduledDuration = scheduledDuration;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public String getDepartureAirportName() {
        return departureAirportName;
    }

    public void setDepartureAirportName(String departureAirportName) {
        this.departureAirportName = departureAirportName;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public String getArrivalAirportName() {
        return arrivalAirportName;
    }

    public void setArrivalAirportName(String arrivalAirportName) {
        this.arrivalAirportName = arrivalAirportName;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAircraftCode() {
        return aircraftCode;
    }

    public void setAircraftCode(String aircraftCode) {
        this.aircraftCode = aircraftCode;
    }

    public LocalDate getActualDeparture() {
        return actualDeparture;
    }

    public void setActualDeparture(LocalDate actualDeparture) {
        this.actualDeparture = actualDeparture;
    }

    public LocalDate getActualDepartureLocal() {
        return actualDepartureLocal;
    }

    public void setActualDepartureLocal(LocalDate actualDepartureLocal) {
        this.actualDepartureLocal = actualDepartureLocal;
    }

    public LocalDate getActualArrival() {
        return actualArrival;
    }

    public void setActualArrival(LocalDate actualArrival) {
        this.actualArrival = actualArrival;
    }

    public LocalDate getActualArrivalLocal() {
        return actualArrivalLocal;
    }

    public void setActualArrivalLocal(LocalDate actualArrivalLocal) {
        this.actualArrivalLocal = actualArrivalLocal;
    }

    public String getActualDuration() {
        return actualDuration;
    }

    public void setActualDuration(String actualDuration) {
        this.actualDuration = actualDuration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FlightEntity that = (FlightEntity) o;

        if (!Objects.equals(flightId, that.flightId)) return false;
        if (!Objects.equals(flightNo, that.flightNo)) return false;
        if (!Objects.equals(scheduledDeparture, that.scheduledDeparture))
            return false;
        if (!Objects.equals(scheduledDepartureLocal, that.scheduledDepartureLocal))
            return false;
        if (!Objects.equals(scheduledArrival, that.scheduledArrival))
            return false;
        if (!Objects.equals(scheduledArrivalLocal, that.scheduledArrivalLocal))
            return false;
        if (!Objects.equals(scheduledDuration, that.scheduledDuration))
            return false;
        if (!Objects.equals(departureAirport, that.departureAirport))
            return false;
        if (!Objects.equals(departureAirportName, that.departureAirportName))
            return false;
        if (!Objects.equals(departureCity, that.departureCity))
            return false;
        if (!Objects.equals(arrivalAirport, that.arrivalAirport))
            return false;
        if (!Objects.equals(arrivalAirportName, that.arrivalAirportName))
            return false;
        if (!Objects.equals(arrivalCity, that.arrivalCity)) return false;
        if (!Objects.equals(status, that.status)) return false;
        if (!Objects.equals(aircraftCode, that.aircraftCode)) return false;
        if (!Objects.equals(actualDeparture, that.actualDeparture))
            return false;
        if (!Objects.equals(actualDepartureLocal, that.actualDepartureLocal))
            return false;
        if (!Objects.equals(actualArrival, that.actualArrival))
            return false;
        if (!Objects.equals(actualArrivalLocal, that.actualArrivalLocal))
            return false;
        return Objects.equals(actualDuration, that.actualDuration);
    }

    @Override
    public int hashCode() {
        int result = flightId != null ? flightId.hashCode() : 0;
        result = 31 * result + (flightNo != null ? flightNo.hashCode() : 0);
        result = 31 * result + (scheduledDeparture != null ? scheduledDeparture.hashCode() : 0);
        result = 31 * result + (scheduledDepartureLocal != null ? scheduledDepartureLocal.hashCode() : 0);
        result = 31 * result + (scheduledArrival != null ? scheduledArrival.hashCode() : 0);
        result = 31 * result + (scheduledArrivalLocal != null ? scheduledArrivalLocal.hashCode() : 0);
        result = 31 * result + (scheduledDuration != null ? scheduledDuration.hashCode() : 0);
        result = 31 * result + (departureAirport != null ? departureAirport.hashCode() : 0);
        result = 31 * result + (departureAirportName != null ? departureAirportName.hashCode() : 0);
        result = 31 * result + (departureCity != null ? departureCity.hashCode() : 0);
        result = 31 * result + (arrivalAirport != null ? arrivalAirport.hashCode() : 0);
        result = 31 * result + (arrivalAirportName != null ? arrivalAirportName.hashCode() : 0);
        result = 31 * result + (arrivalCity != null ? arrivalCity.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (aircraftCode != null ? aircraftCode.hashCode() : 0);
        result = 31 * result + (actualDeparture != null ? actualDeparture.hashCode() : 0);
        result = 31 * result + (actualDepartureLocal != null ? actualDepartureLocal.hashCode() : 0);
        result = 31 * result + (actualArrival != null ? actualArrival.hashCode() : 0);
        result = 31 * result + (actualArrivalLocal != null ? actualArrivalLocal.hashCode() : 0);
        result = 31 * result + (actualDuration != null ? actualDuration.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "FlightEntity{" +
                "flightId='" + flightId + '\'' +
                ", flightNo='" + flightNo + '\'' +
                ", scheduledDeparture='" + scheduledDeparture + '\'' +
                ", scheduledDepartureLocal='" + scheduledDepartureLocal + '\'' +
                ", scheduledArrival='" + scheduledArrival + '\'' +
                ", scheduledArrivalLocal='" + scheduledArrivalLocal + '\'' +
                ", scheduledDuration='" + scheduledDuration + '\'' +
                ", departureAirport='" + departureAirport + '\'' +
                ", departureAirportName='" + departureAirportName + '\'' +
                ", departureCity='" + departureCity + '\'' +
                ", arrivalAirport='" + arrivalAirport + '\'' +
                ", arrivalAirportName='" + arrivalAirportName + '\'' +
                ", arrivalCity='" + arrivalCity + '\'' +
                ", status='" + status + '\'' +
                ", aircraftCode='" + aircraftCode + '\'' +
                ", actualDeparture='" + actualDeparture + '\'' +
                ", actualDepartureLocal='" + actualDepartureLocal + '\'' +
                ", actualArrival='" + actualArrival + '\'' +
                ", actualArrivalLocal='" + actualArrivalLocal + '\'' +
                ", actualDuration='" + actualDuration + '\'' +
                '}';
    }
}
