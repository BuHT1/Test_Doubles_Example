package com.company.examplefortests.secondexample;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class SecurityServiceTest {

    //Mock
    @Test
    public void testSecurityOnOff() {
        //Given
        Door mockDoor = mock(Door.class);
        Window mockWindow = mock(Window.class);
        SecurityService service=new SecurityService(mockDoor,mockWindow);

        //When
        service.securityOff();
        service.securityOn();

        //Then
        verify(mockDoor,atLeastOnce()).close();
        verify(mockWindow,atLeastOnce()).close();
        verify(mockDoor,atLeastOnce()).open();
        verify(mockWindow,atLeastOnce()).open();
    }
}
