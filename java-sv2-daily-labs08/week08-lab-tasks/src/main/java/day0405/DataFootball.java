package day0405;

public class DataFootball {

    private String team;
    private int F;
    private int A;

    public String getTeam() {
        return team;
    }

    public int getF() {
        return F;
    }

    public int getA() {
        return A;
    }

    public DataFootball(String team, int f, int a) {
        this.team = team;
        F = f;
        A = a;
    }

    public int getDiff() {
        return Math.abs(F - A);
    }
}
