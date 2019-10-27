package com.cafecostes.cafe.Firebase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class FirebaseMessagingSnippets {



    FileInputStream serviceAccount;

    {
        try {
            serviceAccount = new FileInputStream("");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    FirebaseOptions options;

    {
        try {
            options = new FirebaseOptions.Builder()
                        .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                        .setDatabaseUrl("")
                        .build();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //FirebaseApp.initializeApp(options);

    public void sendToToken() throws FirebaseMessagingException {
        // [START send_to_token]
        // This registration token comes from the client FCM SDKs.
        String registrationToken = "";

        // See documentation on defining a message payload.
        Message message = Message.builder()
                .putData("score", "850")
                .putData("time", "2:45")
                .setToken(registrationToken)
                .build();

        // Send a message to the device corresponding to the provided
        // registration token.
        String response = FirebaseMessaging.getInstance().send(message);
        // Response is a message ID string.
        System.out.println("Successfully sent message: " + response);
        // [END send_to_token]
    }
    public FirebaseMessagingSnippets(){}
}
