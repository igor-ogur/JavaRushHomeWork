package com.javarush.test.level17.lesson10.home02;

/* Comparable
Реализуйте интерфейс Comparable<Beach> в классе Beach, который будет использоваться нитями.
*/

import java.util.TreeSet;

public class Beach implements Comparable<Beach>{
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    @Override
    /*public synchronized int compareTo(Beach o) {
        int result = name.compareTo(o.getName);
        //if (result != 0) return result;

        int result2 = (int) (distance - o.getDistance);
        if (result2 != 0) result2 = result2/Math.abs(result2);
        //if (result != 0) return result;


        int result3 = quality - o.getQuality;
        if (result3 != 0) result3 = result3/Math.abs(result3);
        //if (result != 0) return result;

        return result+result2+result3;
    }*/

    public synchronized int compareTo(Beach o)
    {
        int distanceParam = (int) (distance - o.getDistance());
        int qualityParam = quality - o.getQuality();
        return 10000 * name.compareTo(o.getName()) + 100 * distanceParam + qualityParam;



    }

    /*public static void main(String[] args) {
        TreeSet<Beach> beaches = new TreeSet<Beach>();

        beaches.add(new Beach("Bbeach1", 125.6f, 7));
        beaches.add(new Beach("Zbeach2", 124.6f, 8));
        beaches.add(new Beach("Mbeach3", 123.6f, 7));
        beaches.add(new Beach("Nbeach4", 124.2f, 7));
        beaches.add(new Beach("Pbeach5", 124.6f, 9));
        beaches.add(new Beach("Fbeach6", 127.6f, 6));

        for (Beach x : beaches){
            System.out.println(x.getName()+" "+x.getDistance()+" "+x.getQuality());
        }
    }*/
}
