import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Arrays;

public class lab7 {

    public static void main(String[] args) {

        ArrayList<String> Dataa = new ArrayList<String>();

        float SepalLengthCount = 0.0f, SepalWidthCount = 0.0f, PetalLengthCount = 0.0f, PetalWidthCount = 0.0f;

        int IrisSetosa = 0, IrisVersicolor = 0, IrisVirginica = 0;

        try {
            File file = new File("C:\\Users\\ashish\\Downloads\\iris.csv");
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                String Line = sc.nextLine();

                Dataa.add(Line);

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Id,SepalLengthCm,SepalWidthCm,PetalLengthCm,PetalWidthCm,Species

        int n = 0;
        ArrayList<Float> SepalLength = new ArrayList<>();
        ArrayList<Float> SepalWidth = new ArrayList<>();
        ArrayList<Float> PetalLength = new ArrayList<>();
        ArrayList<Float> PetalWidth = new ArrayList<>();

        for (int i = 1; i < 151; i++) {

            SepalLengthCount = SepalLengthCount + Float.parseFloat(Dataa.get(i).split(",")[1]);
            SepalLength.add(Float.parseFloat(Dataa.get(i).split(",")[1]));

            SepalWidthCount = SepalLengthCount + Float.parseFloat(Dataa.get(i).split(",")[2]);
            SepalWidth.add(Float.parseFloat(Dataa.get(i).split(",")[2]));

            PetalLengthCount = SepalLengthCount + Float.parseFloat(Dataa.get(i).split(",")[3]);
            PetalLength.add(Float.parseFloat(Dataa.get(i).split(",")[3]));

            PetalWidthCount = SepalLengthCount + Float.parseFloat(Dataa.get(i).split(",")[4]);
            PetalWidth.add(Float.parseFloat(Dataa.get(i).split(",")[4]));

            if (Dataa.get(i).split(",")[5].equals("Iris-setosa")) {
                IrisSetosa++;
            } else if (Dataa.get(i).split(",")[5].equals("Iris-versicolor")) {
                IrisVersicolor++;
            } else if (Dataa.get(i).split(",")[5].equals("Iris-virginica")) {
                IrisVirginica++;
            }

            n++;

        }

        // ---------------------mean--------------------
        float mean_SepalLengthCm = SepalLengthCount / n;
        float mean_SepalWidthCm = SepalWidthCount / n;
        float mean_PetalLengthCm = PetalLengthCount / n;
        float mean_PetalWidthCm = PetalWidthCount / n;
        float mean_IrisSetosa = IrisSetosa / n;
        float mean_IrisVersicolor = IrisVersicolor / n;
        float mean_IrisVirginica = IrisVirginica / n;

        ArrayList<Float> mean = new ArrayList<Float>();
        mean.add(mean_SepalLengthCm);
        mean.add(mean_SepalWidthCm);
        mean.add(mean_PetalLengthCm);
        mean.add(mean_PetalWidthCm);
        mean.add(mean_IrisSetosa);
        mean.add(mean_IrisVersicolor);
        mean.add(mean_IrisVirginica);

        // ---------------median----------------------

        // int[] SL = SepalLength.toArray();

        ArrayList<Float> median = new ArrayList<Float>();

        median.add(medi(SepalLength));
        median.add(medi(SepalWidth));
        median.add(medi(PetalLength));
        median.add(medi(PetalWidth));

        // --------------------min----------------------
        ArrayList<Float> min = new ArrayList<>();
        min.add(Collections.min(SepalLength));
        min.add(Collections.min(SepalWidth));
        min.add(Collections.min(PetalLength));
        min.add(Collections.min(PetalWidth));

        // --------------------max------------------------
        ArrayList<Float> max = new ArrayList<>();
        max.add(Collections.max(SepalLength));
        max.add(Collections.max(SepalWidth));
        max.add(Collections.max(PetalLength));
        max.add(Collections.max(PetalWidth));

        // ------------------------mode-------------------

        ArrayList<Float> modes = new ArrayList<>();
        modes.add(mode(SepalLength));
        modes.add(mode(SepalWidth));
        modes.add(mode(PetalLength));
        modes.add(mode(PetalWidth));

        String[] rowHeading = { "SepalLength", "SepalWidth", "PetalLength", "PetalWidth" };

        System.out.println("              MIN      MAX      MEAN      MEDIAN     MODE");

        for (int i = 0; i < 4; i++) {

            System.out.printf("%-13s %-8.2f %-8.2f %-9.2f %-10.2f %-10.2f", rowHeading[i], min.get(i), max.get(i),
                    mean.get(i),
                    median.get(i),
                    modes.get(i));
            System.out.println();
        }
        System.out.println();
        System.out.println("Iris-setosa :" + IrisSetosa);
        System.out.println("Iris-versicolor :" + IrisVersicolor);
        System.out.println("Iris-virginica :" + IrisVirginica);

    }

    // -=========================mode function======================

    public static Float mode(ArrayList<Float> arr) {
        int maxCount = 0, count = 0;
        Float value, mode = 0.0f;

        for (int i = 0; i < arr.size(); i++) {

            value = arr.get(i);
            for (int j = 0; j < arr.size(); j++) {
                if (value == arr.get(j)) {
                    count++;
                }
            }
            if (count > maxCount) {
                mode = value;
                count = maxCount;
            }
        }
        return mode;
    }

    // --------------------MEDIAN FUNCTION-----------------------

    public static Float medi(ArrayList<Float> arr) {

        Float[] nwArr = new Float[150];
        int itr = 0;
        for (Float i : arr) {
            nwArr[itr++] = i;
        }

        Arrays.sort(nwArr);
        Float nwArr_median = nwArr[150 / 2];

        return nwArr_median;
    }

}
