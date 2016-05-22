package com.example.samuel.jupitertrail;

import com.example.samuel.jupitertrail.Enum.ResourceEnum;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ShipTest {
    @Test
    public void addResource_Working() throws Exception {
        Ship testShip = new Ship();

        testShip.AddResource(ResourceEnum.Fuel, 100);
        testShip.AddResource(ResourceEnum.Fuel, 100);

        assertEquals(testShip.StorageUsed, 300);
        assertEquals(testShip.ResourceList.get(ResourceEnum.Fuel).Amount, 230);
    }
}