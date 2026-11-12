package espoch.edu.ec.yasuni.objects;

public class InterpretiveTour extends Tour {
    private int educationalMinutes;

    public InterpretiveTour(String code, String name, int educationalMinutes) {
        super(code, name);
        this.educationalMinutes = educationalMinutes;
    }

    @Override
    public double getTotalDuration() {
        return getWalkingTime() + educationalMinutes;
    }

    @Override
    public String getType() {
        return "Interpretive";
    }

    public int getEducationalMinutes() { return educationalMinutes; }
    public void setEducationalMinutes(int educationalMinutes) { this.educationalMinutes = educationalMinutes; }
}
