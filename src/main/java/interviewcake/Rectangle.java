package interviewcake;

/**
 * Created by Praveen on 5/6/2018.
 */
public class Rectangle {

    private int xLeft;
    private int yBottom;
    private int width;
    private int height;

    public Rectangle(int xLeft, int yBottom, int width, int height) {
        this.xLeft = xLeft;
        this.yBottom = yBottom;
        this.width = width;
        this.height = height;
    }

    public int getxLeft() {
        return xLeft;
    }

    public void setxLeft(int xLeft) {
        this.xLeft = xLeft;
    }

    public int getyBottom() {
        return yBottom;
    }

    public void setyBottom(int yBottom) {
        this.yBottom = yBottom;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }


}
