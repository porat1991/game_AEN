package my_game;

import base.Game;
import org.apache.poi.ss.formula.functions.T;
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

    public void moveAllTargets() {
        for (Target target : this.targets) {
            target.move(0, 5);
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
}
