package espoch.edu.ec.yasuni.objects;

public class Trail {
    private String name;
    private double length;
    private int estimatedMinutes;
    private boolean enabled;

    public Trail(String name, double length, int estimatedMinutes) {
        this.name = name;
        this.length = length;
        this.estimatedMinutes = estimatedMinutes;
        this.enabled = true;
    }

    public void print() {
        System.out.println("Trail: " + name + ", Length: " + length + " km, Minutes: " + estimatedMinutes + ", Enabled: " + enabled);
    }

    public String getName() { return name; }
    public double getLength() { return length; }
    public int getEstimatedMinutes() { return estimatedMinutes; }
    public boolean isEnabled() { return enabled; }

    public void setName(String name) { this.name = name; }
    public void setLength(double length) { this.length = length; }
    public void setEstimatedMinutes(int estimatedMinutes) { this.estimatedMinutes = estimatedMinutes; }
    public void setEnabled(boolean enabled) { this.enabled = enabled; }
}

