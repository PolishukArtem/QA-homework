package test;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;

class IsItOver {
    static String isItOver(int illPeople) {
        return (illPeople<100)? "Quarantine is over!" : "Quarantine is going on!";
    }
}

class YesCan {
    static String yesCan(String Yes) {
        return "'Yes, you can!'";
    }
}

public class Stepdefs {
    private int illPeople;
    private String actualAnswer;
    private String Yes;
    private String secondAnswer;

    @Given("number of ill people is {int}")
    public void today_is(int illPeople) {
        this.illPeople = illPeople;
    }

    @When("I ask whether it's quarantine is over")
    public void i_ask_whether_it_is_over() {
        actualAnswer = IsItOver.isItOver(illPeople);
    }

    @Then("I should be told (.*)")
    public void i_should_be_told(String expectedAnswer) {
        assertEquals(expectedAnswer, actualAnswer);
    }

    @Given("quarantine is over")
    public void quarantine_is_over() {
        Yes = "Yes, you can!";
    }

    @When("I ask whether i can go to cinema")
    public void can_i_go_to_the_cinema() {
        secondAnswer = YesCan.yesCan(Yes);
    }

    @Then("I should say '(.*)'")
    public void i_should_be_told_cinema(String expectedAnswer2) {
        assertEquals(expectedAnswer2, secondAnswer);
    }
}
