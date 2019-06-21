import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.ArrayList;

public class Testsample {
    public static WebDriver driver;
    public static void main(String[] args) throws IOException {

        Datadriven d = new Datadriven();
        ArrayList  data = d.getData( "Add Profile" );
        System.out.println(data.get( 0 ));
        System.out.println(data.get( 1 ));
        System.out.println(data.get( 2 ));
        System.out.println(data.get( 3 ));

        //driver.findElement( By.xpath( "sdsd" ) ).sendKeys( (CharSequence) data.get( 0 ) );

    }
}
