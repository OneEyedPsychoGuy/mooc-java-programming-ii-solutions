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

    private void getFullImage(Image source, WritableImage target, int width, int height) {
        PixelReader reader = source.getPixelReader();
        PixelWriter writer = target.getPixelWriter();

        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                Color color = reader.getColor(x, y);
                double red = color.getRed();
                double green = color.getGreen();
                double blue = color.getBlue();
                double opacity = color.getOpacity();

                writer.setColor(x, y, new Color(red, green, blue, opacity));
            }
        }
    }

    private void modifyTopLeft(Image source, WritableImage target, int width, int height) {
        PixelReader reader = source.getPixelReader();
        PixelWriter writer = target.getPixelWriter();

        for(int y = 0; y < height / 2; y++) {
            for(int x = 0; x < width / 2; x++) {
                Color color = reader.getColor(x*2, y*2);
                double red = 1.0 - color.getRed();
                double green = 1.0 - color.getGreen();
                double blue = 1.0 - color.getBlue();
                double opacity = color.getOpacity();

                writer.setColor(x, y, new Color(red, green, blue, opacity));
            }
        }
    }

    private void modifyTopRight(Image source, WritableImage target, int width, int height) {
        PixelReader reader = source.getPixelReader();
        PixelWriter writer = target.getPixelWriter();

        for(int y = 0; y < height / 2; y++) {
            for(int x = 0; x < width / 2; x++) {
                Color color = reader.getColor(x*2, y*2);
                double red = 1.0 - color.getRed();
                double green = 1.0 - color.getGreen();
                double blue = 1.0 - color.getBlue();
                double opacity = color.getOpacity();

                writer.setColor(x + (width / 2), y, new Color(red, green, blue, opacity));
            }
        }
    }

    private void modifyBottomLeft(Image source, WritableImage target, int width, int height) {
        PixelReader reader = source.getPixelReader();
        PixelWriter writer = target.getPixelWriter();

        for(int y = 0; y < height / 2; y++) {
            for(int x = 0; x < width / 2; x++) {
                Color color = reader.getColor(x*2, y*2);
                double red = 1.0 - color.getRed();
                double green = 1.0 - color.getGreen();
                double blue = 1.0 - color.getBlue();
                double opacity = color.getOpacity();

                writer.setColor(x, y + (height / 2), new Color(red, green, blue, opacity));
            }
        }
    }

    private void modifyBottomRight(Image source, WritableImage target, int width, int height) {
        PixelReader reader = source.getPixelReader();
        PixelWriter writer = target.getPixelWriter();

        for(int y = 0; y < height / 2; y++) {
            for(int x = 0; x < width / 2; x++) {
                Color color = reader.getColor(x*2, y*2);
                double red = 1.0 - color.getRed();
                double green = 1.0 - color.getGreen();
                double blue = 1.0 - color.getBlue();
                double opacity = color.getOpacity();

                writer.setColor(x + (width / 2), y + (height / 2), new Color(red, green, blue, opacity));
            }
        }
    }

    @Override
    public void start(Stage stage) {
        Image source = new Image("file:monalisa.png");
        int width = (int) source.getWidth();
        int height = (int) source.getHeight();
        WritableImage target = new WritableImage(width, height);

        getFullImage(source, target, width, height);
        modifyTopLeft(source, target, width, height);
        modifyTopRight(source, target, width, height);
        modifyBottomLeft(source, target, width, height);
        modifyBottomRight(source, target, width, height);

        stage.setScene(new Scene(new Pane(new ImageView(target))));
        stage.show();
    }
}