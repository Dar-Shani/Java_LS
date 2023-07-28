package work1;

// Квадрат
public class Square extends Shape {

    public void setHeight(int height) {
        this.height = height;
        this.width = height;
    }

    public void setWidth(int width) {
        this.width = width;
        this.height = width;
    }
}
