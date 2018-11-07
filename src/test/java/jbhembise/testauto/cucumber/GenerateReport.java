package jbhembise.testauto.cucumber;

import java.io.File;
import java.util.Collections;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

/**
 * Class to generate a pretty HTML report for Cucumber.
 */
public class GenerateReport {

    public static void main(String[] args) {
        String outputRootDirectory = "build/reports";

        File reportOutputDirectory = new File( outputRootDirectory);

        String projectName = "tests-auto-in-java-world";

        Configuration configuration = new Configuration(reportOutputDirectory, projectName);

        List<String> jsonFiles = Collections.singletonList(outputRootDirectory + "/cucumber.json");

        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        reportBuilder.generateReports();
    }
}
