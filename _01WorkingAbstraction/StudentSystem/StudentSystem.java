package _01WorkingAbstraction.StudentSystem;
import java.util.HashMap;
import java.util.Map;

public class StudentSystem {

    private Map<String, Student> studentMap;

    public StudentSystem() {
        this.studentMap = new HashMap<>();
    }

    public void parseCommand(String[]args) {

        String cmd = args[0];
        String name = args[1];

        if (cmd.equals("Create")) {
            int age = Integer.parseInt(args[2]);
            double grade = Double.parseDouble(args[3]);

            studentMap.putIfAbsent(name, new Student(name, age, grade));

            if (!studentMap.containsKey(name)) {

                Student student = new Student(name, age, grade);
                studentMap.put(name,student);
            }
        }
        else if (cmd.equals("Show")) {
            if (studentMap.containsKey(name)) {

                Student student = studentMap.get(name);
                String out = String.format("%s is %s years old.", student.getName() ,student.getAge());

                if (student.getGrade() >= 5.00) {
                    out += " Excellent student.";
                }
                else if (student.getGrade() < 5.00 && student.getGrade() >= 3.50) {
                    out += " Average student.";
                }
                else {
                    out += " Very nice person.";
                }

                System.out.println(out);
            }
        }
    }
}
