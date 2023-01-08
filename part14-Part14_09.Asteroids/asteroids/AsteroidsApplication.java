package asteroids;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.concurrent.atomic.AtomicInteger;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.input.KeyCode;
import javafx.animation.AnimationTimer;
import javafx.scene.text.Text;

public class AsteroidsApplication extends Application {
    public static int WIDTH = 300;
    public static int HEIGHT = 200;

    public static void main(String[] args) {
        Application.launch(AsteroidsApplication.class);
    }

    @Override
    public void start(Stage window) throws Exception {
        Map<KeyCode, Boolean> pressedKeys = new HashMap<>();
        List<Projectile> projectiles = new ArrayList<>();
        List<Asteroid> asteroids = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            Random random = new Random();
            asteroids.add(new Asteroid(random.nextInt(WIDTH / 3), random.nextInt(HEIGHT)));
        }
        Ship ship = new Ship(WIDTH / 2, HEIGHT / 2);

        Pane layout = new Pane();
        Text pointsText = new Text(10, 20, "Points: 0");
        AtomicInteger points = new AtomicInteger();
        layout.setPrefSize(WIDTH, HEIGHT);
        layout.getChildren().addAll(pointsText, ship.getCharacter());
        asteroids.forEach(asteroid -> layout.getChildren().add(asteroid.getCharacter()));

        Scene scene = new Scene(layout);
        scene.setOnKeyPressed(event -> pressedKeys.put(event.getCode(), true));
        scene.setOnKeyReleased(event -> pressedKeys.put(event.getCode(), false));

        new AnimationTimer() {
            @Override
            public void handle(long now) {
                if(Math.random() < 0.005) {
                    Asteroid asteroid = new Asteroid(WIDTH, HEIGHT);
                    if(!asteroid.collide(ship)) {
                        asteroids.add(asteroid);
                        layout.getChildren().add(asteroid.getCharacter());
                    }
                }

                if(pressedKeys.getOrDefault(KeyCode.LEFT, false)) {
                    ship.turnLeft();
                }

                if(pressedKeys.getOrDefault(KeyCode.RIGHT, false)) {
                    ship.turnRight();
                }

                if(pressedKeys.getOrDefault(KeyCode.UP, false)) {
                    ship.accelerate();
                }

                if(pressedKeys.getOrDefault(KeyCode.SPACE, false) && projectiles.size() < 3) {
                    Projectile projectile = new Projectile((int) ship.getCharacter().getTranslateX(), (int) ship.getCharacter().getTranslateY());
                    projectile.getCharacter().setRotate(ship.getCharacter().getRotate());
                    projectiles.add(projectile);
                
                    projectile.accelerate();
                    projectile.setMovement(projectile.getMovement().normalize().multiply(3));
                
                    layout.getChildren().add(projectile.getCharacter());
                }

                ship.move();
                asteroids.forEach(asteroid -> asteroid.move());
                projectiles.forEach(projectile -> projectile.move());

                projectiles.forEach(projectile -> {
                    asteroids.forEach(asteroid -> {
                        if (projectile.collide(asteroid)) {
                            projectile.setAlive(false);
                            asteroid.setAlive(false);
                        }
                    });

                    if(!projectile.isAlive()) {
                        pointsText.setText("Points: " + points.addAndGet(1000));
                    }
                });

                projectiles.stream()
                        .filter(projectile -> !projectile.isAlive())
                        .forEach(projectile -> layout.getChildren().remove(projectile.getCharacter()));
                projectiles.removeAll(projectiles.stream()
                        .filter(projectile -> !projectile.isAlive())
                        .collect(Collectors.toList()));

                asteroids.stream()
                        .filter(asteroid -> !asteroid.isAlive())
                        .forEach(asteroid -> layout.getChildren().remove(asteroid.getCharacter()));
                asteroids.removeAll(asteroids.stream()
                        .filter(asteroid -> !asteroid.isAlive())
                        .collect(Collectors.toList()));
            }
        }.start();

        window.setTitle("Asteroids!");
        window.setScene(scene);
        window.show();
    }

    public static int partsCompleted() {
        return 4;
    }
}