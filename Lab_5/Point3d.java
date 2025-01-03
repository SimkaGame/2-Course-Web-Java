public class Point3d {

    //Точки
    public double xCoord;
    public double yCoord;
    public double zCoord;

    public Point3d(double x, double y, double z) {
        xCoord = x;
        yCoord = y;
        zCoord = z;
    }

    //Начальные
    public Point3d() {
        this(0.0, 0.0, 0.0);
    }

    public double getX() {
        return xCoord;
    }

    public double getY() {
        return yCoord;
    }

    public double getZ() {
        return zCoord;
    }
    //Изменение
    public void setX(double x) {
        xCoord = x;
    }

    public void setY(double y) {
        yCoord = y;
    }

    public void setZ(double z) {
        zCoord = z;
    }

    //Сравнение
    public boolean equals(Point3d other) {
        return this.xCoord == other.xCoord &&
               this.yCoord == other.yCoord &&
               this.zCoord == other.zCoord;
    }

    //Вычисление расстояния
    public double distanceTo(Point3d other) {
        double dx = this.xCoord - other.xCoord;
        double dy = this.yCoord - other.yCoord;
        double dz = this.zCoord - other.zCoord;
        return Math.round(Math.sqrt(dx*dx + dy*dy + dz*dz) * 100.0) / 100.0;
    }
}
