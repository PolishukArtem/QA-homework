package test;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import static org.junit.Assert.assertEquals;

class IsItOver {
    static String isItOver(int illPeople) {
        return (illPeople < 100) ? "Quarantine is over!" : "Quarantine is going on!";
    }
}

public class Stepdefs {
    private int illPeople;
    private String actualAnswer;
    private boolean isQuarantineOver = false;

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
        Assert.assertEquals(expectedAnswer, actualAnswer);
    }

    @Given("quarantine is over")
    public void quarantine_is_over() {
        isQuarantineOver = true;
    }

    @When("I ask whether i can go to cinema")
    public void can_i_go_to_the_cinema() {
        actualAnswer = (isQuarantineOver) ?  "\"Yes, you can!\"" : "\"Nope!\"";
    }

    @Then("I should be told '(.*?)'$")
    public void i_should_be_told_cinema(String expectedAnswer) {
        Assert.assertEquals(expectedAnswer, actualAnswer);
    }
}
