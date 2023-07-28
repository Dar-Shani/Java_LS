package work2;

public class Main {
    public static void main(String[] args) {
        
        //Было нарушен 4 Принцип разделения интерфейса, разделил первый интерфейс на два один для xml
        //другой для json

        ReportGeneratorJson reportJson = new AccountReportGenerator();
        System.out.printf("Отчёт в формате %s готов\n", reportJson.generateJson());

        DocumentReportGenerator reportGenerator = new DocumentReportGenerator();
        System.out.printf("Отчёты в форматах %s, %s готовы", reportGenerator.generateJson(),
        reportGenerator.generateXml());
    }
}
