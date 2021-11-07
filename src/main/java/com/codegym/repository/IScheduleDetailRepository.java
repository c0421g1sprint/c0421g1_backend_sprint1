package com.codegym.repository;

import com.codegym.dto.IScheduleTeacher;
import com.codegym.entity.about_schedule.ScheduleDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IScheduleDetailRepository extends JpaRepository<ScheduleDetail,Integer> {



    //Phuc
//    @Query(value="select sd.schedule_detail_id,sd.study_day_time_id,sd.subject_id,sd.schedule_id from schedule_detail sd \n" +
//            "join schedule s on sd.schedule_id = s.schedule_id\n" +
//            "join classroom cl on s.classroom_id = cl.classroom_id \n" +
//            "join teacher t on cl.teacher_id = t.teacher_id where t.teacher_id =?1",nativeQuery=true)
//    List<ScheduleDetail> getScheduleTeacher(@Param("id") Integer id);

        //Phuc
        @Query(value="select st.study_day_time_study_day as studyDay, st.study_day_time_study_time as studyTime," +
                " sj.subject_name as subjectName, cl.classroom_name as classroomName from schedule_detail sd \n" +
                "join study_day_time st  on sd.study_day_time_id = st.study_day_time_id\n" +
                "join schedule s on sd.schedule_id = s.schedule_id\n" +
                "join subject sj on sd.subject_id = sj.subject_id\n" +
                "join classroom cl on s.classroom_id = cl.classroom_id \n" +
                "join teacher t on cl.teacher_id = t.teacher_id where t.teacher_id =?1",nativeQuery=true)
        List<IScheduleTeacher> getScheduleTeacher(@Param("id") Integer id);
    }

