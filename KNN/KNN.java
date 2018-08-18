package KNN;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.DatagramSocket;
import java.util.ArrayList;

public class KNN {
  static ArrayList<Instance> dataSet = new ArrayList<Instance>();
  
  public static void readFile(String filename)
    throws Exception{
    BufferedReader reader = new BufferedReader(new FileReader(filename));
    reader.readLine();
    String newLine;
    while(true){
      newLine = reader.readLine();
      if(newLine==null)
        break;
      String [] splitted =newLine.split(",");
      Instance i = new Instance();
      i.ssc = Double.parseDouble(splitted[0]);
      i.hsc = Double.parseDouble(splitted[1]);
      i.uiucgpa = Double.parseDouble(splitted[2]);
      i.distance = Double.parseDouble(splitted[3]);
      i.studyHours = Double.parseDouble(splitted[4]);
      i.semesters = Double.parseDouble(splitted[5]);
      i.ml = splitted[6].equals("Yes")?1.0:0.0;
      
      dataSet.add(i);
      
      
    } 
    
  }
  public static double knn(int k, ArrayList<Instance> train, Instance test)
  {
    ArrayList<Instance> newTrainer = new ArrayList<Instance>(train);
    
    return -1.0;
  }
  public static void main(String ...args)throws Exception
  {
//    readFile("src/KNN/knndata.csv");
    readFile("knndata.csv");
    System.out.println(dataSet.size());
    for(int i=0;i<dataSet.size();i++);
      
      
      
  }
}
