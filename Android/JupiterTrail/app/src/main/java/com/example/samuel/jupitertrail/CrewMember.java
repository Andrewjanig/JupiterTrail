package com.example.samuel.jupitertrail;

import com.example.samuel.jupitertrail.Enum.ProfessionEnum;

/**
 * Created by Samuel on 27/04/2016.
 */
public class CrewMember {
    public ProfessionEnum Profession;
    public boolean Phalanxus = false;
    public boolean Mitogamoria = false;
    public boolean KyraxianPetris = false;
    public int RationConsumption = 2;
    public int TimeToDie = 0;
    public int KyraxianPetrisTimer = 0;
    public boolean TempImmune = false;
    public boolean PermImmune = false;
    public boolean Alive = true;

    public CrewMember()
    {

    }

    public void Immunise(boolean perm)
    {
        CureIllness();

        if (perm)
            PermImmune = true;
        else
            TempImmune = true;
    }

    public String Status()
    {
        if (!Alive)
            return "Deceased";
        else if (!IsIll())
        {
            if (TempImmune || PermImmune)
                return "Immune";
            else
                return "Healthy";
        }
        else
            return "Ill";
    }

    public void AssignProfession(ProfessionEnum profession)
    {
        Profession = profession;
    }

    public int FoodRequirement()
    {
        if (Game.PlayerShip.Farm)
            return RationConsumption/2;
        else
            return RationConsumption;
    }

    public boolean CheckAlive()
    {

        if (!Alive)
        {
            return false;
        }
        else {
            if (Mitogamoria)
            {
                TimeToDie--;

                if (TimeToDie == 0) {
                    Die();
                    return false;
                }
            }
            if (KyraxianPetris)
            {
                KyraxianPetrisTimer -=1;
                if (KyraxianPetrisTimer == 0) {
                    Die();
                    for (CrewMember c : Game.Crew)
                    {
                        if (c.Alive)
                        {
                            c.Alive = false;
                            break;
                        }
                    }
                    return false;
                }
            }

        }
        return true;
    }

    public boolean IsIll()
    {
        if (Phalanxus)
            return true;
        else if (Mitogamoria)
            return true;
        else if (KyraxianPetris)
            return true;
        else
            return false;

    }

    public void CureIllness()
    {
        if (Phalanxus)
            Phalanxus = false;
        else if (Mitogamoria)
            Mitogamoria = false;
    }

    private void Die()
    {
        Alive = false;
    }
}
