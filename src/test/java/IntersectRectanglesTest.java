import model.Rectangle;
import org.junit.Assert;
import org.junit.Test;
import service.IntersectRectangles;

public class IntersectRectanglesTest {
    IntersectRectangles intersectRectangles = new IntersectRectangles();

    // second inside first
    @Test
    public void secondInsideFirst() {
        Rectangle first = new Rectangle(1.0, 4.0, 5.0, 2.0);
        Rectangle second = new Rectangle(2.0, 3.0, 4.0, 3.0);
        Rectangle actual = intersectRectangles.checkIntersection(first, second);
        Rectangle expected = new Rectangle(2.0, 3.0, 4.0, 3.0);
        Assert.assertEquals(expected, actual);
    }

    // first inside second
    @Test
    public void firstInsideSecond() {
        Rectangle first = new Rectangle(2.0, 3.0, 4.0, 3.0);
        Rectangle second = new Rectangle(1.0, 4.0, 5.0, 2.0);
        Rectangle actual = intersectRectangles.checkIntersection(first, second);
        Rectangle expected = new Rectangle(2.0, 3.0, 4.0, 3.0);
        Assert.assertEquals(expected, actual);
    }

    // crosswise - the first is horizontal, the second is vertical
    @Test
    public void crossFirstOption() {
        Rectangle first = new Rectangle(1.0, 4.0, 2.0, 3.0);
        Rectangle second = new Rectangle(2.0, 3.0, 4.0, 1.0);
        Rectangle actual = intersectRectangles.checkIntersection(first, second);
        Rectangle expected = new Rectangle(2.0, 3.0, 3.0, 2.0);
        Assert.assertEquals(expected, actual);
    }

    // crosswise - the second is horizontal, the first is vertical
    @Test
    public void crossSecondOption() {
        Rectangle first = new Rectangle(2.0, 3.0, 4.0, 1.0);
        Rectangle second = new Rectangle(1.0, 4.0, 3.0, 2.0);
        Rectangle actual = intersectRectangles.checkIntersection(first, second);
        Rectangle expected = new Rectangle(2.0, 3.0, 3.0, 2.0);
        Assert.assertEquals(expected, actual);
    }

    // lower right corner of the first rectangle inside the second
    @Test
    public void lowerRightCornerOfFirst() {
        Rectangle first = new Rectangle(1.0, 3.0, 4.0, 2.0);
        Rectangle second = new Rectangle(2.0, 4.0, 3.0, 1.0);
        Rectangle actual = intersectRectangles.checkIntersection(first, second);
        Rectangle expected = new Rectangle(2.0, 3.0, 3.0, 2.0);
        Assert.assertEquals(expected, actual);
    }

    // both right corners of the first rectangle are inside the second
    @Test
    public void rightCornersOfFirst() {
        Rectangle first = new Rectangle(1.0, 3.0, 4.0, 2.0);
        Rectangle second = new Rectangle(2.0, 4.0, 5.0, 1.0);
        Rectangle actual = intersectRectangles.checkIntersection(first, second);
        Rectangle expected = new Rectangle(2.0, 3.0, 4.0, 2.0);
        Assert.assertEquals(expected, actual);
    }

    // upper right corner of the first rectangle is inside the second
    @Test
    public void upperRightCornerOfFirst() {
        Rectangle first = new Rectangle(1.0, 3.0, 3.0, 1.0);
        Rectangle second = new Rectangle(2.0, 4.0, 4.0, 2.0);
        Rectangle actual = intersectRectangles.checkIntersection(first, second);
        Rectangle expected = new Rectangle(2.0, 3.0, 3.0, 2.0);
        Assert.assertEquals(expected, actual);
    }

    // lower left corner of the first rectangle inside the second
    @Test
    public void lowerLeftCornerOfFirst() {
        Rectangle first = new Rectangle(2.0, 4.0, 4.0, 2.0);
        Rectangle second = new Rectangle(1.0, 3.0, 3.0, 1.0);
        Rectangle actual = intersectRectangles.checkIntersection(first, second);
        Rectangle expected = new Rectangle(2.0, 3.0, 3.0, 2.0);
        Assert.assertEquals(expected, actual);
    }

    // both left corners of the first rectangle are inside the second
    @Test
    public void leftCornersOfFirst() {
        Rectangle first = new Rectangle(2.0, 4.0, 4.0, 2.0);
        Rectangle second = new Rectangle(1.0, 3.0, 5.0, 1.0);
        Rectangle actual = intersectRectangles.checkIntersection(first, second);
        Rectangle expected = new Rectangle(2.0, 3.0, 4.0, 2.0);
        Assert.assertEquals(expected, actual);
    }

    // upper left corner of the first rectangle is inside the second
    @Test
    public void upperLeftCornerOfFirst() {
        Rectangle first = new Rectangle(2.0, 4.0, 3.0, 1.0);
        Rectangle second = new Rectangle(1.0, 3.0, 4.0, 2.0);
        Rectangle actual = intersectRectangles.checkIntersection(first, second);
        Rectangle expected = new Rectangle(2.0, 3.0, 3.0, 2.0);
        Assert.assertEquals(expected, actual);
    }

    // both upper corners of the first rectangle are inside the second
    @Test
    public void upperCornersOfFirst() {
        Rectangle first = new Rectangle(2.0, 4.0, 3.0, 1.0);
        Rectangle second = new Rectangle(1.0, 5.0, 4.0, 2.0);
        Rectangle actual = intersectRectangles.checkIntersection(first, second);
        Rectangle expected = new Rectangle(2.0, 4.0, 3.0, 2.0);
        Assert.assertEquals(expected, actual);
    }

    // both lower corners of the first rectangle are inside the second
    @Test
    public void lowerCornersOfFirst() {
        Rectangle first = new Rectangle(2.0, 4.0, 4.0, 2.0);
        Rectangle second = new Rectangle(1.0, 5.0, 3.0, 1.0);
        Rectangle actual = intersectRectangles.checkIntersection(first, second);
        Rectangle expected = new Rectangle(2.0, 4.0, 3.0, 2.0);
        Assert.assertEquals(expected, actual);
    }

    // both left corners of the second rectangle are inside the first
    @Test
    public void leftCornersOfSecond() {
        Rectangle first = new Rectangle(1.0, 3.0, 5.0, 1.0);
        Rectangle second = new Rectangle(2.0, 4.0, 4.0, 2.0);
        Rectangle actual = intersectRectangles.checkIntersection(first, second);
        Rectangle expected = new Rectangle(2.0, 3.0, 4.0, 2.0);
        Assert.assertEquals(expected, actual);
    }

    // both right corners of the second rectangle are inside the first
    @Test
    public void rightCornersOfSecond() {
        Rectangle first = new Rectangle(2.0, 4.0, 5.0, 1.0);
        Rectangle second = new Rectangle(1.0, 3.0, 4.0, 2.0);
        Rectangle actual = intersectRectangles.checkIntersection(first, second);
        Rectangle expected = new Rectangle(2.0, 3.0, 4.0, 2.0);
        Assert.assertEquals(expected, actual);
    }

    // both upper corners of the second rectangle are inside the first
    @Test
    public void upperCornersOfSecond() {
        Rectangle first = new Rectangle(1.0, 5.0, 4.0, 2.0);
        Rectangle second = new Rectangle(2.0, 4.0, 3.0, 1.0);
        Rectangle actual = intersectRectangles.checkIntersection(first, second);
        Rectangle expected = new Rectangle(2.0, 4.0, 3.0, 2.0);
        Assert.assertEquals(expected, actual);
    }

    // both lower corners of the second rectangle are inside the first
    @Test
    public void lowerCornersOfSecond() {
        Rectangle first = new Rectangle(1.0, 5.0, 3.0, 1.0);
        Rectangle second = new Rectangle(2.0, 4.0, 4.0, 2.0);
        Rectangle actual = intersectRectangles.checkIntersection(first, second);
        Rectangle expected = new Rectangle(2.0, 4.0, 3.0, 2.0);
        Assert.assertEquals(expected, actual);
    }
}
