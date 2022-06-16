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

        assertThat(actualMower).isEqualTo(new Mower(expectedX, y, Direction.WEST));

    }

    @ParameterizedTest
    @CsvSource({
            "1,1,2",
            "2,2,3",
            "3,3,4"})
    void test_parametric_given_the_mower_is_in_x_y_east_when_it_receive_A_then_it_should_be_in_x_expectedx_east
            (int x, int y, int expectedX) {
        //Given
        Mower mower = new Mower(x, y, Direction.EAST);
        //When
        Mower actualMower = mower.receiveCommand("A");

        assertThat(actualMower).isEqualTo(new Mower(expectedX, y, Direction.EAST));

    }

    @ParameterizedTest
    @CsvSource({
            "6,1,0",
            "5,2,1",
            "8,3,2"})
    void test_parametric_given_the_mower_is_in_x_y_south_when_it_receive_A_then_it_should_be_in_y_expectedx_south
            (int x, int y, int expectedY) {
        //Given
        Mower mower = new Mower(x, y, Direction.SOUTH);
        //When
        Mower actualMower = mower.receiveCommand("A");

        assertThat(actualMower).isEqualTo(new Mower(x, expectedY, Direction.SOUTH));

    }

    @Test
    void given_the_mower_is_in_1_3_north_when_it_turnLeft_then_it_should_be_in_1_3_west() {
        //Given
        Mower mower = new Mower(1, 3, Direction.NORTH);
        //When
        Mower actualMower = mower.receiveCommand("L");
        //Then
        assertThat(actualMower).isEqualTo(new Mower(1, 3, Direction.WEST));

    }

    @Test
    void given_the_mower_is_in_1_3_west_when_it_turnLeft_then_it_should_be_in_1_3_south() {
        //Given
        Mower mower = new Mower(1, 3, Direction.WEST);
        //When
        Mower actualMower = mower.receiveCommand("L");
        //Then
        assertThat(actualMower).isEqualTo(new Mower(1, 3, Direction.SOUTH));

    }

    @Test
    void given_the_mower_is_in_1_3_south_when_it_turnLeft_then_it_should_be_in_1_3_east() {
        //Given
        Mower mower = new Mower(1, 3, Direction.SOUTH);
        //When
        Mower actualMower = mower.receiveCommand("L");
        //Then
        assertThat(actualMower).isEqualTo(new Mower(1, 3, Direction.EAST));

    }

    @Test
    void given_the_mower_is_in_1_3_east_when_it_turnLeft_then_it_should_be_in_1_3_North() {
        //Given
        Mower mower = new Mower(1, 3, Direction.EAST);
        //When
        Mower actualMower = mower.receiveCommand("L");
        //Then
        assertThat(actualMower).isEqualTo(new Mower(1, 3, Direction.NORTH));

    }

    @Test
    void given_the_mower_is_in_1_3_north_when_it_turnRight_then_it_should_be_in_1_3_east() {
        //Given
        Mower mower = new Mower(1, 3, Direction.NORTH);
        //When
        Mower actualMower = mower.receiveCommand("R");
        //Then
        assertThat(actualMower).isEqualTo(new Mower(1, 3, Direction.EAST));

    }

    @Test
    void given_the_mower_is_in_1_3_east_when_it_turnRight_then_it_should_be_in_1_3_south() {
        //Given
        Mower mower = new Mower(1, 3, Direction.EAST);
        //When
        Mower actualMower = mower.receiveCommand("R");
        //Then
        assertThat(actualMower).isEqualTo(new Mower(1, 3, Direction.SOUTH));

    }

    @Test
    void given_the_mower_is_in_1_3_south_when_it_turnRight_then_it_should_be_in_1_3_west() {
        //Given
        Mower mower = new Mower(1, 3, Direction.SOUTH);
        //When
        Mower actualMower = mower.receiveCommand("R");
        //Then
        assertThat(actualMower).isEqualTo(new Mower(1, 3, Direction.WEST));

    }

    @Test
    void given_the_mower_is_in_1_3_west_when_it_turnRight_then_it_should_be_in_1_3_north() {
        //Given
        Mower mower = new Mower(1, 3, Direction.WEST);
        //When
        Mower actualMower = mower.receiveCommand("R");
        //Then
        assertThat(actualMower).isEqualTo(new Mower(1, 3, Direction.NORTH));

    }

    @Test
    void given_the_mower_is_in_4_3_north_when_it_receivecommand_LAA_then_it_should_be_in_1_3_north() {
        //Given
        Mower mower = new Mower(4, 3, Direction.NORTH);
        //When
        Mower actualMower = mower.receiveCommand("LAA");
        //Then
        assertThat(actualMower).isEqualTo(new Mower(2, 3, Direction.WEST));

    }


}
