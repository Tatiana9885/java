package example;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.testit.annotations.*;
import ru.testit.models.LinkType;
import ru.testit.services.Adapter;


public class MainTest {

    @Test
    @ExternalId("Testng externalid")
    @DisplayName("Testng displayname")
    @Title("Testng title")
    @Links(links={@Link(url = "https://test01.example", type = LinkType.REQUIREMENT),})
    public void test_1() {
        Assert.assertTrue(true);
        stepWithParams("password", 456);
        stepWithoutParams();
    }

    @Step
    @Title("Step 1 with params: {arg0}, {arg1}")
    @Description("Step 1 description and params: {arg0}, {arg1}")
    private void stepWithParams(String arg0, int arg1) {
        Assert.assertTrue(true);
        Adapter.addAttachments("./attachments/Screenshot_4.png");
        Adapter.addMessage("Message");
    }

    @Step
    @Title("Step 2 empty")
    @Description("Step 2 description")
    private void stepWithoutParams() {
        Assert.assertTrue(true);
        Adapter.addAttachments("./attachments/text.txt");
        Adapter.addLinks("https://google.com", "google", "search page", LinkType.RELATED);
    }
}
