package com.codegym.repository;

import com.codegym.entity.about_schedule.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IScheduleRepository extends JpaRepository<Schedule, Integer> {
}
