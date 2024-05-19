package ru.iu3.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.iu3.backend.model.Museum;

public interface MuseumRepository extends JpaRepository<Museum, Long> {

}
