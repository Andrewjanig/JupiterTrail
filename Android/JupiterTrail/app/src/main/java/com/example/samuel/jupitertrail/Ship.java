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

    public void Reset()
    {
        fuelPerEvent = 2;
        TurnsTillLoss = 100;
        boolean Farm = false;
        eventsBetweenCheckpoints = 5;

    }

    public void Refill()
    {
        do
        {
            AddResource(ResourceEnum.Fuel);
        } while (ResourceList.get(ResourceEnum.Fuel).Amount<30 && StorageUsed<MaxStorage);
        do
        {
            AddResource(ResourceEnum.Rations);
        } while (ResourceList.get(ResourceEnum.Rations).Amount<30 && StorageUsed<MaxStorage);
    }

    public void AddResource(ResourceEnum resource)
    {
        if (StorageUsed<MaxStorage)
        {
            ResourceList.get(resource).Amount += 1;
            StorageUsed += 1;
        }
        else
        {
            Toast toast = Toast.makeText(Game.context, "Storage Full! (Easier this way)", Toast.LENGTH_SHORT);
            toast.show();
        }
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
