package com.masai.model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
public class Bus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="bus_id")
	private Integer id;
	
	@NotBlank(message = "mendatory feild")
	@Column(name="bus_name")
	private String busName;
	
	@NotBlank(message = "mendatory feild")
	@Column(name="driver_name")
	private String driverName;

	@NotBlank(message = "mendatory feild")
	@Column(name="bus_type")
	private String type;
	
	@Column(name="arrival_time")
	@JsonFormat(pattern="HH:mm:ss")
	private LocalTime arrivalTime;
	
	@Column(name="departure_time")
	@JsonFormat(pattern="HH:mm:ss")
	private LocalTime departureTime;
	
	@Column(name="bus_seats",nullable = false)
	private int seats;
	
	@Column(name="available_bus_seats",nullable = false)
	private int availableSeats;
	
	
	@OneToMany(mappedBy = "bus")
	@JsonIgnore
	private List<Reservation> reservation=new ArrayList<>();
	
	@OneToMany(mappedBy = "bus")
	@JsonIgnore
	private List<Feedback> feedback=new ArrayList<>();
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="route_id")
	@JsonIgnore

	private Route route;

	public Bus(@NotBlank(message = "mendatory feild") String busName,
			@NotBlank(message = "mendatory feild") String driverName,
			@NotBlank(message = "mendatory feild") String type, LocalTime arrivalTime, LocalTime departureTime,
			int seats, int availableSeats) {
		super();
		this.busName = busName;
		this.driverName = driverName;
		this.type = type;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		this.seats = seats;
		this.availableSeats = availableSeats;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBusName() {
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public LocalTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public LocalTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalTime departureTime) {
		this.departureTime = departureTime;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

	public List<Reservation> getReservation() {
		return reservation;
	}

	public void setReservation(List<Reservation> reservation) {
		this.reservation = reservation;
	}

	public List<Feedback> getFeedback() {
		return feedback;
	}

	public void setFeedback(List<Feedback> feedback) {
		this.feedback = feedback;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}
	
	
}