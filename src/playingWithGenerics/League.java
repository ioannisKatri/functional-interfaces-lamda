package playingWithGenerics;

import java.util.ArrayList;
import java.util.List;

public class League<T extends Team> {
    private final List<T> teams = new ArrayList<>();

    public League() {
    }

    public List<T> getTeams() {
        return teams;
    }
}
