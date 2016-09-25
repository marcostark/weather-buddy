package com.example.sarai.wheaterhelp;

import java.util.Random;

/**
 * Created by sarai on 01/09/16.
 */
public class Tips {
    String [] tips = {
            "IT DOESN'T MATTER HOW SLOWLY YOU GO",
            "YOU ONLY FAIL WHEN YOU STOP TRYING",
            "Don't count the days make the days count",
            "Look in the mirror that's your competition",
            "If no one thinks you can then you have to",
            "Spending today complaining about yesterday won't make tomorrow any better",
            "Take the risk or loose the chance",
            "Don't be afraid to fail, be afraid of not to try",
            "Decide that you want it more than you are afraid of it",
            "This skin & bones is a rental",
            "Don't let your happiness depend on something you may lose",
            "My weaknesses are where the light shine through",
            "E se tiver com medo vá com medo mesmo",
            "Se o treino é forte, você não será diferente",
            "Só é lutador quem sabe lutar consigo mesmo",
            "Never hope for it more than you work for it",
            "BEAT THE SUN",
            "To give anything less than your best is to sacrifice the gift",
            "WINNING IS A HABIT",
            "TALENT ISN'T ENOUGH",
            "This is your life do what you love & do it often",
            "Walk by faith not by sight",
            "GO BACK TO BED THE WORLD STILL SUCKS"
    };

    public String getTip(){
        Random random = new Random();
        int randomNumber = random.nextInt(tips.length);

        return tips[randomNumber].toUpperCase();
    }
}
