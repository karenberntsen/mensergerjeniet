package nl.MensErgerJeNiet.mensergerjeniet.db.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "games")
public class Game implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)    
    @Column(name="gameid")
	private Long id;

	@NotNull
	@ManyToOne
	private User winner;

	@NotNull
	@Column(name = "turns")
	private int turns;
	
}
