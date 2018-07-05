public class Student {

    private String name;
    private int score;

    public Student(String name, int score) {
        this.score = score;
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Student(name: %s, socre: %d)", name, score);
    }

    public static void main(String[] args) {
        ArrayUsingGenerics<Student> array = new ArrayUsingGenerics<>();
        array.addLast(new Student("kenvin", 100));
        array.addLast(new Student("bobo", 90));

        System.out.println(array.toString());
    }
}
