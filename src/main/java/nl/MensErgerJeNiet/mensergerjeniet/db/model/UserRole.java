package nl.MensErgerJeNiet.mensergerjeniet.db.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.Data;
@Data
@Entity
@Table(name="user_roles")
public class UserRole implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)    
    @Column(name="user_role_id")
	private Long userroleid;
	
	@NotNull
	@ManyToOne
	private User user;
	
	@Column(name="role")
	private String role;	

	
}
