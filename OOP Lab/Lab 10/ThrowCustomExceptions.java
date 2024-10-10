import java.util.Scanner;

class InvalidMovementException extends Exception {
    public InvalidMovementException(String message) {
        super(message);
    }
}

public class ThrowCustomExceptions {
    private String[] movementHistory = new String[100]; 
    private int historyIndex = 0; 
    private int horizontalPosition = 0; 
    private int verticalPosition = 0; 

    public void moveArm(String direction, int degrees) throws InvalidMovementException {
        if (degrees < 0 || degrees > 180) {
            throw new InvalidMovementException("Movement out of range: " + degrees + ". Must be between 0 and 180 degrees.");
        }
        if (direction == null || direction.isEmpty()) {
            throw new InvalidMovementException("Direction cannot be null or empty.");
        }

        switch (direction.toLowerCase()) {
            case "up":
                verticalPosition += degrees; 
                break;
            case "down":
                verticalPosition -= degrees; 
                break;
            case "left":
                horizontalPosition -= degrees;
                break;
            case "right":
                horizontalPosition += degrees; 
                break;
            default:
                throw new InvalidMovementException("Invalid direction: " + direction + ". Use 'up', 'down', 'left', or 'right'.");
        }

        String movement = "Moving " + direction + " by " + degrees + " degrees.";
        System.out.println(movement);
        if (historyIndex < movementHistory.length) {
            movementHistory[historyIndex++] = movement; 
        } else {
            System.err.println("Movement history is full!");
        }
        System.out.println("Current position - Horizontal: " + horizontalPosition + ", Vertical: " + verticalPosition);
    }

    public void displayMovementHistory() {
        System.out.println("Movement History:");
        for (int i = 0; i < historyIndex; i++) {
            System.out.println(movementHistory[i]);
        }
    }

    public static void main(String[] args) {
        ThrowCustomExceptions robotArm = new ThrowCustomExceptions();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter direction (up, down, left, right), 'history' to view past movements, or 'exit' to quit: ");
            String direction = scanner.nextLine();
            if (direction.equalsIgnoreCase("exit")) {
                break;
            } else if (direction.equalsIgnoreCase("history")) {
                robotArm.displayMovementHistory();
                continue;
            }

            System.out.print("Enter degrees (0-180): ");
            int degrees;
            try {
                degrees = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Invalid input for degrees. Please enter a number.");
                continue;
            }

            try {
                robotArm.moveArm(direction, degrees);
            } catch (InvalidMovementException e) {
                System.err.println("Caught exception: " + e.getMessage());
            }
        }

        scanner.close();
        System.out.println("Program terminated.");
    }
}
