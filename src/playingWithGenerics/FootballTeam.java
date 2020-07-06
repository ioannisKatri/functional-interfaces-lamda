package playingWithGenerics;

import java.util.List;

public class FootballTeam extends Team {
    FootballTeam(List<Player> different) {
        super(different);
    }

    public FootballTeam() {
    }
}
