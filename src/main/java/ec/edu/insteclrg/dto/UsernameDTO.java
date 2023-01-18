package ec.edu.insteclrg.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsernameDTO {
    private Long id;
    private String username;
    private String password;
}
