public class Person {
    public String name;
    public int age;
    public Person(String name, int age){
        if(name == null || name.isEmpty() || name.length() > 40){
            throw new IllegalArgumentException("Invalid name");
        }
        if(age > 120 || age < 0){
            throw new IllegalArgumentException("Invalid age");
        }
        this.name = name;
        this.age = age;
    }
}
