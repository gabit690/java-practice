package threads.circleBounce;

public class Main {

    public static void main(String[] args) {
        AppWindow mainFrame = new AppWindow(
                "Bounce in different threads",
                "src/graphics/img/icon.png",
                600,
                400
        );
        mainFrame.showWindow();
    }
}


