public class Point3d {

    // Координаты точки
    private double xCoord;
    private double yCoord;
    private double zCoord;

    // Конструктор, инициализирующий точку заданными значениями
    public Point3d(double x, double y, double z) {
        xCoord = x;
        yCoord = y;
        zCoord = z;
    }

    // Конструктор по умолчанию, инициализирующий точку (0, 0, 0)
    public Point3d() {
        this(0.0, 0.0, 0.0);
    }

    // Методы для получения значений координат
    public double getX() {
        return xCoord;
    }

    public double getY() {
        return yCoord;
    }

    public double getZ() {
        return zCoord;
    }

    // Методы для изменения значений координат
    public void setX(double x) {
        xCoord = x;
    }

    public void setY(double y) {
        yCoord = y;
    }

    public void setZ(double z) {
        zCoord = z;
    }

    // Метод для сравнения двух объектов Point3d
    public boolean equals(Point3d other) {
        return this.xCoord == other.xCoord &&
               this.yCoord == other.yCoord &&
               this.zCoord == other.zCoord;
    }

    // Метод для вычисления расстояния между двумя точками
    public double distanceTo(Point3d other) {
        double dx = this.xCoord - other.xCoord;
        double dy = this.yCoord - other.yCoord;
        double dz = this.zCoord - other.zCoord;
        return Math.round(Math.sqrt(dx*dx + dy*dy + dz*dz) * 100.0) / 100.0;
    }
}
