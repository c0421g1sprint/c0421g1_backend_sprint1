package com.codegym.repository;

import com.codegym.entity.about_schedule.Schedule;
import com.codegym.entity.about_schedule.ScheduleDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface IScheduleRepository extends JpaRepository<ScheduleDetail, Integer> {
    //    List<Schedule> findAllByScheduleId(Integer scheduleId);

    @Query(value = "select schedule_detail_id, sd.schedule_id, sd.subject_id, sd.study_day_time_id\n" +
            "from schedule_detail sd\n" +
            "         inner join schedule s on sd.schedule_id = s.schedule_id\n" +
            "where s.classroom_id = ?1", nativeQuery = true)
    List<ScheduleDetail> findScheduleDetailByClassroomId(Integer classroomId);


    @Query(value = "UPDATE schedule_detail\n" +
            "SET subject_id=?1\n" +
            "WHERE schedule_id=?2;", nativeQuery = true)
    void updateSchedule(int updateValue, int idScheduleDetail);
}
