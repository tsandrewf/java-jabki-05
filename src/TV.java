public class TV {
    private int currentChannel;
    private int volume;

    public int getCurrentChannel() {
        return currentChannel;
    }

    public void setCurrentChannel(int currentChannel) {
        if ((currentChannel >= 1) && (currentChannel <= 50)) {
            this.currentChannel = currentChannel;
        }
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        if ((volume >= 0) && (volume <= 100)) {
            this.volume = volume;
        }
    }

    public void nextChannel() {
        //setCurrentChannel(Math.min(this.currentChannel + 1, 100));
        //setCurrentChannel((this.currentChannel + 1) % 50);
        //setCurrentChannel(this.currentChannel + 1);
        //setCurrentChannel(((this.currentChannel) % 50) + 1);
        this.currentChannel = (this.currentChannel % 50) + 1;
    }
}
