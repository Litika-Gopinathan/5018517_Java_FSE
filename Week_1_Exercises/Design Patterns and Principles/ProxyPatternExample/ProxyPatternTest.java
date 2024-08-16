
public class ProxyPatternTest {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("photo1.jpg");
        Image image2 = new ProxyImage("photo2.jpg");

        // The image will be loaded from the server and then displayed
        image1.display();
        System.out.println("");

        // The image will be displayed directly without loading again
        image1.display();
        System.out.println("");

        // The second image will be loaded from the server and then displayed
        image2.display();
        System.out.println("");

        // The second image will be displayed directly without loading again
        image2.display();
    }
}

