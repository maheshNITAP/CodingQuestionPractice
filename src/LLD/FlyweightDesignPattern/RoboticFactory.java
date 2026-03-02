package LLD.FlyweightDesignPattern;

import java.util.HashMap;
import java.util.Map;

public class RoboticFactory {
    private static Map<String,IRobot> roboticObjCache= new HashMap<>();

    public static IRobot createRobot(String robotType){
        if(roboticObjCache.containsKey(robotType))
            return roboticObjCache.get(robotType);
        else{
            if(robotType.equalsIgnoreCase("HUMANOID")){
                Sprites humanoidSprite = new Sprites();
                IRobot humanoidRobot = new HumanoidRobot(robotType, humanoidSprite);
                roboticObjCache.put(robotType, humanoidRobot);
                return humanoidRobot;
            }else if(robotType.equalsIgnoreCase("ROBOTIC_DOG")){
                Sprites roboticDogSprite = new Sprites();
                IRobot roboticDogObj = new RoboticDog(robotType, roboticDogSprite);
                roboticObjCache.put(robotType, roboticDogObj);
                return roboticDogObj;
            }
        }
        return null;
    }
}
