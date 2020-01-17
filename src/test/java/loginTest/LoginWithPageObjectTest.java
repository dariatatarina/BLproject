package loginTest;

import abstractParentTest.AbstractParentTest;
import jdk.nashorn.internal.ir.CallNode;
import org.junit.Test;

public class LoginWithPageObjectTest extends AbstractParentTest {
    @Test
    public void validLogin (){
    loginPage.openPage ();
    loginPage.enterEmailInToEmailAddress ("dtautotest@gmail.com");
    loginPage.enterPassInToPassword ("90609060");
    loginPage.clickOnButtonLogin ();

    checkExpectedResult("Avatar is not present", clientAndLocation.isAvatarDisplayed());



    }

}
