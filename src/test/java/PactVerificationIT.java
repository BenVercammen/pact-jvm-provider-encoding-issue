import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;
import au.com.dius.pact.provider.spring.SpringRestPactRunner;
import au.com.dius.pact.provider.spring.target.SpringBootHttpTarget;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import pact.issue.Application;

@RunWith(SpringRestPactRunner.class)
@Provider("backend")
@PactFolder("pacts")
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT,
        classes = Application.class
)
public class PactVerificationIT {
    @TestTarget
    public final Target target = new SpringBootHttpTarget();

    @State("Address with ID exists")
    public void defaultState() {
        // Do nothing, our controller is not wired to any backend services...
    }

}
