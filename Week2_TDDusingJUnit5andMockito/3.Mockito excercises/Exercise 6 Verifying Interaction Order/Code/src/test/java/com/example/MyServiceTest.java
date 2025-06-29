package com.example;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import static org.mockito.Mockito.*;

public class MyServiceTest {

    @Test
    public void testInteractionOrder() {
        ExternalApi mockApi = mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        service.executeSteps();

        InOrder inOrder = inOrder(mockApi);
        inOrder.verify(mockApi).stepOne();
        inOrder.verify(mockApi).stepTwo();
    }
}
