package org.example;

import javafx.scene.layout.AnchorPane;
import org.example.components.Component;

public class Container extends AnchorPane {

    public void addComponent(Component component) {
        getChildren().add(component.getNode());
    }

    public boolean removeComponent() {
        return true;
    }
}
