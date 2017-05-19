package classicslot.app

import games.app.IntegrationTest
import io.restassured.RestAssured
import io.restassured.RestAssured.given
import io.restassured.http.ContentType
import org.hamcrest.Matchers.{equalTo, notNullValue}
import org.junit.{Before, Test}

class ClassicSlotControllerIT extends IntegrationTest(new classicslot.App) {
  @Before override def before(): Unit = {
    super.before()

    RestAssured.requestSpecification = spec
      .setBasePath("/api/games/classic-slot")
      .setContentType(ContentType.JSON)
      .setAccept(ContentType.JSON)
      .build()

    given()
      .when()
      .delete()
      .`then`()
      .statusCode(204)
  }

  @Test
  def get(): Unit = {
    given()
      .when()
      .get()
      .`then`()
      .statusCode(200)
      .body("stops[0]", equalTo(0))
      .body("stops[1]", equalTo(0))
      .body("stops[2]", equalTo(0))
  }

  @Test
  def spin(): Unit = {

    given()
      .body("{\"amount\": 10}")
      .when()
      .post("/spins")
      .`then`()
      .statusCode(201)
      .body("stops[0]", notNullValue())
      .body("stops[1]", notNullValue())
      .body("stops[0]", notNullValue())
      .body("balance", notNullValue())
  }
}
