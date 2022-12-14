package lifteb;

import static org.approvaltests.Approvals.verify;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

public class LiftSystemTest {

    private LiftSystemPrinter liftSystemPrinter  = new LiftSystemPrinter();

    private String tickAndVerify(LiftSystem lifts, String toVerify) {
    	lifts.tick();
    	toVerify += "\n\n";
    	toVerify += liftSystemPrinter.print(lifts);
    	return toVerify;
    }
    
	@Test
    public void fulFillRequest() {
        List<Integer> request = new ArrayList<>();
        request.add(3);
		Lift liftA = new Lift("A", 0, request, false);
        LiftSystem lifts = new LiftSystem(Arrays.asList(0, 1, 2, 3), Collections.singletonList(liftA), Collections.emptyList());
        String toVerify = liftSystemPrinter.print(lifts);
        toVerify = tickAndVerify(lifts, toVerify);
        toVerify = tickAndVerify(lifts, toVerify);

        verify(toVerify);
    }

    @Test
    public void idleLift() {
    	Lift liftA = new Lift("A", 0);
    	LiftSystem lifts = new LiftSystem(Arrays.asList(0, 1, 2, 3), Collections.singletonList(liftA), Collections.emptyList());
    	String toVerify = liftSystemPrinter.print(lifts);
    	toVerify = tickAndVerify(lifts, toVerify);
    	
    	verify(toVerify);
    }

	@Test
    public void fulFillTwoRequestGoingDown() {
        List<Integer> request = new ArrayList<>();
        request.add(2);
        request.add(0);
		Lift liftA = new Lift("A", 3, request, false);
        LiftSystem lifts = new LiftSystem(Arrays.asList(0, 1, 2, 3), Collections.singletonList(liftA), Collections.emptyList());
        String toVerify = liftSystemPrinter.print(lifts);
        toVerify = tickAndVerify(lifts, toVerify);
        toVerify = tickAndVerify(lifts, toVerify);
        toVerify = tickAndVerify(lifts, toVerify);

        verify(toVerify);
    }

}
