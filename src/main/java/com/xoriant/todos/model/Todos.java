package com.xoriant.todos.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Todos {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int tid;
	private String title;
	private String description;
	private boolean active;
	private LocalDate date;
	
	@ManyToOne
	@JoinColumn(name = "uid")
	private User user;
	
}
