package university;

import java.util.HashMap;

class Transcript {

    public int studentID;
    public HashMap<Integer, Double> transcript = new HashMap<>();

    public Transcript(int studentID) {
        this.studentID = studentID;
    }
    public void setGrade(int presentedCourseID, double grade) {
        if (PresentedCourse.findById(presentedCourseID) != null) {
            if (PresentedCourse.findById(presentedCourseID).studentIDList.contains(studentID)) {
                transcript.put(presentedCourseID, grade);
            }
        }
    }
    public void printTranscript() {
        for (Integer presentedCourseID : transcript.keySet()) {
            if (PresentedCourse.findById(presentedCourseID) != null) {
                if (Course.findById(PresentedCourse.findById(presentedCourseID).courseID) != null) {
                    System.out.println(Course.findById(PresentedCourse.findById(presentedCourseID).courseID).title + " : " + transcript.get(presentedCourseID));
                } else {
                    System.out.println("not found.");
                }
            } else {
                System.out.println("not found.");
            }
        }
    }
    public double getGPA() {
        int unitsSum = 0;
        double gradeSum = 0;
        for (Integer presentedCourseID : transcript.keySet()) {
            if (PresentedCourse.findById(presentedCourseID) != null) {
                if (Course.findById(PresentedCourse.findById(presentedCourseID).courseID) != null) {
                    unitsSum += Course.findById(PresentedCourse.findById(presentedCourseID).courseID).units;
                    gradeSum += Course.findById(PresentedCourse.findById(presentedCourseID).courseID).units * transcript.get(presentedCourseID);
                }
            }
        }
        if (unitsSum == 0) {
            return 0;
        }
        return gradeSum / unitsSum;
    }
}
