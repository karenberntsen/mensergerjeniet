package nl.MensErgerJeNiet.mensergerjeniet.db.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Data
@Entity
@Table(name = "users", uniqueConstraints=
@UniqueConstraint(columnNames={"username"}))
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)    
    @Column(name="userid")
    private Long userId;

	@NotEmpty
	@Column(name = "username")
    private String userName;   

	@NotEmpty
	@Column(name = "password")
    private String password;   

	@NotEmpty
	@Column(name = "email")
    private String email;

	@NotNull
	@Column(name ="enabled")
	private int enabled;
	public User(){}
	
	public User(User user) {
	        this.userId = user.userId;
	        this.userName = user.userName;
	        this.email = user.email;       
	        this.password = user.password;
	        this.enabled=user.enabled;        
	}
  
}