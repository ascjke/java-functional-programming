package ru.borisov.patterns.command;

class Main {

    public static void main(String[] args) {
        Speaker speaker = new SpeakerImpl();

        Player app = new Player();

//        app.add(new Play(speaker));
//        app.add(new VolumeUp(speaker));
//        app.add(new VolumeUp(speaker));
//        app.add(new VolumeDown(speaker));
//        app.add(new VolumeDown(speaker));
//        app.add(new Pause(speaker));

        app.add(speaker::play);
        app.add(speaker::volumeUp);
        app.add(speaker::volumeUp);
        app.add(speaker::volumeDown);
        app.add(speaker::volumeDown);
        app.add(speaker::pause);

        app.run();
    }
}
