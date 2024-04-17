package com.demowebshop.utils;

import com.demowebshop.models.User;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {
//    @DataProvider
//    public Iterator<Object[]> createNewAccount() {
//
//        List<Object[]> list = new ArrayList<>();
//        list.add(new Object[]{"akuna7@mata.ta", "Africa2024", "Africa2024", "Akuna", "Matata"});
//        list.add(new Object[]{"akuna8@mata.ta", "Africa2024", "Africa2024", "Akuna", "Matata"});
//        list.add(new Object[]{"akuna9@mata.ta", "Africa2024", "Africa2024", "Akuna", "Matata"});
//
//        return list.iterator();
//    }

    @DataProvider
    public Iterator<Object[]> createNewAccountFromCsvFile() throws IOException {
        List<Object[]> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/userdata.csv")));
        String line = reader.readLine();
        while (line != null) {
            String[] split = line.split(",");
            list.add(new Object[]{new User()
                    .setEmail(split[0]).setPassword(split[1]).setPassword(split[2]).setFirstname(split[3]).setSecondname(split[4])  } );

            line = reader.readLine();
        }
        return list.iterator();
    }
}
