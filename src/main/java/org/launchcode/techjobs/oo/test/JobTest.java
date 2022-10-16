package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    //test to see if id is uniquely set between 2 objects
    public void testSettingJobId() {
        Job object1 = new Job();
        Job object2 = new Job();
        assertNotEquals(object1.getId(), object2.getId(),.001);
    }

    @Test
    public void testJobConstructorSetsAllFields() {

        Job jobListing = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        //check to see if the fields of our job object have been correctly set to their class types
        //then check to see that the value of the field matches the value sent in as the parameter

        assertTrue(jobListing.getName() instanceof String);
        assertEquals(jobListing.getName(), "Product tester");

        assertTrue(jobListing.getEmployer() instanceof Employer);
        assertEquals(jobListing.getEmployer().getValue(), "ACME");

        assertTrue(jobListing.getLocation() instanceof Location);
        assertEquals(jobListing.getLocation().getValue(), "Desert");

        assertTrue(jobListing.getPositionType() instanceof PositionType);
        assertEquals(jobListing.getPositionType().getValue(), "Quality control");

        assertTrue(jobListing.getCoreCompetency() instanceof CoreCompetency);
        assertEquals(jobListing.getCoreCompetency().getValue(), "Persistence");

    }

    @Test
    public void testJobsForEquality() {
        Job jobListing1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job jobListing2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    assertFalse(jobListing1.equals(jobListing2));
    }

    @Test
    //test new line formatting
    public void testToStringStartsAndEndsWithNewLine() {
        Job jobListing = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String testString = jobListing.toString();
        assertEquals(testString.charAt(0), '\n');
        assertEquals(testString.charAt(0), testString.charAt(testString.length()-1));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job jobListing = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String testString = jobListing.toString();
        assertEquals(testString,"\nID: 1\nName: Product tester\nEmployer: ACME\nLocation: Desert\nPosition Type: Quality control\nCore Competency: Persistence\n");
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job jobListing = new Job("", new Employer(), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String testString = jobListing.toString();
        assertEquals(testString,"\nID: 1\nName: Data not available\nEmployer: Data not available\nLocation: Desert\nPosition Type: Quality control\nCore Competency: Persistence\n");
    }

    @Test
    public void testOopsAllEmpty() {
        Job jobListing = new Job("", new Employer(), new Location(), new PositionType(), new CoreCompetency());
        String testString = jobListing.toString();
        assertEquals(testString,"\nOOPS! This job does not seem to exist.\n");
    }

}
