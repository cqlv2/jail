package fr.stazi.epsi.spring.boot.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Cell {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String code;
	private short maxPrisoners;

	@JsonIgnore
	@OneToMany(mappedBy = "cell")
	private List<Prisoner> prisoners;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "gardien_cell", joinColumns = @JoinColumn(name = "id_cell"), inverseJoinColumns = @JoinColumn(name = "id_user"))
	private List<User> user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public short getMaxPrisoners() {
		return maxPrisoners;
	}

	public void setMaxPrisoners(short maxPrisoners) {
		this.maxPrisoners = maxPrisoners;
	}

	public List<Prisoner> getPrisoners() {
		return prisoners;
	}

	public void setPrisoners(List<Prisoner> prisoners) {
		this.prisoners = prisoners;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

}
