public class BridgePattern {

    public static void main(String[] args) {
        TV sonyTV = new Sony(new OldRemote());
        sonyTV.on();
        sonyTV.off();

        TV samsungTV = new Samsung(new NewRemote());
        samsungTV.on();
        samsungTV.off();
    }
}

interface Remote {
    void on();

    void off();
}

class OldRemote implements Remote {
    @Override
    public void on() {
        System.out.println("Old Remote - ON");
    }

    @Override
    public void off() {
        System.out.println("Old Remote - OFF");
    }
}

class NewRemote implements Remote {
    @Override
    public void on() {
        System.out.println("New Remote - ON");
    }

    @Override
    public void off() {
        System.out.println("New Remote - OFF");
    }
}

abstract class TV {
    Remote remote;

    TV(Remote remote) {
        this.remote = remote;
    }

    abstract void on();

    abstract void off();
}

class Sony extends TV {

    Remote remoteType;

    Sony(Remote remote) {
        super(remote);
        this.remoteType = remote;
    }

    @Override
    void on() {
        System.out.println("Welcome - Sony TV");
        remoteType.on();
    }

    @Override
    void off() {
        System.out.println("Shutdown - Sony TV");
        remoteType.off();
    }
}

class Samsung extends TV {

    Remote remoteType;

    Samsung(Remote remote) {
        super(remote);
        this.remoteType = remote;
    }

    @Override
    void on() {
        System.out.println("Welcome - Samsung TV");
        remoteType.on();

    }

    @Override
    void off() {
        System.out.println("Shutdown - Samsung TV");
        remoteType.off();
    }
}
