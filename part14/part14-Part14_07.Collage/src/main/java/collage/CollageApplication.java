package collage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CollageApplication extends Application {
    public static void main(String[] args) {
        launch(CollageApplication.class);
    }

    private ImageView getFullImageView(Image source) {
        return new ImageView(source);
    }

    private ImageView getTopLeftImageView(Image source) {
        double width = source.getWidth();
        double height = source.getHeight();

        ImageView image = new ImageView(source);
        image.setScaleX(0.5);
        image.setScaleY(0.5);
        image.setTranslateX(width * -0.25);
        image.setTranslateY(height * -0.25);

        return image;
    }

    @Override
    public void start(Stage stage) {
        Image source = new Image("file:monalisa.png");

        ImageView image = getFullImageView(source);
        ImageView topLeftImage = getTopLeftImageView(source);

        stage.setScene(new Scene(new Pane(image, topLeftImage)));
        stage.show();
    }
}