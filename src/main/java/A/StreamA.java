package A;


import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;



public class StreamA {

    public static Map<Integer,List<String>> groupByLength(List<String> strings){
        return strings.stream().distinct()
                .collect(Collectors.groupingBy(String::length));
    }

    public static void groupByLengthCount(Map<Integer,List<String>> mapLS) {


    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("enter names (Divided by space):");
        List<String> nameList = new ArrayList<>();
        nameList.addAll(Arrays.asList(scanner.nextLine().split(" ")));

        System.out.println("names have been added to the list!");
        System.out.println();

        System.out.println(groupByLength(nameList));

        List<List<String>> lls= (List<List<String>>) groupByLength(nameList).values();

    }
}
