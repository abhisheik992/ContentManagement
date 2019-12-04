package com.km.admin.model;

import org.hibernate.annotations.NaturalId;
import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @NaturalId
    @Column(length = 60)
    private RoleName name;

	/**
	 * 
	 */
	public Role() {
		super();
	}

	/**
	 * @param id
	 * @param name
	 */
	public Role(Long id, RoleName name) {
		super();
		this.id = id;
		this.name = name;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public RoleName getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(RoleName name) {
		this.name = name;
	}
    
    
    
}
