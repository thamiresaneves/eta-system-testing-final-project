package stepDefinitions;

import foundation.InitProcess;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class QuickTest {

    @Test
    public void test(){
        WebDriver driver = InitProcess.createBrowser();
    }
}
