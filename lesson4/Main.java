package lesson4;

import lesson4.controllers.GroupController;
import lesson4.controllers.StudentController;
import lesson4.controllers.TeacherController;
import lesson4.repositories.StudentRepository;
import lesson4.repositories.TeacherRepository;
import lesson4.services.GroupService;
import lesson4.services.StudentService;
import lesson4.services.TeacherService;
import lesson4.view.GroupView;
import lesson4.view.SortType;
import lesson4.view.StudentView;
import lesson4.view.TeacherView;

public class Main {

    private static StudentRepository studentRepository;
    private static StudentService studentService;
    private static StudentController studentController;

    private static TeacherRepository teacherRepository;
    private static TeacherService teacherService;
    private static TeacherController teacherController;

    public static void main(String[] args) {
        StudentView view = getStudentController();
        //GroupView groupView = getGroupView();
//        -------------------------------------------------------------------------

        view.create("Ivan Morozov", 18, "02", "10А");
        view.create("Ivan Morozov", 18, "02", "11А");
        view.create("Petr Vorobev", 19, "03", "10А");
        view.create("Sidor Sidorov", 20, "112", "10А");
        view.create("Elena Ivanova", 19, "911", "10А");
        view.create("Anna Morozova", 17, "01", "11А");


        //view.sendOnConsole();
        view.sendOnConsole(SortType.NAME);
        //view.sendOnConsole(SortType.ID);
        //view.removeUser("Ivan Morozov");
        //view.sendOnConsole();

        TeacherView vision = getTeacherController();
        vision.create("Alexander Sogorov", 54, "456","11А");
        vision.create("Elena Soboleva", 41, "456","10А");

        vision.sendOnConsole();
        GroupView groupView = getGroupView();
        groupView.printAllFromGroup("11А");
    }

    private static StudentView getStudentController() {
        studentRepository = new StudentRepository();
        studentService = new StudentService(studentRepository);
        studentController = new StudentController(studentService);
        return new StudentView(studentController);
    }

    private static TeacherView getTeacherController() {
        teacherRepository = new TeacherRepository();
        teacherService = new TeacherService(teacherRepository);
        teacherController = new TeacherController(teacherService);
        return new TeacherView(teacherController);
    }

    private static GroupView getGroupView() {
        GroupService groupService = new GroupService(studentService, teacherService);
        GroupController groupController = new GroupController(groupService);
        return new GroupView(groupController);
    }


}
