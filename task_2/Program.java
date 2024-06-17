package ru.geekbrains.seminar_3.homework.task_2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static ru.geekbrains.seminar_3.homework.task_2.StudentsApp.*;
import static ru.geekbrains.seminar_3.homework.task_2.StudentsApp.FILE_XML;

public class Program {
    public static void main(String[] args) {
        List<Student> students;
        File f = new File(FILE_JSON);
        if (f.exists() && !f.isDirectory())
            students = loadStudentsFromFile(FILE_JSON);
        else
            students = prepareStudentsList();
        StudentsApp.saveStudentsToFile(FILE_JSON, students);
        StudentsApp.saveStudentsToFile(FILE_BIN, students);
        StudentsApp.saveStudentsToFile(FILE_XML, students);

        displayStudents(students);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Добавить нового студента");
            System.out.println("2. Отметить студента, как перспективного.");
            System.out.println("3. Выйти");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    StudentsApp.addNewStudent(scanner, students);

                case "2":
                    StudentsApp.markStudentAsPerspective(scanner, students);
                    break;
                case "3": {
                    StudentsApp.saveStudentsToFile(FILE_JSON, students);
                    StudentsApp.saveStudentsToFile(FILE_BIN, students);
                    StudentsApp.saveStudentsToFile(FILE_XML, students);
                    System.out.println("\nСписок студентов сохранен.");
                    scanner.close();
                    System.exit(0);
                }
                default:
                    System.out.println("\nНекорректный выбор. Попробуйте снова.");
            }
            displayStudents(students);
        }
    }

    static List<Student> prepareStudentsList() {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Иванов", 15, 4.5));
        students.add(new Student("Петров", 14, 5.0));
        students.add(new Student("Сидоров", 16, 4.9));
        return students;
    }

}
