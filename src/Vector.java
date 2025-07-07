import java.util.Arrays;

public class Vector implements Comparable<Vector> {
    private double[] vector;
    private double distance;
    private String className;

    public Vector(String[] vector) {
        this.vector = new double[vector.length-1];
        for (int i = 0; i < vector.length; i++) {
            try{
                this.vector[i] = Double.parseDouble(vector[i]);
            }catch (NumberFormatException e){
                //System.err.println("Couldn't parse: " + vector[i]);
            }
        }
    }

    public Vector(String[] vector, String className) {
        this.vector = new double[vector.length-1];
        for (int i = 0; i < vector.length; i++) {
            try{
            this.vector[i] = Double.parseDouble(vector[i]);
            }catch (NumberFormatException e){
                //System.err.println("Couldn't parse: " + vector[i]);
            }
        }
        this.className = className;
    }

    public double[] getVector() {
        return vector;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }


    @Override
    public int compareTo(Vector o) {
        return Double.compare(this.distance, o.distance);
    }

    @Override
    public String toString() {
        return "Vector{ " + Arrays.toString(vector) +" Distance "+distance+ " , className='" + className + '\'' + '}';
    }
}
