package com.example.samuel.jupitertrail;

import android.content.res.Resources;
import android.support.annotation.NonNull;

import com.example.samuel.jupitertrail.Enum.ResourceEnum;

import java.util.*;

/**
 * Created by Samuel on 27/04/2016.
 */
public class Ship {
    public int MaxStorage = 1000;

    public HashMap<ResourceEnum, Resource> ResourceList = new HashMap();





    public int StorageUsed = 0;

    public Ship()
    {
        ResourceList.put(ResourceEnum.Fuel, new Resource());
        ResourceList.put(ResourceEnum.Oxygen, new Resource());
        ResourceList.put(ResourceEnum.Rockets, new Resource());
    }

    public void AddResource(ResourceEnum resource)
    {
        ResourceList.get(resource).Amount+=1;
        StorageUsed +=1;
    }



}
