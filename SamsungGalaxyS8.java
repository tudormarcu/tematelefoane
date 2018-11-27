import java.util.ArrayList;
import java.util.List;

public class SamsungGalaxyS8 extends Samsung {
    private final double batteryLife = 25;
    private double tempBatteryLife = batteryLife;
    private final String imei = "255214698785214";
    private List<Contact> contactListS8 = new ArrayList<>();
    private List<Message> messageListS8 = new ArrayList<>();
    private List<Call> callListS8 = new ArrayList<>();

    public SamsungGalaxyS8() {
        setColor("Grey");
        setMaterial("Carbon Fiber");
    }

    @Override
    public void addContact(String id, String phoneNumber, String firstName, String lastName) {
        contactListS8.add(new Contact(id, phoneNumber, firstName, lastName));
    }

    @Override
    public void listContacts() {
        System.out.println("Your contacts are: ");
        for (Contact c : contactListS8) {
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
            messageListS8.add(new Message(phoneNumber, messageContent));
        } else {
            System.out.println("Your battery percentage is too low to be able to send a message");
        }
    }


    @Override
    public Message listMessages(String phoneNumber) {
        System.out.println("Your messages are: ");
        Message result = null;
        for (Message sms : messageListSix) {
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
        if (tempBatteryLife >= 2) {
            tempBatteryLife -= 2;
            callListS8.add(new Call(phoneNumber));
        } else {
            System.out.println("Your battery percentage is too low to be able to make a phone call");
        }
    }


    @Override
    public void viewHistory() {
        System.out.println("\nYour call history is: ");
        for (Call c1 : callListS8) {
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


