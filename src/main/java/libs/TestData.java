package libs;

public class TestData {
    public final static String REGISTRATION_DATE = "Oct. 25";
    public final static int COUNT_OF_RESULT_ROWS = 51;
    private  String actualRaceDateFromRacePage;
    private String expectedRaceDateFromCalendarPage;

    public  String getActualRaceDateFromRacePage() {
        return actualRaceDateFromRacePage;
    }

    public  void setActualRaceDateFromRacePage(String actualRaceDateFromRacePage) {
        this.actualRaceDateFromRacePage = actualRaceDateFromRacePage;
    }

    public String getExpectedRaceDateFromCalendarPage() {
        return expectedRaceDateFromCalendarPage;
    }

    public void setExpectedRaceDateFromCalendarPage(String expectedRaceDateFromCalendarPage) {
        this.expectedRaceDateFromCalendarPage = expectedRaceDateFromCalendarPage;
    }
}
