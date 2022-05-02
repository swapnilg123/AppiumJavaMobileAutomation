package com.company.project.tests.android;

import com.company.project.page.android.WebViewPage;
import com.company.project.utilities.RunOn;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.AppiumDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;
import org.testng.ITestResult;


public class Webview extends RunOn {

  private Logger log = LogManager.getLogger();
  AppiumDriver driver = null;
  RunOn run_on = new RunOn();
  WebViewPage webviewpage = null;

  @BeforeMethod(alwaysRun = true)
  @Parameters({"runOn", "appName"})
  public void invokeApp(String runOn, String appName) {
    driver = run_on.run(runOn, appName);
    log.info("--------------------------------------------------------------------------");
    log.info("Appium driver created for - " + runOn);
    log.info("Targeting app - " + appName);
    log.info("--------------------------------------------------------------------------");
    webviewpage = new WebViewPage(driver);
    logger = extent.startTest("TestCase001 - Internet Speed App");
   // webviewpage.clickViews();
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown(ITestResult result) {
    /*log.info("Tearing down driver");
    if (driver != null) {
      driver.quit();
    }*/
    if (result.getStatus() == ITestResult.FAILURE) {
       logger.log(LogStatus.FAIL, "" + logger.addScreenCapture(capture(driver, "screenShot")));
      // logger.log(LogStatus.FAIL, "Fail Screenshot : " + logger.addScreenCapture(capture(driver, "screenShot")));
      //logStatusFail("Failed", driver);

    } else if (result.getStatus() == ITestResult.SKIP) {
      logger.log(LogStatus.SKIP, "Skip");
    } else if (result.getStatus() == ITestResult.SUCCESS) {
    }
  }
/*
  @Test(groups = {"funtional", "positive"})
  public void validateAccessibilityLink() {
    log.info("Testing a - " + driver.getContext());
    webviewpage.clickWebView();
    webviewpage.switchToWebView();
    webviewpage.switchToNative();
  }*/

  @Test(groups = {"funtional", "positive"})
  public void validateAccessibilityLink() {
    log.info("Testing a - " + driver.getContext());
    webviewpage.letsGo();
    webviewpage.iAgree();
    webviewpage.handleAlert();
    webviewpage.skip1();
    webviewpage.startSpeedTest();
    webviewpage.waitForSpeedTest();
  }
}
