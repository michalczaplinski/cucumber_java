/***
 * Excerpted from "The Cucumber for Java Book",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/srjcuc for more book information.
***/
package nicebank;

import cucumber.api.java.en.*;
import cucumber.api.PendingException;
import cucumber.api.Transform;

import org.junit.*;

import transforms.MoneyConverter;

public class Steps {

    class Account {
        private Money balance = new Money();

        public void deposit(Money amount) {
            balance = balance.add(amount);
        }

        public Money getBalance() {
          return balance;
        }
    }

    class Teller {
        public void withdrawFrom(Account account, int dollars) {

        }
    }

    @Given("^I have deposited (\\$\\d+\\.\\d+) in my account$")
    public void iHaveDeposited$InMyAccount(
                                  @Transform(MoneyConverter.class) Money amount) 
                                                                throws Throwable {
        Account myAccount = new Account();
        myAccount.deposit(amount);

        Assert.assertEquals("Incorrect account balance -", 
                                amount, myAccount.getBalance()); 
    }

    @When("^I withdraw \\$(\\d+)$")
    public void iWithdraw$(int dollars) throws Throwable {
        Teller teller = new Teller();
        teller.withdrawFrom(myAccount, dollars);
    }

    @Then("^\\$(\\d+) should be dispensed$")
    public void $ShouldBeDispensed(int arg1) throws Throwable {
      // Write code here that turns the phrase above into concrete actions
      throw new PendingException();
    }
}