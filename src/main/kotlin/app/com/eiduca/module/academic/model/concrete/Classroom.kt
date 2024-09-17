package app.com.eiduca.module.academic.model.concrete

import app.com.eiduca.module.academic.request.concrete.ClassroomRequest
import app.com.eiduca.module.core.common.general.ConcreteModel
import app.com.eiduca.module.core.interfaces.IConvertModel
import app.com.eiduca.module.core.interfaces.IConvertRequest
import app.com.eiduca.module.core.interfaces.IUniqueAttributeModifier
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name ="tb_classrooms")
class Classroom(
    @Column(unique = true) var code: String,
    @ManyToOne var course: Course,
    @ManyToOne var dayPeriod: DayPeriod,
    @ManyToOne var academicPeriod: AcademicPeriod,
    @ManyToOne var curriculumYear: CurriculumYear,
): ConcreteModel(), IConvertRequest<Classroom>, IUniqueAttributeModifier{

    constructor(): this("", Course(), DayPeriod(), AcademicPeriod(), CurriculumYear())

    override fun updateUniqueAttributes() {
        code += nanoId()
    }

    override fun toRequest(): ClassroomRequest = ClassroomRequest(code, course.id, dayPeriod.id, academicPeriod.id, curriculumYear.id)

    override fun toString(): String {
        return "Classroom(${setToString("code='$code', course=$course, dayPeriod=$dayPeriod, academicPeriod=$academicPeriod, curriculumYear=$curriculumYear")})"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Classroom) return false
        if (!super.equals(other)) return false
        if (course != other.course) return false
        if (dayPeriod != other.dayPeriod) return false
        if (academicPeriod != other.academicPeriod) return false
        if (curriculumYear != other.curriculumYear) return false
        return true
    }

    override fun hashCode(): Int {
        var result = super.hashCode()
        result = 31 * result + course.hashCode()
        result = 31 * result + dayPeriod.hashCode()
        result = 31 * result + academicPeriod.hashCode()
        result = 31 * result + curriculumYear.hashCode()
        return result
    }
}