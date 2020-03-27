package guru.springframework;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Dollar {

    private int amount;

    public Dollar times(int multiplier) {
        return new Dollar(amount * multiplier);
    }

}
