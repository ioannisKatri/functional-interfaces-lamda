package playingWithGenerics;

import java.util.List;

public class BasketballTeam extends Team {
    BasketballTeam(List<Player> different) {
        super(different);
    }

    public BasketballTeam() {
    }
}
