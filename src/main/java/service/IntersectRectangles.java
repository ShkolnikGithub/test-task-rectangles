package service;

import model.Rectangle;

import java.util.ArrayList;
import java.util.List;

public class IntersectRectangles implements Intersect <Rectangle>{

    @Override
    public List<Rectangle> getAllIntersects(List<Rectangle> allRectangle) {
        List<Rectangle> result = new ArrayList<>();

        for (int i = 0; i < allRectangle.size() - 1; i++) {
            for (int k = i + 1; k < allRectangle.size(); k++) {
                Rectangle interRec = checkIntersection(allRectangle.get(i), allRectangle.get(k));
                if (interRec != null) {
                    result.add(interRec);
                }
            }
        }

        return result;
    }

    @Override
    public Rectangle checkIntersection(Rectangle first, Rectangle second) {
        // if second inside first
        if (first.getX1() <= second.getX1() && first.getX2() >= second.getX2()
                && first.getY1() >= second.getY1() && first.getY2() <= second.getY2()) {
            return new Rectangle(second.getX1(), second.getX2(), second.getY1(), second.getY2());
        }

        // if first inside second
        if (first.getX1() >= second.getX1() && first.getX2() <= second.getX2()
                && first.getY1() <= second.getY1() && first.getY2() >= second.getY2()) {
            return new Rectangle(first.getX1(), first.getX2(), first.getY1(), first.getY2());
        }

        // cross first option
        if (first.getX1() <= second.getX1() && first.getX2() >= second.getX2()) {
            if (first.getY1() <= second.getY1() && first.getY2() >= second.getY2()) {
                return new Rectangle(second.getX1(), second.getX2(), first.getY1(), first.getY2());
            }
        }

        // cross second option
        if (first.getY1() >= second.getY1() && first.getY2() <= second.getY2()) {
            if (first.getX1() >= second.getX1() && first.getX2() <= second.getX2()) {
                return new Rectangle(first.getX1(), first.getX2(), second.getY1(), second.getY2());
            }
            if (first.getX1() >= second.getX1() && first.getX1() <= second.getX2()
                    && first.getX2() >= second.getX2()) {
                return new Rectangle(first.getX1(), second.getX2(), second.getY1(), second.getY2());
            }
            if (first.getX2() >= second.getX1() && first.getX2() <= second.getX2()
                    && first.getX1() <= second.getX1()) {
                return new Rectangle(second.getX1(), first.getX2(), second.getY1(), second.getY2());
            }
        }

        // cross third option (only 1 part of rectangle)
        if (first.getX1() <= second.getX1() && first.getX2() >= second.getX2()) {
            if (first.getY1() <= second.getY1() && first.getY1() >= second.getY2()
                    && first.getY2() <= second.getY2()) {
                return new Rectangle(second.getX1(), second.getX2(), first.getY1(), second.getY2());
            }
            if (first.getY2() >= second.getY2() && first.getY2() <= second.getY1()
                    && first.getY1() >= second.getY1()) {
                return new Rectangle(second.getX1(), second.getX2(), second.getY1(), first.getY2());
            }
        }

        // check upper right corner
        if (first.getX2() >= second.getX1() && first.getX2() <= second.getX2()) {
            if (first.getY1() <= second.getY1() && first.getY1() >= second.getY2()) {
                if (first.getX1() >= second.getX1() && first.getX1() <= second.getX2()) {
                    return new Rectangle(first.getX1(), first.getX2(), first.getY1(), second.getY2());
                } else if (first.getY2() <= second.getY1() && first.getY2() >= second.getY2()) {
                    return new Rectangle(second.getX1(), first.getX2(), first.getY1(), first.getY2());
                }
                return new Rectangle(second.getX1(), first.getX2(), first.getY1(), second.getY2());
            }

            // check lower right corner
            if (first.getY2() <= second.getY1() && first.getY2() >= second.getY2()) {
                if (first.getX1() >= second.getX1() && first.getX1() <= second.getX2()) {
                    return new Rectangle(first.getX1(), first.getX2(), second.getY1(), first.getY2());
                }
                return new Rectangle(second.getX1(), first.getX2(), second.getY1(), first.getY2());
            }
        }

        // check lower left corner
        if (first.getX1() >= second.getX1() && first.getX1() <= second.getX2()) {
            if (first.getY2() <= second.getY1() && first.getY2() >= second.getY2()) {
                if (first.getY1() <= second.getY1() && first.getY1() >= second.getY2()) {
                    return new Rectangle(first.getX1(), second.getX2(), first.getY1(), first.getY2());
                }
                return new Rectangle(first.getX1(), second.getX2(), second.getY1(), first.getY2());
            }
            if (first.getY1() <= second.getY1() && first.getY1() >= second.getY2()) {
                return new Rectangle(first.getX1(), second.getX2(), first.getY1(), second.getY2());
            }
        }
        return null;
    }
}
