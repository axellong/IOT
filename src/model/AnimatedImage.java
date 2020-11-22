package model;

import javafx.scene.image.Image;
import org.hibernate.loader.custom.Return;

public class AnimatedImage {


    private Image frames[];
    private double duration;


    public Image getFrames(double time) {
        int index = (int) ((time % (frames.length * duration)) / duration);
        return frames[index];

    }

    public Image getFrame(int porcentaje) {
        return frames[porcentaje];
    }

    public void setFrames(Image[] frames) {
        this.frames = frames;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public String getNameFrames(double time) {
        int index = (int) ((time % (frames.length * duration)) / duration);
        String nombreString = frames[index].getUrl();
        return nombreString;


    }
}
