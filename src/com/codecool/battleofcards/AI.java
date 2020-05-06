package com.codecool.battleofcards;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class AI extends Player{

    public AI(String name) {
        super(name);
    }

    public String chooseRandomAttribute(){
        List<String> attributeNames = new ArrayList<>();

        Map<String, Float> attributesMap = topcard.getCardStats();
        for(String key : attributesMap.keySet()){
            attributeNames.add(key);
        }

        Random random = new Random();
        int randomIndex = random.nextInt(attributeNames.size());

        return attributeNames.get(randomIndex);
    }

    public String chooseBiggestAttribute(){
        Map<String, Float> attributesMap = topcard.getCardStats();
        String biggestAttribute = "";

        float biggestAttributeValue = 0;
        for(String key : attributesMap.keySet()){
            if (attributesMap.get(key) > biggestAttributeValue){
                biggestAttributeValue = attributesMap.get(key);
            }
        }
        for(String key : attributesMap.keySet()){
            if (attributesMap.get(key) == biggestAttributeValue){
                biggestAttribute = key;
            }
        }
        return biggestAttribute;
    }
}
