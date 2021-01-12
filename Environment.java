public class EnvironmentEntity{
    private String name;

    EnvironmentEntity(String Name){
        this.name = Name;
    }
}

public class Table extends EnvironmentEntity{
    private int NumOfChairs;
    private int number;

    Table(int Number){
        super("Стол");
        this.number = Number;

    }

    public int getNumber() {
        return this.number;
    }
}

public class Mirror extends EnvironmentEntity{
    private Distortion distortion;

    Mirror(Distortion Dist){
        super("Зеркало");
        this.distortion = Dist;
    }

    public Distortion getDistortion() {
        return distortion;
    }
}
