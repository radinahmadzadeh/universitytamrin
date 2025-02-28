package university;

import main.Person;

public class Main {

    public static void main(String[] args) {
        university.Major major1 = new university.Major("Computer Science",100);
        university.Major major2 = new university.Major("Mathematics",100);

        Person person1 = new Person("ali","1");
        Person person2 = new Person("mmd","2");
        Person person3 = new Person("sara","3");
        Person person4 = new Person("Mahdi","4");
        Person person5 = new Person("gholi","5");

        university.Student student1 = new university.Student(1,1403,1);
        university.Student student2 = new university.Student(2,1403,1);
        university.Student student3 = new university.Student(3,1403,2);

        System.out.println("Students: ");

        System.out.print(person1.findById(1).name + " ");
        if ( major1.numberOfStudents < 10) {
            int num = Integer.decode(student1.studentCode) %10 ;
            System.out.print( String.valueOf(Integer.decode(student1.studentCode) / 10) + "0" + num + "\n");
        }
        else {
            System.out.print(student1.studentCode + "\n");
        }

        System.out.print(person2.findById(2).name + " ");
        if ( major1.numberOfStudents < 10) {
            int num = Integer.decode(student2.studentCode) %10;
            System.out.print( String.valueOf(Integer.decode(student2.studentCode) / 10) + "0" + num + "\n");
        }
        else {
            System.out.print(student2.studentCode + "\n");
        }
        System.out.print(person3.findById(3).name + " ");
        if ( major2.numberOfStudents < 10) {
            int num = Integer.decode(student3.studentCode) %10;
            System.out.print( String.valueOf(Integer.decode(student3.studentCode) / 10) + "0" + num + "\n");
        }
        else {
            System.out.print(student3.studentCode + "\n");
        }

        university.Professor professor1 = new university.Professor(4,1);
        university.Professor professor2 = new university.Professor(5,2);

        System.out.print("\nProfessors: \n");
        System.out.println(person4.findById(4).name + " " + professor1.id);
        System.out.println(person5.findById(5).name + " " + professor2.id);

        university.Course course1 = new university.Course("advanced programming",4);
        university.Course course2 = new university.Course("Probability Foundations",3);
        university.Course course3 = new university.Course("Mathematics 1",3);

        university.PresentedCourse p_PresentedCourse1 = new university.PresentedCourse(course1.id , professor1.id ,5);
        university.PresentedCourse p_PresentedCourse2 = new university.PresentedCourse(course2.id , professor1.id ,5);
        university.PresentedCourse p_PresentedCourse3 = new university.PresentedCourse(course3.id , professor2.id ,5);

        p_PresentedCourse1.addStudent(student1.id);
        p_PresentedCourse1.addStudent(student2.id);

        p_PresentedCourse2.addStudent(student1.id);
        p_PresentedCourse2.addStudent(student2.id);
        p_PresentedCourse2.addStudent(student3.id);

        p_PresentedCourse3.addStudent(student3.id);

        university.Transcript transcript1 = new university.Transcript(student1.id);
        university.Transcript transcript2 = new university.Transcript(student2.id);
        university.Transcript transcript3 = new university.Transcript(student3.id);

        transcript1.setGrade(p_PresentedCourse1.courseID,19);
        transcript1.setGrade(p_PresentedCourse2.courseID,20);
        transcript2.setGrade(p_PresentedCourse1.courseID,18);
        transcript2.setGrade(p_PresentedCourse2.courseID,17);
        transcript3.setGrade(p_PresentedCourse2.courseID,19.5);
        transcript3.setGrade(p_PresentedCourse3.courseID,12);

        System.out.println("\nali Transcript: ");
        transcript1.printTranscript();
        System.out.println("");
        System.out.println("mmd Transcript: ");
        transcript2.printTranscript();
        System.out.println("");
        System.out.println("sara Transcript: ");
        transcript3.printTranscript();
        System.out.println("");

        System.out.println(person1.findById(1).name + " GPA: " + transcript1.getGPA());
        System.out.println(person2.findById(2).name + " GPA: " + transcript2.getGPA());
        System.out.println(person3.findById(3).name + " GPA: " + transcript3.getGPA());
    }
}