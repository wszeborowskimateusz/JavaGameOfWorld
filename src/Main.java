
public class Main {
	
	public static void main(String[] args) {
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
		@Override
		public void run() {
			Wejscie wejscie = new Wejscie();
			wejscie.wczytaj();
		}
		});
	}
}
