package com.example.imagetest;

import javafx.scene.image.Image;

import java.nio.file.Paths;

public class ConcreteAggregate implements Aggregate{
    private String filetopic;
    private int start = 1;
    private int end = 4;
    @Override
    public Iterator getIterator() {
        return new ImageIterator();
    }
    public ConcreteAggregate(String filetopic)
    {
        this.filetopic = filetopic;
    }
    public class ImageIterator implements Iterator{
        private int current = 0;
        private String getImage(int i){
            return Paths.get( filetopic
                    + i +".jpg").toUri().toString();
        }
        @Override
        public boolean hasNext() {
            return !new Image(getImage(current + 1)).isError();
        }
        @Override
        public boolean hasPreview() {
            return !new Image(getImage(current - 1)).isError();
        }
        @Override
        public Image next() {
            if (hasNext()){
                return new Image(getImage(++current));
            }
            current = start;
            return new Image(getImage(start));
        }
        @Override
        public Image preview()  {
            if (hasPreview()){
                return new Image(getImage(--current));
            }
            current = end;
            return new Image(getImage(end));
        }
    }
}
