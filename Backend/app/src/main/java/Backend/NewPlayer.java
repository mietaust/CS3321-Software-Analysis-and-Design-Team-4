package Backend;

import lombok.Getter;
import lombok.Setter;

public class NewPlayer {
    @Getter@Setter private String pname;

    public NewPlayer(String pname) {
        this.pname = pname;
    }
}
