package work2;

public class DocumentReportGenerator implements ReportGeneratorXml, ReportGeneratorJson {

    @Override
    public String generateXml() {
        String report = "Xml";
        // todo Logic
        return report;
    }

    @Override
    public String generateJson() {
        String report = "json";
        // todo Logic
        return report;
    }
}
