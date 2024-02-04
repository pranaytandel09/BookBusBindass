package com.masai.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Route {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="route_id")
	private Integer id;
	
	@NotBlank(message = "mendatory feild")
	@Column(name="route_source")
	private String routeSource;
	
	@NotBlank(message = "mendatory feild")
	@Column(name="route_destination")
	private String routeDestination;
	
	@Column(nullable = false)
	private int distance;
	
	@OneToMany(mappedBy = "route")                    //have to figure it out later
	@JsonIgnore
	private List<Bus>bus=new ArrayList<>();

	public Route(@NotBlank(message = "mendatory feild") String routeSource,
			@NotBlank(message = "mendatory feild") String routeDestination, int distance) {
		super();
		this.routeSource = routeSource;
		this.routeDestination = routeDestination;
		this.distance = distance;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRouteSource() {
		return routeSource;
	}

	public void setRouteSource(String routeSource) {
		this.routeSource = routeSource;
	}

	public String getRouteDestination() {
		return routeDestination;
	}

	public void setRouteDestination(String routeDestination) {
		this.routeDestination = routeDestination;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public List<Bus> getBus() {
		return bus;
	}

	public void setBus(List<Bus> bus) {
		this.bus = bus;
	}
	
	
}