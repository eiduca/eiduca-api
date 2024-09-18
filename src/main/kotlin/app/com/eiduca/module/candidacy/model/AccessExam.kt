package app.com.eiduca.module.candidacy.model

import app.com.eiduca.module.academic.model.concrete.Course
import app.com.eiduca.module.academic.model.concrete.Discipline
import app.com.eiduca.module.candidacy.common.datatimerange.DateTimeRangeModel
import app.com.eiduca.module.core.common.general.ConcreteModel
import jakarta.persistence.Entity
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name ="tb_access_exam")
class AccessExam(
    @ManyToOne var course: Course,
    @ManyToOne var discipline: Discipline,
    @ManyToOne var calendarAccessExam: CalendarAccessExam,
    startDateTime: LocalDateTime,
    endDateTime: LocalDateTime,
): DateTimeRangeModel(startDateTime, endDateTime){

    constructor(): this(Course(), Discipline(), CalendarAccessExam(), LocalDateTime.now(), LocalDateTime.now())

}