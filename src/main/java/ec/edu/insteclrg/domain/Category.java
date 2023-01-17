package ec.edu.insteclrg.domain;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "tcategory")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private Long id;

	@Column
	private String name;

}
