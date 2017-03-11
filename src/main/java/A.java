import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class A {
    int x;
    public static void main(String[] args) {
        System.out.println(A.builder().x(12).build());
    }
}
