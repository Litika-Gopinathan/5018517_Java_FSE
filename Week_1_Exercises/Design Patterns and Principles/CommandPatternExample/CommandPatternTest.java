
public class CommandPatternTest {
    public static void main(String[] args) {
        Light livingRoomLight = new Light();

        Command lightOn = new LightOnCommand(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);

        RemoteControl remoteControl = new RemoteControl();

        // Turn on the light
        remoteControl.setCommand(lightOn);
        remoteControl.pressButton();

        // Turn off the light
        remoteControl.setCommand(lightOff);
        remoteControl.pressButton();
        
        // Turn off the light
        remoteControl.setCommand(lightOff);
        remoteControl.pressButton();
        
        // Turn on the light
        remoteControl.setCommand(lightOn);
        remoteControl.pressButton();
    }
}

