package stepDefination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddtoCartStep {
	@Given("User Logs  into the system")
	public void user_logs_into_the_system() {
	    System.out.println("login in to system");
	}

	@When("User add {int} products to the cart")
	public void user_add_products_to_the_cart(Integer int1) {
		 System.out.println("added 5 products to cart");
	}

	@When("User add {int} th products to the cart")
	public void user_add_th_products_to_the_cart(Integer int1) {
		 System.out.println("added 6th product");
	}

	@Then("User will get error")
	public void user_will_get_error() {
		 System.out.println("error will occuerd");
	}
}
