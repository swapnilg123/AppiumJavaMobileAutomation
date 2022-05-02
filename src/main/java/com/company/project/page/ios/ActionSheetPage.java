package com.company.project.page.ios;

import com.company.project.utilities.AppiumUtil;
import io.appium.java_client.AppiumDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class ActionSheetPage {

  private Logger log = LogManager.getLogger();
  AppiumDriver driver;
  AppiumUtil appium = null;

  public ActionSheetPage(AppiumDriver driver) {
    this.driver = driver;
    appium = new AppiumUtil(driver);
  }

  public void navigateToUICatalogHomePage() {
    appium.android_returnMobileElementPresentUsingID("UICatalog").click();
    log.info("click action on back button");
  }

  public void clickOnActionSheets() {
    appium.android_returnMobileElementPresentUsingID("Action Sheets").click();
    log.info("click action on Action Sheets");
  }

  public void clickOnSearchBars() {
    appium.android_returnMobileElementPresentUsingID("Search Bars").click();
    log.info("click action on Search Bars Sheets");
  }

  public void clickOKCancelButton() {
    appium.android_returnMobileElementPresentUsingID("Okay / Cancel").click();
    log.info("click action on Okay / Cancel");
  }

  public void clickOK() {
    appium.android_returnMobileElementPresentUsingClassName("OK").click();
    log.info("click action on OK button");
  }

  public void clickCancel() {
    appium.android_returnMobileElementPresentUsingClassName("Cancel").click();
    log.info("click action on Cancel button");
  }
  public boolean validateHomePageLanding() {
    return appium.android_isMobileElementPresentUsingContentDesc("//XCUIElementTypeApplication[@name=\"UICatalog\"]");
  }
}
