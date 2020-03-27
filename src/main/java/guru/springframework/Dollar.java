package guru.springframework;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Dollar {

    private int amount;

    public void times(int multiplier) {
        amount *= multiplier;
    }

}
