package espoch.edu.ec.yasuni.objects;

public abstract class Tour {
    protected String code;
    protected String name;
    protected Trail[] trails;
    protected int trailCount;
    protected double difficultyFactor;
    protected CommunicationDevice device;
    protected Guide guide;

    public Tour(String code, String name) {
        this.code = code;
        this.name = name;
        this.trails = new Trail[10];
        this.trailCount = 0;
        this.difficultyFactor = 1.0;
        this.device = null;
        this.guide = null;
    }

    public void addTrail(Trail trail) {
        if (trailCount < trails.length) {
            trails[trailCount++] = trail;
        }
    }

    public Trail findTrail(String trailName) {
        for (int i = 0; i < trailCount; i++) {
            if (trails[i].getName().equalsIgnoreCase(trailName)) {
                return trails[i];
            }
        }
        return null;
    }

    public double getTotalDistance() {
        double total = 0;
        for (int i = 0; i < trailCount; i++) {
            if (trails[i].isEnabled()) {
                total += trails[i].getLength();
            }
        }
        return total;
    }

    public double getBaseWalkingTime() {
        double total = 0;
        for (int i = 0; i < trailCount; i++) {
            if (trails[i].isEnabled()) {
                total += trails[i].getEstimatedMinutes();
            }
        }
        return total;
    }

    public double getWalkingTime() {
        return getBaseWalkingTime() * difficultyFactor;
    }

    public boolean isAssigned() {
        return device != null && guide != null;
    }

    public void print() {
        System.out.println("Tour [" + code + "] " + name + " - Type: " + getType() + " - Distance: " + getTotalDistance() + " km - Duration: " + getTotalDuration() + " min");
    }

    public abstract double getTotalDuration();
    public abstract String getType();

    public String getCode() { return code; }
    public String getName() { return name; }
    public Trail[] getTrails() { return trails; }
    public double getDifficultyFactor() { return difficultyFactor; }
    public CommunicationDevice getDevice() { return device; }
    public Guide getGuide() { return guide; }

    public void setCode(String code) { this.code = code; }
    public void setName(String name) { this.name = name; }
    public void setTrails(Trail[] trails) { this.trails = trails; }
    public void setDifficultyFactor(double difficultyFactor) { this.difficultyFactor = difficultyFactor; }
    public void setDevice(CommunicationDevice device) { this.device = device; }
    public void setGuide(Guide guide) { this.guide = guide; }
}
