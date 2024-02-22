package edu.bsu.cs222;

import javafx.scene.Group;

import java.io.FileNotFoundException;

public class NodeMaker {

    Group makeImageNode(String nodeName) throws FileNotFoundException {
        ImageGenerator generator = new ImageGenerator();

        Group imageNode;
        imageNode = generator.GetFurnitureImageAsGroup(nodeName);

        return imageNode;
    }
}
