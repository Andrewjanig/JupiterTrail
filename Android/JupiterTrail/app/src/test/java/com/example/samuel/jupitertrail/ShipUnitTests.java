package com.example.samuel.jupitertrail;

import com.example.samuel.jupitertrail.Enum.ResourceEnum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by JDogg on 31/05/2016.
 */
public class ShipUnitTests {
    @Test

    public void ship_eat_pass () throws Exception {
        Ship testShip = new Ship();

        // Rations are set to 50 to start, after eating 30, there should be 20 rations left
        testShip.Eat(30);

        assertEquals(testShip.ResourceList.get(ResourceEnum.Rations).Amount, 20);


    }
@Test
    public void ship_eat_fail () throws Exception {
        Ship testShip = new Ship();

        // Rations are set to 50 to start, after eating 30, there should be 20 rations left, not 30 so test will fail
        testShip.Eat(30);

        assertEquals(testShip.ResourceList.get(ResourceEnum.Rations).Amount, 30);


    }
}
