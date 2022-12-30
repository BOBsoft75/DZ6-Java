import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class hw {
    public static void main(String[] args) {
        //заполняем экземпляры класса
        notebook lap1 = new notebook(1, 512, 16, "DOS", "silver");

        notebook lap2 = new notebook(2,  256, 16, "Windows 10", "white");

        notebook lap3 = new notebook(3, 256, 16, "Linux", "silver");

        notebook lap4 = new notebook(4, 512, 32, "Windows 10", "black");

        notebook lap5 = new notebook(5, 256, 16, "Windows 10", "black");

        HashSet<notebook> lapSet = new HashSet<>(Arrays.asList(lap1, lap2, lap3, lap4, lap5));

        printSet(lapSet);

        HashSet<notebook> filterSet = filter(lapSet);
        printSet(filterSet);

    }

    static void printSet(HashSet<notebook> lapSet){
        for (notebook laptop : lapSet) {
            if (laptop != null){
                System.out.println(laptop);
            }
        }
    }

    static HashSet<notebook> filter(HashSet<notebook> lap) {
        HashSet<notebook> userLaptops = new HashSet<>(lap);
        HashMap<Integer, String> mapFilter = new HashMap<>();

        mapFilter.put(1, "RAM");
        mapFilter.put(2, "hardDisk");
        mapFilter.put(3, "operatingSystem");
        mapFilter.put(4, "color");

        for (Map.Entry<Integer, String> el : mapFilter.entrySet()) {
            System.out.println(el.getKey() + " - " + el.getValue());
        }

        System.out.print("Введите параметр для фильтра: ");
        Scanner iScanner = new Scanner(System.in);
        String input = iScanner.next();

        ArrayList<Integer> choice = new ArrayList<>();
        for (String userInput : input.split(",")) {
            if (mapFilter.containsKey(Integer.parseInt(userInput))) {
                choice.add(Integer.parseInt(userInput));
            }
        }
        HashMap<Integer, String> userFilter = new HashMap<>();
        for (Integer integer : choice) { //  for (int i = 0; i < choice.size(); i++) {
            userFilter.put(integer, mapFilter.get(integer));
        }
        for (Integer i : choice) {
            System.out.print("Введите параметр для фильтра " + userFilter.get(i) + ": ");
            if (iScanner.hasNext()) {
                input = iScanner.next();
                userFilter.put(i, input);
            }
        }
        iScanner.close();

        System.out.println("Фильтр: " + userFilter);

        for (Map.Entry<Integer, String> entry : userFilter.entrySet()) {
            userLaptops.removeIf(laptop -> !laptop.filteringCriteria(entry.getKey(), entry.getValue()));
        }

        return userLaptops;
    }

}