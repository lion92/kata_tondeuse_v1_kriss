import direction.Direction;
import mower.Mower;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class MowerTest {
    @Test
    void given_the_mower_is_in_0_0_north_when_it_receive_command_A_it_then_it_should_be_in_0_1_north() {
        //Given
        Mower mower = new Mower(0, 0, Direction.NORTH);
        //when
        Mower actualMower = mower.receiveCommand("A");
        //Then
        assertThat(actualMower).isEqualTo(new Mower(0, 1, Direction.NORTH));

    }

    @ParameterizedTest
    @CsvSource({
            "0,1,2",
            "0,2,3",
            "0,3,4"})
    void test_parametric_given_the_mower_is_in_x_y_north_when_it_receive_A_then_it_should_be_in_x_expectedy_north(int x, int y, int expectedY) {
        //Given
        Mower mower = new Mower(x, y, Direction.NORTH);
        //When
        Mower actualMower = mower.receiveCommand("A");

        assertThat(actualMower).isEqualTo(new Mower(x, expectedY, Direction.NORTH));

    }

    @ParameterizedTest
    @CsvSource({
            "1,1,0",
            "2,2,1",
            "3,3,2"})
    void test_parametric_given_the_mower_is_in_x_y_west_when_it_receive_A_then_it_should_be_in_x_expectedx_west
            (int x, int y, int expectedX) {
        //Given
        Mower mower = new Mower(x, y, Direction.WEST);
        //When
        Mower actualMower = mower.receiveCommand("A");

        assertThat(actualMower).isEqualTo(new Mower(expectedX,y, Direction.WEST));

    }



}
