package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "Subscriptions")
public class Subscription implements Serializable {

    @EmbeddedId
    private Key id;

    @Column(name = "student_id", insertable = false, updatable = false)
    private int studentId;

    @Column(name = "course_id", insertable = false, updatable = false)
    private int courseId;

    @Column(name = "subscription_date")
    private Date subscriptionDate;

    public Key getId() {
        return id;
    }

    public int getStudent() {
        return studentId;
    }

    public int getCourse() {
        return courseId;
    }

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

    @Embeddable
    public static class Key implements Serializable {

        public Key(Student student, Course course) {
            this.student = student;
            this.course = course;
        }

        public Key() {
        }

        @ManyToOne(fetch = FetchType.LAZY)
        //@ManyToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "student_id", foreignKey = @ForeignKey(name = "PERSON_ID_FK_St"))
        private Student student;

        @ManyToOne(fetch = FetchType.LAZY)
        //@ManyToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "course_id", foreignKey = @ForeignKey(name = "PERSON_ID_FK_Crs"))
        private Course course;

        public Student getStudent() {
            return student;
        }

        public void setStudent(Student student) {
            this.student = student;
        }

        public Course getCourse() {
            return course;
        }

        public void setCourse(Course course) {
            this.course = course;
        }

        @Override
        public boolean equals(Object o) {

            if (this == o) {
                return true;
            }

            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Key key = (Key) o;
            return Objects.equals(getStudent(), key.getStudent()) &&
                    Objects.equals(getCourse(), key.getCourse());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getStudent(), getCourse());
        }
    }
}