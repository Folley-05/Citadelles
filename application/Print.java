package application;

public class Print {
    
    public static void citadelle() {
        System.out.println("  ____ _ _            _      _ _         ____                      \n" +
                " / ___(_) |_ __ _  __| | ___| | | ___   / ___| __ _ _ __ ___   ___ \n" +
                "| |   | | __/ _` |/ _` |/ _ \\ | |/ _ \\ | |  _ / _` | '_ ` _ \\ / _ \\\n" +
                "| |___| | || (_| | (_| |  __/ | |  __/ | |_| | (_| | | | | | |  __/\n" +
                " \\____|_|\\__\\__,_|\\__,_|\\___|_|_|\\___|  \\____|\\__,_|_| |_| |_|\\___|\n");
    }

    public static void choice(String text) {
        
            // ANSI escape codes for RGB background color and white text
            String backgroundColor = "\u001B[48;2;26;188;156m"; // #1abc9c background color
            String textColor = "\u001B[97m"; // White text color
            String resetColor = "\u001B[0m"; // Reset color to default
    
            // Your message
            // String message = "Hello, colored world with white text!";
    
            // Print the colored message
            System.out.println(backgroundColor + textColor + text + resetColor);
        
    }

    public static void pouvoir(){
        // ANSI escape codes for RGB background color and white text
        String backgroundColor = "\u001B[48;2;231;76;60m"; // #e74c3c background color
        String textColor = "\u001B[97m"; // White text color
        String resetColor = "\u001B[0m"; // Reset color to default

        // Your message
        String message = "UN JOUEUR UTILISE SON POUVOIR";

        // Print the colored message
        System.out.println(backgroundColor + textColor + message + resetColor);
    }

    public static void closing() {
                System.out.println(" _____ _____ ____  __  __ _____ _____ _   _ ____  _____   ____  _   _ \n" +
                                   "|  ___| ____|  _ \\|  \\/  | ____|_   _| | | |  _ \\| ____| |  _ \\| | | |\n" +
                                   "| |_  |  _| | |_) | |\\/| |  _|   | | | | | | |_) |  _|   | | | | | | |\n" +
                                   "|  _| | |___|  _ <| |  | | |___  | | | |_| |  _ <| |___  | |_| | |_| |\n" +
                                   "|_|__ |_____|_|_\\_\\_|__|_|_____| |_|  \\___/|_| \\_\\_____|_|____/ \\___/ \n" +
                                   "|  _ \\|  _ \\ / _ \\ / ___|  _ \\    / \\  |  \\/  |  \\/  | ____|          \n" +
                                   "| |_) | |_) | | | | |  _| |_) |  / _ \\ | |\\/| | |\\/| |  _|            \n" +
                                   "|  __/|  _ <| |_| | |_| |  _ <  / ___ \\| |  | | |  | | |___           \n" +
                                   "|_|   |_| \\_\\___/ \\____|_| \\_\\/_/   \\_\\_|  |_|_|  |_|_____|          \n");
            }
        
}
