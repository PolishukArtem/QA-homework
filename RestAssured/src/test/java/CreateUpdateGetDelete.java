import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;

public class CreateUpdateGetDelete {

    @Test
    public void users()
    {
        //create users
        RestAssured.given().contentType(ContentType.JSON).with().body(InputValues.CreateUserList).when().post("https://petstore.swagger.io/v2/user/createWithList");
        //get user 1
        RestAssured.given().when().get("https://petstore.swagger.io/v2/user/ahsoka")
                .then().assertThat()
                .contentType(ContentType.JSON)
                .body("id",equalTo(1))
                .and()
                .body("username",equalTo("ahsoka"));
        //get user 2
        RestAssured.given().when().get("https://petstore.swagger.io/v2/user/Nawezac")
                .then().assertThat()
                .contentType(ContentType.JSON)
                .body("id",equalTo(2))
                .and()
                .body("username",equalTo("Nawezac"));
        //update user 2
        RestAssured.given().contentType(ContentType.JSON).with().body(InputValues.UpdateUser).when().put("https://petstore.swagger.io/v2/user/Nawezac");
        //get updated user
        RestAssured.given().when().get("https://petstore.swagger.io/v2/user/CazeOne")
                .then().assertThat()
                .contentType(ContentType.JSON)
                .body("id",equalTo(2))
                .and()
                .body("username",equalTo("CazeOne"));
        //delete users
        RestAssured.given().delete("https://petstore.swagger.io/v2/user/ahsoka", new Object[0]);
        RestAssured.given().delete("https://petstore.swagger.io/v2/user/CazeOne", new Object[0]);
    }
}

