import com.exercise.VowelCount;
import com.sun.jdi.Value;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StepsDefinitions {
    String[] myArgs;
    LinkedHashMap result;

    @Given("I provide valid input")
    public void provide_valid_input(DataTable testData) {
        provideInput(testData);
    }

    @Given("I provide invalid input")
    public void provide_invalid_input(DataTable testData) {
        provideInput(testData);
    }

    @When("I am calling the application")
    public void call_the_application() {
        //call application
        result = (LinkedHashMap) VowelCount.main(myArgs);
    }

    @Then("I expect no results")
    public void assert_no_result() {
        assertNull(result);
    }

    @Then("I expect correct results")
    public void assert_correct_results(DataTable expectedData) {
        List<List<Object>> actualResultList = getActualResultListFromResult(result);
        List<List<String>> expectedDataInList = expectedData.asLists(String.class);

        assertResultEqualsExpected(expectedDataInList, actualResultList);
    }

    private void assertResultEqualsExpected(List<List<String>> expectedDataInList, List<List<Object>> actualResultList) {
        for (int i = 0; i < expectedDataInList.size(); i++) {
            for (int j = 0; j < 3; j++) {
                Assert.assertEquals(actualResultList.get(i).get(j).toString(), expectedDataInList.get(i).get(j));
            }
        }
    }

    private List<List<Object>> getActualResultListFromResult(LinkedHashMap result) {
        assertNotNull(result);
        List<List<Object>> actualResultList = new ArrayList<List<Object>>();
        result.forEach(
                (key, value) -> {
                    List partialResult = new ArrayList();
                    partialResult.add(key);
                    LinkedHashMap val = (LinkedHashMap) value;
                    val.forEach((k, v) -> {
                        partialResult.add(v);
                        partialResult.add(k);
                    });
                    actualResultList.add(partialResult);
        });
        return actualResultList;
    }

    private void provideInput(DataTable testData) {
        myArgs = new String[testData.asLists(String.class).size()];
        for (int i = 0; i < testData.asLists(String.class).size(); i++) {
            myArgs[i] = String.valueOf(testData.asLists(String.class).get(i).get(0));
        }
    }
}
