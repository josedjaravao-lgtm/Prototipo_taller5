package com.example.taller5;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

        @FXML
        private BorderPane mainFxml; // Corresponde al fx:id en Dashboard.fxml

        // Instancia para acceder a los métodos de creación de vistas (Formulario y Listado)
        private final DashboardApp vistaGenerator = new DashboardApp();

        // Paneles que se alternarán
        private VBox formularioPane;
        private VBox listadoPane;

        @Override
        public void initialize(URL url, ResourceBundle rb) {
            // Inicializar los paneles creados en DashboardApp
            formularioPane = vistaGenerator.crearPanelFormulario();
            listadoPane = vistaGenerator.crearPanelListado();

            // Mostrar el formulario como vista inicial
            mainFxml.setCenter(formularioPane);
        }

        @FXML
        private void showFormulario() {
            mainFxml.setCenter(formularioPane);
        }

        @FXML
        private void showListado() {
            // Al hacer clic, forzamos la actualización de los datos de la tabla.
            vistaGenerator.actualizarTablaListado();
            mainFxml.setCenter(listadoPane);
        }
    }
