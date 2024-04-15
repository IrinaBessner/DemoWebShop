package com.demowebshop.tests;

import com.demowebshop.data.UserData;
import com.demowebshop.models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;


public class CreateAccountTests extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnLogOutLink();
        }
    }

    @Test
    public void createNewAccountPositiveTest() {
        Random random = new Random();
        int i = random.nextInt(1000) + 1000;

        app.getUser().clickOnRegisterLink();
        app.getUser().fillRegisterForm(new User()
                .setEmail("akuna" + i + "@ma.ta")
                //.setEmail(UserData.EMAIL)
                .setPassword(UserData.PASSWORD)
                .setPassword(UserData.PASSWORD)
                .setFirstname(UserData.FIRSTNAME)
                .setSecondname(UserData.SECONDNAME));
        app.getUser().clickOnRegisterButton();

        Assert.assertTrue(app.getUser().ifAccountLinkExists());
    }

    @Test
    public void createNewAccountWithExistedEmailNegativeTest() {

        app.getUser().clickOnRegisterLink();
        app.getUser().fillRegisterForm(new User()
                .setEmail(UserData.EMAIL)
                .setPassword(UserData.PASSWORD)
                .setFirstname(UserData.FIRSTNAME)
                .setSecondname(UserData.SECONDNAME));
        app.getUser().clickOnRegisterButton();
        Assert.assertTrue(app.getUser().ifEmailAlreadyExistsWarning());
        app.getUser().ifEmailAlreadyExists();
    }
}


//    @DataProvider
//    public Iterator<Object[]> createNewAccountFromCsvFile() throws IOException {
//        List<Object[]> list = new ArrayList<>();
//
//        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/userdata.csv")));
//        String line = reader.readLine();
//        while (line != null) {
//
//            String[] split = line.split(",");
//            list.add(new Object[]{new User()
//                    .setEmail(split[0]).setPassword(split[1]).setPassword(split[2]).setFirstname(split[3]).setSecondname(split[4])});
//
//            line= reader.readLine();
//        }
//        return list.iterator();
//    }
//
//    @Test(dataProvider = "createNewAccountFromCsvFile")
//    public void createNewAccountPositiveTestFromDataProviderWithCsvFile(User user) {
//        app.getUser().clickOnRegisterLink();
//        app.getUser().fillRegisterForm(user);
//        app.getUser().clickOnRegisterButton();
//
//        Assert.assertTrue(app.getUser().ifAccountLinkExists());
//    }
//}



