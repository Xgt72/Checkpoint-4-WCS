package com.checkpoint.wcs.wildcircus.repositories;

import com.checkpoint.wcs.wildcircus.entities.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
