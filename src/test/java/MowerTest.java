import direction.Direction;
import mower.Mower;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MowerTest {
    @Test
    void given_the_mower_is_in_0_0_north_when_it_goes_receive_command_A_it_then_it_should_be_in_0_1_north() {
        //Given
        Mower mower= new Mower(0,0, Direction.NORTH);
        //when
        Mower actualMower=mower.receiveCommand("A");
        //Then
        assertThat(actualMower).isEqualTo(new Mower(0,1,Direction.NORTH));

    }
}
