import com.beust.jcommander.JCommander;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import models.User;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

public class Producer {
    // есть EXCHANGE - images НЕ ОЧЕРЕДЬ
    private final static String EXCHANGE_NAME = "documents";
    // тип FANOUT
    private final static String EXCHANGE_TYPE = "fanout";

    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");

        try {
            Connection connection = connectionFactory.newConnection();
            Channel channel = connection.createChannel();
            // создаем exchange
            channel.exchangeDeclare(EXCHANGE_NAME, EXCHANGE_TYPE);
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("Name: ");
                String name = scanner.nextLine();

                System.out.println("Surname: ");
                String surname = scanner.nextLine();

                System.out.println("Age: ");
                String age = scanner.nextLine();

                System.out.println("Passport Number: ");
                String passport = scanner.nextLine();

                System.out.println("Date: ");
                String date = scanner.nextLine();

                User user = User.builder()
                        .name(name)
                        .surname(surname)
                        .age(age)
                        .passport(passport)
                        .date(date)
                        .build();
                System.out.println(user.toString());

                JCommander jCommander = new JCommander();

                try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
                     ObjectOutput out = new ObjectOutputStream(bos)) {
                    out.writeObject(user);
                    channel.basicPublish(EXCHANGE_NAME, "", null, bos.toByteArray());
                }
            }
        } catch (IOException | TimeoutException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
