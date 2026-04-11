package com.movix.movix.repository;

import com.movix.movix.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
    Location findTopByIdOrderByTimestampDesc(Long entregaId);
}
