package nl.MensErgerJeNiet.mensergerjeniet.db.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "statistics")
public class Statistics implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)    
    @Column(name="statisticsid")
	private Long id;

	@NotNull
	@Column(name = "win")
	private int win;

	@NotNull
	@Column(name = "loss")
	private int loss;

	@NotNull
	@OneToOne
	private User user;

}
