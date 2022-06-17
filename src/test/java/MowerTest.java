import direction.Direction;
import lawn.Lawn;
import mower.Mower;
import mower.Mowers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MowerTest {

    @Test
    void given_the_mower_is_in_0_0_north_when_it_receive_command_A_it_then_it_should_be_in_0_1_north() {
        Lawn lawn = new Lawn(5, 5);
        //Given
        Mower mower = new Mower(0, 0, Direction.NORTH, lawn);
        //when
        Mower actualMower = mower.executeCommand("A");
        //Then
        assertThat(actualMower).isEqualTo(new Mower(0, 1, Direction.NORTH, lawn));

    }

    @ParameterizedTest
    @CsvSource({
            "0,1,2",
            "0,2,3",
            "0,3,4"})
    void test_parametric_given_the_mower_is_in_x_y_north_when_it_receive_A_then_it_should_be_in_x_expectedy_north(int x, int y, int expectedY) {
        Lawn lawn = new Lawn(5, 5);
        //Given
        Mower mower = new Mower(x, y, Direction.NORTH, lawn);
        //When
        Mower actualMower = mower.executeCommand("A");

        assertThat(actualMower).isEqualTo(new Mower(x, expectedY, Direction.NORTH, lawn));

    }

    @ParameterizedTest
    @CsvSource({
            "1,1,0",
            "2,2,1",
            "3,3,2"})
    void test_parametric_given_the_mower_is_in_x_y_west_when_it_receive_A_then_it_should_be_in_x_expectedx_west
            (int x, int y, int expectedX) {
        Lawn lawn = new Lawn(5, 5);
        //Given
        Mower mower = new Mower(x, y, Direction.WEST, lawn);
        //When
        Mower actualMower = mower.executeCommand("A");

        assertThat(actualMower).isEqualTo(new Mower(expectedX, y, Direction.WEST, lawn));

    }

    @ParameterizedTest
    @CsvSource({
            "1,1,2",
            "2,2,3",
            "3,3,4"})
    void test_parametric_given_the_mower_is_in_x_y_east_when_it_receive_A_then_it_should_be_in_x_expectedx_east
            (int x, int y, int expectedX) {
        Lawn lawn = new Lawn(5, 5);
        //Given
        Mower mower = new Mower(x, y, Direction.EAST, lawn);
        //When
        Mower actualMower = mower.executeCommand("A");

        assertThat(actualMower).isEqualTo(new Mower(expectedX, y, Direction.EAST, lawn));

    }

    @ParameterizedTest
    @CsvSource({
            "5,1,0",
            "5,2,1",
            "5,3,2"})
    void test_parametric_given_the_mower_is_in_x_y_south_when_it_receive_A_then_it_should_be_in_y_expectedx_south
            (int x, int y, int expectedY) {
        Lawn lawn = new Lawn(5, 5);
        //Given
        Mower mower = new Mower(x, y, Direction.SOUTH, lawn);
        //When
        Mower actualMower = mower.executeCommand("A");

        assertThat(actualMower).isEqualTo(new Mower(x, expectedY, Direction.SOUTH, lawn));

    }

    @Test
    void given_the_mower_is_in_1_3_north_when_it_turnLeft_then_it_should_be_in_1_3_west() {
        Lawn lawn = new Lawn(5, 5);
        //Given
        Mower mower = new Mower(1, 3, Direction.NORTH, lawn);
        //When
        Mower actualMower = mower.executeCommand("L");
        //Then
        assertThat(actualMower).isEqualTo(new Mower(1, 3, Direction.WEST, lawn));

    }

    @Test
    void given_the_mower_is_in_1_3_west_when_it_turnLeft_then_it_should_be_in_1_3_south() {
        Lawn lawn = new Lawn(5, 5);
        //Given
        Mower mower = new Mower(1, 3, Direction.WEST, lawn);
        //When
        Mower actualMower = mower.executeCommand("L");
        //Then
        assertThat(actualMower).isEqualTo(new Mower(1, 3, Direction.SOUTH, lawn));

    }

    @Test
    void given_the_mower_is_in_1_3_south_when_it_turnLeft_then_it_should_be_in_1_3_east() {
        Lawn lawn = new Lawn(5, 5);
        //Given
        Mower mower = new Mower(1, 3, Direction.SOUTH, lawn);
        //When
        Mower actualMower = mower.executeCommand("L");
        //Then
        assertThat(actualMower).isEqualTo(new Mower(1, 3, Direction.EAST, lawn));

    }

    @Test
    void given_the_mower_is_in_1_3_east_when_it_turnLeft_then_it_should_be_in_1_3_North() {
        Lawn lawn = new Lawn(5, 5);
        //Given
        Mower mower = new Mower(1, 3, Direction.EAST, lawn);
        //When
        Mower actualMower = mower.executeCommand("L");
        //Then
        assertThat(actualMower).isEqualTo(new Mower(1, 3, Direction.NORTH, lawn));

    }

    @Test
    void given_the_mower_is_in_1_3_north_when_it_turnRight_then_it_should_be_in_1_3_east() {
        Lawn lawn = new Lawn(5, 5);
        //Given
        Mower mower = new Mower(1, 3, Direction.NORTH, lawn);
        //When
        Mower actualMower = mower.executeCommand("R");
        //Then
        assertThat(actualMower).isEqualTo(new Mower(1, 3, Direction.EAST, lawn));

    }

    @Test
    void given_the_mower_is_in_1_3_east_when_it_turnRight_then_it_should_be_in_1_3_south() {
        Lawn lawn = new Lawn(5, 5);
        //Given
        Mower mower = new Mower(1, 3, Direction.EAST, lawn);
        //When
        Mower actualMower = mower.executeCommand("R");
        //Then
        assertThat(actualMower).isEqualTo(new Mower(1, 3, Direction.SOUTH, lawn));

    }

    @Test
    void given_the_mower_is_in_1_3_south_when_it_turnRight_then_it_should_be_in_1_3_west() {
        Lawn lawn = new Lawn(5, 5);
        //Given
        Mower mower = new Mower(1, 3, Direction.SOUTH, lawn);
        //When
        Mower actualMower = mower.executeCommand("R");
        //Then
        assertThat(actualMower).isEqualTo(new Mower(1, 3, Direction.WEST, lawn));

    }

    @Test
    void given_the_mower_is_in_1_3_west_when_it_turnRight_then_it_should_be_in_1_3_north() {
        Lawn lawn = new Lawn(5, 5);
        //Given
        Mower mower = new Mower(1, 3, Direction.WEST, lawn);
        //When
        Mower actualMower = mower.executeCommand("R");
        //Then
        assertThat(actualMower).isEqualTo(new Mower(1, 3, Direction.NORTH, lawn));

    }

    @Test
    void given_the_mower_is_in_4_3_north_when_it_receivecommand_LAA_then_it_should_be_in_1_3_north() {
        Lawn lawn = new Lawn(5, 5);
        //Given
        Mower mower = new Mower(4, 3, Direction.NORTH, lawn);
        //When
        Mower actualMower = mower.executeCommand("LAA");
        //Then
        assertThat(actualMower).isEqualTo(new Mower(2, 3, Direction.WEST, lawn));

    }

    @ParameterizedTest
    @CsvSource({
            "5,5,0",
            "4,7,0",
            "3,6,0"})
    void given_the_mower_is_in_x_y_north_when_it_receivecommand_LAAAAA_then_it_should_be_in_1_3_north(int x, int y, int expectedX) {
        Lawn lawn = new Lawn(5, 5);
        //Given
        Mower mower = new Mower(x, y, Direction.NORTH, lawn);
        //When
        Mower actualMower = mower.executeCommand("LAAAAA");
        //Then
        assertThat(actualMower).isEqualTo(new Mower(expectedX, y, Direction.WEST, lawn));

    }

    @Test
    void given_the_mower_is_in_a_lawn_5_5_and_its_position_is_1_1_north_when_it_receivecommand_LAA_then_it_should_be_in_0_1_west() {
        //Given
        Lawn lawn = new Lawn(5, 5);
        Mower mower = new Mower(1, 1, Direction.NORTH, lawn);


        //When
        Mower actualMower = mower.executeCommand("LAAAAA");
        //Then
        assertThat(actualMower).isEqualTo(new Mower(0, 1, Direction.WEST, lawn));

    }

    @Test
    void given_the_mower_is_in_a_lawn_5_5_and_its_position_is_1_1_north_when_it_receivecommand_AAAAA_then_it_should_be_in_1_5_north() {
        Lawn lawn = new Lawn(5, 5);
        //Given
        Mower mower = new Mower(1, 1, Direction.NORTH, lawn);


        //When
        Mower actualMower = mower.executeCommand("AAAAA");
        //Then
        assertThat(actualMower).isEqualTo(new Mower(1, 5, Direction.NORTH, lawn));

    }

    @Test
    void given_the_mower_is_in_a_lawn_5_5_and_its_position_is_1_1_south_when_it_receivecommand_AA_then_it_should_be_in_1_0_south() {
        Lawn lawn = new Lawn(5, 5);
        //Given
        Mower mower = new Mower(1, 1, Direction.SOUTH, lawn);

        //When
        Mower actualMower = mower.executeCommand("AAAAA");
        //Then
        assertThat(actualMower).isEqualTo(new Mower(1, 0, Direction.SOUTH, lawn));

    }




}
