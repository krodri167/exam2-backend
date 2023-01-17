package ec.edu.insteclrg.dto;

import ec.edu.insteclrg.domain.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDTO {
    private Long id;
    private String name;
    private Category category;
}
