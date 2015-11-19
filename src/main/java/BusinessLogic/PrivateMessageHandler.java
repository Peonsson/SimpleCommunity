package BusinessLogic;

import Entity.PrivateMessage;

/**
 * Created by Peonsson on 19/11/15.
 */
public class PrivateMessageHandler {

    public static void submit(String sender, String receiver, String subject, String password) {
        int senderId = Integer.parseInt(sender);
        int receiverId = Integer.parseInt(receiver);

        PrivateMessage.submit(senderId, receiverId, subject, password);
    }

}
