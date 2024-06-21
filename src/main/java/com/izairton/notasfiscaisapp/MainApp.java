package com.izairton.notasfiscaisapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Classe principal da aplicação JavaFX.
 * <p>
 * Esta classe é responsável por iniciar a aplicação JavaFX e integrá-la com o
 * contexto do Spring.
 * </p>
 */
public class MainApp extends Application {

    private ConfigurableApplicationContext springContext;

    /**
     * Método de inicialização da aplicação JavaFX.
     * <p>
     * Inicializa o contexto do Spring antes de iniciar a aplicação JavaFX.
     * </p>
     *
     * @throws Exception se ocorrer algum erro durante a inicialização do contexto
     *                   do Spring
     */
    @Override
    public void init() throws Exception {
        springContext = new SpringApplicationBuilder(Application.class).run();
    }

    /**
     * Método de início da aplicação JavaFX.
     * <p>
     * Carrega a interface gráfica definida no arquivo FXML e configura a cena
     * principal.
     * </p>
     *
     * @param primaryStage o palco principal da aplicação JavaFX
     */
    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/NotaFiscalView.fxml"));
            loader.setControllerFactory(springContext::getBean);
            Scene scene = new Scene(loader.load());
            primaryStage.setTitle("Notas Fiscais");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método de finalização da aplicação JavaFX.
     * <p>
     * Fecha o contexto do Spring quando a aplicação JavaFX é encerrada.
     * </p>
     *
     * @throws Exception se ocorrer algum erro durante o fechamento do contexto do
     *                   Spring
     */
    @Override
    public void stop() throws Exception {
        springContext.close();
    }

    /**
     * Método principal que inicia a aplicação JavaFX.
     *
     * @param args argumentos da linha de comando
     */
    public static void main(String[] args) {
        launch(args);
    }
}
