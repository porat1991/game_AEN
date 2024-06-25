package my_game;

import base.Game;
import ui_elements.ScreenPoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TargetsManager {
    List<Target> targets;
    List<String> targetImagePaths = Arrays.asList("enemyspaceship1", "enemyspaceship2");

    int currentId = 0;


    public TargetsManager() {
        this.targets = new ArrayList<>();
    }

    public List<Target> getTargets() {
        return targets;
    }

    public void setTargets(List<Target> targets) {
        this.targets = targets;
    }

    public void moveAllTargets(int level) {
        int stepSize = getStepSize(level);
        for (Target target : this.targets) {
            target.move(0, stepSize);
        }
    }

    public void addTarget() {
        Random r = new Random();
        String randomImagePath = "resources/" + targetImagePaths.get(r.nextInt(targetImagePaths.size())) + ".jpg";
        double width = Game.UI().frame().getSize().getWidth();
        int low = 0;
        int high = (int)width;
        int randomX = r.nextInt(high-low) + low;
        Target target = new Target(randomImagePath, String.valueOf(currentId), new ScreenPoint(randomX, -100));
        currentId++;
        target.addToCanvas();
        targets.add(target);
    }

    public int getStepSize(int level) {
        return switch (level) {
            case 1 -> 5;
            case 2 -> 10;
            case 3 -> 15;
            default -> 5;
        };
    }

    public void removeAllTargets() {
        int size = targets.size();
        List<Target> targetsCopy = new ArrayList<>(this.targets);
        for(int i = 0; i < size; i++) {
            removeTarget(targetsCopy.get(i));
        }

    }

    public void removeTarget(Target target) {
        System.out.println(target.getImageID() + " deleted");
        Game.UI().canvas().getShape(target.getImageID());
        target.removeFromCanvas(target.getImageID());
        targets.remove(target);
    }
}
