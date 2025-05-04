package com.espocrm.listeners;

import com.espocrm.utils.LoggerUtil;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.WebDriverListener;

public class WebEventLogger implements WebDriverListener {

    private static final Logger log = LoggerUtil.getLogger(WebEventLogger.class);

    @Override
    public void beforeClick(WebElement element) {
        log.info("Trying to click: " + getElementInfo(element));
    }

    @Override
    public void afterClick(WebElement element) {
        log.info("Clicked: " + getElementInfo(element));
    }

    public void beforeNavigateTo(String url, WebDriver driver) {
        log.info("Navigating to: " + url);
    }

    public void afterNavigateTo(String url, WebDriver driver) {
        log.info("Navigated to: " + url);
    }

    @Override
    public void beforeSendKeys(WebElement element, CharSequence... keysToSend) {
        log.info("Typing '" + String.join("", keysToSend) + "' into: " + getElementInfo(element));
    }

//    @Override
//    public void onError(Object target, Method method, Object[] args, InvocationTargetException e) {
//        log.error("Exception occurred in method: " + method.getName() + " - " + e.getTargetException());
//    }

    private String getElementInfo(WebElement element) {
        try {
            String tag = element.getTagName();
            String text = element.getText().isEmpty() ? element.getAttribute("value") : element.getText();
            return "<" + tag + "> with text/value: '" + text + "'";
        } catch (Exception e) {
            return "Unknown WebElement";
        }
    }
}

