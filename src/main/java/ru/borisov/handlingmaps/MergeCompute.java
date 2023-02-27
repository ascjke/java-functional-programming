package ru.borisov.handlingmaps;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MergeCompute {

    public static void main(String[] args) {

        Map<String, Integer> companyToNumberOfEmployeesMap = new HashMap<>();

        companyToNumberOfEmployeesMap.put("Goods Inc", 550);
        companyToNumberOfEmployeesMap.put("BestDevStudio", 1200);
        companyToNumberOfEmployeesMap.put("Ggl", 1000000);

        // merge
        // The following example adds 50 new employees to the "Goods Inc" company and creates a new entry for the "Healthy Eating" company.
        companyToNumberOfEmployeesMap.merge("Goods Inc", 50, Integer::sum); // adding 50
        companyToNumberOfEmployeesMap.merge("Goods Inc", 30, Integer::sum); // adding 30
        companyToNumberOfEmployeesMap.merge("Healthy Eating", 100, Integer::sum); // a new company
        System.out.println(companyToNumberOfEmployeesMap);

        // compute
        companyToNumberOfEmployeesMap.compute("Ggl", (company, employees) -> (int) (employees * 0.8));
//        companyToNumberOfEmployeesMap.compute("Ggl2", (company, employees) -> (int) (employees * 0.8)); // NPE
        companyToNumberOfEmployeesMap.compute("Unknown",
                (company, employees) -> Objects.nonNull(employees) ? (int) (employees * 0.8) : 0);
        System.out.println(companyToNumberOfEmployeesMap);

        // computeIfAbsent
        companyToNumberOfEmployeesMap.computeIfAbsent("New company", MergeMap::calculateSomehow);
        companyToNumberOfEmployeesMap.computeIfAbsent("Ggl", MergeMap::calculateSomehow);
        System.out.println(companyToNumberOfEmployeesMap);

        //computeIfPresent
        companyToNumberOfEmployeesMap.computeIfPresent("BestDevStudio",
                (company, employees) -> employees + 200);
        System.out.println(companyToNumberOfEmployeesMap);
    }
}

class MergeMap {

    public static int calculateSomehow(String company) {
        // simulate complex calculations
        return 30;
    }
}
