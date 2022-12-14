package liftvr;

import static org.assertj.core.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import static liftvr.Direction.*;
import static liftvr.LiftEngineCommand.GO_DOWN;
import static liftvr.LiftEngineCommand.GO_UP;
import static liftvr.LiftEngineCommand.OPEN_DOORS;

public class LiftTest {

	private LiftController lift = new LiftController(0);

	@Test
	void testDisplayGroundFloorIfStarting0() throws Exception {
		assertThat(lift.getCurrentFloor()).isEqualTo(0);
	}

	@Test
	void testDisplayFirsFloorIfStarting1() throws Exception {
		assertThat(new LiftController(1).getCurrentFloor()).isEqualTo(1);
	}
	
	@Test
	void testDisplayItGoesUpWhenCalledFromAbove() throws Exception {
		lift.call(new Call(2));
		assertThat(lift.getCurrentDirection()).hasValue(UP);
	}
	
	@Test
	void testDisplayNoDirection_initially() throws Exception {
		LiftController lift = new LiftController(0);
		assertThat(lift.getCurrentDirection()).isEmpty();
	}
	
	@Test
	void testDisplayNoDirection_whenCalledFromTheSomeFloor() throws Exception {
		LiftController lift = new LiftController(1);
		lift.call(new Call(1));
		assertThat(lift.getCurrentDirection()).isEmpty();
	}
	
	@Test
	void testRequestToGoUp_whenCalledFromAbove() throws Exception {
		Optional<LiftEngineCommand> command = lift.call(new Call(1));
		assertThat(command).hasValue(GO_UP);
	}
	
	@Test
	void testOpensDoorWhenCalledFromTheCurrentFloor() throws Exception {
		Optional<LiftEngineCommand> command = lift.call(new Call(0, UP));
		assertThat(command).hasValue(OPEN_DOORS);
	}

	@Test
	void testRequestToGoDown_whenCalledFromBellow() throws Exception {
		Optional<LiftEngineCommand> command = lift.call(new Call(-1));
		assertThat(command).hasValue(GO_DOWN);
	}
	
	@Test
	void testDisplaysFirstFlorr_afterOnFloorOnc() throws Exception {
		lift.call(new Call(1));
		lift.onFloor();
		assertThat(lift.getCurrentFloor()).isEqualTo(1);
	}

	@Test
	void testDisplaysMinusOneFlorr_afterGoingDown() throws Exception {
		lift.call(new Call(-1));
		lift.onFloor();
		assertThat(lift.getCurrentFloor()).isEqualTo(-1);
	}
	
	@Test
	void testReachesTheSecondFloorWhenCalledFromThere() throws Exception {
		lift.call(new Call(2));
		assertThat(lift.onFloor()).isEqualTo(GO_UP);
		assertThat(lift.onFloor()).isEqualTo(OPEN_DOORS);
	}
	
	@Test
	void testReachesTheMinusSecondFloorWhenCalledFromThere() throws Exception {
		lift.call(new Call(-2));
		assertThat(lift.onFloor()).isEqualTo(GO_DOWN);
		assertThat(lift.onFloor()).isEqualTo(OPEN_DOORS);
	}
	
	@Test
	void testDisplaysREquestedToGoToFirstFloorWenRequestedTOGoThere() throws Exception {
		lift.call(new Call(1));
		assertThat(lift.getNextCalls()).containsExactly(new Call(1));
	}
	
	@Test
	void testDisplaysCallesdFromFirstFloorWenCalledFromThere() throws Exception {
		lift.call(new Call(1, UP));
		assertThat(lift.getNextCalls()).containsExactly(new Call(1, UP));
	}
	
	@Test
	void testInitiallyThereAreNotCallsInTheList() throws Exception {
		assertThat(lift.getNextCalls()).isEmpty();
	}
	
	@Test
	void testTheFloorRemovedFromNextCallsAfterReachingThatFloorUp() throws Exception {
		lift.call(new Call(1));
		lift.onFloor();
		assertThat(lift.getNextCalls()).isEmpty();
	}

	@Test
	void testTheFloorRemovedFromNextCallsAfterReachingThatFloorDown() throws Exception {
		lift.call(new Call(-1));
		lift.onFloor();
		assertThat(lift.getNextCalls()).isEmpty();
	}
	
}
