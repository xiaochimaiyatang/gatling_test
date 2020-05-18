package basic

import io.gatling.http.Predef._
import io.gatling.core.Predef._

class MyFirstGatlingTest extends Simulation{
  val httpConf = http
    .baseURL("http://localhost:9090/api/getResume2")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .acceptEncodingHeader("gzip, deflate")
    .userAgentHeader("Mozilla/5.0 (Windows NT 5.1; rv:31.0) Gecko/20100101 Firefox/31.0")

  val scn = scenario("HomePageSimulation")
    .exec(http("Home page request")
      .get(""))
    .pause(5)

  setUp(
    scn.inject(atOnceUsers(10))
  ).protocols(httpConf)

}
