package application;

import UI.*;
import javafx.embed.swing.JFXPanel;
import storage.PersistenceFactory;
import storage.PersistentHandler;

public class Main {
	public static void main(String args[]) throws InterruptedException {
		Store store = Global.store;
		store.PopulateSystem();

		new JFXPanel();
		WindowLogin windowLogin = new WindowLogin();

		windowLogin.run();

	}
}