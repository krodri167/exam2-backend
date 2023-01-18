package ec.edu.insteclrg.persistence;


import ec.edu.insteclrg.domain.Username;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsernameRepository extends JpaRepository<Username,Long> {
}
