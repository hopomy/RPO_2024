package ru.iu3.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.iu3.backend.model.Painting;

public interface PaintingRepository extends JpaRepository<Painting, Long> {

}
