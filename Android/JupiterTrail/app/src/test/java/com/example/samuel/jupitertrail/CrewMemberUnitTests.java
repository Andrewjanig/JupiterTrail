package com.example.samuel.jupitertrail;

import android.content.Context;

import com.example.samuel.jupitertrail.Enum.ProfessionEnum;
import com.example.samuel.jupitertrail.GameScreens.CheckpointScreen;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class CrewMemberUnitTests {
    @Test
    public void crew_resets () throws Exception {
        CrewMember testCrewman = new CrewMember();

        testCrewman.Profession = ProfessionEnum.Doctor;
        testCrewman.RationConsumption = 5;
        testCrewman.TempImmune = true;
        testCrewman.PermImmune = true;
        testCrewman.Alive = false;

        testCrewman.Reset();

        assertEquals(testCrewman.Profession, ProfessionEnum.Doctor);
        assertEquals(testCrewman.RationConsumption, 2);
        assertEquals(testCrewman.TempImmune, false);
        assertEquals(testCrewman.PermImmune, true);
        assertEquals(testCrewman.Alive, false);
    }
    @Test
    public void crew_status_deceased() throws Exception{
        CrewMember testCrewman = new CrewMember();

        testCrewman.Alive = false;
        String expected = "Deceased";

        assertEquals(testCrewman.Status(), expected);


    }
    @Test
    public void crew_status_healthy() throws Exception{
        CrewMember testCrewman = new CrewMember();

        testCrewman.Alive = true;
        String expected = "Healthy";

        assertEquals(testCrewman.Status(), expected);


    }
    @Test
    public void crew_status_ill() throws Exception{
        CrewMember testCrewman = new CrewMember();

        testCrewman.Alive = true;
        testCrewman.KyraxianPetris = true;
        String expected = "Ill";

        assertEquals(testCrewman.Status(), expected);

    }
}