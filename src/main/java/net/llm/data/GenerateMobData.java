package net.llm.data;

import net.minecraft.util.math.random.Random;

public class GenerateMobData {

    String[] mobs = {"Ambulocetus",
            "Andrewsarchus",
            "Ancylotherium",
            "Basilosaurus",
            "Ceodont",
            "Chalicotherium",
            "Cynodictis",
            "Deinotherium",
            "Dinofelis",
            "Doedicurus",
            "Dorudon"};
    private int getRandomNumber() {
        return Random.createLocal().nextInt(10);
    }

    public String generateData(){
        return mobs[getRandomNumber()];
    }
}
