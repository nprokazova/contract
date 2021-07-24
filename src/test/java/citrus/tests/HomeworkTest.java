package citrus.tests;

import com.consol.citrus.annotations.CitrusTest;
import com.consol.citrus.context.TestContext;
import com.consol.citrus.dsl.testng.TestNGCitrusTestRunner;
import com.consol.citrus.http.client.HttpClient;
import com.consol.citrus.message.MessageType;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

public class HomeworkTest extends TestNGCitrusTestRunner {

    @Autowired
    private HttpClient restClient;
    private TestContext context;

    @Test(description = "Получение информации о первом пользователе")
    @CitrusTest
    public void getTestsActions1() {
        this.context = citrus.createTestContext();

        context.setVariable("id", "1");
        context.setVariable("email", "george.bluth@reqres.in");
        context.setVariable("firstName", "George");
        context.setVariable("lastName", "Bluth");
        context.setVariable("avatar", "https://reqres.in/img/faces/1-image.jpg");

        http(httpActionBuilder -> httpActionBuilder
                .client(restClient)
                .send()
                .get("users/" + context.getVariable("id"))
        );

        http(httpActionBuilder -> httpActionBuilder
                .client(restClient)
                .receive()
                .response()
                .messageType(MessageType.JSON)
                .payload("{\n" +
                        "   \"data\":{\n" +
                        "      \"id\":" + context.getVariable("id") + ",\n" +
                        "      \"email\":\"" + context.getVariable("email") + "\",\n" +
                        "      \"first_name\":\"" + context.getVariable("firstName") + "\",\n" +
                        "      \"last_name\":\"" + context.getVariable("lastName") + "\",\n" +
                        "      \"avatar\":\"" + context.getVariable("avatar") + "\"\n" +
                        "   },\n" +
                        "   \"support\":{\n" +
                        "      \"url\":\"https://reqres.in/#support-heading\",\n" +
                        "      \"text\":\"To keep ReqRes free, contributions towards server costs are appreciated!\"\n" +
                        "   }\n" +
                        "}")
        );
    }

    @Test(description = "Получение информации о втором пользователе")
    @CitrusTest
    public void getTestsAction2() {
        this.context = citrus.createTestContext();

        context.setVariable("id", "2");
        context.setVariable("email", "janet.weaver@reqres.in");
        context.setVariable("firstName", "Janet");
        context.setVariable("lastName", "Weaver");
        context.setVariable("avatar", "https://reqres.in/img/faces/2-image.jpg");

        http(httpActionBuilder -> httpActionBuilder
                .client(restClient)
                .send()
                .get("users/" + context.getVariable("id"))
        );

        http(httpActionBuilder -> httpActionBuilder
                .client(restClient)
                .receive()
                .response()
                .messageType(MessageType.JSON)
                .payload("{\n" +
                        "   \"data\":{\n" +
                        "      \"id\":" + context.getVariable("id") + ",\n" +
                        "      \"email\":\"" + context.getVariable("email") + "\",\n" +
                        "      \"first_name\":\"" + context.getVariable("firstName") + "\",\n" +
                        "      \"last_name\":\"" + context.getVariable("lastName") + "\",\n" +
                        "      \"avatar\":\"" + context.getVariable("avatar") + "\"\n" +
                        "   },\n" +
                        "   \"support\":{\n" +
                        "      \"url\":\"https://reqres.in/#support-heading\",\n" +
                        "      \"text\":\"To keep ReqRes free, contributions towards server costs are appreciated!\"\n" +
                        "   }\n" +
                        "}")
        );
    }

    @Test(description = "Получение информации о третьем пользователе")
    @CitrusTest
    public void getTestsActions3() {
        this.context = citrus.createTestContext();

        context.setVariable("id", "3");
        context.setVariable("email", "emma.wong@reqres.in");
        context.setVariable("firstName", "Emma");
        context.setVariable("lastName", "Wong");
        context.setVariable("avatar", "https://reqres.in/img/faces/3-image.jpg");

        http(httpActionBuilder -> httpActionBuilder
                .client(restClient)
                .send()
                .get("users/" + context.getVariable("id"))
        );

        http(httpActionBuilder -> httpActionBuilder
                .client(restClient)
                .receive()
                .response()
                .messageType(MessageType.JSON)
                .payload("{\n" +
                        "   \"data\":{\n" +
                        "      \"id\":" + context.getVariable("id") + ",\n" +
                        "      \"email\":\"" + context.getVariable("email") + "\",\n" +
                        "      \"first_name\":\"" + context.getVariable("firstName") + "\",\n" +
                        "      \"last_name\":\"" + context.getVariable("lastName") + "\",\n" +
                        "      \"avatar\":\"" + context.getVariable("avatar") + "\"\n" +
                        "   },\n" +
                        "   \"support\":{\n" +
                        "      \"url\":\"https://reqres.in/#support-heading\",\n" +
                        "      \"text\":\"To keep ReqRes free, contributions towards server costs are appreciated!\"\n" +
                        "   }\n" +
                        "}")
        );
    }

    @Test(description = "Получение информации о пользователе George Bluth")
    @CitrusTest
    public void getTestsActions4() {
        this.context = citrus.createTestContext();

        http(httpActionBuilder -> httpActionBuilder
                .client(restClient)
                .send()
                .get("users/1")
        );

        http(httpActionBuilder -> httpActionBuilder
                .client(restClient)
                .receive()
                .response()
                .messageType(MessageType.JSON)
                .payload("{\n" +
                        "   \"data\":{\n" +
                        "      \"id\":1,\n" +
                        "      \"email\":\"george.bluth@reqres.in\",\n" +
                        "      \"first_name\":\"George\",\n" +
                        "      \"last_name\":\"Bluth\",\n" +
                        "      \"avatar\":\"https://reqres.in/img/faces/1-image.jpg\"\n" +
                        "   },\n" +
                        "   \"support\":{\n" +
                        "      \"url\":\"https://reqres.in/#support-heading\",\n" +
                        "      \"text\":\"To keep ReqRes free, contributions towards server costs are appreciated!\"\n" +
                        "   }\n" +
                        "}")
        );
    }

    @Test(description = "Получение информации о пятом пользователе")
    @CitrusTest
    public void getTestsAction5() {
        this.context = citrus.createTestContext();

        context.setVariable("id", "5");
        context.setVariable("email", "charles.morris@reqres.in");
        context.setVariable("firstName", "Charles");
        context.setVariable("lastName", "Morris");
        context.setVariable("avatar", "https://reqres.in/img/faces/5-image.jpg");

        http(httpActionBuilder -> httpActionBuilder
                .client(restClient)
                .send()
                .get("users/" + context.getVariable("id"))
        );

        http(httpActionBuilder -> httpActionBuilder
                .client(restClient)
                .receive()
                .response()
                .messageType(MessageType.JSON)
                .payload("{\n" +
                        "   \"data\":{\n" +
                        "      \"id\":" + context.getVariable("id") + ",\n" +
                        "      \"email\":\"" + context.getVariable("email") + "\",\n" +
                        "      \"first_name\":\"" + context.getVariable("firstName") + "\",\n" +
                        "      \"last_name\":\"" + context.getVariable("lastName") + "\",\n" +
                        "      \"avatar\":\"" + context.getVariable("avatar") + "\"\n" +
                        "   },\n" +
                        "   \"support\":{\n" +
                        "      \"url\":\"https://reqres.in/#support-heading\",\n" +
                        "      \"text\":\"To keep ReqRes free, contributions towards server costs are appreciated!\"\n" +
                        "   }\n" +
                        "}")
        );
    }
}