package ns.db;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import ns.models.User;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

}
