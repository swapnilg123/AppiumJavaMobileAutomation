package com.company.project.page.android;

import com.company.project.utilities.AppiumUtil;
import com.company.project.utilities.RunOn;
import io.appium.java_client.AppiumDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import java.util.Set;

/** Created by Swapnil Gore on 10/28/21. */
public class WebViewPage {
  String letsGo = "meteor.test.and.grade.internet.connection.speed:id/btLetsGo";
  String iAgree = "meteor.test.and.grade.internet.connection.speed:id/buttonAgree";
  By sAlert = By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button");
  By sSkip = By.id("meteor.test.and.grade.internet.connection.speed:id/btSecondary");
  By startTest =  By.id("meteor.test.and.grade.internet.connection.speed:id/btStartTest");
  By waitForTest = By.id(" meteor.test.and.grade.internet.connection.speed:id/relativeLayout");

  private final Logger log = LogManager.getLogger();
  AppiumUtil appium = null;
  AppiumDriver driver;
  RunOn r = new RunOn();

  public WebViewPage(AppiumDriver driver) {
    this.driver = driver;
    appium = new AppiumUtil(driver);
  }

  public void clickViews() {
    appium.android_ScrollToText("Views").click();
  }

  public void clickWebView() {
    appium.android_ScrollToText("WebView").click();
    appium.sleep(2);
  }

  public void switchToWebView() {

    Set<String> handles = driver.getContextHandles();
    log.info("Context's available  - " + handles.size());

    for (String handle : handles) {
      log.info("Trying with context - " + handle);
      if (handle.matches(".*?WEBVIEW.*?")) {
        log.info("Trying to switch Context to - " + handle);
        driver.context(handle);
        log.info("Current context - " + driver.getContext());
        break;
      }
    }
  }

  public void switchToNative() {
    Set<String> handles = driver.getContextHandles();
    log.info("Context's available  - " + handles.size());

    for (String handle : handles) {
      log.info("Trying with context - " + handle);
      if (handle.matches("NATIVE_APP")) {
        log.info("Trying to switch Context to - " + handle);
        driver.context(handle);
        log.info("Current context - " + driver.getContext());
        break;
      }
    }
  }

  public String getText() {
    appium.sleep(5);
    return driver.findElement(By.xpath("//body/a")).getText();
  }

  public void letsGo() {
    appium.android_returnMobileElementPresentUsingID(letsGo).click();
    appium.sleep(2);
    r.logStatusPassWithScreenShot("Clicked on Lets Go Button",driver);
  }

  public void iAgree() {
    appium.android_returnMobileElementPresentUsingID(iAgree).click();
    appium.sleep(2);
    r.logStatusPassWithScreenShot("Clicked on iAgree", driver);
  }

  public void handleAlert(){
    appium.wait_until_ElementIs_Clickable(driver,sAlert).click();
    r.logStatusPassWithScreenShot("Handled alert", driver);
  }

  public void skip1(){
    appium.wait_until_ElementIs_Clickable(driver,sSkip).click();
    r.logStatusPassWithScreenShot("Clicked on Skip1 alert", driver);
  }
  public void startSpeedTest(){
    appium.wait_until_ElementIs_Clickable(driver,startTest).click();
    r.logStatusPassWithScreenShot("Start Speed Test", driver);
  }

  public void waitForSpeedTest(){
    appium.wait_until_ElementIs_Visible(driver,waitForTest).click();
    r.logStatusPassWithScreenShot("Speed Test Completed !!", driver);
  }

  /*public String getSpeed(){

  }*/


}
