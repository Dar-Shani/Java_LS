package core.ls4;
import lombok.*;
import java.util.Calendar;


@ToString(onlyExplicitlyIncluded = true)
@AllArgsConstructor
public class Buyer {
    @Getter
    @ToString.Include
    private String name;
    @Getter
    @ToString.Include
    private String gender;
    @Getter
    private Calendar date;
}
