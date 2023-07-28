package work1;
//Нарушен 5 принцип инверсии зависимостей, 
//создал абстрактный класс Rectangl и Square сделал его наследниками
public abstract class Shape {
    
    protected int height;
    protected int width;

    abstract void setHeight(int height);
    abstract void setWidth(int width);
}
