package asteroids;

import java.util.Random;

public class Asteroid extends Character {
    private double rotationalMovement;

    public Asteroid(int x, int y) {
        super(PolygonFactory.createPolygon(), x, y);

        Random random = new Random();

        super.getCharacter().setRotate(random.nextInt(360));

        int acceleration = 1 + random.nextInt(10);
        for (int i = 0; i < acceleration; i++) {
            accelerate();
        }

        rotationalMovement = 0.5 - random.nextDouble();
    }

    @Override
    public void move() {
        super.move();
        super.getCharacter().setRotate(super.getCharacter().getRotate() + rotationalMovement);
    }
}
