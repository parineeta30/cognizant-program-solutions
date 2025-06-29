package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class MyServiceTest {

    @Test
    public void testVoidMethodThrowsException() {
        ExternalApi mockApi = mock(ExternalApi.class);
        doThrow(new RuntimeException("Failure")).when(mockApi).riskyOperation();

        MyService service = new MyService(mockApi);

        assertThrows(RuntimeException.class, service::perform);
        verify(mockApi).riskyOperation();
    }
}
