package com.example.samuel.jupitertrail.Events;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.samuel.jupitertrail.CrewMember;
import com.example.samuel.jupitertrail.Enum.DifficultyEnum;
import com.example.samuel.jupitertrail.Enum.ResourceEnum;
import com.example.samuel.jupitertrail.EventInstance;
import com.example.samuel.jupitertrail.Game;
import com.example.samuel.jupitertrail.GameScreens.JourneyScreen;

import java.util.Random;

/**
 * Created by Samuel on 14/05/2016.
 */
public class Positive extends EventInstance {

    public Positive(DifficultyEnum diff, Context G, JourneyScreen journey)
    {
        this.journey = journey;
        Random rand = new Random();
        int num = rand.nextInt((9 - 1) + 1) + 1;

        switch(num)
        {
            case 1:
                RemainsOfADeadStar(diff, G);
                break;
            case 2:
                DeadSpacecraftSalvage(diff, G);
                break;
            case 3:
                RichMineralDeposit(diff, G);
                break;
            case 4:
                ForceOfWill(diff, G);
                break;
            case 5:
                Vaccine(diff, G);
                break;
            case 6:
                FlightOfThePhoenix(diff, G);
                break;
            case 7:
                HybridInjectionSystem(diff, G);
                break;
            case 8:
                InfernalPreignitionChamber(diff, G);
                break;
            case 9:
                HydraulicFarmOperational(diff, G);
                break;
            default:
                break;
        }

    }

    private void RemainsOfADeadStar(DifficultyEnum diff, Context G)
    {

        final Game Game = (Game)G;
        Options = new Option[1];
        Options[0] = new Option();
        final Button Button1 = new Button(Game);

        Text = "You come across the remains of a dead star. It’s light faded long ago it’s legacy; to further your purpose. You harvest the vapor as fuel for your Ship";

        Button1.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        Button1.setText("Harvest vapor");
        Button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Game.PlayerShip.AddResource(ResourceEnum.Fuel, 10);
                Toast toast = Toast.makeText(Game, "Received 10 Fuel Cells", Toast.LENGTH_SHORT);
                toast.show();
                Button1.setOnClickListener(null);
                journey.Update();
            }
        });

        Options[0].button = Button1;
    }

    private void DeadSpacecraftSalvage(DifficultyEnum diff, Context G)
    {
        final Game Game = (Game)G;
        Options = new Option[2];

        Text = "“A forgotten vessel. The markings of space pirates adorn the hull, the spoils were taken long ago but some functional parts and preserved foods remain, perhaps they will serve you better";

        //Do Event
        Game.PlayerShip.AddResource(ResourceEnum.Rations, 10);

        Options[0] = new Option();
        Options[1] = new Option();
        final Button Button1 = new Button(Game);
        final Button Button2 = new Button(Game);

        Button1.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        Button1.setText("Take a thruster");
        Button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Game.PlayerShip.AddResource(ResourceEnum.Thruster, 1);
                Toast toast = Toast.makeText(Game, "Took a thruster", Toast.LENGTH_SHORT);
                toast.show();
                Button1.setOnClickListener(null);
                Button2.setOnClickListener(null);
                journey.Update();
            }
        });

        Button2.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        Button2.setText("Take a fuel cell");
        Button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Game.PlayerShip.AddResource(ResourceEnum.Fuel, 1);
                Toast toast = Toast.makeText(Game, "Took a fuel cell", Toast.LENGTH_SHORT);
                toast.show();
                Button1.setOnClickListener(null);
                Button2.setOnClickListener(null);
                journey.Update();
            }
        });


        Options[0].button = Button1;
        Options[1].button = Button2;

    }

    private void RichMineralDeposit(DifficultyEnum diff, Context G)
    {
        final Game Game = (Game)G;
        Options = new Option[1];
        Options[0] = new Option();
        final Button Button1 = new Button(Game);

        Text = "You spy a Saronite deposit on the back of a wandering asteroid, you harvest it and store it in your spacecraft. This will fetch a worthy price at any store";

        Button1.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        Button1.setText("Harvest Saronite");
        Button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Game.Credits += 100;
                Toast toast = Toast.makeText(Game, "Received 100 Credits", Toast.LENGTH_SHORT);
                toast.show();
                Button1.setOnClickListener(null);
                journey.Update();
            }
        });

        Options[0].button = Button1;
    }

    private void ForceOfWill(DifficultyEnum diff, Context G)
    {
        final Game Game = (Game)G;

        Options = new Option[1];

        Options[0] = new Option();


        final Button Button1;
        final Button Button2;
        final Button Button3;
        final Button Button4;

        Text = "Man’s instinct to survive, emboldened by love, is the most powerful driving force in the universe. refuses to die!";

        int z = 0;

        //Do Event
        if (Game.Crew[0].Alive == true && Game.Crew[0].IsIll())
        {
            Button1 = new Button(Game);
            Button1.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            Button1.setText("First crew member is cured of all illness.");
            Button1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Game.Crew[0].CureIllness();
                    Toast toast = Toast.makeText(Game, "Crew member cured.", Toast.LENGTH_SHORT);
                    toast.show();
                    Button1.setOnClickListener(null);
                    journey.Update();
                }
            });
            Options[z].button = Button1;
            z++;
        }
        else if (Game.Crew[1].Alive == true && Game.Crew[0].IsIll())
        {
            Button2 = new Button(Game);
            Button2.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            Button2.setText("Second crew member is cured of all illness.");
            Button2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Game.Crew[1].CureIllness();
                    Toast toast = Toast.makeText(Game, "Crew member cured.", Toast.LENGTH_SHORT);
                    toast.show();
                    Button2.setOnClickListener(null);
                    journey.Update();
                }
            });
            Options[z].button = Button2;
            z++;
        }
        else if (Game.Crew[2].Alive == true && Game.Crew[0].IsIll())
        {
            Button3 = new Button(Game);
            Button3.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            Button3.setText("Third crew member is cured of all illness.");
            Button3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Game.Crew[2].CureIllness();
                    Toast toast = Toast.makeText(Game, "Crew member cured.", Toast.LENGTH_SHORT);
                    toast.show();
                    Button3.setOnClickListener(null);
                    journey.Update();
                }
            });
            Options[z].button = Button3;
            z++;
        }
        else if (Game.Crew[3].Alive == true && Game.Crew[0].IsIll())
        {
            Button4 = new Button(Game);
            Button4.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            Button4.setText("Fourth crew member is cured of all illness.");
            Button4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Game.Crew[3].CureIllness();
                    Toast toast = Toast.makeText(Game, "Crew member cured.", Toast.LENGTH_SHORT);
                    toast.show();
                    Button4.setOnClickListener(null);
                    journey.Update();
                }
            });
            Options[z].button = Button4;
            z++;
        }
        else
        {
            Options = null;
        }

    }

    private void Vaccine(DifficultyEnum diff, Context G)
    {
        final Game Game = (Game)G;
        int crewAlive = 0;
        for (CrewMember c : Game.Crew)
        {
            if (c.Alive && !c.TempImmune && !c.PermImmune)
                crewAlive++;
        }

        Options = new Option[crewAlive];

        int i = 0;
        for (Option o : Options)
        {
            Options[i] = new Option();
            i++;
        }
        Button Button1;
        Button Button2;
        Button Button3;
        Button Button4;

        final boolean activated;
        Text = "Vaccines are one of the great triumphs of modern medicine. - Ezekial Emanuel";

        //Do Event
        int z = 0;
        if (Game.Crew[0].TempImmune == false && Game.Crew[0].TempImmune == false)
        {
            Button1 = new Button(Game);
            Button1.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            Button1.setText("Immunise the first crew member.");
            Button1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                        Game.Crew[0].Immunise(false);
                        Toast toast = Toast.makeText(Game, "Crew member immunised.", Toast.LENGTH_SHORT);
                        toast.show();
                    journey.Update();

                }
            });

            Options[z].button = Button1;
            z++;
        }
       if (Game.Crew[1].TempImmune == false && Game.Crew[1].TempImmune == false)
        {
            Button2 = new Button(Game);
            Button2.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            Button2.setText("Immunise the second crew member.");
            Button2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Game.Crew[1].Immunise(false);
                    Toast toast = Toast.makeText(Game, "Crew member immunised.", Toast.LENGTH_SHORT);
                    toast.show();
                    journey.Update();
                }
            });

            Options[z].button = Button2;
            z++;
        }
        if (Game.Crew[2].TempImmune == false && Game.Crew[2].TempImmune == false)
        {
            Button3 = new Button(Game);
            Button3.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            Button3.setText("Immunise the third crew member.");
            Button3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Game.Crew[2].Immunise(false);
                    Toast toast = Toast.makeText(Game, "Crew member immunised.", Toast.LENGTH_SHORT);
                    toast.show();
                    journey.Update();
                }
            });
            Options[z].button = Button3;
            z++;
        }
       if (Game.Crew[3].TempImmune == false && Game.Crew[3].TempImmune == false)
        {
            Button4 = new Button(Game);
            Button4.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            Button4.setText("Immunise the fourth crew member.");
            Button4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Game.Crew[3].Immunise(false);
                    Toast toast = Toast.makeText(Game, "Crew member immunised.", Toast.LENGTH_SHORT);
                    toast.show();
                    journey.Update();
                }
            });
            Options[z].button = Button4;
            z++;
        }

    }

    private void FlightOfThePhoenix(DifficultyEnum diff, Context G)
    {
        final Game Game = (Game)G;
        Options = new Option[1];
        Options[0] = new Option();

        final Button Button1 = new Button(Game);

        Text = "Fawkes is a Phoenix, Harry. Phoenixes burst into flame when it is time for them to die and are reborn from the ashes. - J.K Rowling, Harry Potter and the Chamber of Secrets";

        Button1.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        Button1.setText("Revive and vaccinate fallen crew member.");
        Button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (Game.Crew[0].Alive == false)
                {
                    Game.Crew[0].Alive = true;
                    Game.Crew[0].TempImmune = true;
                }
                else if (Game.Crew[1].Alive == false)
                {
                    Game.Crew[1].Alive = true;
                    Game.Crew[0].TempImmune = true;
                }
                else if (Game.Crew[2].Alive == false)
                {
                    Game.Crew[2].Alive = true;
                    Game.Crew[0].TempImmune = true;
                }
                else if (Game.Crew[3].Alive == false)
                {
                    Game.Crew[3].Alive = true;
                    Game.Crew[0].TempImmune = true;
                }

                Toast toast = Toast.makeText(Game, "Crew member revived.", Toast.LENGTH_SHORT);
                toast.show();
                Button1.setOnClickListener(null);
                journey.Update();
            }
        });

        Options[0].button = Button1;


    }

    private void HybridInjectionSystem(DifficultyEnum diff, Context G) //FIXME
    {
        final Game Game = (Game)G;
        Options = new Option[1];
        Options[0] = new Option();
        final Button Button1 = new Button(Game);

        Text = "Once before the world became a desolate wasteland, fuel was scarce and man waged war over crude oil. Perhaps this was the discovery that would have saved mankind.";

        Button1.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        Button1.setText("Improve fuel efficiency.");
        Button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (Game.PlayerShip.fuelPerEvent != 1)
                    Game.PlayerShip.fuelPerEvent = 1;
                else
                {
                    //
                }
                Toast toast = Toast.makeText(Game, "Fuel efficiency increased.", Toast.LENGTH_SHORT);
                toast.show();
                Button1.setOnClickListener(null);
                journey.Update();
            }
        });

        Options[0].button = Button1;

    }

    private void InfernalPreignitionChamber(DifficultyEnum diff, Context G)
    {
        final Game Game = (Game)G;
        Options = new Option[1];
        Options[0] = new Option();
        final Button Button1 = new Button(Game);

        Text = "Geordi, I have spent my whole life trying to figure out crazy ways of doing things. I’m telling ya, as one engineer to another - I can do this. - Scotty, Star Trek 1996";

        Button1.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        Button1.setText("Blazing Speed!");
        Button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Game.PlayerShip.eventsBetweenCheckpoints -= 2;
                if (Game.PlayerShip.eventsBetweenCheckpoints < 2)
                    Game.PlayerShip.eventsBetweenCheckpoints = 2;     //cannot be less than 2
                Toast toast = Toast.makeText(Game, "Two less stops between checkpoints.", Toast.LENGTH_SHORT);
                toast.show();
                Button1.setOnClickListener(null);
                journey.Update();
            }
        });

        Options[0].button = Button1;

    }

    private void HydraulicFarmOperational (DifficultyEnum diff, Context G)
    {
        final Game Game = (Game)G;
        Options = new Option[1];
        Options[0] = new Option();
        final Button Button1 = new Button(Game);

        Text = "The key to abundance is meeting limited circumstances with unlimited thoughts";

        //Do Event


        Button1.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        Button1.setText("Activate Hydraulic Farm.");
        Button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Game.PlayerShip.Farm = true;
                Toast toast = Toast.makeText(Game, "Ration consumption halved.", Toast.LENGTH_SHORT);
                toast.show();
                Button1.setOnClickListener(null);
                journey.Update();
            }
        });

        Options[0].button = Button1;
    }


}
