package com.demowebshop.tests;

import com.demowebshop.data.UserData;
import com.demowebshop.models.User;
import com.demowebshop.utils.DataProviders;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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

    @Test(dataProvider = "createNewAccountFromCsvFile", dataProviderClass = DataProviders.class)
    public void createNewAccountPositiveTestFromDataProviderWithCsvFile(User user) {
        app.getUser().clickOnRegisterLink();
        app.getUser().fillRegisterForm(user);
        app.getUser().clickOnRegisterButton();

        Assert.assertTrue(app.getUser().ifAccountLinkExists());
    }
}


//    @Test(dataProvider = "createNewAccount", dataProviderClass = DataProviders.class)
//    public void createNewAccountPositiveTestFromDataProvider(String email, String password,String confpassword, String firstname, String secondname) {
//
//        app.getUser().clickOnRegisterLink();
//        app.getUser().fillRegisterForm(new User()
//               .setEmail(email)
//                .setPassword(password)
//                .setPassword(confpassword)
//                .setFirstname(firstname)
//                .setSecondname(secondname));
//        app.getUser().clickOnRegisterButton();
//
//        Assert.assertTrue(app.getUser().ifAccountLinkExists());
//    }





