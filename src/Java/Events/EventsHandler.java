package Java.Events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventsHandler {
    private Map<EventsEnum, List<EventsListener>> eventListenersMap;
    private static EventsHandler eventsHandler = null;

    private EventsHandler() {
        eventListenersMap = new HashMap<EventsEnum, List<EventsListener>>();
    }

    public static EventsHandler getInstance(){
        if(eventsHandler == null){
            synchronized (EventsHandler.class) {
                if(eventsHandler == null){
                    eventsHandler = new EventsHandler();
                }
            }
        }
        return eventsHandler;
    }

    public void registerEvent(EventsEnum event, EventsListener listener) {
        if (eventListenersMap.get(event) == null) {
            List<EventsListener> eventListener = new ArrayList<EventsListener>();
            eventListener.add(listener);
            eventListenersMap.put(event, eventListener);
        }else {
            eventListenersMap.get(event).add(listener);
        }
    }

    public void notifyEvent(EventsEnum event) {
        for (EventsListener listener: eventListenersMap.get(event)) {
            listener.update(event);
        }
    }
}
