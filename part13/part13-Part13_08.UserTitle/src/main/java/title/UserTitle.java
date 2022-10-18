package title;

import javafx.application.Application;
import javafx.stage.Stage;

public class UserTitle extends Application {
    @Override
    public void start(Stage window) {
        window.setTitle(getParameters().getNamed().get("title"));
        window.show();
    }
}
