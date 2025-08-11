package _05Inheritance.Animals;

public class Animal {

    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {

        setName(name);
        setAge(age);
        setGender(gender);
    }

    private void setName(String name) {

        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.name = name;
    }

    private void setAge(int age) {

        if (age < 0) {
            throw new IllegalArgumentException("Invalid input!");
        }
        else {
            this.age = age;
        }
    }

    private void setGender(String gender) {

        if (gender.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String produceSound() {
        return null;
    }

    @Override
    public String toString() {

        return String.format("%s%n%s %d %s%n%s",
                 this.getClass().getSimpleName(),
                      getName(), getAge(), getGender(),
                      produceSound());
    }
}
