package helper.assertors;

import java.util.ArrayList;
import java.util.List;

public class WebElementOrderingAssertor {

	private String idOfParentWebElement;

	public WebElementOrderingAssertor(String idOfParentWebElement) {
		this.idOfParentWebElement = idOfParentWebElement;
	}

	public WebElementOrderingAssertor() {
		// TODO Auto-generated constructor stub
	}



	private List<String> getModifiableIdListOfExpectedChildElements(List<String> elementIds) {
		List<String> ids = new ArrayList<>();
		for (String elementId : elementIds) {
			ids.add(elementId);
		}
		return ids;
	}


}
