package com.yaytech.datatransfer;

import com.yaytech.util.ExcelUtil;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelTest {


    @DataProvider
    public Object[][] userData(){
        ExcelUtil  excelUtil = new ExcelUtil("src/test/resources/Vytracktestdata.xlsx",
                "QA3-short");
        return excelUtil.getDataArrayWithoutFirstRow();
    }

    @Test(dataProvider = "userData")
    public void readExcel(String username, String password, String firstname, String lastname){

        System.out.println("User name: " + username + " || " + " Password: " + password + " || " + " First Name: " + firstname + " || " + " Last name: " + lastname);


    }
}
