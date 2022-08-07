package pa0;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import static java.lang.Integer.*;

public class LineReport {

    LineUsage[] lineUsages = new LineUsage[501];

    // Constructor
    public LineReport(){
        for(int i = 0; i<this.lineUsages.length;i++){
            this.lineUsages[i] = new LineUsage();
        }
    }

    // read input data, put facts into lines array
    void loadData(String filename) throws FileNotFoundException{
        FileReader file = new FileReader(filename);
        //Scanner scan = new Scanner(file);
        try{
            BufferedReader br = new BufferedReader(file);
            String line;
            while((line = br.readLine())!=null){
                String[] array = line.split(" ");
                int index = Integer.valueOf(array[0]);
                //System.out.println(array[1]);
                this.lineUsages[index].addObservation(array[1]);
                //System.out.println(line);
            }
            br.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    // given loaded lines array, generate report on lines
    void generateReport(){
        Usage maxUser = new Usage("",0);
        System.out.println("Terminal" + "\t" + "Most Common User" + "\t" + "Count");
        for (int i = 1; i < this.lineUsages.length; i++){
            if(this.lineUsages[i] == null){
                System.out.println(i + "\t" + "NONE" + "\t" + 0);
            }
            else {
                maxUser = this.lineUsages[i].findMaxUsage();
                System.out.println(i + "\t" + maxUser.getUser() + "\t" + maxUser.getCount());
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        LineReport report = new LineReport();
        report.loadData(args[0]);
        report.generateReport();
    }
}
