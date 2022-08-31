package org.nyrr.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.*;
import java.util.stream.Collectors;

public class MarathonResultsPage extends ParentPage {
    public MarathonResultsPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBys(@FindBy(xpath = ".//span[text()='Place']//span[@class='num ng-binding']"))
    List<WebElement> placeNumberList;


    public void checkResultsSortingByPlace() {
        List<Integer> originalList = placeNumberList.stream()
                .map(s -> s.getText().trim())
                .mapToInt(s -> Integer.parseInt(s)).boxed()
                .collect(Collectors.toList());
        List<Integer> sortedExpectedList = originalList.stream().
                sorted().collect(Collectors.toList());

//        List<Integer> originalListInt = new ArrayList<Integer>();
//        for (String e : originalList) {
//        originalListInt.add(Integer.parseInt(e));
//        }
//        List <Integer> sortedListExpectedInt = new ArrayList<Integer>();
//        for (String e : sortedExpectedList) {
//            sortedListExpectedInt.add(Integer.parseInt(e));
//        }
//        Collections.sort(sortedListExpectedInt);
        try {
            Assert.assertEquals(sortedExpectedList, originalList);
            logger.info("Places are sorted");
        } catch (Exception e) {
            logger.info("Places are NOT sorted" + e);
        }

    }
}
