package com.example.samuel.jupitertrail;

import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.example.samuel.jupitertrail.Enum.ResourceEnum;

import java.util.*;

/**
 * Created by Samuel on 27/04/2016.
 */
public class Ship {

    public HashMap<ResourceEnum, Resource> ResourceList = new HashMap();

    public int fuelPerEvent = 2;
    public int eventsBetweenCheckpoints = 5;
    public boolean Farm = false;
    public int TurnsTillLoss = 100;

    public Ship()
    {
        ResourceList.put(ResourceEnum.Fuel, new Resource());
        ResourceList.put(ResourceEnum.Thruster, new Resource());
        ResourceList.put(ResourceEnum.Rations, new Resource());

        AddResource(ResourceEnum.Fuel, 30, true);
        AddResource(ResourceEnum.Rations, 50, true);
        AddResource(ResourceEnum.Thruster, 20, true);
    }

    public void Reset()
    {
        fuelPerEvent = 2;
        TurnsTillLoss = 100;
        boolean Farm = false;
        eventsBetweenCheckpoints = 5;

    }

    public void AddResource(ResourceEnum resource, int x, boolean free)
    {
            ResourceList.get(resource).Amount += x;
    }

    public int AddResource(ResourceEnum resource, int credits)
    {
        if (credits > 0)
        {
            ResourceList.get(resource).Amount += 1;
            credits-=1;
            return credits;
        }
        return credits;
    }

    public int AddResource(ResourceEnum resource, int credits, int x)
    {
        if (credits > x)
        {
            ResourceList.get(resource).Amount += x;
            credits-=x;
            return credits;
        }
        return credits;
    }

    public boolean Eat(int x)
    {
        if (ResourceList.get(ResourceEnum.Rations).Amount > x)
        {
            ResourceList.get(ResourceEnum.Rations).Amount -= x;
            return true;
        }
        else
        {
            return false;
        }
    }

    public void MoveShip()
    {
        ResourceList.get(ResourceEnum.Fuel).Amount-=fuelPerEvent;
        TurnsTillLoss -= 1;

    }



}
