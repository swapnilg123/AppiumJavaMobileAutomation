package com.company.project.page.android;

import com.company.project.utilities.AppiumUtil;
import io.appium.java_client.AppiumDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import java.util.List;

/** Created by pavankovurru on 7/17/17. */
public class AccessibilityPage {

  private Logger log = LogManager.getLogger();
  AppiumUtil appium = null;
  AppiumDriver driver;

  public AccessibilityPage(AppiumDriver driver) {
    this.driver = driver;
    appium = new AppiumUtil(driver);
  }

  public void clickAccessibility() {
    appium.android_ScrollToText("Accessibility").click();
  }

  // Accessibility Node Provider
  public void clickAccessibilityNodeProvider() {
    appium.android_ScrollToText("Accessibility Node Provider").click();
  }

  public String getAccessibilityNodeProviderText() {
    return appium.android_returnMobileElementPresentUsingXPath("//android.widget.LinearLayout/android.widget.TextView").getText();
  }

  // Accessibility Node Querying
  public void clickAccessibilityNodeQuerying() {
    appium.android_ScrollToText("Accessibility Node Querying").click();
  }

  public void checkAllUncheckedTextBoxesInAccessibilityNodeQuerying() {

    List<WebElement> checkboxes =
        appium.android_returnMobileElementsPresentUsingClassName("android.widget.CheckBox");
    log.info("found - " + checkboxes.size() + "checkboxes");
    for (WebElement mo : checkboxes) {
      if (mo.getAttribute("checked").matches("false")) {
        mo.click();
      }
    }
  }

  public void unCheckAllcheckedTextBoxesInAccessibilityNodeQuerying() {
    List<WebElement> checkboxes =
        appium.android_returnMobileElementsPresentUsingClassName("android.widget.CheckBox");
    for (WebElement mo : checkboxes) {
      if (mo.getAttribute("checked").matches("true")) {
        mo.click();
      }
    }
  }

  public boolean areAllCheckBoxesSelected() {
    List<WebElement> checkboxes =
        appium.android_returnMobileElementsPresentUsingClassName("android.widget.CheckBox");
    for (WebElement mo : checkboxes) {
      if (mo.getAttribute("checked").matches("false")) {
        return false;
      }
    }
    return true;
  }

  // Accessibility Service
  public void clickAccessibilityService() {
    appium.android_ScrollToText("Accessibility Service").click();
  }

  // Custom View
  public void clickCustomView() {
    appium.android_ScrollToText("Custom View").click();
  }
}
