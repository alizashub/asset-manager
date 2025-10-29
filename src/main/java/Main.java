import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Asset> myAsset = new ArrayList<>();

        myAsset.add( new House("My House", "2020-05-10",20000, "34 Park Lane", 2, 3999));

        myAsset.add(new Vehicle("Jane's Truck", "2023-02-11", 35000, "Toyota", 2019,120000));

    }
}
