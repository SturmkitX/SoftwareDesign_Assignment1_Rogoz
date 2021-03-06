package client;

import javafx.beans.property.*;
import javafx.collections.ObservableList;
import model.ArticleDTO;
import model.UserDTO;
import user.User;

import java.io.*;
import java.net.Socket;

public class ClientUtils {

    private static Socket serverCon = null;
    private static ListProperty<ArticleDTO> articles = new SimpleListProperty<>();
    private static ArticleDTO currentArticle = null;
    private static ObjectOutput socketOut = null;
    private static ObjectInput socketIn = null;

    private static IntegerProperty userRole = new SimpleIntegerProperty(0);
    private static IntegerProperty connectedId = new SimpleIntegerProperty(0);
    private static User currentUser = null;

    private static ListProperty<UserDTO> writers = new SimpleListProperty<>();

    private ClientUtils() {

    }

    public static Socket getServerCon() {
        return serverCon;
    }

    public static void setServerCon(Socket serverCon) {
        if(serverCon != null) {
            try {
                ClientUtils.socketOut = new ObjectOutputStream(serverCon.getOutputStream());    // see ObjectInputStream docs
                ClientUtils.socketIn = new ObjectInputStream(serverCon.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        ClientUtils.serverCon = serverCon;
    }

    public static ObservableList<ArticleDTO> getArticles() {
        return articles;
    }

    public static void addArticle(ArticleDTO a) {
        articles.add(a);
    }


    public static ArticleDTO getCurrentArticle() {
        return currentArticle;
    }

    public static void setCurrentArticle(ArticleDTO currentArticle) {
        ClientUtils.currentArticle = currentArticle;
    }

    public static ObjectOutput getSocketOut() {
        return socketOut;
    }

    public static ObjectInput getSocketIn() {
        return socketIn;
    }

    public static int getUserRole() {
        return userRole.get();
    }

    public static IntegerProperty userRoleProperty() {
        return userRole;
    }

    public static void setUserRole(int userRole) {
        ClientUtils.userRole.set(userRole);
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User currentUser) {
        ClientUtils.currentUser = currentUser;
    }

    public static int getConnectedId() {
        return connectedId.get();
    }

    public static IntegerProperty connectedIdProperty() {
        return connectedId;
    }

    public static void setConnectedId(int connectedId) {
        ClientUtils.connectedId.set(connectedId);
    }

    public static ListProperty<ArticleDTO> articlesProperty() {
        return articles;
    }

    public static void setArticles(ObservableList<ArticleDTO> articles) {
        ClientUtils.articles.set(articles);
    }

    public static ObservableList<UserDTO> getWriters() {
        return writers.get();
    }

    public static ListProperty<UserDTO> writersProperty() {
        return writers;
    }

    public static void setWriters(ObservableList<UserDTO> writers) {
        ClientUtils.writers.set(writers);
    }
}
