package com.company.examplefortests.firstexample;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class ExampleTest {


    //Spy+Dummy
    @Test
    public void testDoSomethingAndReturnString() {
        //Given
        Random dummyRandom = mock(Random.class);
        Example spyExampleEntity = spy(new Example(dummyRandom));

        //When
        String actual = spyExampleEntity.getStringUpperCase("string input");

        //Then
        assertEquals("STRING INPUT", actual);
        verify(spyExampleEntity, atLeastOnce()).getStringUpperCase("string input");
    }

    //Stub
    @Test
    public void testGetRandom() {
        //Given
        Random stubRandom = mock(Random.class);
        when(stubRandom.nextInt()).thenReturn(3);
        Example example = new Example(stubRandom);

        //When
        Integer actual = example.getRandomIntInPower(3);

        //Then
        assertEquals(27, actual);
    }


}
