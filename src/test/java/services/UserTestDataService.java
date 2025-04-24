package services;

import model.UserTestData;
import utils.DataReader;

public class UserTestDataService {

    public static UserTestData getTestDataFromProperties(){
        return new UserTestData(
                DataReader.getTestData("testdata.email"),
                DataReader.getTestData("testdata.password")
        );
    }

}
