package com.example.imagetest;

import javafx.scene.image.Image;

public interface Iterator {
   boolean hasNext();
   boolean hasPreview();
   Image next();
   Image preview();

}
