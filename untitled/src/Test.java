
class Jong {
    String name;
    int age;
}
public class Test {
    public static void main(String[] args) {
        Jong j = new Jong();
        Jong j2 = new Jong();
        j.age = 17;
        String a = "jhjh";
        String b = "jhjh";
        System.out.println(b.hashCode());
        System.out.println(a.hashCode());
        System.out.println(j.hashCode());
        System.out.println(j2.hashCode());
    }
}
