package com.example.taller5;

import com.example.taller5.Modelo.Producto;
import javafx.application.Application;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DashboardApp extends Application {


    private TableView<Producto> tablaProductos;

    @Override
    public void start(Stage primaryStage) {

    }


    public void actualizarTablaListado() {
        if (tablaProductos != null) {
            tablaProductos.setItems(com.example.taller5.RegistroProductos.getListaProductos());
        }
    }



    public VBox crearPanelFormulario() {
        // Etiquetas y Campos
        TextField txtNombre = new TextField();
        TextField txtId = new TextField();
        TextField txtPrecio = new TextField();

        Label lblNombre = new Label("Nombre:");
        Label lblId = new Label("Id:");
        Label lblPrecio = new Label("Precio:");

        Button btnGuardar = new Button("Guardar producto");


        btnGuardar.setOnAction(e -> {
            try {
                String nombre = txtNombre.getText().toUpperCase();
                String id = txtId.getText();
                double precio = Double.parseDouble(txtPrecio.getText());

                if (nombre.isEmpty() || id.isEmpty()) {
                    mostrarAlerta("Error", "Todos los campos son obligatorios.", Alert.AlertType.ERROR);
                    return;
                }

                Producto nuevoProducto = new Producto(nombre, id,precio);
                com.example.taller5.RegistroProductos.agregarProducto(nuevoProducto);


                txtNombre.clear();
                txtId.clear();
                txtPrecio.clear();

                mostrarAlerta("Éxito", "Producto registrado correctamente: " + nuevoProducto.toString(), Alert.AlertType.INFORMATION);

            } catch (NumberFormatException ex) {
                mostrarAlerta("Error de Precio", "El precio debe ser un número ", Alert.AlertType.ERROR);
            }
        });

        // Configuración del Layout (GridPane)
        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.add(lblNombre, 0, 0); grid.add(txtNombre, 1, 0);
        grid.add(lblId, 0, 1); grid.add(txtId, 1, 1);
        grid.add(lblPrecio, 0, 2); grid.add(txtPrecio, 1, 2);
        grid.add(btnGuardar, 1, 3);

        VBox formularioVbox = new VBox(20, new Label("Captura de Datos del producto"), grid);
        formularioVbox.setPadding(new Insets(20));
        return formularioVbox;
    }


    public VBox crearPanelListado() {
        tablaProductos = new TableView<>();


        TableColumn<Producto, String> nombreCol = new TableColumn<>("Nombre");
        nombreCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));

        TableColumn<Producto, String> idCol = new TableColumn<>("Id");
        idCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId()));

        TableColumn<Producto, Double>precioCol = new TableColumn<>("Precio");
        precioCol.setCellValueFactory(cellData -> new SimpleObjectProperty<Double>(cellData.getValue().getPrecio()));


        nombreCol.prefWidthProperty().bind(tablaProductos.widthProperty().multiply(0.3));
        idCol.prefWidthProperty().bind(tablaProductos.widthProperty().multiply(0.4));
        precioCol.prefWidthProperty().bind(tablaProductos.widthProperty().multiply(0.3));


        tablaProductos.getColumns().addAll(nombreCol, idCol, precioCol);

        // Cargar los datos iniciales (aunque se actualizarán al hacer clic en el botón)
        tablaProductos.setItems(RegistroProductos.getListaProductos());

        VBox listadoVbox = new VBox(10, new Label("Listado de productos Registrados"), tablaProductos);
        VBox.setVgrow(tablaProductos, Priority.ALWAYS);
        listadoVbox.setPadding(new Insets(20));
        return listadoVbox;
    }

    private void mostrarAlerta(String titulo, String contenido, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(contenido);
        alert.showAndWait();
    }
}
