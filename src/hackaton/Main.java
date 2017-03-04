package hackaton;

public class Main {

	public static void main(String[] args) {
		HashSecurity hs = new HashSecurity("CHU", "PHARMA", "Carole");
		System.out.println(hs.generateHash());
		for(int i =0; i<100;i++)
		{
			try {
				Thread.sleep(10);
				System.out.println(hs.generateHash());

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
