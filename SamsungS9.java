import java.util.ArrayList;
import java.util.List;

public class SamsungS9 extends Samsung {
    private final double batteryLife = 15;
    private double tempBatteryLife = batteryLife;
    private final String imei = "25647874592547";
    private List<Contact> contactListS9 = new ArrayList<>();
    private List<Message> messageListS9 = new ArrayList<>();
    private List<Call> callListS9 = new ArrayList<>();

    public SamsungS9() {
        setColor("Coral Blue");
        setMaterial("Aluminum");
    }

    @Override
    public void addContact(String id, String phoneNumber, String firstName, String lastName) {
        contactListS9.add(new Contact(id, phoneNumber, firstName, lastName));
    }

    @Override
    public void listContacts() {
        System.out.println("Your contacts are: ");
        for (Contact c : contactListS9) {
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
            messageListS9.add(new Message(phoneNumber, messageContent));
        } else {
            System.out.println("Your battery percentage is too low to be able to send a message");
        }
    }


    @Override
    public Message listMessages(String phoneNumber) {
        System.out.println("Your messages are: ");
        Message result = null;
        for (Message sms : messageListS9) {
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
            callListS9.add(new Call(phoneNumber));
        } else {
            System.out.println("Your battery percentage is too low to be able to make a phone call");
        }
    }


    @Override
    public void viewHistory() {
        System.out.println("\nYour call history is: ");
        for (Call c1 : callListS9) {
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