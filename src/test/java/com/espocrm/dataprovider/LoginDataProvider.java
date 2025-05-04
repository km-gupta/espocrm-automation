package com.espocrm.dataprovider;

import com.espocrm.utils.ExcelUtils;
import org.testng.annotations.DataProvider;

public class LoginDataProvider {

    @DataProvider(name = "loginCredentials")
    public Object[][] getLoginDataFromExcel() {
        String excelPath = "src/test/resources/testdata/loginData.xlsx";
        return ExcelUtils.getSheetData(excelPath, "LoginData");
    }
}
