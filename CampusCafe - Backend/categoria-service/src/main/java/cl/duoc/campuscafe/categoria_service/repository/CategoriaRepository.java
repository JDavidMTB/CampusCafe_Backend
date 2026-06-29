package cl.duoc.campuscafe.categoria_service.repository;

import cl.duoc.campuscafe.categoria_service.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
