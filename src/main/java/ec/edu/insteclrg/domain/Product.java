package ec.edu.insteclrg.domain;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "tproduct")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private Long id;

	@Column(unique = true, nullable = false)
	private String name;

	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "category_id")
	private Category category;
}
