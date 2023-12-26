package com.example.imagetest;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.io.File;

public class SliderController {
    public ImageView button;
    @FXML
    private ImageView imageView;
    private boolean isPause = false;
    Timeline timer = new Timeline();
    ConcreteAggregate pic = new ConcreteAggregate("src/main/resources/");
    Iterator iterator = pic.getIterator();

    @FXML
    public void onPlayPause() {
        isPause = !isPause;
        if (isPause){
            int delay = 2;
            timer = new Timeline();
            timer.setCycleCount(Timeline.INDEFINITE);
            timer.getKeyFrames().add(new KeyFrame(Duration.seconds(delay), new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    imageView.setImage(iterator.next());
                }
            }));
            timer.play();
            button.setImage(new Image(new File("src/main/resources/icons/pause.png").toURI().toString()));
        }
        else {
            button.setImage(new Image(new File("src/main/resources/icons/play.png").toURI().toString()));
            timer.stop();
            timer.getKeyFrames().clear();
        }

    }
    @FXML
    public void onLastClick(){
        imageView.setImage(iterator.preview());

    }
    @FXML
    public void onNextClick(){
        imageView.setImage(iterator.next());

    }
}