package com.example.samuel.jupitertrail;

import com.example.samuel.jupitertrail.Enum.ProfessionEnum;

/**
 * Created by Samuel on 27/04/2016.
 */
public class Player {
    public ProfessionEnum Profession;
    public boolean Ill = false;
    public int TimeToDie = 0;

    public void AssignProfession(ProfessionEnum profession)
    {
        Profession = profession;
    }

    public boolean CheckAlive()
    {
        if (Ill == true)
        {
            TimeToDie--;

            if (TimeToDie == 0)
            {
                Die();
                return false;
            }
        }
        return true;
    }

    private void Die()
    {

    }
}
