import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class KNN {
    private List<Vector> trainingList = new ArrayList<>();
    private int k;
    public KNN(String trainingFile, int k) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("./src/"+trainingFile));
            String line = br.readLine();
            while(line!=null){
                String[] tokens = line.split(",");
                trainingList.add(new Vector(tokens,tokens[tokens.length-1]));
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.k = k;
    }
    public Vector predict(Vector vector) {
        double distance;
        for(Vector v: trainingList){
            distance = 0;
            for (int i = 0; i < vector.getVector().length; i++) {
                distance += Math.pow(v.getVector()[i]-vector.getVector()[i],2);
            }
            v.setDistance(Math.sqrt(distance));
        }
        Collections.sort(trainingList);
        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            if(!map.containsKey(trainingList.get(i).getClassName())){
                map.put(trainingList.get(i).getClassName(),1);
            }else {
                map.put(trainingList.get(i).getClassName(),map.get(trainingList.get(i).getClassName())+1);
            }
        }
        vector.setClassName(Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey());
        return vector;
    }
    public void predict(String filename) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("./src/"+filename));
            String line = br.readLine();
            while(line!=null){
                String[] tokens = line.split(",");
                System.out.println(predict(new Vector(tokens)));
                line = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
