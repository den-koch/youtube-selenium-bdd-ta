package services;

import model.SearchTestData;
import model.UserTestData;
import utils.DataReader;

public class SearchTestDataService {

    public static SearchTestData getTestDataFromProperties(){
        return new SearchTestData(
                Integer.valueOf(
                        DataReader.getTestData("testdata.video.position")),
                DataReader.getTestData("testdata.search.request"),
                DataReader.getTestData("testdata.button.text.subscribed")
        );
    }

}
