public class Main {

    public static void main(String[] args) {
        Phone phone = new SamsungS9();

        phone.addContact("1", "0786644777", "Tudor", "Marcu");
        phone.addContact("2", "0723381279", "Cica", "Marcu");
        phone.listContacts();

        // send a message to the first contact from the previous listed
        // max number of characters - 100
        phone.sendMessage("0786644777", "Don't forget to upload your homework by 12 o'clock !");
        phone.listMessages("0786644777");


        // send a message to the second contact from the previous listed
        phone.call("0723381279");
        phone.viewHistory();

        System.out.println("Battery life: " + phone.getBatteryLife());
        System.out.println("Color: " + phone.getColor());
        System.out.println("Material: " + phone.getMaterial());
    }

}
