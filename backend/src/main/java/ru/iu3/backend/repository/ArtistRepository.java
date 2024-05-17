package ru.iu3.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.iu3.backend.model.Artist;

public interface ArtistRepository extends JpaRepository<Artist, Long> {

}
