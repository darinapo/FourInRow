package Java.Events;

public enum EventsEnum {

    QUIT(1, "Bye Bye"),
    MOVE_PLAYED(2, "Player made move"),
    PLAYER_NAME_CHANGED(3, "Player name changed"),
    GAME_MODE_CHANGED(4, "Game Mode Changed"),
    GAME_QUIT(4, "Game quit"),
    WINNER(4, "We Have a winner");

    private final Integer key;
    private final String value;

    EventsEnum(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

    public Integer getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

}
