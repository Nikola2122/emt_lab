package com.example.lab_emt.repository;

import com.example.lab_emt.model.domain.Accommodation;
import com.example.lab_emt.model.projection.DetailedAccProjection;
import com.example.lab_emt.model.projection.SimpleAccProjection;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccommodationRepository extends JpaSpecificationRepository<Accommodation, Long> {
    @Query(value = "select id, name, category, num_rooms from accommodations", nativeQuery = true)
    List<SimpleAccProjection> findSimpleDetails();

    @Query(value = """
                SELECT a.id,
                       a.name,
                       a.category,
                       a.num_rooms,
                       h.name AS host_name,
                       h.surname AS host_surname,
                       c.name AS host_country_name
                FROM accommodations a
                JOIN hosts h ON a.host_id = h.id
                JOIN countries c ON h.country_id = c.id
            """, nativeQuery = true)
    List<DetailedAccProjection> findDetailedDetails();

    @EntityGraph(value = "accommodation-entity-graph", type = EntityGraph.EntityGraphType.FETCH)
    Optional<Accommodation> findWithHostAndCountryById(Long userId);

}
