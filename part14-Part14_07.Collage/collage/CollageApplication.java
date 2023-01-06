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
        Application.launch(CollageApplication.class);
    }

    private void createFullImage(Image source, WritableImage target) {
        PixelReader reader = source.getPixelReader();
        PixelWriter writer = target.getPixelWriter();
        int width = (int) source.getWidth();
        int height = (int) source.getHeight();

        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                Color color = reader.getColor(x, y);

                writer.setColor(x, y, new Color(
                    color.getRed(), 
                    color.getGreen(),
                    color.getBlue(), 
                    color.getOpacity()
                ));
            }
        }
    }

    private void createImageGrid(Image source, WritableImage target) {
        PixelReader reader = source.getPixelReader();
        PixelWriter writer = target.getPixelWriter();
        int width = (int) source.getWidth();
        int height = (int) source.getHeight();

        for(int y = 0; y < height / 2; y++) {
            for(int x = 0; x < width / 2; x++) {
                Color color = reader.getColor(x * 2, y * 2);

                writer.setColor(x, y, color);
                writer.setColor(x + width / 2, y, color);
                writer.setColor(x, y + height / 2, color);
                writer.setColor(x + width / 2, y + height / 2, color);
            }
        }
    }

    private void invertImageColor(Image source, WritableImage target) {
        PixelReader reader = target.getPixelReader();
        PixelWriter writer = target.getPixelWriter();
        int width = (int) source.getWidth();
        int height = (int) source.getHeight();

        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                Color color = reader.getColor(x, y);
                
                writer.setColor(x, y, new Color(
                    1.0 - color.getRed(),
                    1.0 - color.getGreen(),
                    1.0 - color.getBlue(),
                    color.getOpacity()
                ));
            }
        }
    }

    @Override
    public void start(Stage stage) {
        Image source = new Image("file:monalisa.png");
        WritableImage target = new WritableImage((int) source.getWidth(), (int) source.getHeight());

        this.createFullImage(source, target);
        this.createImageGrid(source, target);
        this.invertImageColor(source, target);

        stage.setScene(new Scene(new Pane(new ImageView(target))));
        stage.show();
    }
}