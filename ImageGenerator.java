package edu.bsu.cs222;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImageGenerator {

    public Group GetImageAsGroup(String buttonName) throws FileNotFoundException {

        InputStream fileLocationStream = new FileInputStream("src/main/Images/Rooms/Test" + buttonName + "Room.png");

        Image roomImage = new Image(fileLocationStream);

        ImageView viewableRoomImage = new ImageView();

        viewableRoomImage.setImage(roomImage);

        viewableRoomImage.setX(10);
        viewableRoomImage.setY(10);
        viewableRoomImage.setFitWidth(575);
        viewableRoomImage.setPreserveRatio(true);

        return new Group(viewableRoomImage);

    }

    public Group GetFurnitureImageAsGroup(String buttonName) throws FileNotFoundException {

        InputStream fileLocationStream = new FileInputStream("src/main/Images/Furniture/" + buttonName);

        Image roomImage = new Image(fileLocationStream);

        ImageView viewableRoomImage = new ImageView();

        viewableRoomImage.setImage(roomImage);

        viewableRoomImage.setPreserveRatio(true);

        return new Group(viewableRoomImage);

    }

}

