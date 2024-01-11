package org.openjfx.lab4_client;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;


import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HelloController {

        @FXML
        private TextArea outputTextArea;

        @FXML
        private void initialize() {
            // Вызывается при инициализации контроллера
            fetchDataFromApi();
        }

        private void fetchDataFromApi() {
            try {
                // URL вашего REST API
                URL apiUrl = new URL("http://localhost:8080/api/todo");

                // Открытие соединения
                HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();
                connection.setRequestMethod("GET");

                // Получение ответа
                int responseCode = connection.getResponseCode();

                if (responseCode == HttpURLConnection.HTTP_OK) {
                    // Чтение данных из потока ввода
                    try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                        StringBuilder response = new StringBuilder();
                        String line;

                        while ((line = reader.readLine()) != null) {
                            response.append(line);
                        }

                        // Отображение данных в TextArea
                        outputTextArea.setText(response.toString());
                    }
                } else {
                    System.out.println("Не удалось выполнить GET-запрос. Код ответа: " + responseCode);
                }

                // Закрытие соединения
                connection.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Дополнительные методы для взаимодействия с API могут быть добавлены здесь
    }
