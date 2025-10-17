package com.example.myapplication;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.shapes.Shape;

// BALL USES DIAMETER FOR DRAW NOT RADIUS, KEEP THAT IN MIND
public class Ball extends CustomShape {

    public Ball(
            Coords size,
            Coords position,
            Coords speed,
            Rectangle bounds,
            int r,
            int g,
            int b
    ) {
        super(size, position, speed, bounds, r, g, b);
    }

    public Ball(Coords size, Coords position, Coords speed) {
        super(size, position, speed);
    }

    @Override
    public void draw(Canvas canvas, Paint paint) {
        canvas.drawCircle(
                getPosition().getX(),
                getPosition().getY(),
                getSize().getX(), // The size is diameter, half is radius
                paint
        );
    }
}
