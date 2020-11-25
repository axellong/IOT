
package controller;

import dao.DaoDistancia;
import dao.Daoconfig;
import hibernet.ConexionHibernet;
import hibernet.Distancia;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import model.AnimatedImage;

import java.net.URL;

import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    Timeline timeline = new Timeline();

    @FXML
    private ImageView Contenedor1;

    @FXML
    private ImageView contenedor2;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ConexionHibernet.setDriver("mysql");
//        DaoDistancia daoDistancia = new DaoDistancia();
//        System.out.println(daoDistancia.getDisatanci());
        Animacion();

    }

    public int ChecarEstado() {
        DaoDistancia daoDistancia = new DaoDistancia();
        List<Integer> n = daoDistancia.getDisatancia();
        int ultimoValor = n.size()-1;
        int porcentajeDeCapacidadNeto = n.get(ultimoValor);
        int porcentajeDeCapacidad = 4;
        if (porcentajeDeCapacidadNeto<=5){
            porcentajeDeCapacidad=0;
        }if (porcentajeDeCapacidadNeto>=5 && porcentajeDeCapacidadNeto<10){
            porcentajeDeCapacidad=1;
        }if (porcentajeDeCapacidadNeto>=10 && porcentajeDeCapacidadNeto<15){
            porcentajeDeCapacidad=2;
        }if (porcentajeDeCapacidadNeto>=15 && porcentajeDeCapacidadNeto<20){
            porcentajeDeCapacidad=3;
        }
        if (porcentajeDeCapacidadNeto==20){
            porcentajeDeCapacidad=4;
        }

        return porcentajeDeCapacidad;
    }

    public void Animacion() {

        Image[] animacionBasura = new Image[5];
        AnimatedImage basura = new AnimatedImage();


        for (int i = 0; i < animacionBasura.length; i++) {
            animacionBasura[i] = new Image("/resources/basura" + i + ".png");
        }
        basura.setFrames(animacionBasura);
        contenedor2.setImage(basura.getFrame(0));
        Contenedor1.setImage(basura.getFrame(0));

        timeline.setCycleCount(timeline.INDEFINITE);

        KeyFrame keyFrame = new KeyFrame(Duration.seconds(2.0), new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {

                int porcentaje = ChecarEstado();

                Contenedor1.setImage(basura.getFrame(porcentaje));

            }
        });
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();



    }
}

