import java.util.Vector;

public class ClientGenerator {
    public static void main(String[] args) {
        Generator.randomGenerate();;
    }
    static class Client {
        Integer ID;
        String name;
        String surname;
        String patronymicName;
        String address;
        Vector<String> phones;
        Vector<String> emails;

        Client (Integer ID, String name, String surname, String patronymicName, String address, Vector<String> phones, Vector<String> emails) {
            this.ID=ID;
            this.name=name;
            this.surname=surname;
            this.patronymicName=patronymicName;
            this.address=address;
            this.phones=phones;
            this.emails=emails;
        }
    }
    static class Generator {
        public static void randomGenerate() {
            Integer ID = rnd(1000, 100000); //возможно будут генериться одинаковые, но
            String name = "name" + String.valueOf(ID);
            String surname = "surname" + String.valueOf(ID);
            String patronymicName = "patron" + String.valueOf(ID);
            String address = "address"+String.valueOf(ID);
            Integer numOfPhones = rnd(2, 3);
            Vector<String> phones = new Vector<String>(numOfPhones);
            for (int i = 0; i < numOfPhones; i++) {
                phones.add(i, "+7(9" + String.valueOf(rnd(10, 99)) + ")" + String.valueOf(rnd(100, 999)) + "-" + String.valueOf(rnd(10, 99)) + "-" + String.valueOf(rnd(10, 99)));
            }
            Vector<String> emails = new Vector<String>(numOfPhones); //для простоты
            for (int i = 0; i < numOfPhones; i++) {
                emails.add(i, String.valueOf(ID)+ "-" + rnd(1,8)+"@sber.ru");
            }
            //return new Client(ID, name, surname, patronymicName, address, phones, emails);
            Client client = new Client(ID, name, surname, patronymicName, address, phones, emails);
            System.out.println("ID: " + client.ID);
            System.out.println("Name: " + client.name);
            System.out.println("Surname: " + client.surname);
            System.out.println("PatronymicName: " + client.patronymicName);
            System.out.println("Address: " + client.address);
            int i;
            System.out.println("Phones:");
            for(i = 0; i < phones.size(); ++i) {
                System.out.println(client.phones.get(i));
            }
            System.out.println("Emails:");
            for(i = 0; i < emails.size(); ++i) {
                System.out.println(client.emails.get(i));
            } //проверки
        }

        static int rnd(int min, int max)
        {
            max -= min;
            Double t=Math.random() * ++max;
            return t.intValue()+min;
            //return (int) (Math.random() * ++max) + min;
        }
    }
}