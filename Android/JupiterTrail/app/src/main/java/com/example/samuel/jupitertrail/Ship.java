package com.example.samuel.jupitertrail;

import android.content.res.Resources;
import android.support.annotation.NonNull;

import com.example.samuel.jupitertrail.Enum.ResourceEnum;

import java.util.*;

/**
 * Created by Samuel on 27/04/2016.
 */
public class Ship {
    public int MaxStorage = 100;

    public HashMap<ResourceEnum, Resource> ResourceList = new HashMap();

    public int fuelPerEvent = 2;
    public int eventsBetweenCheckpoints = 5;
    public boolean Farm = false;
    public int TurnsTillLoss = 100;

    public int StorageUsed = 0;

    public Ship()
    {
        ResourceList.put(ResourceEnum.Fuel, new Resource());
        ResourceList.put(ResourceEnum.Thruster, new Resource());
        ResourceList.put(ResourceEnum.Rations, new Resource());

        AddResource(ResourceEnum.Fuel, 30);
        AddResource(ResourceEnum.Rations, 50);
        AddResource(ResourceEnum.Thruster, 20);
    }

    public void AddResource(ResourceEnum resource)
    {
        ResourceList.get(resource).Amount+=1;
        StorageUsed +=1;
    }

    public void AddResource(ResourceEnum resource, int x)
    {
        ResourceList.get(resource).Amount+=x;
        StorageUsed +=x;
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
        StorageUsed -=fuelPerEvent;

    }



}
