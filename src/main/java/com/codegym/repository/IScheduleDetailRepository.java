package com.codegym.repository;

import com.codegym.entity.about_schedule.ScheduleDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IScheduleDetailRepository extends JpaRepository<ScheduleDetail, Integer> {

    // TaiNP query find schdedule by class_id
    @Query(value = "select schedule_detail_id, sd.schedule_id, sd.subject_id, sd.study_day_time_id" +
            " from schedule_detail sd" +
            "   inner join schedule s on sd.schedule_id = s.schedule_id" +
            " where s.classroom_id = ?1", nativeQuery = true)
    List<ScheduleDetail> findScheduleDetailByClassroomId(Integer classroomId);

}
