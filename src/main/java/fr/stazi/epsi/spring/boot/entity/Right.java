package fr.stazi.epsi.spring.boot.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import fr.stazi.epsi.spring.boot.enums.RightEnum;

@Entity
@Table(name = "droits")
public class Right {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Enumerated(EnumType.STRING)
	private RightEnum droit;
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "role_right", joinColumns = @JoinColumn(name = "id_right"), inverseJoinColumns = @JoinColumn(name = "id_role"))
	private List<Role> roles;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public RightEnum getDroit() {
		return droit;
	}

	public void setDroit(RightEnum droit) {
		this.droit = droit;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}
