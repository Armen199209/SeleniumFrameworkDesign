package TestComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
    int count =0;
    int maxRunCount =1;
    @Override
    public boolean retry(ITestResult iTestResult) {
        if (count<maxRunCount){
            count++;
            return true;
        }
        return false;
    }
}
