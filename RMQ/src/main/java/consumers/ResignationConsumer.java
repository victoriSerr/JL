package consumers;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import models.Type;
import models.User;
import services.PdfService;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.util.concurrent.TimeoutException;

public class ResignationConsumer {
    private final static String EXCHANGE_NAME = "documents";
    private final static String EXCHANGE_TYPE = "fanout";

    public static void main(String[] args) {
        PdfService pdfService = new PdfService();
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");

        try {
            Connection connection = connectionFactory.newConnection();
            Channel channel = connection.createChannel();
            channel.basicQos(3);

            channel.exchangeDeclare(EXCHANGE_NAME, EXCHANGE_TYPE);
            // создаем временную очередь со случайным названием
            String queue = channel.queueDeclare().getQueue();

            // привязали очередь к EXCHANGE_NAME
            channel.queueBind(queue, EXCHANGE_NAME, "");

            DeliverCallback deliverCallback = (consumerTag, message) -> {

                try (ByteArrayInputStream bis = new ByteArrayInputStream(message.getBody());
                    ObjectInput in = new ObjectInputStream(bis)) {
                    User user = (User)in.readObject();
                    System.out.println(user);
                    pdfService.createPdf(user, Type.RESIGNATION);
                    System.out.println("Document created");
                    channel.basicAck(message.getEnvelope().getDeliveryTag(), false);
                } catch (ClassNotFoundException e) {
                    System.err.println("FAILED");
                    channel.basicReject(message.getEnvelope().getDeliveryTag(), false);
                }


            };

            channel.basicConsume(queue, false, deliverCallback, consumerTag -> {});
        } catch (IOException | TimeoutException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
