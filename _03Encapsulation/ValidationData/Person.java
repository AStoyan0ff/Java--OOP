package _03Encapsulation.ValidationData;

public class Person {

    private String firstName;
    private String lastName;
    private int age;
    private double salary;


    public Person(String firstName, String lastName, int age, double salary) {

        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
        this.setSalary(salary);
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {

        if (firstName.length() < 3) {
            throw new IllegalStateException("First name cannot be less than 3 symbols");
        }
        else {
            this.firstName = firstName;
        }


    }

    public String getLastName() {
        return this.lastName = lastName;
    }

    public void setLastName(String lastName) {

        if ( lastName.length() < 3) {
            throw new IllegalStateException("Last name cannot be less than 3 symbols");
        }
        else {
            this.lastName = lastName;
        }
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {

        if (age <= 0) {
            throw  new IllegalStateException("Age must not be zero or negative integer");
        }
        else {
            this.age = age;
        }

    }
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {

        if (salary < 460) {
            throw new IllegalStateException("Salary cannot be less than 460 leva");
        }
        else {
            this.salary = salary;
        }
    }

    public void increaseSalary(double bonus) {

        if (this.getAge() < 30) {
            bonus /= 2;
        }

        double increaseSalary = this.getSalary() + (this.getSalary() * (bonus / 100));
        this.setSalary(increaseSalary);
    }



    @Override
    public String toString() {

        return String.format("%s %s gets %.2f leva",
                this.getFirstName(), this.getLastName(), this.getSalary());

    }
}
