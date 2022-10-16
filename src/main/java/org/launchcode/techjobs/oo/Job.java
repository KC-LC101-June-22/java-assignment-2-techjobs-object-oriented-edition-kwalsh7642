package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    //constructors
    public Job() {
        id = nextId;
        nextId++;
    }

    public Job(String aName, Employer aEmployer, Location aLocation, PositionType aPostionType, CoreCompetency aCoreCompetency) {
        this();
        this.name = aName;
        this.employer = aEmployer;
        this.location = aLocation;
        this.positionType = aPostionType;
        this.coreCompetency = aCoreCompetency;
    }

    //custom methods

    @Override
    public boolean equals(Object o) { //Consider two Job objects "equal" when their id fields match.
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return getId() == job.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {

        String convertedString = "\n";

        String[] fields = {name, employer.getValue(), location.getValue(), positionType.getValue(), coreCompetency.getValue()};
        int nullCount = 0;
        for(int i = 0; i < fields.length; i++) {
            if(fields[i] == null || fields[i] == "") {
                nullCount++;
                fields[i] = "Data not available";
            }
        }

        if(nullCount == fields.length) {
            return "\nOOPS! This job does not seem to exist.\n";
        }

        convertedString += "ID: " + id +
                "\nName: " + fields[0] +
                "\nEmployer: " + fields[1] +
                "\nLocation: " + fields[2] +
                "\nPosition Type: " + fields[3] +
                "\nCore Competency: " + fields[4];

        convertedString += "\n";

        return convertedString;
    }


    //getters & setters:


    public int getId() {
        return id;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }
}
