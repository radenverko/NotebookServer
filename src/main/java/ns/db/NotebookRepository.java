package ns.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ns.models.Notebook;

import java.util.UUID;

@Repository
public interface NotebookRepository extends JpaRepository<Notebook, UUID> {
}
