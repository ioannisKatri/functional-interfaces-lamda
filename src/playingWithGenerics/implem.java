package playingWithGenerics;

public class implem {
    public static void main(String[] args) {
        FootballTeam footOne = new FootballTeam();
        FootballTeam footTwo = new FootballTeam();
        BasketballTeam basketballTeam = new BasketballTeam();

        League<FootballTeam> football = new League<>();
        football.getTeams().add(footOne);
//        football.getTeams().add(basketballTeam); Wont compile error
    }
}
