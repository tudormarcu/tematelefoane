import java.util.ArrayList;
import java.util.List;

public class iPhone X extends iPhone {
    private final double batteryLife = 12;
    private double tempBatteryLife = batteryLife;
    private final String imei = "25478965412367";
    private List<Contact> contactListX = new ArrayList<>();
    private List<Message> messageListX = new ArrayList<>();
    private List<Call> callListX = new ArrayList<>();

    public iPhoneX() {
        setColor("Matt Grey");
        setMaterial("Aluminum");
    }

    @Override
    public void addContact(String id, String phoneNumber, String firstName, String lastName) {
        contactListX.add(new Contact(id, phoneNumber, firstName, lastName));
    }

    @Override
    public void listContacts() {
        System.out.println("Your contacts are: ");
        for (Contact c : contactListX) {
            System.out.println(c.getInfo());
        }
        System.out.println("");
    }

    @Override
    public void sendMessage(String phoneNumber, String messageContent) {
        if (tempBatteryLife >= 1) {
            tempBatteryLife -= 1;
            int maxLenght = 100;
            if (messageContent.length() > maxLenght) {
                System.out.println("The maximum number of characters allowed in a message should be 100");
                messageContent = messageContent.substring(0, maxLenght);
            }
            messageListX.add(new Message(phoneNumber, messageContent));
        } else {
            System.out.println("Your battery percentage is too low to be able to send a message");
        }
    }


    @Override
    public Message listMessages(String phoneNumber) {
        System.out.println("Your messages are: ");
        Message result = null;
        for (Message sms : messageListX) {
            if (sms.getPhoneNumber().equalsIgnoreCase(phoneNumber)) {
                result = sms;
                System.out.println(sms.getMessageContent());
            }
            System.out.println("");
        }

        return result;

    }

    @Override
    public void call(String phoneNumber) {
        if (tempBatteryLife >= 5) {
            tempBatteryLife -= 5;
            callListX.add(new Call(phoneNumber));
        } else {
            System.out.println("Your battery percentage is too low to be able to make a phone call");
        }
    }


    @Override
    public void viewHistory() {
        System.out.println("\nYour call history is: ");
        for (Call c1 : callListX) {
            System.out.println(c1.getCalls());
        }
        System.out.println("");
    }

    public double getBatteryLife() {
        return tempBatteryLife;
    }

    @Override
    public String toString() {
        return getColor() + getMaterial();
    }
}