import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class OHP5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.lines().map(String::toUpperCase).filter(d -> d.length() >= 5 && d.length() < 10).forEach(System.out::println);
    }
}
