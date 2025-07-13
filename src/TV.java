public class TV {
    private int currentChannel, volume;

    public int getCurrentChannel() {
        return currentChannel;
    }

    public void setCurrentChannel(int currentChannel) {
        if ((0 <= currentChannel) && (100 >= currentChannel)) {
            this.currentChannel = currentChannel;
        }
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        if ((1 <= volume) && (50 >= volume)) {
            this.volume = volume;
        }
    }

    public void nextChannel() {
        setCurrentChannel(Math.min(currentChannel + 1, 100));
    }
}
