package Tests.Events;

import Java.Connections.TerminalConnection;
import Java.Events.EventsHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EventsHandlerTest {

    @Test
    void getInstance() {
        EventsHandler event = EventsHandler.getInstance();
        Assertions.assertEquals(event,EventsHandler.getInstance());
    }

}